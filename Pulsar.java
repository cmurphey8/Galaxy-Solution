/**********************************************************************************
 *
 *              
 **********************************************************************************/

public class Pulsar extends Body {

    private boolean imageRev;
    private int imageCount;

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
