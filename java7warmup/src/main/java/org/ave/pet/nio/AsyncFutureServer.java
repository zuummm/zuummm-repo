package org.ave.pet.nio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class AsyncFutureServer {

    public void serve() throws Exception {
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 2112);
        ByteBuffer buff = ByteBuffer.allocate(2048);
        
        try (AsynchronousServerSocketChannel serverSocket = AsynchronousServerSocketChannel.open().bind(socketAddress);) 
        {
            Future<AsynchronousSocketChannel> future = serverSocket.accept();
            AsynchronousSocketChannel socket = future.get();
            if (future.isDone()) { 
               System.out.println("Reading: " + socket.read(buff));
            }                
            // Reply...
            // InputStream stream = Channels.newInputStream(); //(...)
        }
    }
}
