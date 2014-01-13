package doco.security;

import doco.utils.tests.TestsCommons;
import doco.utils.tests.WeldJUnit4Runner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

/**
 * User: jesvizan
 * Date: 7/11/13
 */
@RunWith(WeldJUnit4Runner.class)
public class TestSecurity extends TestsCommons {

    @Inject
    private SecurityService securityService;

    @Test
    public void testLogin() {
        LoginResult r = securityService.login(new Credentials("admin", "admin"));
        System.out.println(r.getCode() + ":" + r.getMessage());
    }

}
