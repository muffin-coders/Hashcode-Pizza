import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int rows, cols, minNrOfIngredient, maxNrOfCells;
    private List<Slice> slices = new ArrayList<>();
    private char[][] ingrediants;

    public List<Slice> getSlices() {
        return slices;
    }

    public Pizza(int rows, int cols, int minNrOfIngredient, int maxNrOfCells, char[][] ingrediants) {
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

    public char[][] getIngrediants() {
        return ingrediants;
    }

    public void addSlice(Point rows, Point columns) {
        slices.add(new Slice(rows, columns));
    }
}




