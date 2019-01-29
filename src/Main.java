import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] files = {"a_example.in", "b_small.in", "c_medium.in", "d_big.in"};
        PizzaSlicer pizzaSlicerStrategie = new StupidPizzaSlicer();

        for (String file : files) {
            InputReader inputReader = new InputReader(file);
            PizzaFileWriter pizzaFileWriter =
                    new PizzaFileWriter(pizzaSlicerStrategie.getClass().getName() + "_" + file);

            // Call Input Reader
            Pizza pizza = inputReader.read();

            // Pizza Slicing
            pizzaSlicerStrategie.cutPizza(pizza);

            // Call output writer
            pizzaFileWriter.generateOutput(pizza);
        }
    }
}
