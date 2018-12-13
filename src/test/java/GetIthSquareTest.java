import core.Validator;
import org.junit.Assert;
import org.junit.Test;

public class GetIthSquareTest {
    int[][] board = new int[][]{
            {1,2,3,4,5,6,7,8,9},
            {11,12,13,14,15,16,17,18,19},
            {21,22,23,24,25,26,27,28,29},
            {31,32,33,34,35,36,37,38,39},
            {41,42,43,44,45,46,47,48,49},
            {51,52,53,54,55,56,57,58,59},
            {61,62,63,64,65,66,67,68,69},
            {71,72,73,74,75,76,77,78,79},
            {81,82,83,84,85,86,87,88,89}
    };
    @Test
    public void get2ndSquareTest(){
        Assert.assertArrayEquals(Validator.getIthSquare(board, 1), new int[]{4,5,6,14,15,16,24,25,26});
    }

    @Test
    public void get8thSquareTest(){
        Assert.assertArrayEquals(Validator.getIthSquare(board, 7), new int[]{64,65,66,74,75,76,84,85,86});
    }

    @Test
    public void get6thSquareTest(){
        Assert.assertArrayEquals(Validator.getIthSquare(board, 5), new int[]{37,38,39,47,48,49,57,58,59});
    }

    @Test
    public void getSquareIdTest(){
        Assert.assertEquals(Validator.getSquareId(0, 0), 0);
        Assert.assertEquals(Validator.getSquareId(1, 1), 0);
        Assert.assertEquals(Validator.getSquareId(1, 5), 1);
        Assert.assertEquals(Validator.getSquareId(2, 2), 0);
        Assert.assertEquals(Validator.getSquareId(3, 2), 3);
        Assert.assertEquals(Validator.getSquareId(2, 3), 1);
        Assert.assertEquals(Validator.getSquareId(3, 3), 4);
        Assert.assertEquals(Validator.getSquareId(7, 0), 6);
        Assert.assertEquals(Validator.getSquareId(0, 7), 2);
        Assert.assertEquals(Validator.getSquareId(8, 8), 8);
    }
}
