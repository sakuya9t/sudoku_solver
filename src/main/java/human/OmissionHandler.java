package human;

import core.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class OmissionHandler extends BaseHandler {
    OmissionHandler(HumanSolver solver) {
        super(solver);
    }

    @Override
    protected void reduce(Cell[] section, int sectionType){
        if(sectionType == SECTION_SQUARE){
            Map<Integer, List<Integer>> reverseMap = this.reversedNumberMapInSection(section);
            reverseMap.forEach((number, inCellsId) -> {
                if(allInOneRow(inCellsId)){
                    int rowId = section[inCellsId.get(0)].getRow();
                    List<Integer> colIds = inCellsId.stream()
                            .map(cellId -> section[cellId].getCol())
                            .collect(Collectors.toList());
                    for(int j = 0; j < 9; j++){
                        if(colIds.contains(j)) continue;
                        this.solver.getCell(rowId, j).
                                removePossibilities(new ArrayList<>(Collections.singletonList(number)));
                    }
                }

                if(allInOneCol(inCellsId)){
                    int colId = section[inCellsId.get(0)].getCol();
                    List<Integer> rowIds = inCellsId.stream()
                            .map(cellId -> section[cellId].getRow())
                            .collect(Collectors.toList());
                    for(int i = 0; i < 9; i++){
                        if(rowIds.contains(i)) continue;
                        this.solver.getCell(i, colId).
                                removePossibilities(new ArrayList<>(Collections.singletonList(number)));
                    }
                }
            });
        }
        else{
            Map<Integer, List<Integer>> reverseMap = this.reversedNumberMapInSection(section);
            reverseMap.forEach((number, inCellsId) -> {
                if(allInOneRow(inCellsId)){ // Functionally in same square;
                    int squareId = section[inCellsId.get(0)].getSquare();
                    List<int[]> squarePositions = inCellsId.stream()
                            .map(cellId -> new int[]{section[cellId].getRow(), section[cellId].getCol()})
                            .collect(Collectors.toList());


                }
            });

        }
    }

    boolean allInOneCol(List<Integer> inCellsId) {
        if(inCellsId.size() == 0) return false;
        Integer[][] cols = new Integer[][]{{1,4,7},{2,5,8},{0,3,6}};
        for(Integer[] col : cols){
            List<Integer> colList = Arrays.asList(col);
            if(colList.containsAll(inCellsId)) return true;
        }
        return false;
    }

    boolean allInOneRow(List<Integer> inCellsId) {
        if(inCellsId.size() == 0) return false;
        Integer[][] rows = new Integer[][]{{0,1,2},{3,4,5},{6,7,8}};
        for(Integer[] row : rows){
            List<Integer> rowList = Arrays.asList(row);
            if(rowList.containsAll(inCellsId)) return true;
        }
        return false;
    }
}
