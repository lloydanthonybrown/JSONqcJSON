import src.org.quickconnectfamily.json.*;

import java.io.*;
import java.util.HashMap;

public class SandboxingJSONqcJSON {
    public static void main(String[] args) {
        try {
            System.out.println("Happy Paths");
            File lloydsFile = new File("lloydsFile.json"); // new instance of a file

            FileOutputStream lloydsFileOutputStream = new FileOutputStream(lloydsFile); // new file output stream, writing to new file
            FileInputStream lloydsFileInputStream = new FileInputStream(lloydsFile); // new file input stream, reading from new file

            JSONInputStream jsonIn = new JSONInputStream(lloydsFileInputStream); // json wrapper for file input stream
            JSONOutputStream jsonOut = new JSONOutputStream(lloydsFileOutputStream); // json wrapper for file output stream

            // Make some new books
            BookBean book1 = new BookBean(316, "Artemis Fowl", "2001", false);
            BookBean book2 = new BookBean(355, "Storm Front", "2000", true);
            BookBean book3 = new BookBean(1521, "The Way of Kings", "2010", true);
            BookBean book4 = new BookBean(48, "The Caboose Who Got Loose", "1971", false);

            System.out.println("Writing books to the file.");

            // Write the books to the file
            jsonOut.writeObject(book1);
            jsonOut.writeObject(book2);
            jsonOut.writeObject(book3);
            jsonOut.writeObject(book4);

            System.out.println("Books have been written to the file.");

            // Creating a hashmap from our JSON file.
            HashMap jsonInHashmap = (HashMap) jsonIn.readObject();

            // Retrieves first book with a title (wouldn't do nulls, I assume?)
            System.out.println(jsonInHashmap.get("title"));

            // nasty paths
            System.out.println("Nasty Paths");

            // nulls for new book attributes (arguments?)
            // Had to give it false for the boolean argument in order for it to compile
            BookBean book5 = new BookBean(null,null,null,false);

            // empty arguments for new book
            BookBean book6 = new BookBean(0,"","",true);

            // read a null
            File aNullFile = new File("");
            FileInputStream aNullFileInputStream = new FileInputStream(aNullFile);
            JSONInputStream jsonInReadNull = new JSONInputStream(aNullFileInputStream);
            HashMap jsonReadingNull = (HashMap) jsonInReadNull.readObject();

            // write a null
            jsonOut.writeObject(null);

            // write to an object that doesn't exist
            jsonOut.writeObject(aNullFile);

            // use get method when printing out a title - use null
            System.out.println(jsonInHashmap.get(null));

            // try to write to a file twice
            File writingTwice = new File("writingTwice.json"); // new instance of a file
            FileOutputStream writingTwiceFileOutputStream = new FileOutputStream(writingTwice); // new file output stream, writing to new file
            FileInputStream writingTwiceFileInputStream = new FileInputStream(writingTwice); // new file input stream, reading from new file
            JSONInputStream writingTwiceJsonIn = new JSONInputStream(writingTwiceFileInputStream); // json wrapper for file input stream
            JSONOutputStream writingTwiceJsonOut = new JSONOutputStream(writingTwiceFileOutputStream); // json wrapper for file output stream
            BookBean book7 = new BookBean(100, "Wild Women of Outer Space", "1977", true);
            writingTwiceJsonOut.writeObject(book7);
            writingTwiceJsonOut.writeObject(book7);

            // write to a file you don't have access to
            
            // write to a file that doesn't exist (no name)
            //

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
}
