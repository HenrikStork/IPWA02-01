
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

	String name;
	User user;

	List<User> userListe;

	public LoginController() {
		this.userListe = new ArrayList<User>();
		this.userListe.add(new User("Stork", "123"));
		this.userListe.add(new User("Bock", "456"));
		this.user = new User();
	}

	public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput) ev.getComponent();
		this.name = (String) temp.getValue();
	}

	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		for (User b : userListe) {
			User temp = new User(this.name, (String) value);
			if (b.equals(temp))
				return;
		}
		throw new ValidatorException(new FacesMessage("Inkorrekter Benutzername oder Passwort!"));
	}

	public String login() {
			return "editierbar1?faces-redirect=true";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
