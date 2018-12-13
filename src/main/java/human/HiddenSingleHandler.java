package human;

import core.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HiddenSingleHandler extends BaseHandler{

    HiddenSingleHandler(HumanSolver solver){
        super(solver);
    }

    @Override
    protected void reduce(Cell[] section){
        Map<Integer, List<Integer>> counter = new HashMap<>();
        for(int j = 0; j < 9; j++){
            if(section[j].getPossibilities().size() > 0) {
                for(int possibility : section[j].getPossibilities()){
                    if(counter.containsKey(possibility)){
                        counter.get(possibility).add(j);
                    }
                    else{
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        counter.put(possibility, list);
                    }
                }
            }
        }
        counter.forEach((number, exists) -> {
            if(exists.size() == 1) {
                Cell c = section[exists.get(0)];
                c.setValue(number);
                c.setPossibilities(new ArrayList<>());

                List<Integer> possibilityToBeReduced = new ArrayList<>();
                possibilityToBeReduced.add(number);
                Cell[] row = this.solver.getRow(c.getRow());
                Cell[] col = this.solver.getCol(c.getCol());
                Cell[] square = this.solver.getSquare(c.getSquare());
                for(Cell neibour: row) neibour.removePossibilities(possibilityToBeReduced);
                for(Cell neibour: col) neibour.removePossibilities(possibilityToBeReduced);
                for(Cell neibour: square) neibour.removePossibilities(possibilityToBeReduced);
            }
        });
    }
}
