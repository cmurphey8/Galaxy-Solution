/**********************************************************************************
 *
 *  GOAL: Complete step(...) method to add pulse functionality
 *              
 **********************************************************************************/
public class Pulsar extends Body {

    private boolean imageRev;   // is the image reversed?
    private int imageCount;     // number of steps taken since last image reversal

    // images to swap between every 10 steps
    String image = "pulsar.gif";
    String reverseImage = "pulsarR.gif";

    // create and init a new object with input parameters scanned from a .txt file
    public Pulsar(double[] arr, double R) {
        super(arr, R);
        newImage("pulsar.gif");
        
        imageCount = 0;
        imageRev = false;
    }

    // use Body step update and then attempt to update image
    @Override
    public void step(double dt, double R) {
        // call the Body class step method
        super.step(dt, R);

        // TODO: update this Pulsar object's image from image to reverseImage every 10 steps
        // imageCount++;
        // if (imageCount == 10) {
            
        //     if (!imageRev) {
        //         newImage("pulsarR.gif");
        //         imageRev = true;
        //     }
        //     else {
        //         newImage("pulsar.gif");
        //         imageRev = false;
        //     }
        //     imageCount = 0;
        // }
    }
}
