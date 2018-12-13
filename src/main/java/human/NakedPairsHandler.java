package human;

import core.Cell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class NakedPairsHandler extends  BaseHandler{

    NakedPairsHandler(HumanSolver solver) {
        super(solver);
    }

    @Override
    protected void reduce(Cell[] sections){
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
