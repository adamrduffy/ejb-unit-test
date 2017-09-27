package org.adamrduffy.ejbunittest;

import javax.inject.Inject;

public class PingPong {
    @Inject
    private Ping ping;

    public String name() {
        return ping.name() + " pong";
    }
}
