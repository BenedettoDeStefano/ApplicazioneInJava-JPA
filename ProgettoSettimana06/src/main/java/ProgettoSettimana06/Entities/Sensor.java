package ProgettoSettimana06.Entities;

import ProgettoSettimana06.Interface.Observer;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sensor implements Observer {

	private Long id;
	private Integer smokeLevel = 0;
	private String latitude;
	private String longitude;

	public String generateAlert() {
		return "http://host/alarm?idsonda=" + id + "&lat=" + latitude + "&lon=" + longitude + "&smokelevel="
				+ smokeLevel;
	}

	@Override
	public void checkSmokeLevel() {
		if (this.smokeLevel >= 5) {
			System.err.println("🚨 ALERT Sensor " + id + " has detected smoke level of " + smokeLevel + ", latitude: "
					+ latitude + " longitude: " + longitude + " 🚨");
			System.out.println("⚠️ Control Center has sent the notification URL: " + generateAlert() + " ⚠️");
		}
	}

}
