import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

abstract class AStarTechnique extends AlgorithmTechnique {
    public void performSearch(PriorityQueue<SearchNode> priorityQueue, String technique) {

        int expandedNodes = 0;
        String stringFormat = arrayToString(priorityQueue.peek().getCurState().getCurBoard());
        HashSet<String> visited = new HashSet<>();
        visited.add(stringFormat);
        HashSet<SearchNode> trackQueue = new HashSet<>();


        while (!priorityQueue.isEmpty()) {

            SearchNode parent = priorityQueue.poll();
            trackQueue.remove(parent);
            expandedNodes++;

            if (!parent.getCurState().isGoal()) {
                ArrayList<SearchNode> parentSuccessors = parent.getCurState().generateSuccessors(parent, technique);

                for (int i = 0; i < parentSuccessors.size(); i++) {

                    SearchNode child = parentSuccessors.get(i);
                    stringFormat = arrayToString(child.getCurState().getCurBoard());

                    if (!visited.contains(stringFormat)) {

                        priorityQueue.add(child);
                        visited.add(stringFormat);
                        trackQueue.add(child);
                    } else if (trackQueue.contains(child)) {
                        SearchNode temp = null;
                        boolean found = false;
                        for (SearchNode obj : trackQueue) {
                            if (obj.equals(child) && obj.getFCost() > child.getFCost()) {
                                temp = obj;
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            trackQueue.remove(temp);
                            priorityQueue.remove(temp);
                            trackQueue.add(child);
                            priorityQueue.add(child);
                        }
                    }


                }
            } else {
                printPath(parent, expandedNodes);
                break;
            }
        }
    }
    public int getVerticalDistance(int element,int j){
        return Math.abs(element%3-j);
    }
    public int getHorizontalDistance(int element,int i){
        return Math.abs(element/3-i);
    }
}
