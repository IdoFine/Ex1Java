package code;
import static code.Ex1.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ex1Test {
    @Test
    void computeNumberTest() {
        String s2 = "1011b2";
        int v = Ex1.number2Int(s2);
        assertEquals(v, 11);
        String s10 = "1011bA";
        v = Ex1.number2Int(s10);
        s2 = Ex1.int2Number(v, 2);
        int v2 = Ex1.number2Int(s2);
        assertEquals(v, v2);
        assertTrue(Ex1.equals(s10, s2));
    }
    @Test
    void isBasisNumberTest() {
        String[] good = {"1", "1b2", "01b2", "123bA", "ABbG", "0bA"};
        for (int i = 0; i < good.length; i = i + 1) {
            boolean ok = Ex1.isNumber(good[i]);
            assertTrue(ok);
        }

        String[] not_good = {"b2", "2b2", "1G3bG", "0bbA", "abB", "!@b2", "A", "1bb2"};
        for (int i = 0; i < not_good.length; i = i + 1) {
            boolean not_ok = Ex1.isNumber(not_good[i]);
            assertFalse(not_ok);
        }


    }
    @Test
    void int2NumberTest() {
        assertEquals("0b2", Ex1.int2Number(0, 2));
        assertEquals("111b2", Ex1.int2Number(7, 2));
        assertEquals("7", Ex1.int2Number(7, 10));
        assertEquals("FbG", Ex1.int2Number(15, 16));
        assertEquals("", Ex1.int2Number(-1, 10));
        assertEquals("", Ex1.int2Number(10, 17));
    }


    @Test
    void maxIndexTest() {
        String[] arr = {"1", "10b2", "FFbG", null, "0"};
        assertEquals(2, Ex1.maxIndex(arr));

        String[] arr2 = {"101b2", "5", "10b2"};
        assertEquals(0, Ex1.maxIndex(arr2));

        String[] arr3 = {null, "ZZbG", "1"};
        assertEquals(2, Ex1.maxIndex(arr3));

    }

    @Test
    void number2IntTest() {
        // Valid inputs
        assertEquals(5, Ex1.number2Int("101b2"));
        assertEquals(255, Ex1.number2Int("FFbG"));
        assertEquals(0, Ex1.number2Int("0"));

        // Edge cases
        assertEquals(1, Ex1.number2Int("1b2"));
        assertEquals(0, Ex1.number2Int("0bA"));
        assertEquals(7, Ex1.number2Int("007"));

        // Invalid inputs
        assertEquals(-1, Ex1.number2Int("GAbG"));
        assertEquals(-1, Ex1.number2Int("123b20"));
        assertEquals(-1, Ex1.number2Int("123b1"));
        assertEquals(-1, Ex1.number2Int(""));
        assertEquals(-1, Ex1.number2Int(null));
    }
}

