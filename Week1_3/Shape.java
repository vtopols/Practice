public class Shape {

    public double square(double side) {
        return side * side;
    }

    public double circle(double radius) {
        return Math.PI * radius * radius;
    }

    public double rectangle(double a, double b) {
        return a * b;
    }
}