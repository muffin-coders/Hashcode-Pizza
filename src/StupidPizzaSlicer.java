import java.awt.*;

public class StupidPizzaSlicer implements PizzaSlicer {
    int countTomato = 0, countMushroom = 0;
    int sliceStartRow = 0, sliceStartCol = 0;

    public StupidPizzaSlicer() {
    }

    public void cutPizza(Pizza pizza) {
        int maxNrOfCells = pizza.getMaxNrOfCells();
        int minNrOfIngredient = pizza.getMinNrOfIngredient();
        char[][] ingredient = pizza.getIngrediants();


        for (int row = 0; row < pizza.getRows(); row++) {
            for (int col = 0; col < pizza.getCols(); col++) {
                if (ingredient[row][col] == 'M') {
                    countMushroom++;
                }
                if (ingredient[row][col] == 'T') {
                    countTomato++;
                }

                if (countMushroom >= minNrOfIngredient && countTomato >= minNrOfIngredient) {
                    pizza.addSlice(new Point(sliceStartRow, row), new Point(sliceStartCol, col));
                    reset(row, col);
                }
            }
        }
    }

    private void reset(int row, int col) {
        sliceStartRow = row + 1;
        sliceStartCol = col + 1;
        countMushroom = 0;
        countTomato = 0;
    }
}
