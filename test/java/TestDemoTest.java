import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import java.util.stream.Stream;
import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoTest {
    
      private TestDemo testDemo;
    
      @BeforeEach
      void setUp() throws Exception {
        testDemo = new TestDemo();
      }
    
      @ParameterizedTest
      @MethodSource("TestDemoTest#argumentsForAddPositive")
     void assertThatTwoPositiveNumbersAreAddedCorrectly
     (int a, int b, int expected, boolean expectException) {
        
        if (!expectException) {
          assertEquals(expected, (testDemo.addPositive(a, b)));
        } else {
          assertThatThrownBy(() -> testDemo.addPositive(a, b))
              .isInstanceOf(IllegalArgumentException.class);


        }
      }
   
      static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 4, 6, false),
            arguments(-2, 4, 0, true),
            arguments(2, -4, 0, true));
      }
    
      void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        Test(fiveSquared).isEqualTo(25);
    
        
      }

      private AbstractAssert<?, ? extends Throwable> Test(int fiveSquared) {
        // TODO Auto-generated method stub
        return null;
      }
    }
