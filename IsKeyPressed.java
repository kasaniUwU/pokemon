public class IsKeyPressed {
    private static volatile boolean wPressed = false;

    public static boolean isWPressed() {
        synchronized (IsKeyPressed.class) {
            return wPressed;
        }
    }
}