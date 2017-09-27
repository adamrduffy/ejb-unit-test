package org.adamrduffy.ejbunittest;

import buttso.demo.weblogic.ejbembedded.PingPongBean;
import org.jboss.weld.junit4.WeldInitiator;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;
import javax.naming.NamingException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WeldTest {
    @Rule
    public WeldInitiator weld = WeldInitiator.from(PingPongBean.class).inject(this).build();

    @Inject
    private PingPongBean pingPongBean;

    @Test
    public void testPingUsingClasses() throws NamingException {
        assertNotNull(pingPongBean);
        assertNotNull(pingPongBean.ping());
        assertTrue("pong".equals(pingPongBean.ping()));
    }
}
