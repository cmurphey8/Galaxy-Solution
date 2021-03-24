/**********************************************************************************
 *
 *  This is a template file for Wave.java. It lists the constructors and
 *  methods you need, along with descriptions of what they're supposed to do.
 *  
 *  PART 1: complete all methods of the Ball class
 *  PART 2: update Billiards.java so that all balls are represented by the Ball data type
 *              
 **********************************************************************************/
import java.util.Scanner;

public class BlackHole extends Body {

    // create and init a new object with input parameters scanned from a .txt file
    // this instance is for our supermassive blackhole only!
    public BlackHole(Scanner scan, double R) {
        super(scan, R);
        newImage("blackhole.gif");
        reinit();
    }

    // create and init a new object with an array of input parameters
    public BlackHole(double[] arr, double R) {
        super(arr, R);
        newImage("blackhole.gif");
        reinit();
        newSize(getSize() / 2);
    }

    // use body force update and then attempt to eat neighbors
    @Override
    public void updateF(Body obj, double G) {
        super.updateF(obj, G);
        if (super.calcRad(obj) < Math.max(getSize() / 2, obj.getSize() / 2)) {
            eat(obj);
        }
    }
}
