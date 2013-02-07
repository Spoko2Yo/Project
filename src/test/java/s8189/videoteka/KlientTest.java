
package s8189.videoteka;

import s8189.videoteka.Klient;

import junit.framework.Assert;
import org.junit.Test;


public class KlientTest {
    
    
    @Test
	public void testConstructor(){
		
		Klient k = new Klient("IMIE", "NAZWISKO");
		Assert.assertTrue(k.getImie().equals("IMIE"));
		Assert.assertTrue(k.getNazwisko().equals("NAZWISKO"));
	}
    
}