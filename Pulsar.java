/**********************************************************************************
 *
 *  This is a template file for Wave.java. It lists the constructors and
 *  methods you need, along with descriptions of what they're supposed to do.
 *  
 *  PART 1: complete all methods of the Ball class
 *  PART 2: update Billiards.java so that all balls are represented by the Ball data type
 *              
 **********************************************************************************/

public class Pulsar extends Body {

    private boolean imageRev;
    private int imageCount;

    // create and init a new object with input parameters scanned from a .txt file
    public Pulsar(double[] arr, double R) {
        super(arr, R);
        newImage("pulsar.gif");
        reinit();

        imageCount = 0;
        imageRev = false;
    }

    // use Body step update and then attempt to update image
    @Override
    public void step(double dt, double R) {
        super.step(dt, R);
        imageCount++;
        if (imageCount == 10) {
            
            if (!imageRev) {
                newImage("pulsarR.gif");
                imageRev = true;
            }
            else {
                newImage("pulsar.gif");
                imageRev = false;
            }
            imageCount = 0;
        }
    }
}
