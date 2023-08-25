package ProgettoSettimana06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ProgettoSettimana06.Entities.ControlCenter;
import ProgettoSettimana06.Entities.Sensor;

@SpringBootTest
public class ControlCenterTest {
	private ControlCenter controlCenter;
	private Sensor sensor1;
	private Sensor sensor2;

	@BeforeEach
	public void setUp() {
		controlCenter = new ControlCenter();
		sensor1 = new Sensor(111111L, 0, "5783924", "6564737");
		sensor2 = new Sensor(111111L, 0, "5783924", "6564737");
		controlCenter.register(sensor1);
		controlCenter.register(sensor2);
    }

    @Test
	public void testAlertNotification() {
		sensor1.setSmokeLevel(6);
		sensor2.setSmokeLevel(3);
		String expectedMessage = "ALERT Sensor";
		String result = captureConsoleOutput(() -> controlCenter.notifyObserversChanges());
		assertEquals(true, result.contains(expectedMessage));
    }

    @Test
	public void testInRangeNotification() {
		sensor1.setSmokeLevel(8);
		sensor2.setSmokeLevel(1);
		String expectedMessage = "reports normal smoke";
		String result = captureConsoleOutput(() -> controlCenter.notifyObserversChanges());
		assertEquals(true, result.contains(expectedMessage));
    }

	private String captureConsoleOutput(Runnable code) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		System.setOut(new PrintStream(outputStream));
		code.run();
		System.setOut(originalOut);
		return outputStream.toString();
	}
}