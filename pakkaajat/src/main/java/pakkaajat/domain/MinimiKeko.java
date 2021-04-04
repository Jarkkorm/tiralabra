package pakkaajat.domain;

import pakkaajat.domain.HuffmanSolmu;

/**
 *
 * Minimi keon toteutus
 */
public class MinimiKeko {    
    private HuffmanSolmu[] keko;
    private int indeksi;
    private int koko;

    /**
     * Uuden keon luonti
     * Keko alkaa taulukon kohdasta 1
     */
    public MinimiKeko() {
        this.keko = new HuffmanSolmu[257];
        this.indeksi = 1;
        this.koko = 0;
    }
    
    /**
     * Lisää kekoon uuden Huffman solmun
     * @param lehti
     */
    public void add(HuffmanSolmu lehti) {
        if (this.indeksi > this.koko + 1) {
            return;
        }

        this.keko[this.indeksi] = lehti;
        if (this.indeksi > 1) {
            int i = this.indeksi;
            while (i > 1 && this.keko[i].getFrekvenssi() < this.keko[i/2].getFrekvenssi()) {
                vaihda(i, i / 2); // vanhempi i/2
                i = i / 2;
            }
        }
        this.indeksi++;  
        this.koko++;
    }
    
    /**
     * Poistaa keosta pienimmän solmun
     * @return palauttaa poistetun solmun
     */
    public HuffmanSolmu poll() {
        HuffmanSolmu min = this.keko[1];
        this.indeksi--;
        this.keko[1] = this.keko[indeksi];
        jarjesta(1);        
        this.koko--;
        return min;  
    }
    
    /**
     *
     * @return palauttaa keon koon.
     */
    public int size() {
        return this.koko;
    }

    // Vaihtaa kahden solmun paikkaa keskenään
    private void vaihda(int i, int j) {
        HuffmanSolmu temp = this.keko[i];
        this.keko[i] = this.keko[j];
        this.keko[j] = temp;
    }
    
    // Järkestää solmut minimikekoon.
    private void jarjesta(int i) {
        if (!isLeaf(i)) { //vasen 2k ja oikea 2k+1
            if (this.keko[i].getFrekvenssi() > this.keko[2 * i].getFrekvenssi() || this.keko[i].getFrekvenssi() > this.keko[2 * i + 1].getFrekvenssi()) {
                if (this.keko[2 * i].getFrekvenssi() < this.keko[2 * i + 1].getFrekvenssi()) {
                    vaihda(i, 2 * i);
                    jarjesta(2 * i);
                } else {
                    vaihda(i, 2 * i + 1);
                    jarjesta(2 * i + 1);
                    
                }
            }
        }
    }
    
    /**
     * Testausta varten
     * @return palauttaa keon
     */
    public HuffmanSolmu[] tulosta() {
        return this.keko;
    }

    private boolean isLeaf(int i) {
        if (2 * i >= koko || (2 * i + 1) >= koko) {
            return true;
        }
        return false;
       
    }
}
