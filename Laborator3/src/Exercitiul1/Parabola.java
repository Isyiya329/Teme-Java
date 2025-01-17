package Exercitiul1;

public class Parabola
{
    private int a, b, c;
    public Parabola(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] getVarf() {
        double x = -b / (2.0 * a);
        double y = -((b * b) - 4 * a * c) / (4.0 * a);
        return new double[]{x, y};
    }

    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public static double[] calculeazaMijloc(Parabola p1, Parabola p2) {
        double[] varf1 = p1.getVarf();
        double[] varf2 = p2.getVarf();
        double x = (varf1[0] + varf2[0]) / 2;
        double y = (varf1[1] + varf2[1]) / 2;
        return new double[]{x, y};
    }

    public static double calculeazaLungime(Parabola p1, Parabola p2) {
        double[] varf1 = p1.getVarf();
        double[] varf2 = p2.getVarf();
        return Math.hypot(varf2[0] - varf1[0], varf2[1] - varf1[1]);
    }
}
