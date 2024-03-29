package test;

import model.Animals;
import exceptions.NumberException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalsTest {
    Animals animal;

    @Test
    void test1(){
        animal = new Animals("1234567890","My Toy","My Brand",42.3,3,3,"Wooden", 'L');
        assertEquals("1234567890", animal.getSN());
    }
/**
 * This is a testing for the NegativePriceException.
 * If a negative number is added in place of the price, it will fail.
 * The try & catch will display the NegativePriceException message, should the test fail.
 */
    @Test
    void test2() throws NumberException {
        animal = new Animals("1234567890","My Toy","My Brand",-42.3,3,3,"Wooden", 'L');

        if (animal.getPrice() < 0) {
            try {
                throw new NumberException("Price cannot be negative");
            } catch (NumberException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            fail();
        }
        
    }

}