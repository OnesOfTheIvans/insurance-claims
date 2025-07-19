package claim.strategy;

import claim.entity.Claim;

public class PriorityContext {
    private final PriorityStrategy strategy;

    public PriorityContext(PriorityStrategy strategy) {
        this.strategy = strategy;
    }

    public int comparePriorities(Claim claim1, Claim claim2) {
        //a common part for all strategies
        if (claim1.getType() != claim2.getType()) {
            var deadLineComparisonResult = claim1.getDeadline().compareTo(claim2.getDeadline());
            if (deadLineComparisonResult == 0) {
                var doubleComparisonResult = Double.compare(claim2.getAmount(), claim1.getAmount());
                if (doubleComparisonResult == 0) {
                    return claim2.getComplexity().compareTo(claim1.getComplexity());
                }
                return doubleComparisonResult;
            } else {
                return deadLineComparisonResult;
            }
        }
        return strategy.comparePriorities(claim1, claim2);
    }
}
