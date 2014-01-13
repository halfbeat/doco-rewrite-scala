package doco.security;

import com.sun.jersey.core.util.Base64;
import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RestSecurityFilter implements Filter {
    public static Logger logger = Logger.getLogger(RestSecurityFilter.class);
    protected FilterConfig filterConfig = null;

    @Inject
    private SecurityService securityService;

    private static String[] decode(final String encodedString) {
        final byte[] decodedBytes = Base64.decode(encodedString.getBytes());
        final String pair = new String(decodedBytes);
        final String[] userDetails = pair.split(":", 2);
        return userDetails;
    }

    public synchronized void destroy() {
        filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session;
        if (request.getHeader("Authorization") != null) {
            String[] sps = request.getHeader("Authorization").split(" ");
            if (sps.length == 2 && "Basic".equals(sps[0])) {
                String[] userdata = decode(sps[1]);
                LoginResult result = securityService.login(new Credentials(userdata[0], userdata[1]));
                if (result.getCode() == 0) {
                    chain.doFilter(req, resp);
                    return;
                }
            }
        }
        response.setHeader("WWW-Authenticate", "Basic realm=\"Usuario DOCO\"");
        response.sendError(401);
        return;
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
    }

}
