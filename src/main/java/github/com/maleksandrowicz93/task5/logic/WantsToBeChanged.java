package github.com.maleksandrowicz93.task5.logic;

import github.com.maleksandrowicz93.task5.model.OperSummary;
import github.com.maleksandrowicz93.task5.model.OperationDefinition;
import github.com.maleksandrowicz93.task5.model.OperationDetail;

import java.util.*;

public class WantsToBeChanged {

    private static final String YES = "Y";

    public void performOperationIfAllowed(
            OperationDefinition opDef,
            Map<Long, String> mainMap,
            OperSummary opSummary
    ) {
        Map<Integer, OperationDetail> opDetailsStore = opDef.getOperationDetailsStore();
        boolean isOperationAllowed = !opDetailsStore.isEmpty();
        if (isOperationAllowed)
            performOperation(mainMap, opSummary, opDetailsStore.get(0));
    }

    private void performOperation(
            Map<Long, String> mainMap,
            OperSummary opSummary,
            OperationDetail opDetails
    ) {
        opSummary.setOpCond(true);
        if (hasRequiredIds(opDetails)) {
            opSummary.setIsReliefOperation(YES);
            mainMap.put(opDetails.getOperationsumId(), YES);
        }
    }

    private boolean hasRequiredIds(OperationDetail opDetails) {
        return opDetails.getRelblkId() != null
                && opDetails.getOperationsumRefId() != null
                && opDetails.getOperationsumParentId() != null;
    }

}


