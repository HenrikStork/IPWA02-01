import jakarta.persistence.*;

@Entity
@Table(name = "fiktive_co2_daten")
public class CO2Daten {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column(name = "Land")
    private String land;

    @Column(name = "Jahr")
    private int jahr;

    @Column(name = "CO2_Emission_kt")
    private double co2Emission;

	public CO2Daten() {
	}

	public CO2Daten(int id, String land, int jahr, double co2Emission) {
		this.id = id;
		this.land = land;
		this.jahr = jahr;
		this.co2Emission = co2Emission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public double getCO2Emission() {
		return co2Emission;
	}

	public void setCO2Emission(double cO2Emission) {
		this.co2Emission = cO2Emission;
	}
}
