import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class gridacc{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("find.in"));
        PrintWriter pw = new PrintWriter ("find.out");
        int N = s.nextInt();
        int M = s.nextInt();

        double Dx = s.nextDouble();
        double Dy = s.nextDouble();
        int K = s.nextInt();
        double boundaryx = (N-1);
        double boundaryy = (M-1);
        double arrx[] = new double [K];
        double arry[] = new double [K];
        for(int i = 0; i<K; i++){
            arrx[i] = s.nextDouble();
            arry[i] = s.nextDouble();
        }
    
        for(int i = 0; i< K; i++){
            String ans = "";
            double uno = getPlace(arrx[i], Dx, boundaryx);
            double dos = getPlace(arry[i], Dy, boundaryy);
            ans = (int)uno + " " + (int)dos;
            pw.println(ans);
        }
        pw.close();
        
    }
    public static double getPlace(double x, double dx, double boundary){
        int min =  (int)Math.round((x/dx)-0.1);
        if(min<boundary){
            return min;
        }else{
            return boundary;
        }
    }
   
}
