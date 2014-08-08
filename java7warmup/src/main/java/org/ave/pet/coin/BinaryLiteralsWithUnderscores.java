package org.ave.pet.coin;


public class BinaryLiteralsWithUnderscores {

    private static final byte binaryMonth = 0b01;
    private static final int binaryYear = 0b0111_1101_1111;
    
    public static void main(String[] varargs) {
        System.out.println("Comittee is coming in " + binaryMonth + "/" + binaryYear );
    }
}
