package s8189.videoteka;

import java.util.ArrayList;
import java.util.List;
import s8189.videoteka.repository.OperacjeDB;

public class Wypozyczalnia {

	private String Nazwa;
	List<Film> Filmy = new ArrayList<Film>();    // zastąpiono bazą
	List<Klient> Klienci = new ArrayList<Klient>(); // zastąpiono bazą

	public Wypozyczalnia(String nazwa,
			List<s8189.videoteka.Film> filmy,
			List<s8189.videoteka.Klient> klient) {
		this.Nazwa = nazwa;
		Filmy = filmy;
		Klienci = klient;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}

	public List<Film> getFilmy() {
		return Filmy;
	}

	public void setFilmy(List<Film> filmy) {
		Filmy = filmy;
	}

	public List<Klient> getKlienci() {
		return Klienci;
	}

	public void setKlienci(List<Klient> klienci) {
		Klienci = klienci;
	}

	public void dodajFilm(String nazwa, String gatunek, int rok_produkcji) {
                OperacjeDB manager =OperacjeDB.getManager();
                manager.saveFilm(new Film(nazwa, gatunek, rok_produkcji));
	}

	public void dodajKlient(String imie, String nazwisko) {
                OperacjeDB manager =OperacjeDB.getManager();
                manager.saveKlient(new Klient(imie, nazwisko));
	}
        
        public void usunKlient(int numer_klienta) {
                Klient klient;
                OperacjeDB manager =OperacjeDB.getManager();
                klient = manager.getKlientById(numer_klienta);
                manager.removeKlient(klient);
	}
        
	public void usunFilm(int numer) {
		Film film;
                OperacjeDB manager =OperacjeDB.getManager();
                film = manager.getFilmById(numer);
                manager.removeFilm(film);
	}

	public void wyswietlFilmy() {
		System.out.println("Lista filmow w naszej videotece:");
		System.out.println();
                
                OperacjeDB manager =OperacjeDB.getManager();
                Filmy = manager.getRentedFilm(false);
                System.out.println("Dostepne:");
		for (Film k : Filmy) {
			k.pokazFilm();
		}
                Filmy = manager.getRentedFilm(true);
                System.out.println();
                System.out.println("Wypozyczone:");
		for (Film k : Filmy) {
			k.pokazFilm();
		}
	}

	public void wyswietlKlienci() {
		System.out.println("Lista klientow:");
		System.out.println();
                
                OperacjeDB manager =OperacjeDB.getManager();
                Klienci = manager.getAllKlient();
		for (Klient k : Klienci) {
			k.pokazKlienta();
		}
	}

        public void wypozycz(int numerfilmu,int numerklienta){
         Film film;
         Klient klient;
                OperacjeDB manager =OperacjeDB.getManager();
                film = manager.getFilmById(numerfilmu);
                klient = manager.getKlientById(numerklienta);
         if(klient!=null && film!=null){
            List<Film> filmy = klient.getFilmy();
            filmy.add(film);
            klient.setFilmy(filmy);
            manager.updateKlient(klient);
         }
         
        }
         
         public void oddaj(int numerfilmu){
         Film film;
                OperacjeDB manager =OperacjeDB.getManager();
                film = manager.getFilmById(numerfilmu);
         if(film!=null){
            film.clearKlient();
            manager.updateFilm(film);
         }  
                
        }
        

}