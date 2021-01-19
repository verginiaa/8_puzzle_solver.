import java.util.*;

public class AStarManhattan extends AStarTechnique {

    public SearchNode initRoot(int[][]board){
        SearchNode rootParent=null;
        int rootManhattanDistance=getManhattanDistance(board);
        SearchNode root = new SearchNode(rootParent,new EightPuzzleState(board),0,rootManhattanDistance);
        return root;
    }



    public  void search(int[][] board) {

        SearchNode root=initRoot(board);
        PriorityQueue<SearchNode> priorityQueue = new PriorityQueue<SearchNode>(181400,
                new Comparator<SearchNode>(){
                    public int compare(SearchNode i, SearchNode j){
                        if(i.getFCost() > j.getFCost()){
                            return 1;
                        }

                        else if (i.getFCost() < j.getFCost()){
                            return -1;
                        }

                        else{
                            return 0;
                        }
                    }

                }
        );
        priorityQueue.add(root);
        performSearch(priorityQueue,"Manhattan");
    }


    public int getManhattanDistance(int[][]currBoard)
    {
        int manhattanDistance=0;
        for(int i=0;i<currBoard.length;i++){
            for(int j=0;j<currBoard[i].length;j++){
                int elementValue=currBoard[i][j];
                if(elementValue!=(i*3)+j){
                    int verticalDistance=getVerticalDistance(elementValue,j);
                    int horizontalDistance=getHorizontalDistance(elementValue,i);
                    manhattanDistance+=horizontalDistance+verticalDistance;

                }
            }
        }
        return manhattanDistance;
    }
}
