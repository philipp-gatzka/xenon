package ch.gatzka;

/**
 * A utility class for generating greeting messages with customizable patterns.
 * <p>
 * This class uses the builder pattern with static factory methods to create instances with either
 * default or custom greeting patterns. The pattern should contain a single {@code %s} placeholder
 * that will be replaced with the name to greet.
 * </p>
 */
public class Greeter {

  private final String pattern;

  /**
   * Creates a new Greeter with the default greeting pattern.
   */
  private Greeter() {
    this("Hello %s!");
  }

  /**
   * Creates a new Greeter with the specified greeting pattern.
   *
   * @param pattern the pattern to use for greetings
   */
  private Greeter(String pattern) {
    this.pattern = pattern;
  }

  /**
   * Generates a greeting message for the specified name.
   *
   * @param name the name to greet
   * @return the formatted greeting message
   */
  public String greet(String name) {
    return String.format(pattern, name);
  }

  /**
   * Creates a new Greeter instance with the default greeting pattern.
   *
   * @return a Greeter with default settings
   */
  public static Greeter withDefaults() {
    return new Greeter();
  }

  /**
   * Creates a new Greeter instance with a custom greeting pattern.
   *
   * @param pattern the pattern to use for greetings
   * @return a Greeter with the specified pattern
   */
  public static Greeter withPattern(String pattern) {
    return new Greeter(pattern);
  }

}
