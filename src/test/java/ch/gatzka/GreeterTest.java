package ch.gatzka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {

  @Test
  void testDefaultGreeter() {
    Greeter greeter = Greeter.withDefaults();
    assertEquals("Hello World!", greeter.greet("World"));
  }

  @Test
  void testCustomPatternGreeter() {
    Greeter greeter = Greeter.withPattern("Hi, %s!");
    assertEquals("Hi, Alice!", greeter.greet("Alice"));
  }

  @ParameterizedTest
  @CsvSource({
      "World, Hello World!",
      "Alice, Hello Alice!",
      "Bob, Hello Bob!"
  })
  void testGreetWithDifferentNames(String name, String expected) {
    Greeter greeter = Greeter.withDefaults();
    assertEquals(expected, greeter.greet(name));
  }

  @ParameterizedTest
  @ValueSource(strings = {"John", "Jane", "Developer"})
  void testGreeterWithValueSource(String name) {
    Greeter greeter = Greeter.withDefaults();
    assertEquals("Hello " + name + "!", greeter.greet(name));
  }

}