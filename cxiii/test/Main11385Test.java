import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class Main11385Test {
    
    @BeforeClass
    public static void setup() {
    }
    
    @Test
    public void example() {        
        assertEquals("THE MONA LISA", Main11385.decode(new long[] {13, 2, 89, 377, 8, 3, 233, 34, 144, 21, 1}, "OH, LAME SAINT!"));
        assertEquals("LEONARDO DA VINCI", Main11385.decode(new long[] {34, 21, 13, 144, 1597, 3, 987, 610, 8, 5, 89, 2, 377, 2584, 1}, "O, DRACONIAN DEVIL!"));        
    }
    
    @Test
    public void simple() {        
        assertEquals("ABCDEFGH", Main11385.decode(new long[] {1, 2, 3, 5, 8, 13, 21, 34}, "ABCDEFGH"));                
    }
    
    @Test
    public void oneChar() {        
        assertEquals("Z", Main11385.decode(new long[] {1}, "auhdceh813erZauisd"));                
    }
    
    @Test
    public void reverted() {        
        assertEquals("ABCDEFGH", Main11385.decode(new long[] {34, 21, 13, 8, 5, 3, 2, 1}, "HGFEDCBA"));                
    }
    
    @Test
    public void threespaces() {        
        assertEquals("A   B", Main11385.decode(new long[] {8, 1}, "Baswe1Aadv"));                
    }
    
    @Test
    public void simpleThreeChars() {        
        assertEquals("THE", Main11385.decode(new long[] {2, 3, 1}, "aaaaaaaaaHET"));                
    }
    
    @Test
    public void simpleSixCharsWithSpace() {        
        assertEquals("THE END", Main11385.decode(new long[] {2, 3, 1, 21, 13, 8}, "HEiTDNEssssss123"));                
    }
}