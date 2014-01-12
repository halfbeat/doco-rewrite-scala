package doco.cdi;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

public class RequestParamProducer implements Serializable {

    private static final long serialVersionUID = -4260202951977249652L;
    @Inject
    FacesContext facesContext;

    // Producer for @RequestParam
    @Produces
    @RequestParam
    String getRequestParameter(InjectionPoint ip) {
        String name = ip.getAnnotated().getAnnotation(RequestParam.class)
                .value();

        if ("".equals(name))
            name = ip.getMember().getName();

        return facesContext == null ? null : facesContext.getExternalContext().getRequestParameterMap()
                .get(name);
    }
}
