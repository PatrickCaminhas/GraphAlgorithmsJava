import java.io.*;

public class Main {
  public static void main(String[] args) {
    Graph g1 = new Graph(9);
    g1.addUnOrientedEdge(7, 5, 1);
    g1.addUnOrientedEdge(7, 1, 1);
    g1.addUnOrientedEdge(7, 2, 1);
    g1.addUnOrientedEdge(1, 0, 1);
    g1.addUnOrientedEdge(1, 4, 1);
    g1.addUnOrientedEdge(2, 3, 1);
    g1.addUnOrientedEdge(5, 6, 1);
    g1.addUnOrientedEdge(6, 8, 1);
    System.out.println(g1.bfs(7));
    System.out.println("Está conectado? " + g1.connected());

    /*
     * Graph g1 = new Graph(4);
     * g1.addEdge(0,1,1);
     * g1.addEdge(1,0,1);
     * g1.addEdge(0,3,1);
     * g1.addEdge(3,0,1);
     * g1.addEdge(3,4,1); //AVISO
     * System.out.println(g1);
     * System.out.println(g1.degree(0));
     * System.out.println(g1.degree(1));
     * System.out.println(g1.degree(2));
     * System.out.println(g1.degree(3));
     * System.out.println("MAIOR GRAU: "+g1.highestDegree());
     * System.out.println("MENOR GRAU: "+g1.lowestDegree());
     * System.out.println(g1.complement());
     * System.out.println(g1.density());
     */
  }
}
