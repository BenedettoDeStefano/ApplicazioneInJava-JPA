package ProgettoSettimana06.Entities;

import java.util.ArrayList;
import java.util.List;

import ProgettoSettimana06.Interface.Observer;
import ProgettoSettimana06.Interface.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ControlCenter implements Subject {

	private Long id;
	private List<Sensor> sensors = new ArrayList<>();

	@Override
	public void register(Observer observer) {
		sensors.add((Sensor) observer);

	}

	@Override
	public void unregister(Observer observer) {
		sensors.remove(observer);

	}

	@Override
	public void notifyObserversChanges() {
		for (Sensor sensor : sensors) {
			sensor.checkSmokeLevel();
		}

	}

}
