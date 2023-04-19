package simplicity;
import java.util.*;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    } 

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEqual(int x2, int y2) {
        return ((this.x == x2) && (this.y == y2));
    }
}

