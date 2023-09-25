package application;

import framework.Inject;
import framework.Test;
import framework.TestClass;

import static framework.Asserts.assertEquals;


@TestClass
public class MyTest {
    @Inject
    Calculator calculator;

    @Test
    public void testMethod1() {
        assertEquals(calculator.add(3), 3);
        assertEquals(calculator.add(5), 9);
    }

    @Test
    public void testMethod2() {
        assertEquals(calculator.add(3), 3);
        assertEquals(calculator.add(7), -1);
    }

}
