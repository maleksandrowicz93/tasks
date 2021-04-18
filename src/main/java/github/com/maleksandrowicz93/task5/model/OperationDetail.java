package github.com.maleksandrowicz93.task5.model;

public class OperationDetail {

    private final Long opStatusId;
    private Long relblkId;
    private Long operationsumRefId;
    private Long operationsumParentId;
    private Long operationsumId;

    OperationDetail(Long opStatusId) {
        this.opStatusId = opStatusId;
    }

    public Long getRelblkId() {
        return relblkId;
    }

    public Long getOperationsumRefId() {
        return operationsumRefId;
    }

    public Long getOperationsumParentId() {
        return operationsumParentId;
    }

    public Long getOperationsumId() {
        return operationsumId;
    }

    public void setRelblkId(Long relblkId) {
        this.relblkId = relblkId;
    }

    public void setOperationsumRefId(Long operationsumRefId) {
        this.operationsumRefId = operationsumRefId;
    }

    public void setOperationsumParentId(Long operationsumParentId) {
        this.operationsumParentId = operationsumParentId;
    }

    public void setOperationsumId(Long operationsumId) {
        this.operationsumId = operationsumId;
    }

    public Long getOpStatusId() {
        return opStatusId;
    }
}
