package org.dist.patterns.common;


import org.dist.kvstore.InetAddressAndPort;

import java.net.Socket;

class Client {
    public RequestOrResponse sendReceive(RequestOrResponse requestOrResponse, InetAddressAndPort to) {
        try {
            var clientSocket = new Socket(to.address(), to.port());
            var response = new SocketIO<RequestOrResponse>(clientSocket, RequestOrResponse.class).requestResponse(requestOrResponse);
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}