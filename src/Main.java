import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] files = {"a_example.in", "b_small.in", "c_medium.in", "d_big.in"};

        for (String file : files) {
            InputReader inputReader = new InputReader(file);
            PizzaFileWriter pizzaFileWriter = new PizzaFileWriter(file);

            // Call Input Reader
            Pizza pizza = inputReader.read();

            // Pizza Slicing
            PizzaSlicer pizzaSlicer = new StupidPizzaSlicer();

            pizzaSlicer.cutPizza(pizza);

            // Call output writer
            pizzaFileWriter.generateOutput(pizza);
        }
    }
}
