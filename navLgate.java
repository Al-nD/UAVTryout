import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class navLgate {
    static int arr[][];
    static int wex;
    static int wey;
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("navigate.in"));
        PrintWriter pw = new PrintWriter ("navigate.out");
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        int P = s.nextInt();
        arr = new int [N+1][M+1];
        wex = s.nextInt();
        wey = s.nextInt();
        int targetsx [] = new int [K-1];
        int targetsy [] = new int [K-1];
        for(int i =0; i< K-1; i++){
            targetsx[i] = s.nextInt();
            targetsy[i] = s.nextInt();
        }
        for(int i = 0; i< K-1; i++){
            plotTargets(targetsx[i], targetsy[i], i+2);
        }
        for(int i = 0; i< P; i++){
            int amt = s.nextInt();
            for(int j =0; j< amt; j++){
                int x = s.nextInt();
                int y = s.nextInt();
                addTargets(x, y);
            }
        }
        for(int i = 0; i<11; i++){
            System.out.println(Arrays.toString(arr[i]));
        }


        while(!whereTarget(2, targetsx[0], targetsy[0])){
            boolean yes = whereTarget(2, targetsx[0], targetsy[0]);
            if(yes){
                break;
            }
        }


    }
    public static void plotTargets(int x, int y, int number){
        arr[x][y] =number;
    }

    public static boolean whereTarget(int target, int x, int y){
        boolean up = false;
        boolean down = false;
        boolean right = false;
        boolean left  = false;
        boolean upright = false;
        boolean upleft = false;
        boolean downright = false;
        boolean downleft = false;
        double min = Integer.MAX_VALUE;
        double distance =  Math.sqrt((wey - y) * (wey - y) + ((wex) - x) * ((wex) - x));
        if(distance == 1){
            wex = x;
            wey = y;
            System.out.println(wex);
            System.out.println(wey);
            return true;
        }
        if(arr[wex+1][wey] == 0){
            double distanceright  = Math.sqrt((wey - y) * (wey - y) + ((wex+1) - x) * ((wex+1) - x));
            if(distanceright<min){
                min = distanceright;
                right = true;
            }
        }
        if(arr[wex][wey+1] == 0){
            double distanceup  = Math.sqrt(((wey+1) - y) * ((wey+1) - y) + ((wex) - x) * ((wex) - x));
            if(distanceup<min){
                min = distanceup;
                right = false;
                up = true;
            }
        }
        if(arr[wex][wey-1] == 0){
            double distancedown  = Math.sqrt(((wey-1) - y) * ((wey-1) - y) + ((wex) - x) * ((wex) - x));
            if(distancedown<min){
                min = distancedown;
                right = false;
                up = false;
                down = true;
            }
        }
        if(arr[wex-1][wey] == 0){
            double distanceleft  = Math.sqrt((wey - y) * (wey - y) + ((wex-1) - x) * ((wex-1) - x));
            if(distanceleft<min){
                min = distanceleft;
                right = false; 
                up = false;
                down = true;
            }
        }
        if(arr[wex+1][wey+1] == 0){
            double distanceupright  = Math.sqrt(((wey+1) - y) * ((wey+1) - y) + ((wex+1) - x) * ((wex+1) - x));
            if(distanceupright<min){
                min = distanceupright;
                right = false; 
                up = false;
                down = false;
                upright = true;
            }
        }
        if(arr[wex-1][wey+1] == 0){
            double distanceupleft  = Math.sqrt(((wey+1) - y) * ((wey+1) - y) + ((wex-1) - x) * ((wex-1) - x));
            if(distanceupleft<min){
                min = distanceupleft;
                right = false; 
                up = false;
                down = false;
                upright = false;
                upleft = true;
            }
        }
        if(arr[wex+1][wey-1] == 0){
            double distancedownright  = Math.sqrt(((wey-1) - y) * ((wey-1) - y) + ((wex+1) - x) * ((wex+1) - x));
            if(distancedownright<min){
                min = distancedownright;
                right = false; 
                up = false;
                down = false;
                upright = false;
                upleft = false;
                downright = true;
            }
        }
        if(arr[wex-1][wey-1] == 0){
            double distancedownleft  = Math.sqrt(((wey-1) - y) * ((wey-1) - y) + ((wex-1) - x) * ((wex-1) - x));
            if(distancedownleft<min){
                min = distancedownleft;
                right = false; 
                up = false;
                down = false;
                upright = false;
                upleft = false;
                downright = false;
                downleft = true;
            }
        }

        if(up){
            wey++;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }
        if(down){
            wey--;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }
        if(right){
            wex++;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }
        if(left){
            wex--;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }
        if(upright){
            wey++;
            wex++;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }else if( upleft){
            wey++;
            wex--;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }else if (downright){
            wey--;
            wex++;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }else if (downleft){
            wex--;
            wey--;
            System.out.println(wex);
            System.out.println(wey);
            return false;
        }
        return false;
    }

    public static void addTargets(int x, int y){
        arr[x][y] = 1;
    }

}

