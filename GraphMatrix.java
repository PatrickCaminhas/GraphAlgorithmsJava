import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphMatrix {

  private int countNodes;
  private int countEdges;
  private int[][] adjMatrix;
  private static int INF = 9999;


  public GraphMatrix(int countNodes) {
    this.countNodes = countNodes;
    this.adjMatrix = new int[countNodes][countNodes];
  }

  public GraphMatrix(String fileName) throws IOException {
    File file = new File(fileName);
    FileReader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);

    // Read header
    String[] line = bufferedReader.readLine().split(" ");
    this.countNodes = (Integer.parseInt(line[0]));
    int fileLines = (Integer.parseInt(line[1]));

    // Create and fill adjMatrix with read edges
    this.adjMatrix = new int[this.countNodes][this.countNodes];
    for (int i = 0; i < fileLines; ++i) {
      String[] edgeInfo = bufferedReader.readLine().split(" ");
      int source = Integer.parseInt(edgeInfo[0]);
      int sink = Integer.parseInt(edgeInfo[1]);
      int weight = Integer.parseInt(edgeInfo[2]);
      addEdge(source, sink, weight);
    }
    bufferedReader.close();
    reader.close();
  }


  public int getCountNodes() {
    return countNodes;
  }

  public int getCountEdges() {
    return countEdges;
  }

  public int[][] getAdjMatrix() {
    return adjMatrix;
  }

  @Override
  public String toString() {
    String str = "";
    for (int i = 0; i < this.adjMatrix.length; i++) {
      for (int j = 0; j < this.adjMatrix[i].length; j++) {
        str += this.adjMatrix[i][j] + "\t";
      }
      str += "\n";
    }
    return str;
  }


  public void addEdge(int source, int sink, int weight) {
    if (source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
      System.err.println("Invalid edge: " + source + " " + sink + " " + weight);
      return;
    }
    this.adjMatrix[source][sink] = weight;
    this.countEdges++;
  }

  public int degree(int node) {
    //returns the degree of a node
    if (node < 0 || node > this.countNodes - 1) {
      System.err.println("Invalid node: " + node);
    }
    int degree = 0;
    for (int j = 0; j < this.adjMatrix[node].length; j++) {
      if (this.adjMatrix[node][j] != 0) {
        ++degree;
      }
    }

    return degree;
  }

  public int highestDegree() {
    int aux = 0;
    int high = 0;
    for (int i = 0; i < this.adjMatrix.length; i++) {
      aux = this.degree(i);
      if (aux > high) {
        high = aux;
      }
    }
    return high;
  }


  public int lowestDegree() {
    int aux = 0;
    int low = this.adjMatrix.length;
    for (int i = 0; i < this.adjMatrix.length; i++) {
      aux = this.degree(i);
      if (aux < low) {
        low = aux;
      }
    }
    return low;
  }

  public GraphMatrix complement() {
    GraphMatrix complent = new GraphMatrix(this.adjMatrix.length);
    for (int i = 0; i < adjMatrix.length; i++) {
      for (int j = 0; j < adjMatrix[i].length; j++) {
        if (adjMatrix[i][j] == 0 && i != j) {
          complent.addEdge(i, j, 1);
        }
      }
    }
    return complent;
  }

  public float density() {
    return (float) (this.countEdges / (this.countNodes * (this.countNodes - 1)));
  }

  public boolean subGraph(GraphMatrix g2) {
    if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges) {
      return false;
    }
    for (int i = 0; i < g2.adjMatrix.length; i++) {
      for (int j = 0; j < g2.adjMatrix[i].length; j++) {
        if (g2.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] == 0) {
          return false;
        }

      }
    }
    return true;
  }

  public ArrayList<Integer> bfs(int s) { //BUSCA EM LARGURA
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> Q = new ArrayList<>();
    Q.add(s);
    ArrayList<Integer> R = new ArrayList<>();
    R.add(s);
    desc[s] = 1;
    while (Q.size()>0) {
      {
        int u=Q.remove(0);
        for(int v = 0; v<this.adjMatrix[u].length; v++)
        {
          if(this.adjMatrix[u][v] !=0)
          {
            if(desc[v]==0)
            {
              Q.add(v);
              R.add(v);
              desc[v] = 1;
            }
          }
        }
      }
    }
    return R;
  }

  public void addUnOrientedEdge(int u, int v, int w) {
    if (u < 0 || u > this.countNodes - 1 || v < 0 || v > this.countNodes - 1 || w <= 0) {
      System.err.println("Invalid edge: " + u + " " + v + " " + w);
      return;
    }
    this.adjMatrix[u][v] = w;
    this.adjMatrix[v][u] = w;
    this.countEdges+=2;
  }

  public boolean connected(){
    return this.bfs(0).size() == this.countNodes;
  }

  public ArrayList<Integer> dfs(int s){ //BUSCA PROFUNDIDADE
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> S = new ArrayList<>();
    S.add(s);
    ArrayList<Integer> R = new ArrayList<>();
    R.add(s);
    desc[s] = 1;
    while (S.size()>0) {
      {
        int u=S.get(S.size()-1);
        boolean unstack = true; //desempilhar
        for(int v = 0; v<this.adjMatrix[u].length; v++)
        {
          if(this.adjMatrix[u][v] !=0 && desc[v]==0) {
            S.add(v);
            R.add(v);
            desc[v] = 1;
            unstack = false;
            break;
          }
        }
        if(unstack){
          S.remove(S.size()-1);
        }
      }
    }
    return R;
  }

  public boolean notOriented(){

    for(int i=0; i < this.adjMatrix.length;i++){
      for(int j=i+1; j < this.adjMatrix[i].length;j++) {
        if (this.adjMatrix[i][j] != this.adjMatrix[j][i]) {
          return false;
        }
      }
    }
    return true;
  }

  public ArrayList<Integer> dfs_Rec(int s){
    int[] desc = new int[this.countNodes];
    ArrayList<Integer> R = new ArrayList<>();
    dfs_Rec_Aux(s, desc, R);
    return R;

  }

  public void dfs_Rec_Aux(int u, int desc[],ArrayList<Integer> R){

    desc[u] = 1;
    R.add(u);
    for (int v = 0; v < this.adjMatrix[u].length; ++v) {
      if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
        dfs_Rec_Aux(v, desc, R);
      }
    }


  }




  public void floydWarshall(int s, int t){
    int[][] dist = new int[this.countNodes][this.countNodes];
    int[][] pred = new int[this.countNodes][this.countNodes];
    for(int i=0; i< this.adjMatrix.length; i++){
      for(int j=0; j < this.adjMatrix[i].length; j++){
        if( i == j)
        {
          dist[i][j]=0;
          pred[i][j]=-1;
        }
        else if(this.adjMatrix[i][j]!= 0)
        {
          dist[i][j]=this.adjMatrix[i][j];
          pred[i][j]=i;
        }
        else
        {
          dist[i][j]=INF;
          pred[i][j]= -1;
        }

      }
    }

    for(int k = 0; k < this.countNodes; k++){
      for(int i = 0; i < this.countNodes; i++){
        for(int j = 0; j < this.countNodes; j++){
          if(dist[i][j]> dist[i][k] + dist[k][j]){
            dist[i][j]= dist[i][k] + dist[k][j];
            pred[i][j]= pred[k][j];
          }
        }
      }
    }
    System.out.println("DIST: ");
    for(int i=0; i<this.adjMatrix.length; i++){
      for(int j = 0; j < this.adjMatrix[i].length; j++){
        System.out.print(dist[i][j]+ "\t" );
      }
      System.out.println();
    }

    System.out.println("\nPRED: ");

    for(int i=0; i<this.adjMatrix.length; i++){
      for(int j = 0; j < this.adjMatrix[i].length; j++){
        System.out.print(pred[i][j]+ "\t");
      }
      System.out.println();
    }
    System.out.printf("Distancia de %d  a %d e: %d \n", s,t,dist[s][t]);
    ArrayList<Integer> C = new ArrayList<Integer>();
    C.add(t);
    int aux= t;
    while (aux !=s){
      aux = pred[s][aux];
      C.add(0,aux);
    }
    System.out.println("Path: "+ C);
  }

}

