/**********************************************************************************
 *
 *  GOAL: Complete the updateF(...) method to add the eat other objects functionality
 *              
 **********************************************************************************/
import java.util.Scanner;

public class BlackHole extends Body {

    double compression = 0.0001;    // compression factor for the eat process

    // create and init a new object with input parameters scanned from a .txt file
    // this instance is for our supermassive blackhole only!
    public BlackHole(Scanner scan, double R) {
        super(scan, R);
        newImage("blackhole.gif");
    }

    // create and init a new object with an array of input parameters
    public BlackHole(double[] arr, double R) {
        super(arr, R);
        newImage("blackhole.gif");
        newSize(0.5);        
    }

    // attempt to eat neighbors after body force update
    @Override
    public void updateF(Body obj, double G) {
        // call Body class force update
        super.updateF(obj, G);

        // TODO:    if the distance from this black hole to the input object is 
        // //          less than the radius of either object, eat the input object
        // if (calcDist(obj) < Math.max(size / 2, obj.size / 2)) {
        //     eat(obj);
        // }
    }

    // update fx & fy with the additive gravitational force from the input Body obj
    public double calcDist(Body obj) {
        double dx = obj.rx - rx;
        double dy = obj.ry - ry;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // blackhole eat process
    public void eat(Body obj) {
        // TODO: update the removed status of the input Body object
        // obj.removed = true;

        // // grow the size of this black hole by 0.1% the size of the the input Body object
        // size += obj.size / 1000;

        // // grow the mass of this black hole by the mass of the input Body object
        // mass += obj.mass;
    }
}
