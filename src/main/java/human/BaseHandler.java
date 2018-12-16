package human;

import core.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseHandler {
    protected HumanSolver solver;
    protected final int SECTION_ROW = 1;
    protected final int SECTION_COL = 2;
    protected final int SECTION_SQUARE = 3;

    BaseHandler(HumanSolver solver){
        this.solver = solver;
    }

    protected void handle() {
        for(int i = 0; i < 9; i++){
            Cell[] row = this.solver.getRow(i);
            reduce(row, SECTION_ROW);

            Cell[] col = this.solver.getCol(i);
            reduce(col, SECTION_COL);

            Cell[] square = this.solver.getSquare(i);
            reduce(square, SECTION_SQUARE);
        }
    }

    protected void reduce(Cell[] section, int sectionType){}

    protected Map<Integer, List<Integer>> reversedNumberMapInSection(Cell[] section){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int id = 0; id < 9; id++){
            Cell c = section[id];
            List<Integer> possibilities = c.getPossibilities();
            for(int poss : possibilities){
                if(map.containsKey(poss)){
                    map.get(poss).add(id);
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(id);
                    map.put(poss, list);
                }
            }
        }
        return map;
    }
}
