
/**********************************************************************************
 *
 *  GOAL: Complete the step(...) method too add supernove functionality
 *              
 **********************************************************************************/
import java.util.Scanner;

public class Star extends Body {
    private final double NOVA_RATE = 1.2;
    private final double NOVA_GROWTH = Math.pow(NOVA_RATE, 10);
    
    private boolean startNova = false;
    private int novaCount = 0;

    // create and init a new object with input parameters scanned from a .txt file
    public Star(Scanner scan, double R) {
        super(scan, R);
    }

    // start the supernova process randomly
    public void Nova() {
        if (Math.random() > 0.99995) {
            startNova = true;
        }
    }

    // attempt to supernova after Body step update
    @Override
    public void step(double dt, double R) {
        // call the Body class step method
        super.step(dt, R);

        // if supernova has started, grow image by scaling factor NOVA_RATE
        if (startNova) {
            // if (novaCount == 10) {
            //     // select new object type by updating image -- compare to maxSize scaled by NOVA_GROWTH (size at end of Nova)
            //     if (size > 0.8 * maxSize * NOVA_GROWTH) newImage("blackhole.gif");
            //     else if (size > 0.4 * maxSize * NOVA_GROWTH) newImage("pulsar.gif");
            //     else newImage("neutron.gif");
            // }
            // else {
            //     newSize(NOVA_RATE);
            //     novaCount++;
            // }
        }
        else {
            Nova();
        }
    }

}
