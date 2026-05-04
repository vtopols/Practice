import java.util.Scanner;
public class Main {
    void main() {
        Scanner scan = new Scanner(System.in);
        double number = 0;

        while (true) {
            System.out.print("Введите число:");
            if (scan.hasNextDouble()) {
                number = scan.nextDouble();
                break;
            } else {
                System.out.println("Формат данных не поддерживается.");
                scan.next();
            }
        }
        scan.close();

        NumberAnalyzer analyzer = new NumberAnalyzer(number);
        System.out.print("Введённое число:");
        analyzer.Positive();
        analyzer.EvenOdd();
        analyzer.CheckInt();
        analyzer.Easy();
        analyzer.Sqrt();
        analyzer.Square();
    }
}

class NumberAnalyzer {
    private double num;
    public NumberAnalyzer (double num) {
        this.num = num;
    }

    public void Positive() {
        if (num > 0) {
            System.out.print(" положительное,");
        } else if (num<0) {
            System.out.print(" отрицательное,");
        }
    }

    public void CheckInt() {
        if (num == (int) num) {
            System.out.print(" целое,");
        } else {
            System.out.print(" дробное,");
        }
    }

    public void EvenOdd() {
        if (num == (int) num) {
            if (num % 2 == 0) {
                System.out.print(" чётное,");
            } else {
                System.out.print(" нечётное,");
            }
        }
    }

    public void Easy() {
        int a = 0;
        if (num == (int) num) {
            if (num < 2){
                System.out.print(" не простое,");
            } else {
                for (int i = 2; i <= Math.sqrt(num); i += 1) {
                    if (num % i == 0) {
                        a += 1;
                    }
                }
                if (a == 0) {
                    System.out.print(" простое,");
                } else {
                    System.out.print(" не простое,");
                }
            }
        }
    }

    public void Sqrt() {
        if (num>=0) {
            System.out.print(" Корень: " + Math.sqrt(num) + ",");
        }
    }

    public void Square() {
        System.out.print(" Квадрат: " + num*num + ".");
    }

}
