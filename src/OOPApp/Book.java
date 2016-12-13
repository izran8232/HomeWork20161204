package OOPApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by izran on 12/13/2016.
 */


//2) Encapsulation
public class Book implements LibraryManagement {
    private String Title;
    private String Publisher;
    private String Author;
    public String Type;
    private int Cost;

    Book() {

    }

    Book(String Title, String Pub, String auth, String type, int cost) {
        this.Title = Title;
        this.Publisher = Pub;
        this.Author = auth;
        this.Type = type;
        this.Cost = cost;
    }

    //book focus like action.drama,hisotry
    public String getType() {
        return this.Type;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getPublisher() {
        return this.Publisher;
    }

    public String getAuthor() {
        return this.Author;
    }

    public int getCost() {
        return this.Cost;
    }

    public void getType(String type) {
        this.Type = type;
    }

    public void SetTitle(String title) {
        this.Title = title;
    }

    public void SetPublisher(String publisher) {
        this.Publisher = publisher;
    }

    public void SetAuthor(String author) {
        this.Author = author;
    }

    public void SetType(String type) {
        this.Type = type;
    }

    public void SetCost(int cost) {
        this.Cost = cost;
    }


    public void DisplayBook() {
        System.out.println("Title " + this.Title + " , Publisher:" + this.Publisher + " , Author:" + this.Author + " , Type:" + this.Type + " , Cost:" + this.Cost);
    }

    public ArrayList<Book> getBookDataFromFile(String path) {
        ArrayList<Book> list = new ArrayList<Book>();

        FileReader fr = null;
        BufferedReader br = null;
        try {
            // open input stream test.txt for reading purpose.
            String thisLine = null;
            String cvsSplitBy = ",";
            try {
                fr = new FileReader(path);
            } catch (FileNotFoundException e) {
                //e.printStackTrace();
                System.out.println("please fix the path");
            }
            br = new BufferedReader(fr);
            while ((thisLine = br.readLine()) != null) {
                String[] arrBook = thisLine.split(cvsSplitBy);

                String Title = arrBook[0];
                String Publisher = arrBook[1];
                String Author = arrBook[2];
                String Type = arrBook[3];
                int Cost = Integer.parseInt(arrBook[4]);

                Book bk = new Book(Title, Publisher, Author, Type, Cost);
                list.add(bk);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (br != null) {
                    br = null;
                }
                if (fr != null) {
                    fr = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    public void saveToFile(ArrayList<Book> bklist, String path) {
        FileWriter write = null;
        PrintWriter print_line = null;
        try {
            write = new FileWriter(path, false);
            print_line = new PrintWriter(write);
            for (Book bk : bklist) {
                print_line.println(bk.getTitle() + "," + bk.getPublisher() + "," + bk.getAuthor() + "," + bk.getType() + "," + bk.getCost());
            }
            print_line.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {

                if (write != null) {
                    write = null;
                }
                if (print_line != null) {
                    print_line = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

}
