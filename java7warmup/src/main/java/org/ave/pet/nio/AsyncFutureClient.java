package org.ave.pet.nio;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.Future;

public class AsyncFutureClient {

    public void request() throws Exception {
        ByteBuffer buff = ByteBuffer.allocate(2048);
        SocketAddress localSocket = new InetSocketAddress("127.0.0.1", 2112);
        
        try ( AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
              OutputStream os = Channels.newOutputStream(channel);)
        {            
            Future<Void> future = channel.connect(localSocket);
            if (future.isDone()) {
                future.get();
            }
            // Send something            
            os.write(buff.array());            
        }         
    }
}
