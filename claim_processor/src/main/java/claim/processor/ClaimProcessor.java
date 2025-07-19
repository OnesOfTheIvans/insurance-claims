package claim.processor;

import claim.PriorityComparator;
import claim.entity.Claim;
import claim.entity.ClaimComplexity;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ClaimProcessor {
    private final Queue<Claim> queue;
    private final List<String> processedClaims;
    private final List<Claim> delayedClaims;
    private final double amountLimit;
    private final int maxHighClaims;

    public ClaimProcessor(List<Claim> queue, double amountLimit, int maxHighClaims) {
        this.queue = new PriorityQueue<>(new PriorityComparator());
        this.queue.addAll(queue);
        this.processedClaims = new ArrayList<>();
        this.amountLimit = amountLimit;
        this.maxHighClaims = maxHighClaims;
        this.delayedClaims = new ArrayList<>();
    }

    public void processDay() {
        double amountSum = 0;
        int highClaims = 0;

        while (!queue.isEmpty()) {
            var claim = queue.poll();
            if (processedClaims.contains(claim.getId())) {
                continue;
            }
            if (claim.getAmount() + amountSum > amountLimit) {
                delayedClaims.add(claim);
            }
            else if (claim.getComplexity() == ClaimComplexity.HIGH && highClaims == maxHighClaims) {
                delayedClaims.add(claim);
            }
            else {
                amountSum += claim.getAmount();
                highClaims += claim.getComplexity() == ClaimComplexity.HIGH ? 1 : 0;
                processedClaims.add(claim.getId());
                System.out.println(claim);
            }
        }
        printTotalSum(amountSum, highClaims);

        queue.addAll(delayedClaims);
        delayedClaims.clear();
    }

    private void printTotalSum(double amountSum, int highClaims) {
        System.out.printf("Total amount sum: %.2f%n", amountSum);
        System.out.println("Total high claims: " + highClaims);
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }
}
