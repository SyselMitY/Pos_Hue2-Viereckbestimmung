package viereckbestimmung;

public class Punkt {

    double x;
    double y;

    public Punkt() {
        this.x = 0;
        this.y = 0;
    }

    Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
