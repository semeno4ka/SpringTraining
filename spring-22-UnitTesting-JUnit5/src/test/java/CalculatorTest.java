import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void beforeAll(){System.out.println("Before all executed");}

    @AfterAll
    static void afterAll(){System.out.println("After all executed");}//static because they are common for all methods


    @BeforeEach
    void setUpEach(){System.out.println("Before each executed");}

    @AfterEach
    void turnDownEach(){ System.out.println("After each executed");}

    @Test
    void add2(){
        System.out.println("Test case add2 method");
       assertThrows(IllegalArgumentException.class,()-> Calculator.add2(3,2));
       //  assertThrows(AccessDeniedException.class,()-> Calculator.add2(3,2));
       //  assertThrows(IllegalArgumentException.class,()-> Calculator.add2(2,3));// exception will be thrown
    }

    @Test
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2, 3);
        assertEquals(5, actual, "Test failed");//in JUnit5 expected goes first, actual second
        //can provide fail message as well
    }

    @Test
    void testCase1() {
        System.out.println("Test case 1");
        fail("Not implemented yet");
    }

    @Test
    void testCase2() {
        System.out.println("Test case 2");
        assertTrue(Calculator.operator.equals("add"));//asserts if operator is equal to operator in the class
        assertEquals("add", Calculator.operator);
    }

    @Test
    void testCase3() {
        System.out.println("Test case 3");
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}, "Arrays are not the same");
    }

    @Test
    void testCase4() {
        System.out.println("Test case 4");
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void testCase5() {
        System.out.println("Test case 5");

        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1,c3);
    }


}