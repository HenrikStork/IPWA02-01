import java.util.List;
import jakarta.persistence.*;

public class CO2DatenDAO {
    private EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("ipwa02-01");

    public List<CO2Daten> findAll() {
        EntityManager em = emf.createEntityManager();
        Query abfrage = em.createQuery("SELECT d FROM CO2Daten d");
        List<CO2Daten> alleDaten = abfrage.getResultList();
        em.close();
        return alleDaten;
    }
    
    public void remove(CO2Daten eintrag) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        CO2Daten merged = em.merge(eintrag); 
        em.remove(merged);
        t.commit();
        em.close();
    }
    
    public void saveAll(List<CO2Daten> liste) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        for (CO2Daten d : liste) {
            if (d.getId() == 0) {
                em.persist(d);
            } else {
                em.merge(d);   
            }
        }
        t.commit();
        em.close();
    }
   
}

