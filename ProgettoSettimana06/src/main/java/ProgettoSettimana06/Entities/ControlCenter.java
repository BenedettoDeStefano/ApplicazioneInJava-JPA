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
		// TODO Auto-generated method stub

	}

	@Override
	public void unregister(Observer observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notifyObserversChanges() {
		// TODO Auto-generated method stub

	}

}
