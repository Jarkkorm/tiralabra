package pakkaajat.domain;

import java.util.Map;

public class HuffmanTiedosto {
    

    static String luoPakattuData(char[] content, Map<Character, String> map, HuffmanSolmu tree) {
        String data = "";
        data = tallennaHuffmanPuu(tree);
        data += tallennaHuffmanData(content, map);
        return data;
    }
    
    private static String tallennaHuffmanPuu(HuffmanSolmu tree) {
        String puuData = ""; 
        if (tree == null) {
            return null;
        }
        
        if (!tree.onkoLehti()) {
            puuData += 0;
            tallennaHuffmanPuu(tree.getVasenSolmu());
            tallennaHuffmanPuu(tree.getOikeaSolmu());
        } else {
            char merkki = tree.getMerkki();
            puuData += 1;
            for (int j = 0; j < 8; j++) {
                int bit = (merkki >>> (8 - j - 1));
                puuData += bit;
            }
        }
        return puuData.length() + puuData;
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
    
    public static String tallennaHuffmanData(char[] content, Map<Character, String> map) {
        String huffmanData = "";
        for (int i = 1; i < content.length; i++) {
            huffmanData += map.get(content[i]);
        }        
        return huffmanData.length() + huffmanData;
    }
    
    public static HuffmanSolmu readHuffmanTree() {
        HuffmanSolmu solmu = new HuffmanSolmu(' ', 0, null, null);
        return solmu;
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

}
