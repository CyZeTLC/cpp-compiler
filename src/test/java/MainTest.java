import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void appHasAGreeting() {
        Main classUnderTest = new Main();
        assertNotNull(classUnderTest);
    }

    @Test
    void doubleNegative() {
        int val = de.cyzetlc.Main.solve("--4").v();
        assertEquals(4, val);
    }

    @Test
    void onlyZero() {
        int val = de.cyzetlc.Main.solve("0").v();
        assertEquals(0, val);
    }

    @Test
    void correctOrderDiv() {
        int val = de.cyzetlc.Main.solve("4+4/2").v();
        assertEquals(6, val);
    }

    @Test
    void correctOrderMul() {
        int val = de.cyzetlc.Main.solve("4+4*2").v();
        assertEquals(12, val);
    }

    @Test
    void correctUsageOfBrackets() {
        int val = de.cyzetlc.Main.solve("(4+4)*2").v();
        assertEquals(16, val);
    }
}
