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
    Assertions.assertEquals(0,num %3);
  }//check if all can be divided by 3 with 0 remainder, 3 tests

  @ParameterizedTest
  @ValueSource(strings ={"Java","JS","Python"})//single parameter
 // @EmptySource   //passes "" empty argument after ValueSource
 // @NullSource    //passes null argument after ValueSource
  @NullAndEmptySource// passes null and then empty arguments after ValueSource
  void testCase3(String arg) {
    Assertions.assertFalse(arg.isEmpty());
  }

  @ParameterizedTest
  @MethodSource("stringProvider")// the name of the factory method
  void testCase4(String arg) {
    Assertions.assertFalse(arg.isEmpty());
  }
  static String[] stringProvider(){//factory method, which provides data
    return new String[]{"Java","JS","TS"};}
  @ParameterizedTest
  @CsvSource({
          "10,20,30",
          "20,20,40",
          "30,20,100"//num, num, result
  })
  void testCase5(int num1, int num2, int result){

    Assertions.assertEquals(result, Calculator.add(num1,num2));
  }

  @ParameterizedTest // skip first line in csv, because it causes a problem
  @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    //by default looks in resource folder,can use full path
  void testCase6(int num1, int num2, int result){
    Assertions.assertEquals(result, Calculator.add(num1,num2));
  }


}
