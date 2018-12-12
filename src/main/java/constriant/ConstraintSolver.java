import core.CellGrid;
import org.jacop.constraints.Alldifferent;
import org.jacop.constraints.Constraint;
import org.jacop.core.IntVar;
import org.jacop.core.Store;
import org.jacop.search.*;

public class ConstraintSolver {
    private CellGrid grid;

    public ConstraintSolver(CellGrid grid) {
        this.grid = grid;
    }

    public CellGrid solve(){
        Store store = new Store();
        IntVar[] vars = new IntVar[9*9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid.get(i, j) == 0)
                    vars[i * 9 + j] = new IntVar(store, "var" + i + "" + j, 1, 9);
                else
                    vars[i * 9 + j] = new IntVar(store, "var" + i + "" + j, grid.get(i, j), grid.get(i, j));
            }
        }

        IntVar[][] comparisions = initComparisions(vars);
        for(int i = 0; i < 27; i++){
            Constraint constraint = new Alldifferent(comparisions[i]);
            store.impose(constraint);
        }

        Search<IntVar> search = new DepthFirstSearch<IntVar>();
        SelectChoicePoint<IntVar> select =
                new InputOrderSelect<IntVar>(store, vars, new IndomainMin<IntVar>());
        search.labeling(store, select);

        int[][] grid = new int[9][9];
        CellGrid result = new CellGrid(grid);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                IntVar var = (IntVar) store.findVariable("var" + i + "" + j);
                result.fill(i, j, var.value());
            }
        }

        return result;
    }

    private IntVar[][] initComparisions(IntVar[] vars) {
        IntVar[][] result = new IntVar[27][9];
        for(int iter = 0; iter < 9; iter++){
            IntVar[] square = getIthSquareFlatten(vars, iter);
            //rows
            result[iter] = new IntVar[9];
            //cols
            result[9 + iter] = new IntVar[9];
            //squares
            result[18 + iter] = new IntVar[9];
            for(int j = 0; j < 9; j++){
                result[iter][j] = vars[iter * 9 + j];
                result[iter + 9][j] = vars[j * 9 + iter];
                result[iter + 18][j] = square[j];
            }
        }
        return result;
    }

    private IntVar[] getIthSquareFlatten(IntVar[] board, int i){
        int iStart = i / 3 * 3;
        int jStart = i % 3 * 3;
        return new IntVar[]{
                board[iStart * 9 + jStart], board[iStart * 9 + jStart + 1], board[iStart * 9 + jStart + 2],
                board[(iStart + 1) * 9 + jStart], board[(iStart + 1) * 9 + jStart + 1], board[(iStart + 1) * 9 + jStart + 2],
                board[(iStart + 2) * 9 + jStart], board[(iStart + 2) * 9 + jStart + 1], board[(iStart + 2) * 9 + jStart + 2]
        };
    }
}
