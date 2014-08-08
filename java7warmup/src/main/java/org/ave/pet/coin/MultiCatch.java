package org.ave.pet.coin;

import java.io.BufferedReader;
import java.io.IOException;

import org.ave.pet.exception.OneException;
import org.ave.pet.exception.TwoExeption;

public class MultiCatch {

    public void throwExeptions(boolean b) throws OneException, TwoExeption {
        // any code which may throw both OneException and TwoExeption
        try {
            if (b) {
                throw new OneException("Test");
            } else if (!b){
                throw new TwoExeption();
            }
        }  catch(OneException | TwoExeption ex) {
            // logging the same information for both case
            throw ex;
        }       
    }
    
    public void tryMultiCatch() throws Exception {
        try {
            throwExeptions(true);
            BufferedReader br = new BufferedReader(null);
            br.read();
            br.close();
        } catch(IOException e) {
            // some info logged
            throw e;
        } catch(OneException | TwoExeption ex) {
            // logging the same information for both case
            throw ex;
        }
    }
    
}
