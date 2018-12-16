package core;

import core.Validator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CellGrid {
    private int[][] grid;

    public CellGrid(int[][] cells){
        this.grid = cells;
    }

    public CellGrid(){
        this.grid = new int[9][9];
    }

    public Queue<int[]> getChangableCells(){
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(grid[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        return queue;
    }

    public List<Integer> getOptions(int row, int col){
        boolean[] valid = new boolean[10];
        for(int i = 0; i < 10; i++)
            valid[i] = true;
        int squareId = Validator.getSquareId(row, col);
        int[] square = Validator.getIthSquare(grid, squareId);
        for(int i = 0; i < 9; i++) {
            valid[grid[row][i]] = false;
            valid[grid[i][col]] = false;
            valid[square[i]] = false;
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i = 1; i < 10; i++)
            if(valid[i]) result.add(i);
        return result;
    }

    public void fill(int i, int j, int value){ this.grid[i][j] = value; }


    public String printGrid(){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                result.append(this.grid[i][j] == 0 ? " " : this.grid[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    public int get(int i, int j) {
        return this.grid[i][j];
    }

}
