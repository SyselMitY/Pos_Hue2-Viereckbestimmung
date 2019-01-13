package viereckbestimmung;


import java.util.Scanner;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Viereckbestimmung {

    public static final double EPS = 1E-5;

    public static void main(String[] args) {
        System.out.println(liesPunkt());
    }

    static boolean isViereck(Punkt[] p) {

        if (p == null || p.length != 4) return false;

        for (Punkt punkt : p) {
            if (punkt == null) return false;
        }

        for (int i = 0; i < 3; i++) {
            if (distanz(p[i], p[i + 1]) <= 0) return false;
        }
        return !(distanz(p[3], p[0]) <= 0);

    }

    public static boolean isQuadrat(Punkt[] p) {

        if (!isRaute(p)) return false;

        double e = distanz(p[0], p[2]);
        double f = distanz(p[1], p[3]);

        return isEqual(EPS, e, f);

    }

    static boolean isRechteck(Punkt[] p) {

        if (!isParallelogramm(p)) return false;

        double e = distanz(p[0], p[2]);
        double f = distanz(p[1], p[3]);

        return isEqual(EPS, e, f);
    }

    public static boolean isParallelogramm(Punkt[] p) {

        if (!isViereck(p)) return false;

        double a = distanz(p[0], p[1]);
        double b = distanz(p[1], p[2]);
        double c = distanz(p[2], p[3]);
        double d = distanz(p[3], p[0]);

        return isEqual(EPS, a, c) && isEqual(EPS, b, d);

    }

    public static boolean isRaute(Punkt[] p) {

        if (!isParallelogramm(p)) return false;

        double a = distanz(p[0], p[1]);
        double b = distanz(p[1], p[2]);
        double c = distanz(p[2], p[3]);
        double d = distanz(p[3], p[0]);

        return isEqual(EPS, a, b, c, d);
    }

    public static boolean isDeltoid(Punkt[] p) {

        if (!isViereck(p)) return false;

        double a = distanz(p[0], p[1]);
        double b = distanz(p[1], p[2]);
        double c = distanz(p[2], p[3]);
        double d = distanz(p[3], p[0]);

        return (isEqual(EPS, a, d) && isEqual(EPS, b, c)) || (isEqual(EPS, a, b) && isEqual(EPS, c, d));
    }

    static Punkt liesPunkt() {

        Scanner scanner = new Scanner(System.in);
        Punkt punkt = new Punkt();

        do {
            System.out.print("\tx-Koordinate eigeben --> ");
            if (!scanner.hasNextDouble())
                System.out.println("Es muss ein Doublewert eingegeben werden!");
        } while (!scanner.hasNextDouble());

        punkt.x = scanner.nextDouble();

        do {
            System.out.print("\ty-Koordinate eigeben --> ");
            if (!scanner.hasNextDouble())
                System.out.println("Es muss ein Doublewert eingegeben werden!");
        } while (!scanner.hasNextDouble());

        punkt.y = scanner.nextDouble();

        return punkt;
    }

    static boolean isEqual(double eps, double d1, double d2) {
        return Math.abs(d1 - d2) <= eps;
    }

    static boolean isEqual(double eps, double... values) {
        if (values.length < 2) {
            return false;
        } else {
            for (int i = 1; i < values.length; i++) {
                if (Math.abs(values[i] - values[0]) > eps) return false;
            }
            return true;
        }
    }

    static double distanz(Punkt p, Punkt q) {
        return Math.sqrt(Math.pow(q.x - p.x, 2) + Math.pow(q.y - p.y, 2));
    }

    //Zu lang aufbleiben ist ned gut für mich...
   /* static Punkt[] ordnen(Punkt[] in) {

        if (in == null || in.length != 4) {
            return null;
        }

        Punkt[] out = {new Punkt(0,0),new Punkt(0,0),new Punkt(0,0),new Punkt(0,0)};

        for (Punkt p : in) {
            if (p.x<=out[0].x&&p.y<=out[0].y) out[0] = p;
        }
        for (Punkt p : in) {
            if (p.x>=out[1].x&&p.y<=out[1].y) out[1] = p;
        }
        for (Punkt p : in) {
            if (p.x>=out[2].x&&p.y>=out[2].y) out[2] = p;
        }
        for (Punkt p : in) {
            if (p.x<=out[3].x&&p.y>=out[3].y) out[3] = p;
        }

        return out;
    }*/

}

