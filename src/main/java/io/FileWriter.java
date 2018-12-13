package core;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileWriter {

    public static void write(String filename, CellGrid grid){
        String dir = System.getProperty("user.dir") + "\\answers\\";
        String path = dir + filename;
        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.write(grid.printGrid());
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void write(String filename, String message){
        String dir = System.getProperty("user.dir") + "\\answers\\";
        String path = dir + filename;
        try {
            PrintWriter writer = new PrintWriter(path, "UTF-8");
            writer.write(message + "\n");
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
