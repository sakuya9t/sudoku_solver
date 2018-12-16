package core;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int i;
    private int j;
    private int value;
    private List<Integer> possibilities = new ArrayList<Integer>();

    public Cell(int i, int j){
        this.i = i;
        this.j = j;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibilities() {
        return possibilities;
    }

    public void setPossibilities(List<Integer> possibilities) {
        this.possibilities = possibilities;
    }

    public void removePossibilities(List<Integer> numbers){
        List<Integer> newPossibilities = new ArrayList<>();
        for(int i : this.possibilities){
            if(!numbers.contains(i)) newPossibilities.add(i);
        }
        this.setPossibilities(newPossibilities);
    }

    public int getRow(){
        return i;
    }

    public int getCol(){
        return j;
    }

    public int getSquare(){
        return Validator.getSquareId(i, j);
    }
}
