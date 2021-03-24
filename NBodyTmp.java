/*******************************************************************************
 * 
 *  Dependencies: StdDraw.java
 *
 *  N-body simulation.
 *    *  Reads in length of simulation T and time quantum dt from the command line;
 *    *  Reads in number of bodies N, radius of universe R, initial positions,
 *       velocities, masses, and name of image files from standard input;
 *    *  Simulate the system from time t = 0 until t >= T and plots the
 *       the results to standard drawing;
 *    *  Prints the final positions and velocities to standard output.
 *
 ******************************************************************************/

import java.util.Scanner;
import java.io.File; 
import java.io.FileNotFoundException;

public class NBodyTmp {

    // animation pause (in miliseconds)
    public static final int DELAY = 20;

    // music (2001 theme)
    public static final String MUSIC = "2001theme.wav";

    // background image
    public static final String BACKGROUND = "starfield.jpg";

    // parameters input file
    public static String PLANETS_FILE;

    // gravitational constant (N m^2 / kg^2)
    public static final double G = 6.67e-11;

                                            // parameters from command line
    public static double T= 157788000.0;    // simulate from time 0 to T (s);             
    public static double dt = 25000.0;      // time quantum (s);

                                        // parameters from first two lines 
    public static int N;                // number of bodies
    public static double R;             // radius of universe

    public static double[] rx;          // x position (m)
    public static double[] ry;          // y position (m)
    public static double[] vx;          // x velocity (m/s)
    public static double[] vy;          // y velocity (m/s)
    public static double[] mass;        // mass (kg)
    public static String[] image;       // name of gif

    // read the planet file, new the parallel arrays, 
    // and load their values from the file.
    public static void loadPlanets() {
        
        // open a parameters File to read from
        Scanner scan = null;
        try { File f = new File(getFile()); scan = new Scanner( f ); } 
        catch(FileNotFoundException e) { System.out.println("File not found exception"); } 

        // read from standard input
        N = scan.nextInt();         // number of bodies
        R = scan.nextDouble();      // radius of universe (m)

        // declare parallel arrays
        rx = new double[N];         // x position (m)
        ry = new double[N];         // y position (m)
        vx = new double[N];         // x velocity (m/s)
        vy = new double[N];         // y velocity (m/s)
        mass = new double[N];       // mass (kg)
        image = new String[N];      // name of gif

        // read in initial position, velocity, mass, and image name from stdin
        for (int i = 0; i < N; i++) {
            rx[i]    = scan.nextDouble();
            ry[i]    = scan.nextDouble();
            vx[i]    = scan.nextDouble();
            vy[i]    = scan.nextDouble();
            mass[i]  = scan.nextDouble();
            image[i] = scan.next();
        }
    }

    public static String getFile() {
        Scanner console = new Scanner( System.in );
        System.out.print("parameters input file: ");
        String inputFile = console.next();
        console.close();
        return inputFile;
    }

    public static void runSimulation() {

        // run numerical simulation from 0 to T
        for (double t = 0.0; t < T; t += dt) {

            // the x- and y-components of force
            double[] fx = new double[N];
            double[] fy = new double[N];

            // calculate forces on each object
            for (int i = 0; i < N; i++) {
                fx[i] = 0;
                fy[i] = 0;
                for (int j = 0; j < N; j++) {
                    if (i != j) {
                        double dx = rx[j] - rx[i];
                        double dy = ry[j] - ry[i];
                        double rad = Math.sqrt(dx * dx + dy * dy);
                        double Force = G * mass[i] * mass[j] / (rad * rad);
                        
                        fx[i] += Force * dx / rad;
                        fy[i] += Force * dy / rad;
                    }    
                }
                // update velocities and positions
                vx[i] += dt * fx[i] / mass[i];
                vy[i] += dt * fy[i] / mass[i];

                rx[i] += dt * vx[i];
                ry[i] += dt * vy[i];
            }
            // draw background and then planets
            // pause for a short while, using "animation mode"
            StdDraw.picture(0.0, 0.0, BACKGROUND);
            for (int i = 0; i < N; i++) {
                StdDraw.picture(rx[i], ry[i], image[i]);
                // System.out.println("NEW STEP: " + t);    
            }
            StdDraw.show();
            StdDraw.pause(DELAY);
        }

    }

    public static void main(String[] args) {
        loadPlanets();

        // rescale coordinates that we can use natural x- and y-coordinates
        StdDraw.setXscale(-R, +R);
        StdDraw.setYscale(-R, +R);

        StdAudio.play( MUSIC );

        StdDraw.enableDoubleBuffering();
        // turn on animation mode
        StdDraw.show();

        // Run simulation
        runSimulation();

        // print final state of universe to standard output
        System.out.printf("%d\n", N);
        System.out.printf("%.2e\n", R);
        for (int i = 0; i < N; i++) {
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          rx[i], ry[i], vx[i], vy[i], mass[i], image[i]);
        }

    }
}