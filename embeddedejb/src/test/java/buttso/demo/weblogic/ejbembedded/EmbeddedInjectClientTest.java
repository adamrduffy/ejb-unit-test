package buttso.demo.weblogic.ejbembedded;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Ignore("does not work with inject annotation")
public class EmbeddedInjectClientTest {

    private EJBContainer ejbContainer;

    @Inject
    PingPongBean ppb;

    @Before
    public void setupTest() {
        try {
            ejbContainer = EJBContainer.createEJBContainer();
        } catch (Exception e) {
            System.out.println("Bummer, something wrong with the setup of the EJBContainer: " + e.getMessage());
            throw (e);
        }
    }

    @After
    public void finishTest() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

    @Test
    public void testPingUsingClasses() throws NamingException {
        assertNotNull(ppb);
        assertNotNull(ppb.ping());
        assertTrue("pong".equals(ppb.ping()));
    }

}
