import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Call Input Reader
        Pizza pizza = (new InputReader()).read();

        // Pizza Slicing
        PizzaSlicer pizzaSlicer = new StupidPizzaSlicer();

        pizzaSlicer.cutPizza(pizza);

        // Call output writer
        (new PizzaFileWriter(pizza)).generateOutput();
    }
}
