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

	@Override
	public void checkSmokeLevel() {

	}

}
