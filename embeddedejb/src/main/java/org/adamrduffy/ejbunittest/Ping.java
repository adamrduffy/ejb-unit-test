package org.adamrduffy.ejbunittest;

import javax.ejb.Stateless;

@Stateless
public class Ping {
    public String name() {
        return "ping";
    }
}
