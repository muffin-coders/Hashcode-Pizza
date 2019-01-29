public class Pizza {
    private static Pizza ourInstance = new Pizza();

    public static Pizza getInstance() {
        return ourInstance;
    }

    private Pizza() {
    }
}
