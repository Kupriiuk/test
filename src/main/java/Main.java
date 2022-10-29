import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input number: ");
            new PrimeNumbers().run(Integer.parseInt(scanner.nextLine()));
        }
    }
}
