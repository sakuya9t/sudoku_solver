package human;

import core.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class HiddenPairsHandler extends BaseHandler{

    HiddenPairsHandler(HumanSolver solver) {
        super(solver);
    }

    @Override
    protected void reduce(Cell[] section){
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

        Map<Integer, List<Integer>> numbersAppearTwice = map.entrySet()
                .stream()
                .filter(x -> x.getValue().size() == 2)
                .collect(Collectors.toMap((Map.Entry::getKey), (Map.Entry::getValue)));


        for(Map.Entry<Integer, List<Integer>> e1: numbersAppearTwice.entrySet())
        {
            for(Map.Entry<Integer, List<Integer>> e2: numbersAppearTwice.entrySet())
            {
                if (e1.getKey() != e2.getKey() && e1.getValue().equals(e2.getValue()))
                {
                    Cell c1 = section[e1.getValue().get(0)];
                    Cell c2 = section[e2.getValue().get(1)];
                    List<Integer> newPossibilities = new ArrayList<>();
                    newPossibilities.add(e1.getKey());
                    newPossibilities.add(e2.getKey());
                    c1.setPossibilities(newPossibilities);
                    c2.setPossibilities(newPossibilities);
                }
            }
        }
    }
}
