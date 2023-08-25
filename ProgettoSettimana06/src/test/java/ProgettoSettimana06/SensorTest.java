package ProgettoSettimana06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ProgettoSettimana06.Entities.Sensor;

@SpringBootTest
public class SensorTest {

	private Sensor sensor;

	@BeforeEach
	public void setupSensor() {
		sensor = new Sensor(111111L, 0, "5783924", "6564737");
	}

	@Test
	public void testHighSmoke() {
		sensor.setSmokeLevel(6);
		String expectedMessage = "ALERT Sensor";
		String result = captureConsoleOutput(() -> sensor.checkSmokeLevel());
		assertEquals(true, result.contains(expectedMessage));
	}

	@Test
	public void testNormalSmoke() {
		sensor.setSmokeLevel(3);
		String expectedMessage = "reports normal smoke";
		String result = captureConsoleOutput(() -> sensor.checkSmokeLevel());
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