
/**********************************************************************************
 *
 *  All methods in this class are complete
 *  You need not make any modifications to this file, but you will use several Body methods in other files!
 *              
 **********************************************************************************/

import java.util.Scanner;

public class Body {
    public final double SCALE = 0.042;  // scalar for star size

    private double fx;      // x force
    private double fy;      // y force
    private String image;   // png image

    protected double rx;      // x position
    protected double ry;      // y position
    protected double vx;      // x velocity
    protected double vy;      // y velocity

    protected double mass;    // mass
    protected double size;    // size

    protected double maxSize;
    


    protected boolean removed = false;    // removed status

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
        maxSize = SCALE * R;
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
        maxSize = SCALE * R;
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

    // draw this object using it's rx, ry, and image data
    public void draw() {
        StdDraw.picture(rx, ry, image, size, size);
    }

/**********************************************************************************
 *  Accessors      
 **********************************************************************************/

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

    // return removed status
    public boolean isRemoved() {
        return removed;
    }
}
