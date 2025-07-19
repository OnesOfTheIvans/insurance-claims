package claim.strategy;

import claim.entity.Claim;

public class PropertyPriorityStrategy implements PriorityStrategy {
    @Override
    public int comparePriorities(Claim claim1, Claim claim2) {
        var amountComparisonResult = Double.compare(claim2.getAmount(), claim1.getAmount());
        if (amountComparisonResult == 0) {
            return claim1.getDeadline().compareTo(claim2.getDeadline());
        } else {
            return amountComparisonResult;
        }
    }
}
