import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        List<Integer> primeList = primeList(123456);
        System.out.println(primeList);
        List<Integer> result = longArray(primeList);
        System.out.println(longArray(result));
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        if (n % 3 == 0) {
            return n == 3;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> primeList(int n) {
        List<Integer> primeList = new ArrayList<>();
        for (int i = n / 10; i < n; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public static List<Integer> longArray(List<Integer> primeList) {
        List<Integer> temp = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < primeList.size() - 1; i++) {
            temp.clear();
            temp.add(primeList.get(i));
            for (int j = i + 1; j < primeList.size(); j++) {
                if (String.valueOf(primeList.get(i)).length() == String.valueOf(primeList.get(j)).length()) {
                    if (sort(primeList.get(i),primeList.get(j))) {
                        temp.add(primeList.get(j));
                    }
                }
            }
            if (temp.size() > result.size()) {
                result = new ArrayList<>(temp);
            }
        }
        return result;
    }
    public static boolean sort(int s1, int s2) {
        char[] ch1 = String.valueOf(s1).toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = String.valueOf(s2).toCharArray();
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
}
