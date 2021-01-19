import java.util.ArrayList;
import java.util.Stack;

abstract class AlgorithmTechnique {

    public String arrayToString(int[][]array){
        String str=new String();

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) str+=String.valueOf(array[i][j]);
        }
        return str;
    }

    public void printPath(SearchNode node,int expandedNodes){
        ArrayList<int[][]> bigArray=new ArrayList<int[][]>();
        Stack<SearchNode> solutionPath = new Stack<SearchNode>();
        solutionPath.push(node);
       // if(node.getParent()!=null)
        //node = node.getParent();

        while (node.getParent() != null) {
            solutionPath.push(node.getParent());
            node = node.getParent();
        }
       // solutionPath.push(node);

        int loopSize = solutionPath.size();

        for (int i = 0; i < loopSize; i++) {
            node = solutionPath.pop();
            node.getCurState().printState();
            int[][]array=node.getCurState().getCurBoard();
            bigArray.add(array);
            System.out.println();
            System.out.println();
        }

        System.out.println("The cost is: " + node.getGCost());
        System.out.println("The depth is: " + node.getGCost());
        System.out.println("The expanded nodes : " + expandedNodes);

        visualization(bigArray,node.getGCost());

    }
    public void visualization(ArrayList<int[][]> array,int cost){

        Controller controller=new Controller();
        controller.draw(array,cost);
    }

}
