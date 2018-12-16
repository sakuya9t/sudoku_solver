package human;

import core.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class HiddenPairsHandler extends BaseHandler{

    HiddenPairsHandler(HumanSolver solver) {
        super(solver);
    }

    @Override
    protected void reduce(Cell[] section, int sectionType){
        Map<Integer, List<Integer>> map = this.reversedNumberMapInSection(section);

        Map<Integer, List<Integer>> numbersAppearTwice = map.entrySet()
                .stream()
                .filter(x -> x.getValue().size() == 2)
                .collect(Collectors.toMap((Map.Entry::getKey), (Map.Entry::getValue)));


        for(Map.Entry<Integer, List<Integer>> e1: numbersAppearTwice.entrySet())
        {
            for(Map.Entry<Integer, List<Integer>> e2: numbersAppearTwice.entrySet())
            {
                if (!e1.getKey().equals(e2.getKey()) && e1.getValue().equals(e2.getValue()))
                {
                    Cell c1 = section[e1.getValue().get(0)];
                    Cell c2 = section[e2.getValue().get(1)];
                    List<Integer> newPossibilities = new ArrayList<>();
                    newPossibilities.add(e1.getKey());
                    newPossibilities.add(e2.getKey());
                    Collections.sort(newPossibilities);
                    c1.setPossibilities(newPossibilities);
                    c2.setPossibilities(newPossibilities);
                }
            }
        }
    }
}
