import constriant.ConstraintSolver;
import core.CellGrid;
import io.SudokuReader;
import human.HumanSolver;
import org.junit.Assert;
import org.junit.Test;

public class HumanSolverTest {

    @Test
    public void TestSolveSimple(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("1.txt"));
        HumanSolver solver = new HumanSolver(grid);
        int iterations = solver.solve();
        CellGrid result = solver.getResult();

        System.out.println("Puzzle solved in " + iterations + " cycles.");

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
    public void TestSolveNakedPairs(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("6.txt"));
        HumanSolver solver = new HumanSolver(grid);
        int iterations = solver.solve();
        CellGrid result = solver.getResult();
        System.out.println("Puzzle solved in " + iterations + " cycles.");

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

    @Test
    public void TestSolveNakedTriples(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("nakedtriple.txt"));
        HumanSolver solver = new HumanSolver(grid);
        int iterations = solver.solve();
        CellGrid result = solver.getResult();
        System.out.println("Puzzle solved in " + iterations + " cycles.");

        ConstraintSolver cSolver = new ConstraintSolver(grid);
        Assert.assertEquals(cSolver.solve().printGrid(), result.printGrid());
    }

    @Test
    public void TestSolveHiddenSingle(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("7.txt"));
        HumanSolver solver = new HumanSolver(grid);
        int iterations = solver.solve();
        CellGrid result = solver.getResult();
        System.out.println("Puzzle solved in " + iterations + " cycles.");

        Assert.assertEquals("954361872\n" +
                "718295463\n" +
                "236847195\n" +
                "385726941\n" +
                "462159738\n" +
                "179438256\n" +
                "893514627\n" +
                "621973584\n" +
                "547682319\n", result.printGrid());
    }

    @Test
    public void TestSolveHiddenPairs(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("hiddenpair.txt"));
        HumanSolver solver = new HumanSolver(grid);
        int iterations = solver.solve();
        CellGrid result = solver.getResult();
        System.out.println("Puzzle solved in " + iterations + " cycles.");

        ConstraintSolver cSolver = new ConstraintSolver(grid);
        Assert.assertEquals(cSolver.solve().printGrid(), result.printGrid());
    }
}
