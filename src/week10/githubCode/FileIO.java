package week10.githubCode;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileIO {
    public static void simpleWrite(String text) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write("My first line \n");
        bufferedWriter.close();
    }

    public static void arrayFileWrite(String[] data) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        for (String row : data) {
            bufferedWriter.write("\n" + row);
        }
        bufferedWriter.close();
    }

    public static void simpleRead() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("output.txt"));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
    }

    public static void readWholeFileList() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("output.txt"));
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        //We can also utilize streams to transform a file lines into ArrayList
        //The List<String> lines is the "array" (in this case, a list) that contains the lines of the file.
        for (String line : lines) {
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void readWholeFile() throws IOException //the best approach
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("output.txt"));

        String tempLine;
        while ((tempLine = bufferedReader.readLine()) != null) //sve dok ne dođe do kraja fajla, on čita i sprema linije u tempLine var
        {
            System.out.println(tempLine);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
        String[] names = {"Becir", "Adnan", "Amila"};
//        arrayFileWrite(names);
        readWholeFile();
//        readWholeFileList();
    }
}
