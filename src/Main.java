import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] files = {"a_example.in", "b_small.in", "c_medium.in", "d_big.in"};

        for (int i = 0; i < files.length; i++) {
            InputReader inputReader = new InputReader(files[i]);
            PizzaFileWriter pizzaFileWriter = new PizzaFileWriter(files[i]);

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
