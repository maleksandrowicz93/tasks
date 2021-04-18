package github.com.maleksandrowicz93.task5.logic;

import github.com.maleksandrowicz93.task5.model.OperSummary;
import github.com.maleksandrowicz93.task5.model.OperationDefinition;
import github.com.maleksandrowicz93.task5.model.OperationDetail;

import java.util.Map;

public class Original implements Task5 {
    @Override
    public void performOperationIfAllowed(
            OperationDefinition op,
            Map<Long, String> theMainMap,
            OperSummary sum
    ) {
        for (int d = 0; d < op.getOperationDetailsStore().size(); ) {
            OperationDetail opDetails = op.getOperationDetailsStore().get(d);
            if (opDetails.getOpStatusId() == 1 || opDetails.getOpStatusId() == 3 ||
                    opDetails.getOpStatusId() == 4) {
                sum.setOpCond(true);
                if (opDetails.getRelblkId() != null && opDetails.getOperationsumRefId() != null
                        && opDetails.getOperationsumParentId() != null) {
                    sum.setIsReliefOperation("Y");
                    theMainMap.put(opDetails.getOperationsumId(), "Y");
                }
            } else {
                if (opDetails.getRelblkId() != null && opDetails.getOperationsumRefId() != null &&
                        opDetails.getOperationsumParentId() != null) {
                    sum.setOpCond(true);
                    sum.setIsReliefOperation("Y");
                    theMainMap.put(opDetails.getOperationsumId(), "Y");
                } else {
                    sum.setOpCond(true);
                }
            }
            break;
        }
    }
}
