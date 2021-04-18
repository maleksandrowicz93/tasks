package github.com.maleksandrowicz93.task7;

import org.junit.Assert;
import org.junit.Test;

public class Task7 {

    private int expected;
    private int count8 = 0;
    private int count9 = 0;
    private int count10 = 0;

    @Test
    public void test() {
        int[] commitIds = generateCommitIds();
        for (int id : commitIds) {
            expected = id;
            int badCommit = findBadCommit(commitIds);
            Assert.assertEquals(expected, badCommit);
        }
        for (int id : commitIds) {
            expected = id;
            int badCommit = findBadCommitWitchCounting(commitIds);
            Assert.assertEquals(expected, badCommit);
        }
        Assert.assertEquals(300, count8 + count9 + count10);
        System.out.println("80: " + count8);
        System.out.println("90: " + count9);
        System.out.println("100: " + count10);
    }

    private int[] generateCommitIds() {
        int first = 123;
        int[] commitIds = new int[300];
        for (int i = 0; i < commitIds.length; i++) {
            commitIds[i] = (i > 0) ? (i + first) + commitIds[i-1] : (i + first);
        }
        return commitIds;
    }

    public int findBadCommit(int[] commitIds) {
        int rangeStart = 1;
        int rangeEnd = commitIds.length;
        boolean isAssumedCommitCorrect = false;
        while (rangeEnd - rangeStart > 1) {
            int assumedId = (rangeEnd + rangeStart) / 2;
            if (executeTests(commitIds[assumedId - 1])) {
                rangeStart = assumedId;
                isAssumedCommitCorrect = true;
            } else {
                rangeEnd = assumedId;
                isAssumedCommitCorrect = false;
            }
        }
        if (isAssumedCommitCorrect) {
            return commitIds[rangeEnd - 1];
        }
        return executeTests(commitIds[rangeStart-1]) ? commitIds[rangeEnd-1] : commitIds[rangeStart-1];
    }

    public boolean executeTests(int commitId) {
        return commitId < expected;
    }

    private int findBadCommitWitchCounting(int[] commitIds) {
        int rangeStart = 1;
        int rangeEnd = commitIds.length;
        boolean isAssumedCommitCorrect = false;
        int i = 0;
        while (rangeEnd - rangeStart > 1) {
            int assumedId = (rangeEnd + rangeStart) / 2;
            if (executeTests(commitIds[assumedId - 1])) {
                rangeStart = assumedId;
                isAssumedCommitCorrect = true;
            } else {
                rangeEnd = assumedId;
                isAssumedCommitCorrect = false;
            }
            i++;
        }
        if (isAssumedCommitCorrect) {
            if (i == 8) count8++;
            if (i == 9) count9++;
            return commitIds[rangeEnd - 1];
        }
        i++;
        if (i == 9) count9++;
        if (i == 10) count10++;
        return executeTests(commitIds[rangeStart-1]) ? commitIds[rangeEnd-1] : commitIds[rangeStart-1];    }

}
