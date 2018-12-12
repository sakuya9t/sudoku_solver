import java.util.List;
import java.util.Queue;

public class Solver {
    CellGrid grid;
    Queue<int[]> empty;

    public Solver(CellGrid grid){
        this.grid = grid;
        this.empty = grid.getChangableCells();
    }

    CellGrid solve(){
        if(empty.size() == 0) return grid;
        int[] next = empty.peek();
        List<Integer> options = grid.getOptions(next[0], next[1]);
        if(options.size() == 0) return null;
        next = empty.poll();
        for(int value : options){
            grid.fill(next[0], next[1], value);
            CellGrid answer = solve();
            if(answer != null) return answer;
            grid.fill(next[0], next[1], 0);
        }
        empty.offer(next);
        return null;
    }


}
