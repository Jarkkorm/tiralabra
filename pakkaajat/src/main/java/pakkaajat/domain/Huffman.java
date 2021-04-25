
package pakkaajat.domain;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import pakkaajat.io.FileIO;

/**
 *
 * Huffman koodauksen sisältävä luokka
 */
public class Huffman {

    /**
     * Tekee tiedoston pakkaamisen Huffman koodauksella.
     * @param file Pakattava tiedosto
     * @throws IOException
     */
    public static void pakkaaHuffman(File file) throws IOException {
        final char[] content = FileIO.readFile(file);
        final long alku = System.nanoTime();
        final int[] freq = frekvenssi(content);
        final HuffmanSolmu tree = teeHuffmanPuu(freq);
        
        Map<Character, String> map = new HashMap<>();
        luoMerkisto(tree, map, "");
        
        final String pakattuData = HuffmanTiedosto.luoPakattuData(content, map, tree);
        long loppu = System.nanoTime();
        FileIO.writeFile(file.getName(), pakattuData);
        //return (loppu - alku);
    }
    
    // Laskee merkkien esiintymis frekvenssin
    private static int[] frekvenssi(char[] data) {
        int[] f = new int [256];
        for (int i = 0; i < data.length; i++) {
            f[data[i]]++;
        }
        return f;
    }
    
    // Luo puun merkkien esiintymisfrekvenssin perusteella
    private static HuffmanSolmu teeHuffmanPuu(int[] freq) {
        MinimiKeko minimiKeko = new MinimiKeko();
        for (char i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                minimiKeko.add(new HuffmanSolmu(i, freq[i], null, null));
            }
        }    
        
        while (minimiKeko.size() > 1) {
            HuffmanSolmu left = minimiKeko.poll();
            HuffmanSolmu right = minimiKeko.poll();
            HuffmanSolmu parent = new HuffmanSolmu('\0', left.getFrekvenssi() + right.getFrekvenssi(), left , right);
            minimiKeko.add(parent);
        }

        return minimiKeko.poll();
    } 
    
    // tekee merkistön jolla merkit koodataan
    private static void luoMerkisto(HuffmanSolmu puu, Map<Character, String> map, String s) {
        if (!puu.onkoLehti()) {
            luoMerkisto(puu.getVasenSolmu(), map, s + "0");
            luoMerkisto(puu.getOikeaSolmu(), map, s + "1");
        } else {
            map.put(puu.getMerkki(), s);
        }
    }

}
