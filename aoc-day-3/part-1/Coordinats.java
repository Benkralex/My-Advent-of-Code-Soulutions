package de.benkralex;

public class Coordinats {
    char target;
    int x;
    int y;

    public Coordinats(char target, int x, int y) {
        this.target = target;
        this.x = x;
        this.y = y;
    }

    public boolean isNearBy(int x, int y) {
        boolean xNearBy = false;
        boolean yNearBy = false;
        if (x - 1 == this.x) {
            xNearBy = true;
        } else if (x == this.x) {
            xNearBy = true;
        } else if (x + 1 == this.x) {
            xNearBy = true;
        }
        if (y - 1 == this.y) {
            yNearBy = true;
        } else if (y == this.y) {
            yNearBy = true;
        } else if (y + 1 == this.y) {
            yNearBy = true;
        }
        return xNearBy && yNearBy;
    }
}
