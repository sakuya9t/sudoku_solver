import org.junit.Assert;
import org.junit.Test;

public class GetIthColumnTest {
    @Test
    public void GetIthColTest(){
        int[][] board = new int[][]{{1,3,5},{9,8,7}, {2,3,4}};
        Assert.assertArrayEquals(new int[]{3,8,3}, Validator.getIthColumn(board, 1));
    }

    @Test
    public void GetIthColTest2(){
        int[][] board = new int[][]{{1,3,5},{9,8,7}, {2,3,4}};
        Assert.assertArrayEquals(new int[]{1,9,2}, Validator.getIthColumn(board, 0));
    }
}
