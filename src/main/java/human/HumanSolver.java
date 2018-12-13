package human;

import core.Cell;
import core.CellGrid;

public class HumanSolver {
    private Cell[][] cells;

    public HumanSolver(CellGrid grid){
        this.cells = new Cell[9][9];
        for(int i = 0; i < 9; i++){
            this.cells[i] = new Cell[9];
            for(int j = 0; j < 9; j++){
                this.cells[i][j] = new Cell(i, j);
                this.cells[i][j].setValue(grid.get(i, j));
                if(this.cells[i][j].getValue() == 0)
                    this.cells[i][j].setPossibilities(grid.getOptions(i, j));
            }
        }
    }

    public int solve(){
        int iterations = 0;
        while(!this.isSolved()){
            FillSingleHandler fillSingleHandler = new FillSingleHandler(this);
            fillSingleHandler.handle();

            NakedPairsHandler nakedPairsHandler = new NakedPairsHandler(this);
            nakedPairsHandler.handle();

            HiddenSingleHandler hiddenSingleHandler = new HiddenSingleHandler(this);
            hiddenSingleHandler.handle();

            HiddenPairsHandler hiddenPairsHandler = new HiddenPairsHandler(this);
            hiddenPairsHandler.handle();
            iterations++;
        }
        return iterations;
    }

    private boolean isSolved(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.cells[i][j].getValue() == 0) return false;
            }
        }
        return true;
    }

    protected Cell[] getRow(int i) {
        return this.cells[i];
    }

    protected Cell[] getCol(int j) {
        Cell[] result = new Cell[9];
        for(int i = 0; i < 9; i++) result[i] = this.cells[i][j];
        return result;
    }

    protected Cell[] getSquare(int id){
        int iStart = id / 3 * 3;
        int jStart = id % 3 * 3;
        return new Cell[]{
                cells[iStart][jStart], cells[iStart][jStart + 1], cells[iStart][jStart + 2],
                cells[iStart + 1][jStart], cells[iStart + 1][jStart + 1], cells[iStart + 1][jStart + 2],
                cells[iStart + 2][jStart], cells[iStart + 2][jStart + 1], cells[iStart + 2][jStart + 2]
        };
    }
    
    public CellGrid getResult(){
        CellGrid result = new CellGrid();
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.fill(i, j, this.cells[i][j].getValue());
            }
        }
        return result;
    }

    public Cell getCell(int i, int j) { return this.cells[i][j]; }
}
