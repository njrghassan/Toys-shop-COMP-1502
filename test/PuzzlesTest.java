package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.NumberException;
import model.Puzzles;

class PuzzlesTest {

    @Test
    void test1() {
        Puzzles p = new Puzzles("1987654321", "My Toy", "My Brand", 42.9, 3, 3, 'M');
        assertEquals("1987654321", p.getSN());
    }

    @Test
    void test2() throws NumberException {
        Puzzles p = new Puzzles("1987654321", "My Toy", "My Brand", -42.9, 3, 3, 'M');

        if (p.getPrice() < 0) {
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
