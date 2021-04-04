package pakkaajat.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jarkko
 */
public class MinimiKekoTest {
    
    public MinimiKekoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class MinimunHeap.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MinimiKeko instance = new MinimiKeko();
        instance.add(new HuffmanSolmu('1', 1, null, null));
        instance.add(new HuffmanSolmu('2', 4, null, null));
        instance.add(new HuffmanSolmu('3', 5, null, null));
        instance.add(new HuffmanSolmu('5', 7, null, null));
        instance.add(new HuffmanSolmu('4', 5, null, null));
        instance.add(new HuffmanSolmu('6', 8, null, null));
        instance.add(new HuffmanSolmu('7', 9, null, null));
        instance.add(new HuffmanSolmu('8', 3, null, null));
        instance.add(new HuffmanSolmu('9', 8, null, null));
        instance.add(new HuffmanSolmu('0', 5, null, null));
        HuffmanSolmu[] testi = instance.tulosta();
        String tulos = "";
        for (int i = 1; i < 11; i++){
            tulos += (testi[i].getFrekvenssi());
        }
        assertEquals("1354589785",tulos);
    }

    /**
     * Test of poll method, of class MinimunHeap.
     */
    @Test
    public void testPoll() {
        System.out.println("poll");
        MinimiKeko instance = new MinimiKeko();
        HuffmanSolmu expResult = new HuffmanSolmu('1', 1, null, null);
        
        instance.add(new HuffmanSolmu('1', 1, null, null));
        instance.add(new HuffmanSolmu('2', 4, null, null));
        instance.add(new HuffmanSolmu('3', 5, null, null));
        instance.add(new HuffmanSolmu('5', 7, null, null));
        instance.add(new HuffmanSolmu('4', 5, null, null));
        instance.add(new HuffmanSolmu('6', 8, null, null));
        instance.add(new HuffmanSolmu('7', 9, null, null));
        instance.add(new HuffmanSolmu('8', 3, null, null));
        instance.add(new HuffmanSolmu('9', 8, null, null));
        instance.add(new HuffmanSolmu('0', 5, null, null));
        
        HuffmanSolmu result = instance.poll();
        
        HuffmanSolmu[] testi = instance.tulosta();
        String tulos = "";
        for (int i = 1; i < 11; i++){
            tulos += (testi[i].getFrekvenssi());
        }
        System.out.println(tulos);
        assertEquals(expResult.getFrekvenssi(), result.getFrekvenssi());
    }

    /**
     * Test of size method, of class MinimunHeap.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        MinimiKeko instance = new MinimiKeko();
        
        instance.add(new HuffmanSolmu('7', 9, null, null));
        instance.add(new HuffmanSolmu('1', 1, null, null));
        
        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);
    }
    
}
