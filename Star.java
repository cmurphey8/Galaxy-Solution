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

    // use Body step update and then attempt to supernova
    @Override
    public void step(double dt, double R) {
        super.step(dt, R);
        if (startNova) {
            if (novaCount == 10) {
                if (getSize() > 0.8 * SCALE * R * NOVA_GROWTH) newImage("blackhole.gif");
                else if (getSize() > 0.4 * SCALE * R * NOVA_GROWTH) newImage("pulsar.gif");
                else newImage("neutron.gif");
            }
            else {
                newSize(NOVA_RATE);
                novaCount++;
            }
        }
        else {
            Nova();
        }
    }

}
