package s8189.videoteka.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import s8189.videoteka.Klient;
import s8189.videoteka.Film;

public class OperacjeDB {
    
    public static OperacjeDB instance;
    
    public  static OperacjeDB getManager() {
        if (instance == null) {
            instance = new OperacjeDB();
        }
        return instance;
    }

	public void saveKlient(Klient klient) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(klient);
		session.getTransaction().commit();
		session.close();
	}
        
        
        	public void updateKlient(Klient klient) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(klient);
		session.getTransaction().commit();
		session.close();
	}
                
                public void updateFilm(Film film) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(film);
		session.getTransaction().commit();
		session.close();
	}
        
        	public void removeKlient(Klient klient) {
		// otwiera sesje hibernate
                //klient.setNumerKlienta(2);
                try{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		// otwiera transakcje bazy danych
		session.beginTransaction();
		// zapisuje studenta
		session.delete(klient);
		// commituje transakcje, zatwierdza
		session.getTransaction().commit();
		// zamkniecie sesji
		session.close();
                System.out.println("Usunieto klienta");  
                }
                catch(IllegalArgumentException e)
                {
                System.out.println("Nie ma klienta o tym numerze");   
                }
	}

	public Klient getKlientById(int id) {
                try{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Klient k = (Klient) session.get(Klient.class, id);
		session.getTransaction().commit();
		session.close();

		return k;
                }
                catch(IllegalArgumentException e){
                System.out.println("Nie ma klienta o takim numerze");
                    return null;    
                }
	}

	public List<Klient> getAllKlient() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Klient> klientAll = session.createQuery("from Klient").list();
		session.getTransaction().commit();
		session.close();
		return klientAll;
	}
//-----------------------------filmy
        
        	public void saveFilm(Film film) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(film);
		session.getTransaction().commit();
		session.close();
	}
        
        	public void removeFilm(Film film) {
                try{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(film);
		session.getTransaction().commit();
		session.close();
                System.out.println("Usunieto film");  
                }
                catch(IllegalArgumentException e)
                {
                System.out.println("Nie ma filmu o tym numerze");   
                }
	}

	public Film getFilmById(int id) {
                Film k;
                try{
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		k = (Film) session.get(Film.class, id);
		session.getTransaction().commit();
		session.close();
                return k;
                }
                catch(IllegalArgumentException e)
                {
                System.out.println("Nie ma filmu o tym numerze");
                return null;
                }
	}

	public List<Film> getAllFilm() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Film> filmAll = session.createQuery("from Film").list();
		session.getTransaction().commit();
		session.close();
		return filmAll;
	        }
        
        	public List<Film> getRentedFilm(boolean rented) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
                List<Film> filmAll;
                if(rented){
		filmAll = session.createQuery("from Film where KLIENTID is NOT NULL").list();
                }
                else{
                filmAll = session.createQuery("from Film where KLIENTID is NULL").list();    
                }
		session.getTransaction().commit();
		session.close();
		return filmAll;
	        }
}
