import io.SudokuReader;
import org.junit.Assert;
import org.junit.Test;

public class SudokuReaderTest {
    @Test
    public void TestReadCompleteSring(){
        String s = "678913452";
        Assert.assertArrayEquals(SudokuReader.convertString(s), new int[]{6,7,8,9,1,3,4,5,2});
    }

    @Test
    public void TestReadIncompleteString(){
        String s = "6 89  452";
        Assert.assertArrayEquals(SudokuReader.convertString(s), new int[]{6,0,8,9,0,0,4,5,2});
    }

    @Test
    public void TestReadStringNotLongEnough(){
        String s = "938725 6";
        Assert.assertArrayEquals(SudokuReader.convertString(s), new int[]{9,3,8,7,2,5,0,6,0});
    }

    @Test
    public void TestReadEmptyString(){
        String s = "";
        Assert.assertArrayEquals(SudokuReader.convertString(s), new int[]{0,0,0,0,0,0,0,0,0});
    }

    @Test
    public void TestReadFile(){
        int[][] expected = new int[][]{
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
        Assert.assertArrayEquals(SudokuReader.readSudoku("1.txt"), expected);
    }

    @Test
    public void TestReadFileNotExist(){
        Assert.assertNull(SudokuReader.readSudoku("999.txt"));
    }
}
