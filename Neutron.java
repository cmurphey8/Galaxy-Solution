/**********************************************************************************
 *
 *  This is a template file for Wave.java. It lists the constructors and
 *  methods you need, along with descriptions of what they're supposed to do.
 *  
 *  PART 1: complete all methods of the Ball class
 *  PART 2: update Billiards.java so that all balls are represented by the Ball data type
 *              
 **********************************************************************************/

public class Neutron extends Body {

    // create and init a new object with an array of input parameters
    public Neutron(double[] arr, double R) {
        super(arr, R);
        newImage("neutron.gif");
        newSize(getSize() / 2);
        reinit();
    }

}
