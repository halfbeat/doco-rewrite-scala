package doco.security;

import doco.usuarios.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.*;

@Path("security")
public class SecurityService {
    @Inject
    private EntityManager em;

    @POST
    @Path("/login")
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public LoginResult login(Credentials creds) {
        try {
            em.createQuery("select u from Usuario u where u.userId = :user and u.password = :pass", Usuario.class).
                    setParameter("user", creds.getUser()).setParameter("pass", creds.getPassword()).getSingleResult();
            return new LoginResult(0, "Usuario autenticado correctamente", "AABBCCDDEEFF");
        } catch (Exception e) {
            return new LoginResult(-1, "Usuario/password no válidos");
        } finally {
        }
    }

    @GET
    @Path("/test")
    public String test() {
        return "Hoola";
    }
}
