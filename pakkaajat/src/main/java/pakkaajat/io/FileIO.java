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
        int i = br.read();;
        char[] contents = {};
        while (i != -1) {
            s += (char) i;
            i = br.read();
        }
        contents = s.toCharArray();
        
        return contents; 
    }

    public static void writeFile(String name, String pakattuData, HuffmanSolmu tree) throws IOException {
        String outputFile = name + ".huf";
        out = new BufferedOutputStream(new FileOutputStream(outputFile));
        tallennaHuffmanPuu(tree);
        tallennaHuffmanData(pakattuData);
        out.close();
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
            out.write(buffer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        n = 0;
        buffer = 0;
    }

}


