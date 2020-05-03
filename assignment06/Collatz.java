import java.util.Arrays;
import java.io.IOException;
import java.io.*;

public class Collatz {

    public BrobInt divideByTwo(BrobInt bint) {
        if (bint.byteVersion[0] == 0 ||
            bint.byteVersion[0] == 2 ||
            bint.byteVersion[0] == 4 ||
            bint.byteVersion[0] == 6 ||
            bint.byteVersion[0] == 8   ) {
            
            System.out.println(bint.divide(BrobInt.TWO));
        }
        return bint;
    }

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("This program requires one argument");
            System.exit(-1);
        }

        try {
            BrobInt brobInt = new BrobInt(args[0]);
        } catch (Exception e) {
            System.out.println("Problem constructing BrobInt");
            System.exit(-1);
        }

        BrobInt brobInt = new BrobInt(args[0]);
        System.out.println(brobInt.toString());
        int i = 0;
        while (!brobInt.equals(BrobInt.ONE)) {    
            if (brobInt.byteVersion[0] == (byte) 0 ||
                brobInt.byteVersion[0] == (byte) 2 ||
                brobInt.byteVersion[0] == (byte) 4 ||
                brobInt.byteVersion[0] == (byte) 6 ||
                brobInt.byteVersion[0] == (byte) 8   ) {
                
                brobInt = brobInt.divide(BrobInt.TWO);
                System.out.println(brobInt.toString());
            } else {
                brobInt = (brobInt.multiply(BrobInt.THREE)).add(BrobInt.ONE);
                System.out.println(brobInt.toString());
            }
            i++;
        }
        System.out.println("We have arrived at 1 after " + i + " loops!");
        return;
    }
}