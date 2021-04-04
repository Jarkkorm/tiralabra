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
import pakkaajat.domain.HuffmanSolmu;

public class FileIO {
    
    public static char[] readFile(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        char[] contents = {};
        while ((string = br.readLine()) != null) {
            contents = string.toCharArray();
        }
        
        return contents; 
    }

    public static void writeFile(String name, byte[] compressedData, HuffmanSolmu tree) throws IOException {
        String outputFile = name + ".huf";
        OutputStream os = new FileOutputStream(outputFile);
              
        PrintStream printStream = new PrintStream(os);
        printStream.write(compressedData);
        printStream.close();
        
    }
}

