package github.com.maleksandrowicz93.task5.model;

import java.util.HashMap;
import java.util.Map;

public class OperationDefinition {

    private final boolean isFilled;
    private final boolean hasRequiredIds;
    private final boolean isOpStatusIdInRequiredScope;

    public OperationDefinition(
            boolean isOpStatusIdInRequiredScope,
            boolean isFilled,
            boolean hasRequiredIds
    ) {
        this.isFilled = isFilled;
        this.hasRequiredIds = hasRequiredIds;
        this.isOpStatusIdInRequiredScope = isOpStatusIdInRequiredScope;
    }

    public Map<Integer, OperationDetail> getOperationDetailsStore() {
        Map<Integer, OperationDetail> operationDetailsStore = new HashMap<>();
        if (isFilled) {
            Long opStatusID = isOpStatusIdInRequiredScope ? 1L : 10L;
            OperationDetail opDetail = new OperationDetail(opStatusID);
            if (hasRequiredIds) {
                opDetail.setRelblkId(132L);
                opDetail.setOperationsumId(123L);
                opDetail.setOperationsumParentId(123L);
                opDetail.setOperationsumRefId(123L);
            }
            operationDetailsStore.put(0, opDetail);
        }
        return operationDetailsStore;
    }

}
