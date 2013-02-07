package s8189.videoteka;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Klient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numerKlienta;
	private String imie;
	private String nazwisko;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="klientId") 
        private List<Film> filmy;
        
	public Klient() {
	}
	
	public Klient(String imie, String nazwisko) {
		this.imie = imie;
		this.nazwisko = nazwisko;
	}

	public int getNumerKlienta() {
		return numerKlienta;
	}

	public void setNumerKlienta(int numerKlienta) {
		this.numerKlienta = numerKlienta;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void pokazKlienta() {
		System.out.println("Nr: " + numerKlienta
				+ " | " + imie + " " + nazwisko);
	}

	public List<Film> getFilmy() {
		return filmy;
	}

	public void setFilmy(List<Film> filmy) {
		this.filmy = filmy;
	}

}