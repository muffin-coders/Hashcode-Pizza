import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int rows, cols, minNrOfIngredient, maxNrOfCells;
    private List<Slice> slices = new ArrayList<>();

    public List<Slice> getSlices() {
        return slices;
    }

    public Pizza(int rows, int cols, int minNrOfIngredient, int maxNrOfCells) {
        this.rows = rows;
        this.cols = cols;
        this.minNrOfIngredient = minNrOfIngredient;
        this.maxNrOfCells = maxNrOfCells;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getMinNrOfIngredient() {
        return minNrOfIngredient;
    }

    public int getMaxNrOfCells() {
        return maxNrOfCells;
    }
}




