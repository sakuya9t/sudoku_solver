package human;

import core.Cell;

public class BaseHandler {
    protected HumanSolver solver;

    BaseHandler(HumanSolver solver){
        this.solver = solver;
    }

    protected void handle() {
        for(int i = 0; i < 9; i++){
            Cell[] row = this.solver.getRow(i);
            reduce(row);

            Cell[] col = this.solver.getCol(i);
            reduce(col);

            Cell[] square = this.solver.getSquare(i);
            reduce(square);
        }
    }

    protected void reduce(Cell[] section){}
}
