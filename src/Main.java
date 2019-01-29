public class Main {

    public static void main(String[] args) {
        // Call Input Reader
        Pizza pizza = null;
        new InputReader(pizza);

        // Pizza Slicing
        PizzaSlicer pizzaSlicer = new StupidPizzaSlicer();

        pizzaSlicer.cutPizza(pizza);

        // Call output writer
    }
}
