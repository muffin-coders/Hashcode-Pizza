import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int rows, cols, maxNrOfIngredient, maxNrOfCells;
    private List<Slice> slices = new ArrayList<>();

    public List<Slice> getSlices() {
        return slices;
    }

    public Pizza(int rows, int cols, int maxNrOfIngredient, int maxNrOfCells) {
        this.rows = rows;
        this.cols = cols;
        this.maxNrOfIngredient = maxNrOfIngredient;
        this.maxNrOfCells = maxNrOfCells;
    }
}



