package prac;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prac {

    public static int suitablelocations(List<Integer> center, long d) {
        int minTotalDistance = Integer.MAX_VALUE;

        for (int x : center) {
            int totalDistance = calculateDistance(center, d, x);
            minTotalDistance = Math.min(minTotalDistance, totalDistance);
        }

        return minTotalDistance;
    }

    public static int calculateDistance(List<Integer> center, long d, int x) {
        int totalDistance = 0;
        for (int c : center) {
            totalDistance += 2 * Math.abs(c - x);
        }
        return totalDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int centerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> center = IntStream.range(0, centerCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        long d = Long.parseLong(bufferedReader.readLine().trim());

        int result = suitablelocations(center, d);

        System.out.println(result);

        bufferedReader.close();
    }
}
