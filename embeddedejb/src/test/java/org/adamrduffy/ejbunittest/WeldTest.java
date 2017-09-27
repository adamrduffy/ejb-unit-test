package org.adamrduffy.ejbunittest;

import buttso.demo.weblogic.ejbembedded.PingPongBean;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//@Ignore("appears to work if the embedded weblogic container is not running")
public class WeldTest {
    @Rule
    public WeldInitiator weld = WeldInitiator.from(PingPongBean.class, PingPong.class, Ping.class).inject(this).build();

    @Inject
    private PingPongBean pingPongBean;

    @Inject
    private PingPong pingPong;

    @Test
    public void testPingPong() {
        assertNotNull(pingPong);
        assertNotNull(pingPong.name());
        assertEquals("ping pong", pingPong.name());
    }

    @Test
    public void testPingUsingClasses() throws NamingException {
        assertNotNull(pingPongBean);
        assertNotNull(pingPongBean.ping());
        assertTrue("pong".equals(pingPongBean.ping()));
    }
}
