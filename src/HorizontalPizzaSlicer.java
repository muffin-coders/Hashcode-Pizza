import java.awt.*;

public class HorizontalPizzaSlicer implements PizzaSlicer {
    private int countTomato = 0, countMushroom = 0;
    private int sliceStartRow = 0, sliceStartCol = 0;
    private Pizza pizza;
    private char[][] ingredient;
    private int maxNrOfCells;
    private int minNrOfIngredient;

    public HorizontalPizzaSlicer() {
    }

    public void cutPizza(Pizza pizza) {
        int pizzaCounter = 0;
        this.pizza = pizza;

        maxNrOfCells = pizza.getMaxNrOfCells();
        minNrOfIngredient = pizza.getMinNrOfIngredient();
        ingredient = pizza.getIngrediants();

        reset(0, 0);


        for (int row = 0; row < pizza.getRows(); row++) {
            for (int col = 0; col < pizza.getCols(); col++) {
                if (ingredient[row][col] == 'M') {
                    countMushroom++;
                }
                if (ingredient[row][col] == 'T') {
                    countTomato++;
                }
                if (ingredient[row][col] == 'X') {
                    break;
                }

                if (maxNrOfCells <= (countMushroom + countTomato)) {
                    reset(row, col);
                }
                if (countMushroom >= minNrOfIngredient && countTomato >= minNrOfIngredient) {
                    cut(sliceStartRow, row, sliceStartCol, col);
                    System.out.println("I cut a pizza");
                    pizzaCounter++;
                    reset(row, col + 1);
                }
            }
            reset(row + 1, 0);
            System.out.println("next row");
        }
        System.out.println("Total: " + pizzaCounter);
    }

    private void print(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private void cut(int fromRow, int toRow, int fromCol, int toCol) {
        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromCol; j <= toCol; j++) {
                ingredient[i][j] = 'X';
            }

        }
        System.out.println(fromCol);
        System.out.println(toCol);
        pizza.addSlice(new Point(fromRow, toRow), new Point(fromCol, toCol));
    }

    private void reset(int row, int col) {
        sliceStartRow = row;
        sliceStartCol = col;
        countMushroom = 0;
        countTomato = 0;
    }

    private void probability() {

    }
}
