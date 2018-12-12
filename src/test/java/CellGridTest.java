import org.junit.Assert;
import org.junit.Test;

public class CellGridTest {

    @Test
    public void TestNonFixedCellGrid(){
        int[][] board = new int[][]{
                {0,2,0,4,5,6,7,8,9},
                {4,5,7,0,8,0,2,3,6},
                {6,8,9,2,3,7,0,4,0},
                {0,0,5,3,6,2,9,7,4},
                {2,7,4,0,9,0,6,5,3},
                {3,9,6,5,7,4,8,0,0},
                {0,4,0,6,1,8,3,9,7},
                {7,6,1,0,4,0,5,2,8},
                {9,3,8,7,2,5,0,6,0}
        };
        CellGrid grid = new CellGrid(board);
        Assert.assertEquals(18, grid.getChangableCells().size());
    }

    @Test
    public void TestGetOptions(){
        int[][] board = new int[][]{
                {0,2,0,4,5,6,7,8,9},
                {4,5,7,0,8,0,2,3,6},
                {6,8,9,2,3,7,0,4,0},
                {0,0,5,3,6,2,9,7,4},
                {2,7,4,0,9,0,6,5,3},
                {3,9,6,5,7,4,8,0,0},
                {0,4,0,6,1,8,3,9,7},
                {7,6,1,0,4,0,5,2,8},
                {9,3,8,7,2,5,0,6,0}
        };
        CellGrid grid = new CellGrid(board);
        Assert.assertEquals(1, grid.getOptions(0, 0).size());
        Assert.assertEquals(1, grid.getOptions(0, 2).size());
        Assert.assertEquals(1, grid.getOptions(8, 8).size());
    }

    @Test
    public void TestGridGet(){
        int[][] board = new int[][]{
                {0,2,0,4,5,6,7,8,9},
                {4,5,7,0,8,0,2,3,6},
                {6,8,9,2,3,7,0,4,0},
                {0,0,5,3,6,2,9,7,4},
                {2,7,4,0,9,0,6,5,3},
                {3,9,6,5,7,4,8,0,0},
                {0,4,0,6,1,8,3,9,7},
                {7,6,1,0,4,0,5,2,8},
                {9,3,8,7,2,5,0,6,0}
        };
        CellGrid grid = new CellGrid(board);
        Assert.assertEquals(0, grid.get(0, 0));
        Assert.assertEquals(6, grid.get(3, 4));
        Assert.assertEquals(0, grid.get(8, 8));
    }
}
