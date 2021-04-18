package github.com.maleksandrowicz93.task5.logic;

import github.com.maleksandrowicz93.task5.model.OperSummary;
import github.com.maleksandrowicz93.task5.model.OperationDefinition;

import java.util.Map;

public class Solution implements Task5 {
    @Override
    public void performOperationIfAllowed(
            OperationDefinition opDef,
            Map<Long, String> mainMap,
            OperSummary opSummary
    ) {
        new WantsToBeChanged().performOperationIfAllowed(opDef, mainMap, opSummary);
    }
}
