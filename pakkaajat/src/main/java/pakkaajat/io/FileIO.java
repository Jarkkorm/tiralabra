package pakkaajat.io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import pakkaajat.domain.HuffmanSolmu;

public class FileIO {
    private static BufferedOutputStream out;
    private static int buffer = 0;
    private static int n = 0;
    
    public static char[] readFile(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = "";
        int i = 0;
        char[] contents = {};
        while (i != -1) {
            i = br.read();
            s += (char) i;
        }
        contents = s.toCharArray();
        
        return contents; 
    }
    
    public static char[] readHuffman(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        char[] contents = {};
        while ((string = br.readLine()) != null) {
            contents = string.toCharArray();
        }
        
        return contents; 
    }
    
    public static HuffmanSolmu readHuffmanTree() {
        HuffmanSolmu solmu = new HuffmanSolmu(' ', 0, null, null);
        return solmu;
    }

    public static void writeFile(String name, String pakattuData, HuffmanSolmu tree) throws IOException {
        String outputFile = name + ".huf";
        out = new BufferedOutputStream(new FileOutputStream(outputFile));
        tallennaHuffmanPuu(tree);
        tallennaHuffmanData(pakattuData);
        out.close();
        
    }

    private static void tallennaHuffmanPuu(HuffmanSolmu tree) {
        if (tree == null) {
            return;
        }
        
        if (!tree.onkoLehti()) {
            writeBit(0);
            tallennaHuffmanPuu(tree.getVasenSolmu());
            tallennaHuffmanPuu(tree.getOikeaSolmu());
        } else {
            char merkki = tree.getMerkki();
            writeBit(1);
            for (int j = 0; j < 8; j++) {
                int bit = (merkki >>> (8 - j - 1));
                writeBit(bit);
            }
        }
    }
    /*
    private static void lueHuffmanPuu() {
        bit readBit();
    
        if (!tree.onkoLehti()) {
            writeBit(0);
            tallennaHuffmanPuu(tree.getVasenSolmu());
            tallennaHuffmanPuu(tree.getOikeaSolmu());
        } else {
            char merkki = tree.getMerkki();
            writeBit(1);
            for (int j = 0; j < 8; j++) {
                int bit = (merkki >>> (8 - j - 1));
                writeBit(bit);
            }
        }
    }
    */
    
    public static void tallennaHuffmanData(String pakattuData) {
        for (int i = 1; i < pakattuData.length(); i++) {
            System.out.println(pakattuData);
            //for (int j = 0; j < 8; j++) {
                int bit = (Character.getNumericValue(pakattuData.charAt(i))); //>>> (8 - j - 1)) & 1) == 1;
                writeBit(bit);
                System.out.println(bit);
            //}
        }        

    }

    private static void writeBit(int bit) {
        buffer <<= 1;
        if (bit == 1)
            buffer |= 1;

        n++;
        if (n == 8) clearBuffer();
    }

    private static void clearBuffer() {
        if (n == 0) return;
        if (n > 0) buffer <<= (8 - n);
        try {
            System.out.println(buffer);
            out.write(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        n = 0;
        buffer = 0;
    }

}


