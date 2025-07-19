package claim.strategy;

import claim.entity.Claim;

public interface PriorityStrategy {
    int comparePriorities(Claim claim1, Claim claim2);
}
