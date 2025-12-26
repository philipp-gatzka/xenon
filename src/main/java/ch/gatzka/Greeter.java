package ch.gatzka;

public class Greeter {

  private final String pattern;

  private Greeter() {
    this("Hello %s!");
  }

  private Greeter(String pattern) {
    this.pattern = pattern;
  }

  public String greet(String name) {
    return String.format(pattern, name);
  }

  public static Greeter withDefaults() {
    return new Greeter();
  }

  public static Greeter withPattern(String pattern) {
    return new Greeter(pattern);
  }

}
