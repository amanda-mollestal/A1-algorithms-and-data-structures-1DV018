package uppgift;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MethodTimer {

    public MethodTimer() {
    }

    public void measure(Callable<Void> method, int runs, int iterations) throws Exception {
        List<Long> executionTimes = new ArrayList<>();

        for (int r = 0; r < runs; r++) {
            for (int l = 0; l < iterations; l++) {
                long startTime = System.nanoTime();
                method.call();
                long elapsedTime = System.nanoTime() - startTime;
                executionTimes.add(elapsedTime);
            }
        }

        // Calculate mean execution time
        long totalExecutionTime = 0;
        for (Long time : executionTimes) {
            totalExecutionTime += time;
        }
        double meanExecutionTime = (double) totalExecutionTime / executionTimes.size();

        // Calculate standard deviation
        double sumSquaredDifferences = 0;
        for (Long time : executionTimes) {
            double difference = time - meanExecutionTime;
            sumSquaredDifferences += difference * difference;
        }
        double stdDeviation = Math.sqrt(sumSquaredDifferences / executionTimes.size());

        System.out.println("    Mean Execution Time: " + meanExecutionTime + " ns, (" + (meanExecutionTime * 1.0e-6) + " ms)");
        System.out.println("    Standard Deviation: " + stdDeviation + " ns, (" + (stdDeviation * 1.0e-6) + " ms)");

    }

}
