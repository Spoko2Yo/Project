
package s8189.videoteka;

import s8189.videoteka.Film;

import junit.framework.Assert;
import org.junit.Test;

public class FilmTest {
    
    
    @Test
	public void testConstructor(){
		
		Film k = new Film("NAME", "GENER",2000);
		Assert.assertTrue(k.getNazwa().equals("NAME"));
		Assert.assertTrue(k.getGatunek().equals("GENER"));
                Assert.assertTrue(k.getRokProdukcji()==2000);
	}
    
}
