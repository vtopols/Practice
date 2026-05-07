import java.util.Scanner;

public class Week1_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] arr = {"квадрат", "круг", "прямоугольник"};
        String figure;

        while (true) {
            System.out.print("Введите тип фигуры:");
            figure = scan.nextLine();
            for (String s : arr) {
                if (s.equals(figure)) {
                    break;
                }
            }
            if (figure.equals("квадрат") || figure.equals("круг") || figure.equals("прямоугольник")) {
                break;
            } else {
                System.out.println("неверный тип фигуры");
            }
        }

        Shape calculator = new Shape();

        if (figure.equals("квадрат")) {
            double a;
            while (true) {
                System.out.print("Введите сторону: ");
                if (scan.hasNextDouble()) {
                    a = scan.nextDouble();
                    if (a <= 0) {
                        System.out.println("Введите положительное число!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            System.out.print("Площадь квадрата: " + calculator.square(a));
        } else if (figure.equals("круг")) {
            double r;
            while (true) {
                System.out.print("Введите радиус: ");
                if (scan.hasNextDouble()) {
                    r = scan.nextDouble();
                    if (r <= 0) {
                        System.out.println("Введите положительное число!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            System.out.print("Площадь круга: " + calculator.circle(r));
        } else {
            double a;
            while (true) {
                System.out.print("Введите сторону А: ");
                if (scan.hasNextDouble()) {
                    a = scan.nextDouble();
                    if (a <= 0) {
                        System.out.println("Введите положительное число!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            double b;
            while (true) {
                System.out.print("Введите сторону B: ");
                if (scan.hasNextDouble()) {
                    b = scan.nextDouble();
                    if (b <= 0) {
                        System.out.println("Введите положительное число!");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Формат данных не поддерживается.");
                    scan.next();
                }
            }
            System.out.print("Площадь прямоугольника: " + calculator.rectangle(a, b));
        }

        scan.close();
    }
}
