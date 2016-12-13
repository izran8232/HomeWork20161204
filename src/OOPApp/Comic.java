package OOPApp;

/**
 * Created by izran on 12/13/2016.
 */

//3) Inheritance
public class Comic extends Book{

    Comic(String Title,String Pub, String auth,String type, int cost){
        super(Title,Pub, auth, type, cost);
    }

    //@Override
    public String getType(){
        return "This is a Comic " + Type;
    }
}