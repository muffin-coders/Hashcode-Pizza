import java.awt.*;

public class BetterPizzaSlicer implements PizzaSlicer {
    private Pizza pizza;
    private int pizzaCounter;
    int col = 0;
    int row = 0;
    private int freePlace;

    //TODO NOT WORKING
    public BetterPizzaSlicer() {
    }


    public void cutPizza(Pizza pizza) {
        char[][] array = pizza.getIngrediants();
        randomCut(pizza, array, pizza.getRows(), pizza.getCols());
        print(array);
    }

    private void randomCut(Pizza pizza, char[][] ingredient, int rows, int cols) {
        this.pizza = pizza;
        freePlace = cols * rows;
        int totalPlace = freePlace;
        int startRow = 0, startCol = 0;
        while (totalPlace * 0.25 < freePlace) {
            goDown();

            System.out.println(row + " " + col);
            if (isValidCut(startRow, row, startCol, col, ingredient)) {
                cut(startRow, row, startCol, col, ingredient);
                System.out.println(freePlace);
                startRow = row;
                startCol = col;
            }
            if (row >= pizza.getRows()) {
                row = 0;
                goRight();
            }
        }
    }

    private void goRight() {
        if (col < pizza.getCols())
            col++;
    }

    private void goDown() {
        if (row < pizza.getRows())
            row++;
    }

    private boolean isValidCut(int fromRow, int toRow, int fromCol, int toCol, char[][] ingredient) {
        if (toRow > pizza.getRows())
            return false;
        if (toCol > pizza.getCols())
            return false;
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

    private void cut(int fromRow, int toRow, int fromCol, int toCol, char[][] ingredient) {
        pizzaCounter++;
        System.out.println("I cut a pizza: " + pizzaCounter);
        String pizzaString = String.valueOf(pizzaCounter);

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = fromCol; j <= toCol; j++) {
                ingredient[i][j] = pizzaString.charAt(0);
                freePlace--;
            }
        }

//        print(ingredient);
        pizza.addSlice(new Point(fromRow, toRow), new Point(fromCol, toCol));
    }


    private void print(char[][] matrix) {
        for (char[] row : matrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
