import java.util.*;

public class AStarEuclid extends AStarTechnique {

    public SearchNode initRoot(int[][]board){
        SearchNode rootParent=null;
        int rootManhattanDistance=getEuclidDistance(board);
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
        performSearch(priorityQueue,"Euclid");
    }

    public int getEuclidDistance(int[][]currBoard){
        int euclidDistance=0;
        for(int i=0;i<currBoard.length;i++){
            for(int j=0;j<currBoard[i].length;j++){
                int elementValue=currBoard[i][j];
                if(elementValue!=(i*3)+j){
                    int verticalDistance=getVerticalDistance(elementValue,j);
                    int horizontalDistance=getHorizontalDistance(elementValue,i);
                    euclidDistance= (int) (euclidDistance+Math.sqrt(Math.pow(verticalDistance,2)+Math.pow(horizontalDistance,2)));

                }
            }
        }
        return euclidDistance;
    }
}



