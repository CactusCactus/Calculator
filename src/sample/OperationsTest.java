package sample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Created by jakub on 17.01.2017.
 */
class OperationsTest {

    @Test
    public void testAdd(){
        Assertions.assertEquals(5,3,2);
    }
    @Test
    public void testSubstract(){
        Assertions.assertEquals(5,10,5);
    }
    @Test
    public void testMultiply(){
        Assertions.assertEquals(6,3,2);
    }
    @Test
    public void testDevide(){
        Assertions.assertEquals(5,25,5);
    }
}