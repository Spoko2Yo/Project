package s8189.videoteka;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {

		List<Film> SprzetyWodne = new ArrayList<Film>();
		List<Klient> Klienci = new ArrayList<Klient>();

		Wypozyczalnia nowa = new Wypozyczalnia("nowa", SprzetyWodne,
				Klienci);

               
                char znak='?';
                while(znak!='x')
                {
                System.out.println("----------------------------------------------------------");    
                System.out.println("Wybierz opcje");
                System.out.println("1-wypożycz film      2-oddaj film");
                System.out.println("3-wyswietl klientow  4-dodaj klienta  5-usuń klienta");
                System.out.println("6-wyswietl filmy     7-dodaj film     8-usun film");
                System.out.println("x - wyjscie z programu   p - WYPEŁNIJ BAZE DANYMI");
                
                znak = czytajznak();
                switch(znak)
                {
                    case '1':{
                        int numerfilmu,numerklienta;
                        System.out.println("Podaj numer filmu:");
                        numerfilmu = czytajliczbe();
                        System.out.println("Podaj numer klienta:");
                        numerklienta = czytajliczbe();
                        nowa.wypozycz(numerfilmu,numerklienta);
                        break;
                    }
                    case '2':{
                        int numerfilmu;
                        System.out.println("Podaj numer filmu:");
                        numerfilmu = czytajliczbe();
                        nowa.oddaj(numerfilmu);
                        break;
                    }    
                    case '3':{
                        nowa.wyswietlKlienci();
		        System.out.println("----------------------------------------------------------");
                        break;
                    }
                    case '4':{
                        String imie, nazwisko;
                        System.out.println("Podaj imie klienta:");
                        imie = czytajciag();
                        System.out.println("Podaj nazwisko klienta:");
                        nazwisko = czytajciag();
                        nowa.dodajKlient(imie, nazwisko);
                        break;
                    }
                    case '5':{
                        System.out.println("Podaj numer klienta do usuniecia:");
                        //System.out.println(czytajliczbe());
                        nowa.usunKlient(czytajliczbe());
                        break;
                    }    
                    case '6':{
                        nowa.wyswietlFilmy();
		        System.out.println("----------------------------------------------------------");
                        break;
                    }
                    case '7':{
                        String nazwa, gatunek;
                        int rok;
                        System.out.println("Podaj tytul filmu:");
                        nazwa = czytajciag();
                        System.out.println("Podaj gatunek:");
                        gatunek = czytajciag();
                        System.out.println("Podaj rok produkcji:");
                        rok = czytajliczbe();
                        nowa.dodajFilm(nazwa, gatunek, rok);
                        break;
                    }
                    case '8':{
                        System.out.println("Podaj numer filmu do usuniecia:");
                        nowa.usunFilm(czytajliczbe());
                        break;
                    }
                        
                    case 'p':{
                        nowa.dodajFilm("Kopciuszek", "romans", 1995);                        
                        nowa.dodajFilm("Hobbit", "fntasy", 2013);                       
                        nowa.dodajFilm("Niezniszczalni", "akcja", 2012);                       
                        nowa.dodajFilm("Transformers", "akcja", 2009);                       
                        nowa.dodajFilm("Skyfall", "akcja", 2012);                       
                        nowa.dodajFilm("Dumbo", "bajka", 1975);                       
                        nowa.dodajFilm("Pat i kot", "bajka", 1997);                       
                        nowa.dodajFilm("Terminator", "akcja", 1982);
                        nowa.dodajKlient("Malgorzata", "Frask");
                        nowa.dodajKlient("Jaroslaw", "Kurowski");
                        nowa.dodajKlient("Karol", "Goldburger");
                        nowa.dodajKlient("Janina", "Nowak");
                        nowa.dodajKlient("Kuba", "Bielecki");
                        nowa.dodajKlient("Marta", "Milecka");
                        System.out.println("Baza została wypełniona testowymi danymi");
                        break;
                    } 
                        
                    default:{
                     break;   
                    }    
                 }
                }
	}
        
        public static char czytajznak(){
            char znak='?';
            int koniec = '?';
            try{
             znak = (char) System.in.read();
             do{
             koniec = System.in.read();
             }while (koniec !=10);
             return znak;
            }
            catch(IOException e){
             return znak;
            }
        }
        
        
         public static int czytajliczbe(){
             int liczba;
             String liczbaStream="";
             BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             try{
             liczbaStream = buffer.readLine();    
             }
             catch(IOException e){
             System.out.print("Błąd przy odczycie");    
             }
             liczba = Integer.parseInt(liczbaStream);
             return liczba;
         }
         
         
         public static String czytajciag(){
             
             String liczbaStream="";
             BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             try{
             liczbaStream = buffer.readLine();    
             }
             catch(IOException e){
             System.out.print("Błąd przy odczycie");    
             }
             
             return liczbaStream;
         }
         
}