package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.NumberException;
import model.Figures;

class FiguresTest {

    @Test
    void test1() {
        Figures f = new Figures("1112345678", "My Toy", "My Brand", 69.9, 3, 3, "Hello");
        assertEquals("1112345678", f.getSN());
    }

    @Test
    void test2() throws NumberException {
        Figures f = new Figures("1112345678", "My Toy", "My Brand", -69.9, 3, 3, "Hello");

        if (f.getPrice() < 0) {
            try {
                throw new NumberException("Price cannot be negative");
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            }
        } else {
            fail("Test failed: Price is not negative");
        }
    }

}
