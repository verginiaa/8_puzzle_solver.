import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is Initial State (example : 0 1 2 3 4 5 6 7 8) : \n");

        int [][]startingStateBoard=new int[3][3];
        for(int i=0; i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                startingStateBoard[i][j]=scanner.nextInt();
            }
        }
        System.out.println("Which Algorithm Technique ?\n" +
                "1 - dfs\n" +
                "2 - bfs\n"+
                "3 -A* (Manhattan)\n"+
                "4 -A* (Euclid)\n"
        );

        int choice = scanner.nextInt();
       BFS BFS =new BFS();
        DFS DFS =new DFS();
        AStarManhattan aStar =new AStarManhattan();
        AStarEuclid euclid =new AStarEuclid();

        long start=System.currentTimeMillis();

        switch (choice) {
            case 1:
                DFS.search(startingStateBoard);
                break;
            case 2:
                BFS.search(startingStateBoard);
                break;
            case 3:
                aStar.search(startingStateBoard);
                break;
            case 4:
                euclid.search(startingStateBoard);
                break;
        }
        long end=System.currentTimeMillis();
        long totalTime=end-start;
        System.out.println("time is :"+totalTime+" milliseconds.");
    }



}
