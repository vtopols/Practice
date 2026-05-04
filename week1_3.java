import java.util.Scanner;

public class Main{
    public void main() {
        String[] arr = {"квадрат", "круг", "прямоугольник"};
        String figure = "";
        Scanner scan = new Scanner(System.in);
        boolean found = false;
        while (true) {
            System.out.print("Введите тип фигуры:");
            figure = scan.nextLine();
            for (String s : arr) {
                if (s.equals(figure)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            } else {
                System.out.println("неверный тип фигуры");
            }
        }

        S s = new S(figure);
        if (figure.equals("квадрат")) {
            double a = 0;
            while (true) {
                System.out.print("Введите сторону А: ");
                if (scan.hasNextDouble()) {
                    a = scan.nextDouble();
                    if (a<=0) {
                        System.out.println("Введите положительное число!");
                        continue;}
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            scan.close();
            System.out.print("Площадь квадрата: " + s.Square(a));

        } else if (figure.equals("круг")) {
            double r = 0;
            while (true) {
                System.out.print("Введите радиус: ");
                if (scan.hasNextDouble()) {
                    r = scan.nextDouble();
                    if (r<=0) {
                        System.out.println("Введите положительное число!");
                        continue;}
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            scan.close();
            System.out.print("Площадь круга: " + s.Circle(r));

        } else {
            double a = 0;
            double b = 0;
            while (true) {
                System.out.print("Введите сторону А: ");
                if (scan.hasNextDouble()) {
                    a = scan.nextDouble();
                    if (a<=0) {
                        System.out.println("Введите положительное число!");
                        continue;}
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            while (true) {
                System.out.print("Введите сторону B: ");
                if (scan.hasNextDouble()) {
                    b = scan.nextDouble();
                    if (b<=0) {
                        System.out.println("Введите положительное число!");
                        continue;}
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            scan.close();
            System.out.print("Площадь квадрата: " + s.Rectangle(a, b));
        }
    }
}

class S{
    public S(String figure){
    }

    public double Square(double a) {
        return a*a;
    }

    public double Circle(double r) {
        return r * r * 3.14;
    }

    public double Rectangle(double a, double b) {
        return a*b;
    }
}
