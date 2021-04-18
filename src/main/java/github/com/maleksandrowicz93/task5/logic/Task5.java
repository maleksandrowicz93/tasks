package github.com.maleksandrowicz93.task5.logic;

import github.com.maleksandrowicz93.task5.model.OperSummary;
import github.com.maleksandrowicz93.task5.model.OperationDefinition;

import java.util.Map;

public interface Task5 {
    void performOperationIfAllowed(OperationDefinition opDef, Map<Long, String> mainMap, OperSummary opSummary);
}
