package human;

import core.Cell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NakedPairsHandler {
    private HumanSolver solver;

    public NakedPairsHandler(HumanSolver solver){
        this.solver = solver;
    }

    public void doNakedPairs() {
        for(int i = 0; i < 9; i++){
            Cell[] row = this.solver.getRow(i);
            this.nakedPairsReduce(row);

            Cell[] col = this.solver.getCol(i);
            this.nakedPairsReduce(col);

            Cell[] square = this.solver.getSquare(i);
            this.nakedPairsReduce(square);
        }
    }

    private void nakedPairsReduce(Cell[] sections){
        Map<List<Integer>, Integer> pairsMap = new HashMap<>();
        for(Cell cell : sections){
            if(cell.getPossibilities().size() > 0){
                pairsMap.putIfAbsent(cell.getPossibilities(), 0);
                pairsMap.put(cell.getPossibilities(),
                        pairsMap.get(cell.getPossibilities()) + 1);
            }
        }
        pairsMap.forEach((options, count) -> {
            if(options.size() == count){
                for(Cell cell : sections){
                    List<Integer> intersect = cell.getPossibilities().stream()
                            .filter(options::contains)
                            .collect(Collectors.toList());
                    if(intersect.size() > 0 && !cell.getPossibilities().equals(options)){
                        cell.removePossibilities(options);
                    }
                }
            }
        });
    }
}
