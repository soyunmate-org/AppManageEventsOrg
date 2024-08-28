package cl.talentodigital.appmanageevents;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = "cl.talentodigital.appmanageevents")
class AppManageEventsApplicationTests {


	@Test
     void testSuma() {
		int num1 = 5;
		int num2 = 5;

        int resultado = num1 + num2;
        assertEquals(10, resultado, "Debe sumar 10");
    }

	@Test
     void testRest() {
		int num1 = 15;
		int num2 = 3;

        int resultado = num1 - num2;
        assertEquals(12, resultado, "Debe resultar 12");
    }

}
