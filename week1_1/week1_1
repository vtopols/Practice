import java.util.Scanner;
public class Week1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double number;

        while (true) {
            System.out.print("Введите число:");
            if (scan.hasNextDouble()) {
                number = scan.nextDouble();
                if (Double.isNaN(number) || Double.isInfinite(number)) {
                    System.out.println("Некорректное число.");
                    continue;
                }
                break;
            } else {
                System.out.println("Формат данных не поддерживается.");
                scan.next();
            }
        }
        scan.close();

        NumberAnalyzer analyzer = new NumberAnalyzer(number);
        System.out.println(analyzer.getInfo());
    }
}
