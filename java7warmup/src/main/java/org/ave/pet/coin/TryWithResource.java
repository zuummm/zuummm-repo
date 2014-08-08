package org.ave.pet.coin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResource {

    public void tryIt(String path) throws IOException {
        // try-with-resources
        try (InputStream in = new FileInputStream(path)) {
            byte[] buffer = new byte[1024];
            while ((in.read(buffer)) >= 0) {
                System.out.println(in.toString());
            }
        }        
    }
}
