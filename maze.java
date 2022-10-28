import java.io.*;
import java.util.*;
public class maze {

    private int ROW;
    private int COL;


    // To store matrix cell coordinates
    static class Point
    {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    };

    // A Data Structure for queue used in BFS
    static class queueNode
    {
        Point pt; // The coordinates of a cell
        int dist; // cell's distance of from the source

        public queueNode(Point pt, int dist)
        {
            this.pt = pt;
            this.dist = dist;
        }
    };

    // check whether given cell (row, col)
// is a valid cell or not.
     boolean isValid(int row, int col)
    {
        // return true if row number and
        // column number is in range
        return (row >= 0) && (row < this.ROW) &&
                (col >= 0) && (col < this.COL);
    }

    // These arrays are used to get row and column
// numbers of 4 neighbours of a given cell
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    // function to find the shortest path between
// a given source cell to a destination cell.
    int BFS(int mat[][], Point src,
            Point dest)
    {
        // check source and destination cell
        // of the matrix have value 1
        if (mat[src.x][src.y] != 1 ||
                mat[dest.x][dest.y] != 1)
            return -1;

        boolean [][]visited = new boolean[this.ROW][this.COL];

        // Mark the source cell as visited
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<queueNode> q = new LinkedList<>();

        // Distance of source cell is 0
        queueNode s = new queueNode(src, 0);
        q.add(s); // Enqueue source cell

        // Do a BFS starting from source cell
        while (!q.isEmpty())
        {
            queueNode curr = q.peek();
            Point pt = curr.pt;

            // If we have reached the destination cell,
            // we are done
            if (pt.x == dest.x && pt.y == dest.y)
                return curr.dist;

            // Otherwise dequeue the front cell
            // in the queue and enqueue
            // its adjacent cells
            q.remove();

            for (int i = 0; i < 4; i++)
            {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                // if adjacent cell is valid, has path
                // and not visited yet, enqueue it.
                if (isValid(row, col) &&
                        mat[row][col] == 1 &&
                        !visited[row][col])
                {
                    // mark cell as visited and enqueue it
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode
                            (new Point(row, col),
                                    curr.dist + 1 );
                    q.add(Adjcell);
                }
            }
        }

        // Return -1 if destination cannot be reached
        return -1;
    }

    public int getColuna(String fileName) throws IOException {
        File f=new File("input.txt");     //Creation of File Descriptor for input file
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        int tamanhoColuna=1;
        while((c = br.read()) != -1)         //Read char by Char
        {

            if(c==13){
                tamanhoColuna++;
                System.out.println("COLUNA: "+tamanhoColuna);
            }

        }
        return tamanhoColuna;
    }
    public int getLinha(String fileName) throws IOException {
        File f=new File("input.txt");     //Creation of File Descriptor for input file
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        int tamanhoLinha=0;
        while((c = br.read()) != -1)         //Read char by Char
        {

            if(c!=13 && c!=10){
                tamanhoLinha++;
                System.out.println("LINHA: "+tamanhoLinha);
            }

        }
        return tamanhoLinha;
    }

    public int[][] convertMazetoMatrix(String fileName) throws IOException {
        File f=new File("input.txt");     //Creation of File Descriptor for input file
        FileReader fr=new FileReader(f);   //Creation of File Reader object
        BufferedReader br=new BufferedReader(fr);  //Creation of BufferedReader object
        int c = 0;
        int TAMlinha=this.getLinha(fileName);
        int TAMcoluna=this.getColuna(fileName);
        int linha=0;
        int coluna=0;
        int [][] matriz = new int[TAMcoluna][TAMlinha];
        while((c = br.read()) != -1)         //Read char by Char
        {
            if(c==35){
                matriz[coluna][linha]=0;
            }
            if(c==32){
                matriz[coluna][linha]=1;
            }
            //converting integer to char
            System.out.println(c);        //Display the Character
            if(c==35 || c==32)
                linha++;
            if(linha==TAMlinha){
                linha=0;
                coluna++;
            }

        }
        return matriz;
    }

}
