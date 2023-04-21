package com.simplicity;
import java.util.*;

public class Point {
    private int x;
    private int y;
    private int hashCode;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.hashCode = Objects.hash(x,y);
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

    @Override
    public String toString() {
        return String.format("<%d, %d>",getX(),getY());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point that = (Point) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}

