package doco.startup;

import doco.cdi.Eager;
import doco.usuarios.Usuario;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
@Eager
public class StartupManager {
    @Inject
    private EntityManager em;

    @PostConstruct
    private void init() {
        Usuario u = new Usuario("admin", "admin");
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
}
