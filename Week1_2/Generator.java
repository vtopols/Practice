import java.util.Random;
import java.util.ArrayList;

class Generator {
    private int num;
    private Random random;
    private int[] numbers;
    private ArrayList<Integer> primes;

    public Generator(int num) {
        this.num = num;
        this.random = new Random();
        this.numbers = new int[num];
        this.primes = new ArrayList<>();
    }

    public void generate() {
        for (int i = 0; i < num; i++) {
            numbers[i] = i + 1;
        }
    }

    public void shuffle() {
        for (int i = 0; i < numbers.length; i++) {
            int j = random.nextInt(numbers.length);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void collectPrimes() {
        primes.clear();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
    }

    public void printNumbers() {
        System.out.print("Полученная последовательность: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(".");
    }

    public void printPrimes() {
        System.out.print("Простые числа: ");
        if (primes.isEmpty()) {
            System.out.println("нет простых чисел.");
            return;
        }

        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            if (i < primes.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(".");
    }
}