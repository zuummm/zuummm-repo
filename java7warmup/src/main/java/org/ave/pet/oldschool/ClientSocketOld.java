package org.ave.pet.oldschool;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocketOld {

    public static void main(String[] args) {
        try (   Socket socket = new Socket(InetAddress.getLocalHost(), 2112);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());) 
        {
            oos.writeObject("Hello Server!");

            String message = (String) ois.readObject();
            System.out.println("Message: " + message);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
