package ProgettoSettimana06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ProgettoSettimana06.Entities.ControlCenter;
import ProgettoSettimana06.Entities.Sensor;

@SpringBootApplication
public class ProgettoSettimana06Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimana06Application.class, args);

		ControlCenter controlCenter = new ControlCenter();

		Sensor sensor1 = new Sensor(111111L, 0, "5783924", "6564737");
		Sensor sensor2 = new Sensor(222222L, 10, "7567567", "24352");
		Sensor sensor3 = new Sensor(333333L, 2, "987043", "763788");
		Sensor sensor4 = new Sensor(444444L, 8, "2454466", "5464634");

		controlCenter.register(sensor1);
		controlCenter.register(sensor2);
		controlCenter.register(sensor3);
		controlCenter.register(sensor4);

		controlCenter.notifyObserversChanges();
	}

}
