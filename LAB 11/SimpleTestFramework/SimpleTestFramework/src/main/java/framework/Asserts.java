package framework;

public class Asserts {
    public static void assertEquals(int x, int y) {
        if (x != y) System.out.println("Fails: " + y + " was expected but result is " + x);
    }
}
