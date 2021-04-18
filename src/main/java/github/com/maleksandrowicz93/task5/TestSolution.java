package github.com.maleksandrowicz93.task5;

import github.com.maleksandrowicz93.task5.logic.Original;
import github.com.maleksandrowicz93.task5.logic.Solution;
import github.com.maleksandrowicz93.task5.logic.Task5;
import github.com.maleksandrowicz93.task5.model.OperSummary;
import github.com.maleksandrowicz93.task5.model.OperationDefinition;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestSolution {

    @Test
    public void shouldBeSolutionsEqual() {
        test(true, true, true);
        test(true, true, false);
        test(true, false, true);
        test(true, false, false);
        test(false, true, true);
        test(false, true, false);
        test(false, false, true);
        test(false, false, false);
    }

    private static void test(
            boolean isOpStatusIdInRequiredScope,
            boolean isOpDefFilled,
            boolean hasOpDetailsRequiredIds
    ) {
        //given
        Map<Long, String> fakeMainMap = new HashMap<>();
        OperSummary fakeOpSummary = new OperSummary();
        OperationDefinition fakeOpDef = new OperationDefinition(
                isOpStatusIdInRequiredScope,
                isOpDefFilled,
                hasOpDetailsRequiredIds
        );
        Task5 solution = new Solution();

        Map<Long, String> realMainMap = new HashMap<>();
        OperSummary realOpSummary = new OperSummary();
        OperationDefinition realOpDef = new OperationDefinition(
                isOpStatusIdInRequiredScope,
                isOpDefFilled,
                hasOpDetailsRequiredIds
        );
        Original original = new Original();

        //when
        solution.performOperationIfAllowed(fakeOpDef, fakeMainMap, fakeOpSummary);
        original.performOperationIfAllowed(realOpDef, realMainMap, realOpSummary);

        //then
        Assert.assertEquals(fakeOpSummary.isOpCond(), realOpSummary.isOpCond());
        Assert.assertEquals(fakeOpSummary.getIsReliefOperation(), realOpSummary.getIsReliefOperation());
        Assert.assertEquals(fakeMainMap.size(), realMainMap.size());
        fakeMainMap.forEach((key, value) -> Assert.assertEquals(value, realMainMap.get(key)));
    }

}
