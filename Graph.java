import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph {
    private int countNodes;
    private int countEdges;
    private ArrayList<ArrayList<Edge>> adjlist;

    ////////////////////////////////////////
    public Graph(int countNodes) {
        this.countNodes = countNodes;
        adjlist = new ArrayList<>(this.countNodes);
        for (int i = 0; i < this.countNodes; i++) {
            adjlist.add(new ArrayList<Edge>());
        }
    }
////////////////////////////////////////

    public Graph(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Read header
        String[] line = bufferedReader.readLine().split(" ");
        this.countNodes = (Integer.parseInt(line[0]));
        int fileLines = (Integer.parseInt(line[1]));

        // Create and fill adjList with read edges
        this.adjlist = new ArrayList<>(this.countNodes);
        for (int i = 0; i < this.countNodes; ++i) {
            this.adjlist.add(new ArrayList<Edge>());
        }
        //Adds one edge at a time
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
////////////////////////////////////////

    public int getCountNodes() {
        return countNodes;
    }

    public void setCountNodes(int countNodes) {
        this.countNodes = countNodes;
    }

    public int getCountEdges() {
        return countEdges;
    }

    public void setCountEdges(int countEdges) {
        this.countEdges = countEdges;
    }

    public ArrayList<ArrayList<Edge>> getAdjlist() {
        return adjlist;
    }

    public void setAdjlist(ArrayList<ArrayList<Edge>> adjlist) {
        this.adjlist = adjlist;
    }
/////////////////////////////////////////

    public void addEdge(int source, int sink, int weight) {
        if (source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
            System.err.println("Invalid edge: " + source + " " + sink + " " + weight);
            return;
        }
        adjlist.get(source).add(new Edge(source, sink, weight));
        this.countEdges++;
    }


    public void addEdgeUnoriented(int source, int sink, int weight) {
        addEdge(source, sink, weight);
        addEdge(sink, source, weight);
    }
////////////////////////////////////////

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.adjlist.size(); i++) {
            str += i + ": ";
            for (int j = 0; j < this.adjlist.get(i).size(); j++) {
                str += this.adjlist.get(i).get(j) + "\t";
            }
            str += "\n";
        }
        return str;
    }
////////////////////////////////////////

    public int degree(int node) {
        //returns the degree of a node
        if (node < 0 || node > this.countNodes - 1) {
            System.err.println("Invalid node: " + node);
        }
        return this.adjlist.get(node).size();
    }
    public int highestDegree() {
        int aux = 0;
        int high = 0;
        for (int i = 0; i < this.adjlist.size(); i++) {
            aux = this.degree(i);
            if (aux > high) {
                high = aux;
            }
        }
        return high;
    }

    public int lowestDegree() {
        int aux = 0;
        int low = this.adjlist.size();
        for (int i = 0; i < this.adjlist.size(); i++) {
            aux = this.degree(i);
            if (aux < low) {
                low = aux;
            }
        }
        return low;
    }
/////////////////////////////////////////////

    public GraphMatrix complement() {
        GraphMatrix complent = new GraphMatrix(this.adjlist.size());
        for (int i = 0; i < adjlist.size(); i++) {
            for (int j = 0; j < adjlist.get(i).size(); j++) {
                if (adjlist.get(i).get(j).equals(0)  && i != j) {
                    complent.addEdge(i, j, 1);
                }
            }
        }
        return complent;
    }

    public boolean subGraph(Graph g2) {
        if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges) {
            return false;
        }
        for (int i = 0; i < g2.adjlist.size(); i++) {
            for (int j = 0; j < g2.adjlist.get(i).size(); j++) {
                if (g2.adjlist.get(i).get(j).equals(0) && this.adjlist.get(i).get(j).equals(0) ) {/*g2.adjlist.get(i).get(j).equals(!0)*/
                    return false;
                }

            }
        }
        return true;
    }


}
