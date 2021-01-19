import java.util.*;

public class BFS extends AlgorithmTechnique{

    public  void search(int[][] board) {

        SearchNode root = new SearchNode(new EightPuzzleState(board));
        Queue<SearchNode> queue = new LinkedList<SearchNode>();
        queue.add(root);
        performSearch(queue);
    }

    public void performSearch(Queue<SearchNode> queue) {

        int expandedNodes=0;
        String stringFormat=arrayToString(queue.peek().getCurState().getCurBoard());
        HashSet<String>visited=new HashSet<>();
        visited.add(stringFormat);

        while (!queue.isEmpty())
        {

            SearchNode parent = queue.poll();
            expandedNodes++;

            if (!parent.getCurState().isGoal())
            {
                ArrayList<SearchNode> parentSuccessors = parent.getCurState().generateSuccessors(parent,"");

                for (int i = 0; i < parentSuccessors.size(); i++) {

                    SearchNode child=parentSuccessors.get(i);

                    stringFormat=arrayToString(child.getCurState().getCurBoard());

                    if(!visited.contains(stringFormat)) {
                        visited.add(stringFormat);
                        queue.add(child);
                    }

                }
            } else
            {
                printPath(parent,expandedNodes);

                break;
            }
        }
    }
    public String arrayToString(int[][]array){
    return super.arrayToString(array);
    }
    public void printPath(SearchNode parent,int expandedNodes){
        super.printPath(parent,expandedNodes);

    }

}
