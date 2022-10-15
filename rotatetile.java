import java.util.*;
import java.io.*;
import java.lang.Math; 
public class rotatetile{

    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("rotate.in"));
        PrintWriter pw = new PrintWriter ("rotate.out");
        double H = s.nextDouble();
        double V = s.nextDouble();
        int L = s.nextInt();
        double X = s.nextDouble();
        double Y = s.nextDouble();
        double altitude = getAlt(V, L);
        double ansalt = Math. round(altitude * 10.0) / 10.0;
        double answid = getWid(altitude, H);
        double ansR = getR(altitude, Y);
        double ansP = getP(altitude, X);
        String ans = "";
        System.out.println(getP (altitude, X));
        ans = ansalt + " "+ answid + " " + ansR+ " " + ansP;
        pw.print(ans);
        pw.close();

    }
    public static double getAlt(double V, int L){
        double length = (double)(L/2);
        double angle = Math.toRadians(V/2);
        double altitude = length/Math.tan(angle);

        return altitude;
    }
    public static double getWid(double alt, double H){
        double angle = Math.toRadians(H/2);
        double width = (alt*Math.tan(angle))*2;
        return  Math. round(width * 10.0) / 10.0;
    }
    public static double getP(double alt, double X){
        double angle = Math.toDegrees(Math.atan(X/alt));
        return Math. round(angle * 10.0) / 10.0;
    }
    public static double getR(double alt, double Y){
        Y*=-1;
        double angle = Math.toDegrees(Math.atan(Y/alt));
        return Math. round(angle * 10.0) / 10.0;
    }

}
