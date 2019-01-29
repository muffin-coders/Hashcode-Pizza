import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class PizzaFileWriterTest {

    @Test
    public void test() {
        Pizza pizza = new Pizza(0,0, 0,0,new char[0][0]);
        pizza.addSlice(new Point(0,2),new Point(3,4));
        pizza.addSlice(new Point(5,6),new Point(7,8));
        pizza.addSlice(new Point(9,10),new Point(11,12));
        PizzaFileWriter pfw = new PizzaFileWriter(pizza);
        try {
            pfw.generateOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}