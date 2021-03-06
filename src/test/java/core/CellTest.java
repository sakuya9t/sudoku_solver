import core.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CellTest {
    @Test
    public void TestValueHandle(){
        Cell c = new Cell(5, 5);
        c.setValue(5);
        Assert.assertEquals(5, c.getValue());
    }

    @Test
    public void TestPossibilitiesHandleEmpty(){
        Cell c = new Cell(5, 5);
        c.setPossibilities(new ArrayList<>());
        Assert.assertEquals(new ArrayList<>(), c.getPossibilities());
    }

    @Test
    public void TestPossibilitiesHandle(){
        Cell c = new Cell(5, 5);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        c.setPossibilities(list);
        Assert.assertEquals(list, c.getPossibilities());
    }
}
