package doco.utils.tests;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * User: jesvizan
 * Date: 7/11/13
 */
public class WeldJUnit4Runner extends BlockJUnit4ClassRunner {
    private final Class<?> klass;
    private final Weld weld;
    private final WeldContainer container;

    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @throws org.junit.runners.model.InitializationError
     *          if the test class is malformed.
     */
    public WeldJUnit4Runner(Class<?> klass) throws InitializationError {
        super(klass);
        this.klass = klass;
        this.weld = new Weld();
        this.container = weld.initialize();
    }

    @Override
    protected Object createTest() throws Exception {
        final Object test = container.instance().select(klass).get();

        return test;
    }
}
