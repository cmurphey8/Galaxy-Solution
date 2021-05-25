
/**********************************************************************************
 *
 *  Nothing to do here... neutron stars simply exist
 *              
 **********************************************************************************/

public class Neutron extends Body {

    // create and init a new object with an array of input parameters
    public Neutron(double[] arr, double R) {
        super(arr, R);
        newImage("neutron.gif");
        newSize(0.5);   // scale by 0.5 -> neutron stars are small, dense objects
    }

}
