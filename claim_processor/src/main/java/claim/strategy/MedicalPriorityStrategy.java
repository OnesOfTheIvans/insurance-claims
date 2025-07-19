package claim.strategy;

import claim.entity.Claim;

public class MedicalPriorityStrategy implements PriorityStrategy {
    @Override
    public int comparePriorities(Claim claim1, Claim claim2) {
        var deadLineComparisonResult = claim1.getDeadline().compareTo(claim2.getDeadline());
        if (deadLineComparisonResult == 0) {
            return Double.compare(claim2.getAmount(), claim1.getAmount());
        } else {
            return deadLineComparisonResult;
        }
    }
}
