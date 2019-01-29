import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PizzaFileWriter {

    private Pizza pizza;

    public PizzaFileWriter(Pizza pizza) {
        this.pizza = pizza;
    }

    public void generateOutput(String filename) throws IOException {

        List<Slice> slices = pizza.getSlices();

        String fileData = slices.size() + "\n";

        for(Slice slice : slices) {
            Point col = slice.getColumns();
            Point row = slice.getRows();
            fileData += row.x + " " + col.x + " " + row.y + " " + col.y + "\n";
        }

        FileOutputStream fos = new FileOutputStream("output_" + filename + ".txt");
        fos.write(fileData.getBytes());
        fos.flush();
        fos.close();

    }

}
