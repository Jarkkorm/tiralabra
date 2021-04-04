
package pakkaajat.domain;

/**
 * 
 * Huffman puun solmun esitysmuoto.
 */
public class HuffmanSolmu {
    
    private char merkki;
    private int frekvenssi;
    private HuffmanSolmu vasenSolmu;
    private HuffmanSolmu oikeaSolmu;

    /**
     *
     * @param merkki
     * @param frekvenssi
     * @param vasenSolmu
     * @param oikeaSolmu
     */
    public HuffmanSolmu(char merkki, int frekvenssi, HuffmanSolmu vasenSolmu, HuffmanSolmu oikeaSolmu) {
        this.merkki = merkki;
        this.frekvenssi = frekvenssi;
        this.vasenSolmu = vasenSolmu;
        this.oikeaSolmu = oikeaSolmu;
    }

    /**
     * Palauttaa merkin
     * @return
     */
    public char getMerkki() {
        return merkki;
    }

    /**
     * Palauttaa frekvenssin
     * @return
     */
    public int getFrekvenssi() {
        return frekvenssi;
    }

    /**
     * Palauttaa vasemman solmun
     * @return
     */
    public HuffmanSolmu getVasenSolmu() {
        return vasenSolmu;
    }

    /**
     * Palauttaa oikean solmun
     * @return 
     */
    public HuffmanSolmu getOikeaSolmu() {
        return oikeaSolmu;
    }

    /**
     * Palauttaa tiedon onko solmulla lehtiä
     * @return
     */
    public boolean onkoLehti() {
        return this.vasenSolmu == null && this.oikeaSolmu == null;
    }

}
