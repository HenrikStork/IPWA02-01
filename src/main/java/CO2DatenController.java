import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Named
@ApplicationScoped
public class CO2DatenController {

	private CO2DatenDAO d1 = new CO2DatenDAO();
	private List<CO2Daten> liste = new ArrayList<>();

	public CO2DatenController() {
		liste = d1.findAll(); // Einmal laden
	}

	public List<CO2Daten> getListe() {
		return liste; // nicht jedes Mal neu laden!
	}

	public String stopEdit() {
		d1.saveAll(liste); // statt: d1.stopEdit()
		return "editierbar1?faces-redirect=true";
	}

	public void addNewRow() {
		liste.add(new CO2Daten()); // leeres Objekt ohne ID → JPA setzt ID automatisch
	}

	public String startEdit() {
		return "editierbar2?faces-redirect=true";
	}
	
	public void entferneEintrag(CO2Daten eintrag) {
	    d1.remove(eintrag);
	    liste.remove(eintrag); // auch aus der lokalen Liste entfernen
	}
}
