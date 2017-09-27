package org.adamrduffy.ejbunittest;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PingPong {
    @Inject
    private Ping ping;

    public String name() {
        return ping.name() + " pong";
    }
}
