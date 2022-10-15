public class navigateNode {
    navigateNode parent;
    int col;
    int row;
    int gcost;
    int hcost;
    int fcost;
    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;

    public navigateNode(int col, int row){
        this.col = col;
        this.row = row;
    }
    public void setAsStart(){
        start = true;
    }
    public void setAsGoal(){
        goal = true;
    }
    public void setAsSolid() {
        solid = true;
    }
    
}
