
import java.util.ArrayList;

public class EightPuzzleState {

    private int rows = 3;
    private int columns = 3;
    private static int[][] goal = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    private int[][] curBoard;

    public EightPuzzleState(int[][] board) {
        curBoard = board;
    }

//Node bdl state.
    public ArrayList<SearchNode> generateSuccessors(SearchNode parent,String technique) {

        ArrayList<SearchNode> successors = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (curBoard[i][j] == 0) {
                    if (i > 0) {
                        int[][] copy=swap(i-1,j,i,j,successors,parent);
                        formSuccessor(technique,successors,parent,copy);

                    }
                    if (i < rows - 1) {
                        int[][] copy=swap(i+1,j,i,j,successors,parent);
                        formSuccessor(technique,successors,parent,copy);

                    }
                    if (j > 0) {
                        int[][] copy= swap(i,j-1,i,j,successors,parent);
                        formSuccessor(technique,successors,parent,copy);

                    }
                    if (j < columns - 1) {
                        int[][] copy=swap(i,j+1,i,j,successors,parent);
                        formSuccessor(technique,successors,parent,copy);

                    }


                    return successors;

                }
            }

        }

        return successors;

    }
    private int[][] swap(int i1, int j1, int i2, int j2, ArrayList<SearchNode> s, SearchNode parent) {
        int[][] copy = copyBoard(curBoard);
        int temp=copy[i1][j1];
        copy[i1][j1]=copy[i2][j2];
        copy[i2][j2]=temp;
        return copy;
    }
    public void formSuccessor(String technique, ArrayList<SearchNode> s, SearchNode parent,int[][]board){
        int distance=0;
        if(technique.equalsIgnoreCase("Manhattan"))
            distance=getManhattanDistance(board);
        if(technique.equalsIgnoreCase("Euclid"))
            distance=getEuclidDistance(board);
        s.add(new SearchNode(parent,new EightPuzzleState(board),parent.getGCost()+ 1,distance));


    }
    public boolean isGoal() {
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(curBoard[i][j]!=goal[i][j]) return false;
            }
        }
        return true;
    }
    private int[][] copyBoard(int[][] original) {
        int[][] copy = new int[rows][columns];
        for(int i=0; i<rows; i++)
            for(int j=0; j<columns; j++)
                copy[i][j]=original[i][j];
        return copy;
    }


    public void printState() {
        // obj.draw(curBoard);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(j==columns-1){
                    System.out.println(curBoard[i][j]);
                    System.out.println("---------");
                }else
                    System.out.print(curBoard[i][j]+" | ");
            }
        }
    }

    public int[][] getCurBoard() {
        return curBoard;
    }

   /* @Override
    public boolean equals(Object o){
        if(!(o instanceof EightPuzzleState)) return false;
        EightPuzzleState oState = (EightPuzzleState) o;
    }*/
   public int getVerticalDistance(int element,int j){
       return Math.abs(element%3-j);
   }
    public int getHorizontalDistance(int element,int i){
        return Math.abs(element/3-i);
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