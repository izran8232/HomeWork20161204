package OOPApp;

/**
 * Created by izran on 12/13/2016.
 */
//5) Abstraction
abstract public class BookAbstract {
    public abstract void read();
    public final void finish(){
        System.out.println("Finished Reading");
    }
}
