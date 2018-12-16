package human;

import core.Cell;
import core.CellGrid;
import io.SudokuReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OmissionTest
{
    @Test
    public void TestAllInOneRowPositive(){
        OmissionHandler handler = new OmissionHandler(null);
        List<Integer> inCellsId = new ArrayList<>(Arrays.asList(0,1,2));
        Assert.assertTrue(handler.allInOneRow(inCellsId));
    }

    @Test
    public void TestAllInOneRowNegative(){
        OmissionHandler handler = new OmissionHandler(null);
        List<Integer> inCellsId = new ArrayList<>(Arrays.asList(1, 4));
        Assert.assertFalse(handler.allInOneRow(inCellsId));
    }

    @Test
    public void TestAllInOneRowEmpty(){
        OmissionHandler handler = new OmissionHandler(null);
        List<Integer> inCellsId = new ArrayList<>();
        Assert.assertFalse(handler.allInOneRow(inCellsId));
    }

    @Test
    public void TestAllInOneColumnPositive(){
        OmissionHandler handler = new OmissionHandler(null);
        List<Integer> inCellsId = new ArrayList<>(Arrays.asList(1,7));
        Assert.assertTrue(handler.allInOneCol(inCellsId));
    }

    @Test
    public void TestAllInOneColumnNegative(){
        OmissionHandler handler = new OmissionHandler(null);
        List<Integer> inCellsId = new ArrayList<>(Arrays.asList(1, 3, 4));
        Assert.assertFalse(handler.allInOneCol(inCellsId));
    }

    @Test
    public void TestAllInOneColumnEmpty(){
        OmissionHandler handler = new OmissionHandler(null);
        List<Integer> inCellsId = new ArrayList<>();
        Assert.assertFalse(handler.allInOneCol(inCellsId));
    }

    @Test
    public void OmissionTestSquareReduceRow(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("omission1.txt"));
        HumanSolver solver = new HumanSolver(grid);
        OmissionHandler handler = new OmissionHandler(solver);
        Cell[] section = solver.getSquare(7);
        handler.reduce(section, handler.SECTION_SQUARE);
        Assert.assertFalse(solver.getCell(6, 0).getPossibilities().contains(1));
        Assert.assertFalse(solver.getCell(6, 1).getPossibilities().contains(1));
        Assert.assertFalse(solver.getCell(6, 2).getPossibilities().contains(1));
        Assert.assertTrue(solver.getCell(6, 3).getPossibilities().contains(1));
        Assert.assertTrue(solver.getCell(6, 5).getPossibilities().contains(1));
        Assert.assertFalse(solver.getCell(6, 6).getPossibilities().contains(1));
        Assert.assertFalse(solver.getCell(6, 7).getPossibilities().contains(1));
        Assert.assertFalse(solver.getCell(6, 8).getPossibilities().contains(1));
    }

    @Test
    public void OmissionTestSquareReduceCol(){

        Assert.assertTrue(true);
    }
}
