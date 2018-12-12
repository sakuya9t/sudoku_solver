import java.util.*;
import java.util.stream.Collectors;

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
            this.fillSingle();
            this.reducePossibilities();
            this.doNakedPairs();
            this.doHiddenSingle();
            iterations++;
        }
        return iterations;
    }

    private void doHiddenSingle() {
        for(int i = 0; i < 9; i++) {
            Cell[] row = getRow(i);
            this.hiddenSingleReduce(row);

            Cell[] col = getCol(i);
            this.hiddenSingleReduce(col);

            Cell[] square = getSquare(i);
            this.hiddenSingleReduce(square);
        }
    }

    private void hiddenSingleReduce(Cell[] section){
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
                Cell[] row = this.getRow(c.getRow());
                Cell[] col = this.getCol(c.getCol());
                Cell[] square = this.getSquare(c.getSquare());
                for(Cell neibour: row) neibour.removePossibilities(possibilityToBeReduced);
                for(Cell neibour: col) neibour.removePossibilities(possibilityToBeReduced);
                for(Cell neibour: square) neibour.removePossibilities(possibilityToBeReduced);
            }
        });
    }

    private void doNakedPairs() {
        for(int i = 0; i < 9; i++){
            Cell[] row = getRow(i);
            this.nakedPairsReduce(row);

            Cell[] col = getCol(i);
            this.nakedPairsReduce(col);

            Cell[] square = getSquare(i);
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

    private void reducePossibilities() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.cells[i][j].getPossibilities().size() > 0){
                    boolean[] flags = new boolean[10];
                    List<Integer> newPossibilities = new ArrayList<Integer>();
                    Cell[] row = getRow(i);
                    Cell[] col = getCol(j);
                    Cell[] square = getSquare(Validator.getSquareId(i, j));
                    for(int k = 0; k < 9; k++){
                        flags[row[k].getValue()] = true;
                        flags[col[k].getValue()] = true;
                        flags[square[k].getValue()] = true;
                    }
                    for(int k = 1; k < 10; k++)
                        if(!flags[k]) newPossibilities.add(k);
                    this.cells[i][j].setPossibilities(newPossibilities);
                }
            }
        }
    }

    private void fillSingle(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.cells[i][j].getPossibilities().size() == 1){
                    this.cells[i][j].setValue(this.cells[i][j].getPossibilities().get(0));
                    this.cells[i][j].setPossibilities(new ArrayList<Integer>());
                }
            }
        }
    }

    private boolean isSolved(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(this.cells[i][j].getValue() == 0) return false;
            }
        }
        return true;
    }

    private Cell[] getRow(int i) {
        return this.cells[i];
    }

    private Cell[] getCol(int j) {
        Cell[] result = new Cell[9];
        for(int i = 0; i < 9; i++) result[i] = this.cells[i][j];
        return result;
    }

    private Cell[] getSquare(int id){
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
}
