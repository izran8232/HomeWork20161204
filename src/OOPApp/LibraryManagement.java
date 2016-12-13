package OOPApp;
import java.util.ArrayList;
/**
 * Created by izran on 12/13/2016.
 */
public interface LibraryManagement {
    public void DisplayBook();

    public ArrayList<Book> getBookDataFromFile(String path);
    public void saveToFile(ArrayList<Book> bklist,String path);
}
