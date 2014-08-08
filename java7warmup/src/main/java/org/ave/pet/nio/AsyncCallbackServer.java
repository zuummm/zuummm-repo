package org.ave.pet.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AsyncCallbackServer {

    public void serve() {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 2155);

        try {
            final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open().bind(socketAddress);

            listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {                
                public void completed(AsynchronousSocketChannel ch, Void att) {
                    // accept the next connection
                    listener.accept(null, this);
                    // handle this connection
                    System.out.println("Reading: " + ch.read(ByteBuffer.allocate(2048)));
                }

                public void failed(Throwable exc, Void att) {
                    System.out.println(exc.getCause());
                }
            });
        } catch (Exception e) {
        }
    }
}
