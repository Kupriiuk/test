import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PrimeNumbers {

    public void run(int n) {
        System.out.println("Just wait, calculating is going...");
        List<Integer> primeList = sieveOfEratosthenes(n);
        System.out.println("The result is --> " + longArray(primeList));
    }
    private int longArray(List<Integer> primeList) {
        String lastNum = String.valueOf(primeList.get(primeList.size() - 1));
        List<Integer> newPrimeList = primeList.stream()
                .filter(i -> String.valueOf(i).length() >= lastNum.length() - 1)
                .collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        List<String> collect = newPrimeList.stream()
                .map(i -> Arrays.stream(String.valueOf(i).split(""))
                        .sorted(Comparator.comparingInt(Integer::parseInt))
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
        collect.forEach(s -> {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        });
        Optional<Integer> max = map.entrySet().stream().map(Map.Entry::getValue).max(Integer::compareTo);
        return max.get();
    }

    private List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> integerList = new ArrayList<>();
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = 1;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (a[i] == 1) {
                for (int j = 2; i * j <= n; j++) {
                    a[i * j] = 0;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (a[i] == 1) {
                integerList.add(i);
            }
        }
        return integerList;
    }
}
