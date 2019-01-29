import java.awt.*;

public class PicesPizzaSlicer implements PizzaSlicer {
    private int countTomato = 0, countMushroom = 0;
    private int sliceStartRow = 0, sliceStartCol = 0;
    private Pizza pizza;
    private char[][] ingredient;
    private int maxNrOfCells;
    private int minNrOfIngredient;
    private int pizzaCounter;
    private boolean upDownSearch = false;
    private int pizzaFound;

    public PicesPizzaSlicer() {
    }


    //TODO: NOT WORKING
    public void cutPizza(Pizza pizza) {
        pizzaCounter = 0;
        this.pizza = pizza;

        maxNrOfCells = pizza.getMaxNrOfCells();
        minNrOfIngredient = pizza.getMinNrOfIngredient();
        ingredient = pizza.getIngrediants();

        int row = 0;
        int col = 0;
        reset(row, col);


        while (checkBorder(pizza, row, col)) {
            if (ingredient[row][col] == 'M') {
                countMushroom++;
            }else if (ingredient[row][col] == 'T') {
                countTomato++;
            } else {
                if (upDownSearch) {
                    col++;
                } else {
                    row++;
                }
                reset(row,col);
            }

            if (maxNrOfCells <= (countMushroom + countTomato)) {
                System.out.println("anders");
                reset(sliceStartRow, sliceStartCol);
                upDownSearch = true;
            }

            if (countMushroom >= minNrOfIngredient && countTomato >= minNrOfIngredient) {
                cut(sliceStartRow, row, sliceStartCol, col);
                if (upDownSearch) {
                    reset(row + 1, col);
                } else {
                    reset(row, col + 1);
                }
            }
            if (upDownSearch) {
                row++;

                if (row >= pizza.getRows()) {
                    row = 0;
                    col++;
                    System.out.println("next col");
                    reset(0, col);
                    upDownSearch = false;
                }

            } else {
                col++;

                if (col >= pizza.getCols()) {
                    col = 0;
                    row++;
                    System.out.println("next row");
                    if (pizzaFound > 0) {
                        reset(row, 0);
                    } else {
                        upDownSearch = true;
                        row = sliceStartRow;
                        col = sliceStartCol;
                        reset(row, col);
                    }
                }
            }
        }
        System.out.println("Total: " + pizzaCounter);
        print(ingredient);
    }

    private boolean checkBorder(Pizza pizza, int row, int col) {
        if (upDownSearch) return col < pizza.getCols();
        return row < pizza.getRows();
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
        System.out.println("I cut a pizza");
        pizzaCounter++;
        pizzaFound++;
        String pizzaString = String.valueOf(pizzaCounter);

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromCol; j <= toCol; j++) {
                ingredient[i][j] = pizzaString.charAt(0);
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
