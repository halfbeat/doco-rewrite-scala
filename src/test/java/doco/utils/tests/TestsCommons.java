package doco.utils.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestsCommons {
    private static final String USUARIO = "USUARIO_DOCO";
    private static final String USER_SECURITY_DATA = "USER_SECURITY_DATA";
    static SetupManager setupManager = new SetupManager();

    @BeforeClass
    public static void startup() {
        setupManager.startup();
    }

    @AfterClass
    public static void B_shutdown() {
        setupManager.cleanup();
    }

}
