package github.com.maleksandrowicz93.task9;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Task9 {

    @Test
    public void test() {
        String value = "a";
        String[] arrayA;
        String[] arrayB;

        arrayA = new String[]{"b, c"};
        arrayB = new String[]{"d, e"};
        Assert.assertFalse(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{"a", "c"};
        arrayB = new String[]{"d", "e"};
        Assert.assertFalse(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{"b", "c"};
        arrayB = new String[]{"a", "e"};
        Assert.assertFalse(isInBoth(value, arrayA, arrayB));

        arrayB = new String[]{"a", "e"};
        Assert.assertFalse(isInBoth(value, null, arrayB));

        arrayA = new String[]{"a", "c"};
        Assert.assertFalse(isInBoth(value, arrayA, null));

        Assert.assertFalse(isInBoth(value, null, null));

        arrayA = new String[]{"a", "c"};
        arrayB = new String[]{"a", "e"};
        Assert.assertFalse(isInBoth(null, arrayA, arrayB));

        arrayA = new String[]{"a", "c"};
        arrayB = new String[]{null, "e"};
        Assert.assertFalse(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{null, "c"};
        arrayB = new String[]{"a", "e"};
        Assert.assertFalse(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{null, "c"};
        arrayB = new String[]{null, "e"};
        Assert.assertFalse(isInBoth(null, arrayA, arrayB));

        arrayA = new String[]{"a", "c"};
        arrayB = new String[]{"a", "e"};
        Assert.assertTrue(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{"a", "a", "c"};
        arrayB = new String[]{"a", "a", "e"};
        Assert.assertTrue(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{"a", null};
        arrayB = new String[]{"a", "e"};
        Assert.assertTrue(isInBoth(value, arrayA, arrayB));

        arrayA = new String[]{"a", "c"};
        arrayB = new String[]{"a", null};
        Assert.assertTrue(isInBoth(value, arrayA, arrayB));
    }

    public static boolean isInBoth(String value, String[] arrayA, String[] arrayB) {
        boolean isInA = isInArray(value, arrayA);
        boolean isInB = isInArray(value, arrayB);
        return isInA && isInB;
    }

    private static boolean isInArray(String value, String[] arrayA) {
        return Optional.ofNullable(arrayA)
                .map(Arrays::asList)
                .map(l -> l.stream()
                        .filter(string -> Optional.ofNullable(string)
                                .map(s -> s.equals(value))
                                .orElse(false)
                        )
                        .collect(Collectors.toList())
                )
                .map(l -> !l.isEmpty())
                .orElse(false);
    }

}
