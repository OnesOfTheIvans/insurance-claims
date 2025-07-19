package claim;

import claim.entity.Claim;
import claim.entity.ClaimType;
import claim.strategy.MedicalPriorityStrategy;
import claim.strategy.PriorityContext;
import claim.strategy.PropertyPriorityStrategy;
import claim.strategy.VehiclePriorityStrategy;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Claim> {
    @Override
    public int compare(Claim claim1, Claim claim2) {
        var context = switch (claim1.getType()) {
            case ClaimType.MEDICAL -> new PriorityContext(new MedicalPriorityStrategy());
            case ClaimType.VEHICLE -> new PriorityContext(new VehiclePriorityStrategy());
            case ClaimType.PROPERTY -> new PriorityContext(new PropertyPriorityStrategy());
        };
        return context.comparePriorities(claim1, claim2);
    }
}
