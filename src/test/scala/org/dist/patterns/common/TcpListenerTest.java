package org.dist.patterns.common;


import org.dist.kvstore.InetAddressAndPort;
import org.dist.queue.TestUtils;
import org.dist.util.Networks;
import org.junit.Test;

import java.net.InetAddress;

import static org.junit.Assert.assertNotNull;

public class TcpListenerTest {

    @Test
    public void shouldExecuteSingularUpdateQueue() {
        InetAddress inetAddress = new Networks().ipv4Address();
        InetAddressAndPort serverIp = InetAddressAndPort.create(inetAddress.getHostAddress(), TestUtils.choosePort());
        TcpListener tcpListener = new TcpListener(serverIp);
        tcpListener.start();

        RequestOrResponse requestOrResponse = new Client().sendReceive(new RequestOrResponse(1, "Test String", 0), serverIp);

        System.out.println(requestOrResponse);

        assertNotNull(requestOrResponse);
    }
}