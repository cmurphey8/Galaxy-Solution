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

public class Body {
    public final double SCALE = 0.042;  // scalar for star size

    private double rx;      // x position
    private double ry;      // y position
    private double vx;      // x velocity
    private double vy;      // y velocity

    private double mass;    // mass
    private String image;   // png image
    private double size;    // size
    
    private double fx;      // x force
    private double fy;      // y force

    private boolean reinit = false;     // reinitialized status
    private boolean removed = false;    // removed status

/**********************************************************************************
 *  Constructors        
 **********************************************************************************/

    // create and init a new object with input parameters scanned from a .txt file
    public Body(Scanner scan, double R) {
        rx    = scan.nextDouble();
        ry    = scan.nextDouble();
        vx    = scan.nextDouble();
        vy    = scan.nextDouble();
        mass  = scan.nextDouble();
        image = scan.next();
        size  = Math.random() * SCALE * R;
    }

    public Body(double[] arr, double R) {
        rx    = arr[0];
        ry    = arr[1];
        vx    = arr[2];
        vy    = arr[3];
        mass  = arr[4];
        fx    = arr[5];
        fy    = arr[6];
        size  = SCALE * R;
    }

/**********************************************************************************
 *  Modifiers      
 **********************************************************************************/

    // set fx & fy to 0
    public void zeroF() {
        fx = 0;
        fy = 0;
    }

    // update fx & fy with the additive gravitational force from the input Body obj
    public void updateF(Body obj, double G) {
        double dx = obj.rx - rx;
        double dy = obj.ry - ry;
        double rad = Math.sqrt(dx * dx + dy * dy);
        double Force = G * mass * obj.mass / (rad * rad);
        
        fx += Force * dx / rad;
        fy += Force * dy / rad;
    }

    // update this object's position and velocity
    public void step(double dt, double R) {
        vx += dt * fx / mass;
        vy += dt * fy / mass;

        rx += dt * vx;
        ry += dt * vy;
    }

    // update image
    public void newImage(String imageName) {
        image = imageName;
    }

    // update size
    public void newSize(double multiplier) {
        size *= multiplier;
    }

    // blackhole eat process
    public void eat(Body obj) {
        obj.removed = true;
        size += obj.size / 1000;
        mass += obj.mass;
    }

    // update removed status
    public void remove() {
        removed = true;
    }

    // update removed status
    public void reinit() {
        reinit = true;
    }

    // draw this object using it's rx, ry, and image data
    public void draw() {
        StdDraw.picture(rx, ry, image, size, size);
    }

/**********************************************************************************
 *  Accessors      
 **********************************************************************************/

    // update fx & fy with the additive gravitational force from the input Body obj
    public double calcRad(Body obj) {
        double dx = obj.rx - rx;
        double dy = obj.ry - ry;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // print formatted rx, ry, vx, vy, mass, & image data of the object
    public void status() {
        System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", rx, ry, vx, vy, mass, image);
    }

    // return an array with all necessary parameters to reinit as a new celestial object
    public double[] params() {
        double[] arr = {rx, ry, vx, vy, mass, fx, fy};
        return arr;
    }

    // return image
    public String getImage() {
        return image;
    }

    // return size
    public double getSize() {
        return size;
    }

    // return removed status
    public boolean isRemoved() {
        return removed;
    }

    // return reinit status
    public boolean isReinit() {
        return reinit;
    }

}
