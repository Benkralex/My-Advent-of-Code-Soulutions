package de.benkralex;

import java.util.ArrayList;
import java.util.List;

public class Coordinats {
    char target;
    int x;
    int y;
    List<Integer> intNearBy = new ArrayList<>();
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
