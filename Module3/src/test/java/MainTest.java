//package src.test.java;
import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testAddition() {
        assertEquals(5, Main.add(2, 3));
    }

    @Test
    public void testNegativeNumbers() {
        assertEquals(-1, Main.add(-2, 1));
    }
}