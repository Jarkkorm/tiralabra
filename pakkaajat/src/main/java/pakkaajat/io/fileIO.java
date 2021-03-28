package pakkaajat.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileIO {
    
    public static char[] readFile(File file) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String string;
        char[] contents={};
        while ((string = br.readLine()) != null){
            contents = string.toCharArray();
        }
        
        return contents; 
    }
}
