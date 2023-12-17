package week10.githubCode;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIOAll {
    public static void createFile()
    {
        try
        {
            File file=new File("example.txt");
            if(file.createNewFile())
            {
                System.out.println("File created: " + file.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occured.");
            e.printStackTrace(); //printing everything that's wrong
        }
    }
    public static void createFileNio()
    {
        try
        {
            Path path= Paths.get("example.docx");//This line creates a Path object representing the file with the path "example.txt."
            // The Paths.get method is used to obtain a Path instance.
            Files.createFile(path); //This method is used to create an empty regular file at the specified path.
            System.out.println("File created: " + path.getFileName());
        }
        catch(IOException e)
        {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
    public static void writeToFile() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("example.csv"));
            bufferedWriter.write("Hello, its me.");
            bufferedWriter.close();
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void readFromFile()
    {
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader("example.csv"));
            String tempLine;
            while((tempLine = bufferedReader.readLine()) != null) //pazi na zagrade
            {
                System.out.println(tempLine);
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void deleteFile()
    {
        File file=new File("example.txt");
        if(file.delete())
        {
            System.out.println("File deleted: " + file.getName());
        }
        else
        {
            System.out.println("Failed to delete the file.");
        }
    }
}
