import java.util.Scanner;
public class ratInMaze {
    static Scanner sc = new Scanner(System.in);
    public static boolean ratInmaze(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze,0,0,path);
    }
    public static boolean solveMaze(int maze[][],int i , int j, int path[][]){
        int n = maze.length;
        if(i < 0 || i>=n || j < 0 || j>=n || maze[i][j]==0 || path[i][j]==1){
            return false;
        }
        path[i][j] =1;
        if(i==n-1 && j==n-1){
            for(int r =0 ; r<n;r++){
                for(int c =0; c<n;c++){
                    System.out.print(path[r][c]+"\t");
                }
                System.out.println();
            }
            return true;
        }
        // top
        if(solveMaze(maze,i-1,j,path)){
            return true;
        }
        //right
        if(solveMaze(maze,i,j+1,path)){
            return true;
        }
        //down
        if(solveMaze(maze,i+1,j,path)){
            return true;
        }
        //left
        if(solveMaze(maze,i,j-1,path)){
            return true;
        }
        return false;
    }
    //==========main function=============
    public static void main(String [] args){
        System.out.println("Enter the size of Maze N X N :");
        int n = sc.nextInt();
        int maze[][] = new int[n][n];
        for(int r= 0 ; r< n ; r++){
            for(int c =0 ; c < n; c++ ){
                System.out.println("Enter 0 or 1 in row "+r+" and "+"col "+c);
                maze[r][c] = sc.nextInt();

            }
        }
        boolean pathPossible = ratInmaze(maze);
        System.out.println(pathPossible);
    }
}
