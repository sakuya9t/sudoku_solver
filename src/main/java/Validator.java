import java.util.Arrays;

public class Validator{
    static boolean isValid(int[][] board){
        for(int iter = 0; iter < 9; iter++){
            if(!allDifferent(board[iter])) return false;
            if(!allDifferent(getIthColumn(board, iter))) return false;
            if(!allDifferent(getIthSquare(board, iter))) return false;
        }
        return true;
    }

    static boolean allDifferent(int[] array){
        int[] cpy = Arrays.copyOf(array, array.length);
        Arrays.sort(cpy);
        for(int i = 0; i < cpy.length - 1; i++){
            if(cpy[i] == 0) continue;
            if(cpy[i] == cpy[i+1]) return false;
        }
        return true;
    }

    static int[] getIthColumn(int[][] board, int i){
        int[] result = new int[board.length];
        for(int iter = 0; iter < board.length; iter++){
            result[iter] = board[iter][i];
        }
        return result;
    }

    static int[] getIthSquare(int[][] board, int i){
        int iStart = i / 3 * 3;
        int jStart = i % 3 * 3;
        return new int[]{
                board[iStart][jStart], board[iStart][jStart + 1], board[iStart][jStart + 2],
                board[iStart + 1][jStart], board[iStart + 1][jStart + 1], board[iStart + 1][jStart + 2],
                board[iStart + 2][jStart], board[iStart + 2][jStart + 1], board[iStart + 2][jStart + 2]
        };
    }

    static int getSquareId(int row, int col){
        return col / 3 + row / 3 * 3;
    }
}