package IECS;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class class1Test {
    @Test
    public void check1() throws Exception {
    }

    @Test
    public void check() throws Exception {
        class1 test = new class1(1);
        String result = test.check(0);
        Assert.assertEquals("It's 0", result);
    }

}
