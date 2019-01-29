import java.io.*;

public class InputReader {
    private Pizza pizza;
    private boolean isFistline = true;
    private int rows, cols, minxNrOfIngredient, maxNrOfCells;


    public InputReader() {
        pizza = new Pizza();
        read();
    }


    private void read() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("b_small.in"))))) {
            String line;
            while ((line = br.readLine()) != null) {

                if(isFistline){
                    createPizza(line);
                }
                isFistline = false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createPizza(String line) {
        String[] firstLine = line.split(" ");
        rows = Integer.parseInt(firstLine[0]);
        cols = Integer.parseInt(firstLine[1]);
        minxNrOfIngredient = Integer.parseInt(firstLine[2]);
        maxNrOfCells = Integer.parseInt(firstLine[3]);

    }


    public static void main(String[] args) {
        new InputReader();
    }
}
