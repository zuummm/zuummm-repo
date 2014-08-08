package org.ave.pet.oldschool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketOld {

    private ServerSocket server;
    private int port = 2112;
 
    public ServerSocketOld() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        ServerSocketOld socket = new ServerSocketOld();
        socket.handleConnection();
    }
 
    public void handleConnection() {
        System.out.println("Waiting for client ...");
        while (true) {
            try (Socket socket = server.accept();) {
                new ConnectionHandler(socket);                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
