import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PizzaFileWriter {
    private String filename;

    public PizzaFileWriter(String filename) {
        this.filename = filename;
    }

    public void generateOutput(Pizza pizza) throws IOException {

        List<Slice> slices = pizza.getSlices();

        String fileData = slices.size() + "\n";

        for (Slice slice : slices) {
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
