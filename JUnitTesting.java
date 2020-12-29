package Assignment;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class JUnitTesting {

	@Test
	public void test() {
		Implementations test = new Implementations("data.properties");
		try {
			test.create("ID","abc999");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
