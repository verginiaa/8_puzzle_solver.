import java.util.*;

public class DFS extends AlgorithmTechnique{

    public  void search(int[][] board) {

        SearchNode root = new SearchNode(new EightPuzzleState(board));
        Stack<SearchNode> stack = new Stack<>();
        stack.add(root);
        performSearch(stack);
    }

    public void performSearch(Stack<SearchNode> stack) {

        int expandedNodes=0;
        String stringFormat=arrayToString(stack.peek().getCurState().getCurBoard());
        HashSet<String>visited=new HashSet<>();
        visited.add(stringFormat);

        while (!stack.isEmpty())
        {

            SearchNode parent = stack.pop();
            expandedNodes++;

            if (!parent.getCurState().isGoal())
            {
                ArrayList<SearchNode> parentSuccessors = parent.getCurState().generateSuccessors(parent,"");

                for (int i = 0; i < parentSuccessors.size(); i++) {


                    SearchNode child=parentSuccessors.get(i);
                    stringFormat=arrayToString(child.getCurState().getCurBoard());

                    if(!visited.contains(stringFormat)) {
                        visited.add(stringFormat);
                        stack.push(child);
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
    public void printPath(SearchNode node,int expandedNodes){
        super.printPath(node,expandedNodes);
    }
}
