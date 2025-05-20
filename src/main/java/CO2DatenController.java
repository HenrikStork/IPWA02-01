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
		liste = d1.findAll(); 
	}

	public List<CO2Daten> getListe() {
		return liste; 
	}

	public String stopEdit() {
		d1.saveAll(liste); 
		return "editierbar1?faces-redirect=true";
	}

	public void addNewRow() {
		liste.add(new CO2Daten()); 
	}

	public String startEdit() {
		return "editierbar2?faces-redirect=true";
	}
	
	public void entferneEintrag(CO2Daten eintrag) {
	    d1.remove(eintrag);
	    liste.remove(eintrag); 
	}
}
