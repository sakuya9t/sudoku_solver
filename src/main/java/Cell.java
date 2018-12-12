import java.util.ArrayList;
import java.util.List;

public class Cell {
    private int value;
    private List<Integer> possibilities = new ArrayList<Integer>();

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
}
