public class Sudoku
{

    public static void main( String[] args )
    {
        String filename = args[0];
        CellGrid grid = new CellGrid(SudokuReader.readSudoku(filename));
        Solver solver = new Solver(grid);
        CellGrid result = solver.solve();
        if(result == null) FileWriter.write(filename, "UNSOLVABLE");
        else FileWriter.write(filename, result.printGrid());
    }

}