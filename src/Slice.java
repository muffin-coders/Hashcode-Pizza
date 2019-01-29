import java.awt.*;

public class Slice {
    Point rows;
    Point columns;

    public Slice(Point rows, Point columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public Point getColumns() {
        return columns;
    }

    public Point getRows() {
        return rows;
    }
}
