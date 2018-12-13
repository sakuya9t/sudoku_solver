import core.CellGrid;
import io.SudokuReader;
import normal.Solver;
import org.junit.Assert;
import org.junit.Test;

public class SudokuSolverTest {
    @Test
    public void TestSolve1(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("1.txt"));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();

        Assert.assertEquals("123456789\n" +
                "457189236\n" +
                "689237145\n" +
                "815362974\n" +
                "274891653\n" +
                "396574812\n" +
                "542618397\n" +
                "761943528\n" +
                "938725461\n", result.printGrid());
    }

    @Test
    public void TestSolve2(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("2.txt"));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();

        Assert.assertEquals("435269781\n" +
                "682571493\n" +
                "197834562\n" +
                "826195347\n" +
                "374682915\n" +
                "951743628\n" +
                "519326874\n" +
                "248957136\n" +
                "763418259\n", result.printGrid());
    }

    @Test
    public void TestSolve3(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("3.txt"));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();

        Assert.assertEquals("534678912\n" +
                "672195348\n" +
                "198342567\n" +
                "859761423\n" +
                "426853791\n" +
                "713924856\n" +
                "961537284\n" +
                "287419635\n" +
                "345286179\n", result.printGrid());
    }

    @Test
    public void TestSolve4(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("4.txt"));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();

        Assert.assertEquals("643215897\n" +
                "127389645\n" +
                "958764123\n" +
                "435876912\n" +
                "276951438\n" +
                "891432576\n" +
                "789643251\n" +
                "564127389\n" +
                "312598764\n", result.printGrid());
    }

    @Test
    public void TestSolveNoSolution(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("5.txt"));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();
        Assert.assertNull(result);
    }

    @Test
    public void TestSolve6(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("6.txt"));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();

        Assert.assertEquals("597846132\n" +
                "348512967\n" +
                "612397584\n" +
                "756238491\n" +
                "839451276\n" +
                "421679853\n" +
                "173925648\n" +
                "964183725\n" +
                "285764319\n", result.printGrid());
    }
}
