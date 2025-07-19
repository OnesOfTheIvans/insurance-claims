package claim.strategy;

import claim.entity.Claim;

public class VehiclePriorityStrategy implements PriorityStrategy {
    @Override
    public int comparePriorities(Claim claim1, Claim claim2) {
        var complexityComparisonResult = claim2.getComplexity().compareTo(claim1.getComplexity());
        if (complexityComparisonResult == 0) {
            var deadLineComparisonResult = claim1.getDeadline().compareTo(claim2.getDeadline());
            if (deadLineComparisonResult == 0) {
                return Double.compare(claim2.getAmount(), claim1.getAmount());
            } else {
                return deadLineComparisonResult;
            }
        } else {
            return complexityComparisonResult;
        }
    }
}
