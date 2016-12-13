package OOPApp;

/**
 * Created by izran on 12/13/2016.
 */
//4) Inheritance and Polymorphism
public class Novel extends Book {

    Novel(String Title,String Pub, String auth,String type, int cost){
        super(Title,Pub, auth, type, cost);
    }

    @Override
    public String getType(){
        return "This is a Novel " + Type;
    }

    public void Display(String Publisher){
        System.out.println("Publisher: "+Publisher);
    }

    public void Display(int Cost){
        System.out.println("Cost: "+Cost);
    }

    public void Display(String Title,String Author,String Publisher,int Cost){
        System.out.println("Title: "+Title+" Author: "+" Publisher :"+Publisher+" Cost :"+Cost);
    }
}
