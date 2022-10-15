import java.util.*;
import java.io.*;
public class navigatePath {
    static navigateNode[][]node;
    static navigateNode startNode;
    static navigateNode currentNode;
    static navigateNode goalNode;
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("navigate.in"));
        PrintWriter pw = new PrintWriter ("navigate.out");
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        int P = s.nextInt();
        int col = 0;
        int row = 0;

        navigateNode[][]node = new navigateNode[N][M];
        while(col < N && row< M){
            node[col][row] = new navigateNode(col, row);
            if(col == N){
                col=0;
                row++;
            }

        }
        setStartNode(s.nextInt(), s.nextInt());
        setGoalNode(s.nextInt(), s.nextInt());

    }
    private static void setStartNode(int col, int row){
        node[col][row].setAsStart();
        startNode = node[col][row];
        currentNode = startNode;  
    }
    private static void setGoalNode(int col, int row){
        node[col][row].setAsGoal();
        goalNode = node[col][row];
    }
    private static void setSolidNode(int col, int row){
        node[col][row].setAsSolid();
    }
}
