package org.ave.pet.oldschool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    private Socket socket;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;

        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try (   ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); 
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());) 
        {
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);

            oos.writeObject("Hi Client!");
            System.out.println("Waiting for client message...");
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
