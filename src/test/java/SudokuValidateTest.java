import org.junit.Assert;
import org.junit.Test;

public class SudokuValidateTest {

    @Test
    public void TestValidCompleteSudoku(){
        int[][] board = new int[][]{
            {4,3,5,2,6,9,7,8,1},
            {6,8,2,5,7,1,4,9,3},
            {1,9,7,8,3,4,5,6,2},
            {8,2,6,1,9,5,3,4,7},
            {3,7,4,6,8,2,9,1,5},
            {9,5,1,7,4,3,6,2,8},
            {5,1,9,3,2,6,8,7,4},
            {2,4,8,9,5,7,1,3,6},
            {7,6,3,4,1,8,2,5,9}
        };
        Assert.assertTrue(Validator.isValid(board));
    }

    @Test
    public void TestValidSudokuWithSpace(){
        int[][] board = new int[][]{
                {4,3,0,2,6,9,7,0,1},
                {6,0,0,5,7,1,4,9,3},
                {1,9,7,8,3,0,5,6,2},
                {8,2,6,1,9,5,3,4,7},
                {0,7,4,6,0,2,9,1,5},
                {9,5,1,7,4,3,6,2,8},
                {5,1,0,3,2,0,8,7,4},
                {0,4,8,9,5,7,1,0,6},
                {7,6,0,4,1,0,2,5,9}
        };
        Assert.assertTrue(Validator.isValid(board));
    }

    @Test
    public void TestInvalidCompleteSudoku(){
        int[][] board = new int[][]{
                {4,3,5,2,6,9,8,7,1},
                {6,8,2,5,7,1,4,9,3},
                {1,9,7,8,3,4,5,6,2},
                {8,2,6,1,9,5,3,4,7},
                {3,7,4,6,8,2,9,1,5},
                {9,5,1,7,4,3,6,2,8},
                {5,1,9,3,2,6,8,7,4},
                {2,4,8,9,5,7,1,3,6},
                {7,6,3,4,1,8,2,5,9}
        };
        Assert.assertFalse(Validator.isValid(board));
    }

    @Test
    public void TestInvalidSudokuWithSpace(){
        int[][] board = new int[][]{
                {4,3,0,2,6,9,7,0,1},
                {6,0,0,5,7,1,4,9,3},
                {1,9,7,8,3,0,5,6,2},
                {8,2,6,1,9,5,3,4,7},
                {0,7,4,6,0,2,1,9,5},
                {9,5,1,7,4,3,6,2,8},
                {5,1,0,3,2,0,8,7,4},
                {0,4,8,9,5,7,1,0,6},
                {7,6,0,4,1,0,2,5,9}
        };
        Assert.assertFalse(Validator.isValid(board));
    }
}
