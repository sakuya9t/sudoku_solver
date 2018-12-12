import org.junit.Assert;
import org.junit.Test;

public class ValidatorArrayDiffTest {

    @Test
    public void TestListAllDiffNormal(){
        int[] list = new int[]{1,3,5,7,9,2,4,6,8};
        Assert.assertTrue(Validator.allDifferent(list));
    }

    @Test
    public void TestListAllDiffHasDuplicate(){
        int[] list = new int[]{1,3,3,5,7,2,4,6,8};
        Assert.assertFalse(Validator.allDifferent(list));
    }

    @Test
    public void TestListAllDiffWithZero(){
        int[] list = new int[]{1,0,5,0,9,2,0,6,8};
        Assert.assertTrue(Validator.allDifferent(list));
    }

    @Test
    public void TestListAllDiffWithDupAndZero(){
        int[] list = new int[]{1,0,5,0,9,9,0,6,8};
        Assert.assertFalse(Validator.allDifferent(list));
    }
}
