import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    void main() {
        Scanner scan = new Scanner(System.in);
        int number = 0;

        while (true) {
            System.out.print("Введите число:");
            if (scan.hasNextInt()) {
                number = scan.nextInt();

                if (number <=0) {
                    System.out.println("Нельзя создать массив такой длинны");
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
        generator.Generate();
        generator.Shuffle();
        generator.CheckEasy();
        generator.PrintArr();
        generator.PrintNewArr();
    }
}

class Generator {

    private int num;
    Random random = new Random();
    private int[] arr;
    ArrayList<Integer> newArr = new ArrayList<>();

    public Generator(int num) {
        this.arr = new int[num];
        this.num = num;
    }

    public void Generate() {
        for (int i = 0; i < num; i ++) {
            arr[i] = i + 1;
        }
    }

    public void Shuffle() {
        for (int i = 0; i < arr.length; i++) {
            int j = random.nextInt(arr.length);
            int h = arr[i];
            arr[i] = arr[j];
            arr[j] = h;
        }
    }

    public void CheckEasy() {
        for (int j=0; j<arr.length; j++) {
            if (arr[j]<2) continue;
            int a = 1;
            for (int i = 2; i <= Math.sqrt(arr[j]); i++) {
                if (arr[j] % i == 0) {
                    a=0;
                }
            }
            if (a!=0){
                newArr.add(arr[j]);
            }
        }
    }
    public void PrintArr() {
        System.out.print("Полученная последовательность: ");
        for (int i=0; i< arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            } else System.out.println(".");
        }
    }

    public void PrintNewArr() {
        System.out.print("Простые числа: ");
        for (int i=0; i< newArr.size(); i++) {
            System.out.print(newArr.get(i));
            if (i < newArr.size() - 1) {
                System.out.print(", ");
            } else System.out.print(".");
        }
    }
}
