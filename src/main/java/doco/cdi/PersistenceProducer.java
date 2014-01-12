package doco.cdi;

import org.apache.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceProducer {
    private static Logger logger = Logger.getLogger(PersistenceProducer.class);

    @Produces
    @Named("emf")
    @ApplicationScoped
    public EntityManagerFactory createEntityManagerFactory() {
        logger.info("Creando el EntityManagerFactory");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("doco");
        logger.info("Se ha creado el EntityManagerFactory");
        return emf;
    }

    public void destroyEntityManagerFactory(
            @Disposes @Named("emf") EntityManagerFactory emf) {
        if (emf != null) {
            logger.info("Destruyendo el EntityManagerFactory");
            emf.close();
            logger.info("Se ha destruido el EntityManagerFactory");
        }
    }

    @Produces
    @Named("em")
    public EntityManager createEntityManager(
            @Named("emf") EntityManagerFactory emf) {
        logger.info("Creando el EntityManager");
        EntityManager em = emf.createEntityManager();
        logger.info("Se ha creado el EntityManager");
        return em;
    }

    public void destroyEntityManager(@Disposes EntityManager em) {
        if (em != null && em.isOpen()) {
            logger.info("Destruyendo el EntityManager");
            em.close();
            logger.info("Se ha destruido el EntityManager");
        }
    }

}
