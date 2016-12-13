package OOPApp;

/**
 * Created by izran on 12/13/2016.
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class TestOOPApp {
    public static void main(String[] args) {
        // Abstraction

        Sherlock s = new Sherlock();
        s.read();
        s.finish();
        HarryPotter hp = new HarryPotter();
        hp.read();
        hp.finish();


        // Abstraction end

        try{

            Novel nov = new Novel("Study in Scarlet","MK Mag","Doyle","Mystery",3000);
            nov.Display("MK Mag");
            nov.Display(3000);
            nov.Display("Study in Scarlet", "Doyle", "MK Mag", 3000);
            nov.getType();

            Comic com = new Comic("Death of a Hero","DC Comics","Stan","Action",1500);
            com.getType();

            String Title,Publisher,Author,Type;

            int size = 5,Cost,MenuSelection;
            Scanner in = new Scanner(System.in);

            while(true){
                System.out.println("Please chose any option from following");
                System.out.println("1 for enter information to get from keyboard");
                System.out.println("2 for reading the data from file");
                System.out.println("3 Exit");

                MenuSelection = in.nextInt();
                if(MenuSelection==3){
                    break;
                }else if(MenuSelection==2){
                    String path = Paths.get("src/OOPApp/Bookdata.csv").toAbsolutePath().normalize().toString();
                    Book tbk = new Book();
                    ArrayList<Book> bklist=tbk.getBookDataFromFile(path);
                    for (Book bk : bklist) {
                        System.out.println(bk.getTitle()+ ","+bk.getPublisher()+","+bk.getAuthor()+","+bk.getType()+","+bk.getCost());
                    }

                    System.out.println("\n");
                }else{
                    System.out.println("Enter Title(Enter key E or e to exit)\n");
                    Title = in.next();
                    System.out.println("\nEnter Publisher\n");
                    Publisher = in.next();
                    System.out.println("\nEnter Author\n");
                    Author = in.next();
                    System.out.println("\nEnter Type\n");
                    Type = in.next();
                    Cost = (int)Math.floor(Math.random()*100);
                    Book bk = new Book(Title,Publisher,Author,Type,Cost);
                    bk.getType();
                }
            }


        }catch(Exception e){
            System.out.println("\n\n\nError");
        }finally{
            System.out.println("\n\n\n\nThis code will run regardless if error is found or not");
        }
    }

}
