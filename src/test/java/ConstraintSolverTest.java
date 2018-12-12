import org.jacop.constraints.Alldifferent;
import org.jacop.constraints.Constraint;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;
import org.junit.Assert;
import org.junit.Test;

public class ConstraintSolverTest {

    @Test
    public void SimpleTest(){
        Store store = new Store();
        IntVar[] vars = new IntVar[5];
        vars[0] = new IntVar(store, "a0", 5, 5);
        vars[1] = new IntVar(store, "a1", 4, 4);
        vars[2] = new IntVar(store, "a2", 3, 3);
        vars[3] = new IntVar(store, "a3", 2, 2);
        vars[4] = new IntVar(store, "a4", 1, 5);
        Constraint constraint = new Alldifferent(vars);
        store.impose(constraint);
        Search<IntVar> search = new DepthFirstSearch<IntVar>();
        SelectChoicePoint<IntVar> select =
                new InputOrderSelect<IntVar>(store, vars, new IndomainMin<IntVar>());
        search.labeling(store, select);

        Assert.assertEquals(1, vars[4].value());
    }

    @Test
    public void TestSolve1(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("1.txt"));
        ConstraintSolver solver = new ConstraintSolver(grid);
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
        ConstraintSolver solver = new ConstraintSolver(grid);
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
    public void TestSolve4(){
        CellGrid grid = new CellGrid(SudokuReader.readSudoku("4.txt"));
        ConstraintSolver solver = new ConstraintSolver(grid);
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
}
