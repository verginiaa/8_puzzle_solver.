import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class SearchNode {

    private EightPuzzleState curState;
    private SearchNode parent;
    private int gCost;
    private int hCost;
    private int fCost;


    public SearchNode(EightPuzzleState s) {
        curState = s;
        parent = null;
        gCost = 0;
    }


    public String arrayToString(){
        String str=new String();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) str+=String.valueOf(curState.getCurBoard()[i][j]);
        }
        return str;
    }
    @Override
    public int hashCode() {
        return arrayToString().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchNode state = (SearchNode) o;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(state.curState.getCurBoard()[i][j]!=curState.getCurBoard()[i][j]) return false;
            }
        }
        return true;
    }

    public SearchNode(SearchNode prev, EightPuzzleState s, int g,int h) {
        parent = prev;
        curState = s;
        gCost = g;
        hCost = h;
        fCost = gCost+hCost;
    }

    public EightPuzzleState getCurState() {
        return curState;
    }

    public SearchNode getParent() {
        return parent;
    }

    public int getGCost() {
        return gCost;
    }

    public void setGCost(int gCost) {
        this.gCost = gCost;
    }

    public int getHCost() {
        return hCost;
    }

    public void setHCost(int hCost) {
        this.hCost = hCost;
    }

    public int getFCost() {
        return fCost;
    }

    public void setFCost(int fCost) {
        this.fCost = fCost;
    }




}
