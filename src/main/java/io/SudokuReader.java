package io;

import java.io.*;

public class SudokuReader {
    public static int[][] readSudoku(String filename){
        String path = System.getProperty("user.dir") + "\\puzzle\\" + filename;
        File file = new File(path);

        int[][] result = new int[9][9];

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            int lineNumber = 0;
            while ((s = br.readLine()) != null){
                int[] line = convertString(s);
                result[lineNumber] = line;
                lineNumber++;
            }
            return result;
        } catch (IOException e1) {
            System.err.println(e1.getMessage());
            return null;
        }
    }

    public static int[] convertString(String line){
        int[] result = new int[9];
        for(int iter = 0; iter < 9; iter++){
            if(iter >= line.length()){
                result[iter] = 0;
                continue;
            }
            char c = line.charAt(iter);
            if(c >= '1' && c <= '9') result[iter] = c - '0';
            else result[iter] = 0;
        }
        return result;
    }
}
