package s8189.videoteka;

import s8189.videoteka.Klient;
import s8189.videoteka.Film;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import s8189.videoteka.repository.OperacjeDB;

public class KlientOperacjeTest {

	@Test
	public void testFilmSave(){
		
		Film k = new Film("Dr No", "akcja",1967);
		OperacjeDB operacje = new OperacjeDB();
		List<Film> allFilm = operacje.getAllFilm();
                operacje.saveFilm(k);
                List<Film> allFilm2 = operacje.getAllFilm();
		Assert.assertTrue(allFilm.size()+1 == allFilm2.size());
		
	}
	
	@Test
	public void testAllKlient(){
		
		// stworzenie kllienta
		Klient k = new Klient("Jan", "Kowalski");
		Klient p = new Klient("Piotr", "Nowak");
		
		OperacjeDB klientOperacje = new OperacjeDB();
		List<Klient> allKlient = klientOperacje.getAllKlient();
		// zapisanie do bazy
		klientOperacje.saveKlient(k);
		klientOperacje.saveKlient(p);

		//pobranie klienta
		List<Klient> allKlientafter = klientOperacje.getAllKlient();
		
		// sprawdzenie 
		Assert.assertNotNull(allKlient);
		Assert.assertTrue(allKlient.size()+2 == allKlientafter.size() );
		
	}
	
}
