package uppgift;

import java.util.Random;

public class App {
    private static MethodTimer timer = new MethodTimer();
    private static int[] arrays = { 100, 200, 400, 800, 1600, 3200 };
    private static Random random = new Random();

    public static void main(String[] args) throws Exception {

        unionFindMeasure();
        threeSumMeasure();

    }

    private static void unionFindMeasure() throws Exception {

        System.out.println("Running warm-up runs.....");
        System.out.println(" ");

        // Warm-up runs
        for (int iteration = 0; iteration < arrays.length - 2; iteration++) {
            int size = arrays[iteration];
            UnionFind uf = new UnionFind(size);
            WQUnionFind wquf = new WQUnionFind(size);

            for (int y = 0; y < size / 2; y++) {
                uf.union(y, y + 1);
                wquf.union(y, y + 1);
            }

            for (int y = 0; y < size / 2; y++) {

                uf.connected(y, y + 1);
                wquf.connected(y, y + 1);
            }
        }

        System.out.println("TESTING 2 IMPLEMENTATIONS OF UNION FIND");
        for (int iteration = 0; iteration < arrays.length; iteration++) {
            int size = arrays[iteration];
            UnionFind uf = new UnionFind(size);
            WQUnionFind wquf = new WQUnionFind(size);

            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println(
                    "Array size: " + size + ", with " + size / 2 + " unions and " + size / 2 + " connections");
            System.out.println(
                    "            each method called 1000 times * 10 runs.");
            System.out.println(" ");

            System.out.println("UnionFind union: ");

            timer.measure(() -> {
                for (int y = 0; y < size / 2; y++) {
                    uf.union(y, y + 1);
                }

                return null;
            }, 10, 1000);

            System.out.println("WQUnionFind union: ");

            timer.measure(() -> {

                for (int y = 0; y < size / 2; y++) {
                    wquf.union(y, y + 1);
                }

                return null;
            }, 10, 1000);

            System.out.println(" ");
            System.out.println("UnionFind connected: ");

            timer.measure(() -> {
                for (int y = 0; y < size / 2; y++) {
                    uf.connected(y, y + 1);

                }
                return null;
            }, 10, 1000);

            System.out.println("WQUnionFind connected: ");

            timer.measure(() -> {
                for (int y = 0; y < size / 2; y++) {
                    wquf.connected(y, y + 1);

                }
                return null;
            }, 10, 1000);
        }

    }

    private static void threeSumMeasure() throws Exception {
        System.out.println(" ");
        System.out.println("Running warm-up runs.....");
        System.out.println(" ");

        // Warm-up runs
        for (int iteration = 0; iteration < arrays.length - 2; iteration++) {
            int size = arrays[iteration];
            BruteForceThreeSum bfts = new BruteForceThreeSum();
            TwoPointerThreeSum tpts = new TwoPointerThreeSum();

            int[] randomNumbers = new int[size];

            for (int i = 0; i < randomNumbers.length; i++) {
                randomNumbers[i] = random.nextInt(size * 2) - size;
            }

            bfts.bruteForceThreeSum(randomNumbers);

            tpts.twoPointerThreeSum(randomNumbers);
        }

        System.out.println("TESTING 2 IMPLEMENTATIONS OF THREE SUM");
        for (int iteration = 0; iteration < arrays.length; iteration++) {
            int size = arrays[iteration];
            BruteForceThreeSum bfts = new BruteForceThreeSum();
            TwoPointerThreeSum tpts = new TwoPointerThreeSum();

            int[] randomNumbers = new int[size];

            for (int i = 0; i < randomNumbers.length; i++) {

                randomNumbers[i] = random.nextInt(size * 2) - size;
            }

            System.out.println("-------------------------------------------------------------------------------");
            System.out.println(
                    "Array size: " + size + ", each method called 20 times * 5 runs.");
            System.out.println(" ");

            System.out.println("Brute Force: ");

            timer.measure(() -> {
                bfts.bruteForceThreeSum(randomNumbers);
                return null;
            }, 5, 20);

            System.out.println(" ");

            System.out.println("Two Pointer: ");
            timer.measure(() -> {
                tpts.twoPointerThreeSum(randomNumbers);
                return null;
            }, 5, 20);

        }

    }

}
