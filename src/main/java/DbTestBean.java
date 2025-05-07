
import java.io.Serializable;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Named("DbTestBean")
@ViewScoped
public class DbTestBean implements Serializable {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ipwa02-01");

    private String message;

    public String saveArtikel() {
        EntityManager em = emf.createEntityManager(); // MANUELL!
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            User user = new User();
            user.setId(1L);
            user.setName("Test Artikel");
            em.persist(user);
            tx.commit();
            message = "Artikel wurde gespeichert!";
            return null; // bleibt auf derselben Seite
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            message = "Fehler beim Speichern des Artikels.";
            return null;
        } finally {
            em.close();
        }
    }

    public String getAnzahlArtikel() {
        EntityManager em = emf.createEntityManager();
        try {
            long count = em.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult();
            message = "Anzahl der Artikel: " + count;
            return null;
        } finally {
            em.close();
        }
    }
    
    public String getMessage() {
        return message;
    }
}
<!-- Kommentar  
<h:form>
	Button zum Speichern des Artikels 
	<h:commandButton value="Artikel speichern"
		action="#{DbTestBean.saveArtikel}" />
	<br />
	<br />

	Button zum Abrufen der Anzahl der Artikel 
	<h:commandButton value="Anzahl der Artikel anzeigen"
		action="#{DbTestBean.getAnzahlArtikel}" />
	<br />
	<br />
	 Nachricht aus der Bean anzeigen 
	<h:outputText value="#{DbTestBean.message}" />
</h:form>
-->

public String stopEdit() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ipwa02-01");
	
	EntityManager em = emf.createEntityManager();
    EntityTransaction t = em.getTransaction();
    t.begin();
    for (CO2Daten a : getListe())
      em.merge(a);
    t.commit();
    return "editierbar1?faces-redirect=true";
}
