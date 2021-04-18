package github.com.maleksandrowicz93.task5.model;

public class OperSummary {

    private boolean opCond;
    private String isReliefOperation;

    public void setOpCond(boolean opCond) {
        this.opCond = opCond;
    }

    public void setIsReliefOperation(String isReliefOperation) {
        this.isReliefOperation = isReliefOperation;
    }

    public boolean isOpCond() {
        return opCond;
    }

    public String getIsReliefOperation() {
        return isReliefOperation;
    }

}
