import java.awt.*;

public class HorizontalWithRandomPizzaSlicer implements PizzaSlicer {
    private int countTomato = 0, countMushroom = 0;
    private int sliceStartRow = 0, sliceStartCol = 0;
    private Pizza pizza;
    private char[][] ingredient;
    private int maxNrOfCells;
    private int minNrOfIngredient;
    private int freePlace;
    private int totalPlace;

    public HorizontalWithRandomPizzaSlicer() {
    }

    public void cutPizza(Pizza pizza) {

        int pizzaCounter = 0;
        this.pizza = pizza;

        maxNrOfCells = pizza.getMaxNrOfCells();
        minNrOfIngredient = pizza.getMinNrOfIngredient();
        ingredient = pizza.getIngrediants();

        freePlace = pizza.getCols() * pizza.getRows();
        totalPlace = freePlace;

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
                    System.out.println(freePlace);
                    pizzaCounter++;
                    reset(row, col + 1);
                }
            }
            reset(row + 1, 0);
        }
        System.out.println("Total: " + pizzaCounter);
        randomCut(pizza, pizza.getRows(), pizza.getCols());
    }

    private void randomCut(Pizza pizza, int rows, int cols) {
        this.pizza = pizza;
        int startRow = 0, startCol = 0;
        while (totalPlace * 0.5 < freePlace) {
            startRow = (int) (Math.random() * (rows));
            startCol = (int) (Math.random() * (cols));
            int row = startRow + (int) (Math.random() * ((rows - startRow)));
            int col = startCol + (int) (Math.random() * ((cols - startCol)));

            if (isValidCut(startRow, row, startCol, col)) {
                cut(startRow, row, startCol, col);
                System.out.println(freePlace);
            }
        }
    }

    private boolean isValidCut(int fromRow, int toRow, int fromCol, int toCol) {
        int countMushroom = 0;
        int countTomato = 0;

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromCol; j <= toCol; j++) {
                if (ingredient[i][j] == 'M') {
                    countMushroom++;
                } else if (ingredient[i][j] == 'T') {
                    countTomato++;
                } else {
                    return false;
                }
            }
        }

        if (countMushroom + countTomato <= pizza.getMaxNrOfCells()) {
            return countMushroom >= pizza.getMinNrOfIngredient() && countTomato >= pizza.getMinNrOfIngredient();
        }
        return false;
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
                freePlace--;
            }
        }
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
