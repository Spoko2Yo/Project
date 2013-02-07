package s8189.videoteka;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Film implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nazwa;
	private int rokProdukcji;
	private String gatunek;
        
        @JoinColumn(name = "klientId", referencedColumnName = "numerKlienta", nullable = true)
        @ManyToOne(optional = true, fetch = FetchType.EAGER)
        private Klient klient;

	public Film(){
		
	}
	
	public Film(String nazwa, String gatunek, int rokProdukcji) {
		this.nazwa = nazwa;
		this.rokProdukcji = rokProdukcji;
		this.gatunek = gatunek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getRokProdukcji() {
		return rokProdukcji;
	}

	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}

	public String getGatunek() {
		return gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}
        
        public void clearKlient() {
		this.klient = null;
	}

	public void pokazFilm() {
		System.out.println("ID:"+ id + "   Nazwa: " + nazwa + "  Gatunek: " + gatunek
				+ "  Rok: " + rokProdukcji);// + "Wypożyczył: " +klient!=null ? klient.getImie(): " " +" "+klient!=null ?  klient.getNazwisko() : "do wypożyczenia" );
	}
}