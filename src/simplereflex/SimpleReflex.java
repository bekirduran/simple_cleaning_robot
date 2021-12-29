
package simplereflex;


public class SimpleReflex {

    public static void main(String[] args) {

        // Creating new place matrix flexible
        Environment e = new Environment(5,5);
        // Agent start position
        Agent a = new Agent(0,0);
        a.BeginCleaning(e);
    }
    
}
