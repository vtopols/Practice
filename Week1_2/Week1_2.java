import java.util.Scanner;

public class Week1_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = 0;

        while (true) {
            System.out.print("Введите число: ");
            if (scan.hasNextInt()) {
                number = scan.nextInt();

                if (number <= 0) {
                    System.out.println("Нельзя создать массив такой длины. Введите положительное число.");
                    continue;
                }

                break;
            } else {
                System.out.println("Формат данных не поддерживается.");
                scan.next();
            }
        }
        scan.close();

        Generator generator = new Generator(number);
        generator.generate();
        generator.shuffle();
        generator.collectPrimes();
        generator.printNumbers();
        generator.printPrimes();
    }
}
