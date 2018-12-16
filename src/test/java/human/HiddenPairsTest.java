package human;

import core.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class HiddenPairsTest {

    @Test
    public void TestReduce(){
        Cell[] cells = new Cell[9];
        cells[0] = new Cell(0, 8);
        cells[0].setValue(0);
        cells[0].setPossibilities(new ArrayList<>(Arrays.asList(6, 7, 8)));
        cells[1] = new Cell(1, 8);
        cells[1].setValue(0);
        cells[1].setPossibilities(new ArrayList<>(Arrays.asList(2, 6)));
        cells[2] = new Cell(2, 8);
        cells[2].setValue(4);
        cells[2].setPossibilities(new ArrayList<>());
        cells[3] = new Cell(3, 8);
        cells[3].setValue(0);
        cells[3].setPossibilities(new ArrayList<>(Arrays.asList(2, 7)));
        cells[4] = new Cell(4, 8);
        cells[4].setValue(0);
        cells[4].setPossibilities(new ArrayList<>(Arrays.asList(1, 6, 9)));
        cells[5] = new Cell(5, 8);
        cells[5].setValue(5);
        cells[5].setPossibilities(new ArrayList<>());
        cells[6] = new Cell(6, 8);
        cells[6].setValue(0);
        cells[6].setPossibilities(new ArrayList<>(Arrays.asList(1, 9)));
        cells[7] = new Cell(7, 8);
        cells[7].setValue(3);
        cells[7].setPossibilities(new ArrayList<>());
        cells[8] = new Cell(8, 8);
        cells[8].setValue(0);
        cells[8].setPossibilities(new ArrayList<>(Arrays.asList(2, 7, 8)));

        HiddenPairsHandler handler = new HiddenPairsHandler(null);
        handler.reduce(cells, handler.SECTION_COL);
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 9)), cells[4].getPossibilities());
        Assert.assertEquals(new ArrayList<>(Arrays.asList(1, 9)), cells[6].getPossibilities());
    }
}
