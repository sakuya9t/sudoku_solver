package human;

import core.Cell;
import core.Validator;

import java.util.ArrayList;
import java.util.List;

class FillSingleHandler extends BaseHandler {

    FillSingleHandler(HumanSolver solver){
        super(solver);
    }

    @Override
    protected void handle(){
        this.fillSingle();
        this.reducePossibilities();
    }

    private void reducePossibilities() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.solver.getCell(i, j).getPossibilities().size() > 0){
                    boolean[] flags = new boolean[10];
                    List<Integer> newPossibilities = new ArrayList<Integer>();
                    Cell[] row = this.solver.getRow(i);
                    Cell[] col = this.solver.getCol(j);
                    Cell[] square = this.solver.getSquare(Validator.getSquareId(i, j));
                    for(int k = 0; k < 9; k++){
                        flags[row[k].getValue()] = true;
                        flags[col[k].getValue()] = true;
                        flags[square[k].getValue()] = true;
                    }
                    for(int k = 1; k < 10; k++)
                        if(!flags[k]) newPossibilities.add(k);
                    this.solver.getCell(i, j).setPossibilities(newPossibilities);
                }
            }
        }
    }

    private void fillSingle(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.solver.getCell(i, j).getPossibilities().size() == 1){
                    this.solver.getCell(i, j).setValue(this.solver.getCell(i, j).getPossibilities().get(0));
                    this.solver.getCell(i, j).setPossibilities(new ArrayList<Integer>());
                }
            }
        }
    }

}
