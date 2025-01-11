package File_Handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws IOException {
        // File path
        File f = new File("D:\\Programing\\Java Programing\\Eclipse\\Java\\src\\File_Handling\\Jojo\\java.txt");
        
        // Ensure parent directories exist
        f.getParentFile().mkdirs();

        // Create the file
        System.out.println("File created: " + f.createNewFile());
        
        // File details
        System.out.println("Can Execute: " + f.canExecute());
        System.out.println("Can Read: " + f.canRead());
        System.out.println("Can Write: " + f.canWrite());
        System.out.println("Canonical Path: " + f.getCanonicalPath());
        System.out.println("Absolute Path: " + f.getAbsolutePath());
        System.out.println("File Exists: " + f.exists());
        System.out.println("File Name: " + f.getName());
        System.out.println("File Length (in bytes): " + f.length());

        // Reading the file
        Scanner Reader = new Scanner(f);
        System.out.println("\nReading file content:");
        while (Reader.hasNextLine()) {
            String data = Reader.nextLine();
            System.out.println(data);
        }
        Reader.close();

        // Writing to the file
        FileWriter w = new FileWriter(f);
        w.write("Hello Nilendra, what are you doing?");
        w.close();
        System.out.println("\nSuccessfully written to the file!");

        // Reading again after writing
        Scanner newReader = new Scanner(f);
        System.out.println("\nReading updated file content:");
        while (newReader.hasNextLine()) {
            String data = newReader.nextLine();
            System.out.println(data);
        }
        newReader.close();
    }
}
