import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

  @ParameterizedTest
  @ValueSource(strings ={"Java","JS","Python"})//single parameter
  void testCase1(String arg) {
    Assertions.assertFalse(arg.isEmpty());//check each input from array -> 3 parameters, 3 tests
  }

  @ParameterizedTest
  @ValueSource(ints ={3,6,9})//single parameter
  void testCase2(int num) {
    Assertions.assertEquals(0,num %3);//check if all can be divided by 3 with 0 reminder, 3 tests
  }

  @ParameterizedTest
  @ValueSource(strings ={"Java","JS","Python"})//single parameter
//  @EmptySource   //argument becomes "" empty
//  @NullSource    //argument becomes null
  @NullAndEmptySource
  void testCase3(String arg) {
    Assertions.assertFalse(arg.isEmpty());
  }

  @ParameterizedTest
  @MethodSource("stringProvider")
  void testCase4(String arg) {
    Assertions.assertFalse(arg.isEmpty());//check each input from array -> 3 parameters, 3 tests
  }

  static String[] stringProvider(){
    return new String[]{"Java","JS","TS"};// will run test for each of element
  }
}
