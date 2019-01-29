import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int rows, cols, minxNrOfIngredient, maxNrOfCells;
    private List<Slice> slices = new ArrayList<>();

    public List<Slice> getSlices() {
        return slices;
    }

    public Pizza(int rows, int cols, int minxNrOfIngredient, int maxNrOfCells) {
        this.rows = rows;
        this.cols = cols;
        this.minxNrOfIngredient = minxNrOfIngredient;
        this.maxNrOfCells = maxNrOfCells;
    }
}



