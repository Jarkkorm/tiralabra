
package pakkaajat.domain;

import java.io.File;
import java.io.IOException;
import pakkaajat.io.fileIO;

public class huffman {

    
    private void compressHuffman(File file) throws IOException {
        char[] content = fileIO.readFile(file);
        
        
    }
    
    private int[] frequency(char[] data) {
        int[] f = new int [256];
        for(int i = 0; i<data.length; i++) {
            f[data[i]]++;
        }
        return f;
    }
}
