import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphList {

    private int countNodes;
    private int countEdges;
    private ArrayList<ArrayList<Edge>> adjList;
    private ArrayList<Edge> edgeList;
    private static final int INF = 999999;

    ////////////////////////////////////////
    public GraphList(int countNodes) {
        this.countNodes = countNodes;
        adjList = new ArrayList<>(this.countNodes);
        for (int i = 0; i < this.countNodes; i++) {
            adjList.add(new ArrayList<Edge>());
        }
        edgeList = new ArrayList<>();
    }
////////////////////////////////////////

    public GraphList(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Read header
        String[] line = bufferedReader.readLine().split(" ");
        this.countNodes = (Integer.parseInt(line[0]));
        int fileLines = (Integer.parseInt(line[1]));

        // Create and fill adjList with read edges
        this.adjList = new ArrayList<>(this.countNodes);
        for (int i = 0; i < this.countNodes; ++i) {
            this.adjList.add(new ArrayList<Edge>());
        }
        edgeList = new ArrayList<>();
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

    public ArrayList<ArrayList<Edge>> getAdjList() {
        return adjList;
    }

    public void setAdjList(ArrayList<ArrayList<Edge>> adjList) {
        this.adjList = adjList;
    }
/////////////////////////////////////////

    public void addEdge(int source, int sink, int weight) {
        if (source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
            System.err.println("Invalid edge: " + source + " " + sink + " " + weight);
            return;
        }
        adjList.get(source).add(new Edge(source, sink, weight));
        edgeList.add(new Edge(source, sink, weight));
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
        for (int i = 0; i < this.adjList.size(); i++) {
            str += i + ": ";
            for (int j = 0; j < this.adjList.get(i).size(); j++) {
                str += this.adjList.get(i).get(j) + "\t";
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
        return this.adjList.get(node).size();
    }

    public int highestDegree() {
        int aux = 0;
        int high = 0;
        for (int i = 0; i < this.adjList.size(); i++) {
            aux = this.degree(i);
            if (aux > high) {
                high = aux;
            }
        }
        return high;
    }

    public int lowestDegree() {
        int aux = 0;
        int low = this.adjList.size();
        for (int i = 0; i < this.adjList.size(); i++) {
            aux = this.degree(i);
            if (aux < low) {
                low = aux;
            }
        }
        return low;
    }
/////////////////////////////////////////////

    public GraphList complement() {
        GraphList complent = new GraphList(this.adjList.size());
        for (int i = 0; i < adjList.size(); i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                boolean addEdgeUV = true;
                for (int idx = 0; idx < this.adjList.get(i).size(); ++idx) {
                    int y = this.adjList.get(i).get(idx).getSink();
                    if (y == j) { // Edge (u, v) exists and should not be added
                        addEdgeUV = false;
                        break;
                    }
                }
                if (addEdgeUV && i != j) {
                    complent.addEdge(i, j, 1);
                }
            }
        }
        return complent;
    }

    public boolean subGraph(GraphList g2) {
        if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges) {
            return false;
        }
        for (int i = 0; i < g2.adjList.size(); i++) {
            boolean foundEdge = false;

            for (int j = 0; j < g2.adjList.get(i).size(); j++) {
                int y = g2.adjList.get(i).get(j).getSink();

                for (int x = 0; x < this.adjList.get(i).size(); ++x) {
                    int v2 = this.adjList.get(i).get(x).getSink();
                    if (y == v2) { // Edge exists
                        foundEdge = true;
                        break;
                    }
                }

                if (!foundEdge)
                    return false;
            }
        }
        return true;
    }

    public float density() {
        return (float) this.countEdges / (this.countNodes * (this.countNodes - 1));
    }

    public ArrayList<Integer> bfs(int s) {
        int[] desc = new int[this.countNodes];
        ArrayList<Integer> Q = new ArrayList<>();
        Q.add(s);
        ArrayList<Integer> R = new ArrayList<>();
        R.add(s);
        desc[s] = 1;
        while (Q.size() > 0) {
            int u = Q.remove(0);
            for (int v = 0; v < this.adjList.size(); v++) {
                if (!this.adjList.get(u).equals(0)) {
                    if (desc[v] == 0) {
                        Q.add(v);
                        R.add(v);
                        desc[v] = 1;
                    }
                }
            }
        }
        return R;
    }

    public ArrayList<Integer> dfs(int s) {
        int[] desc = new int[this.countNodes];
        ArrayList<Integer> S = new ArrayList<>();
        S.add(s);
        ArrayList<Integer> R = new ArrayList<>();
        R.add(s);
        desc[s] = 1;
        while (S.size() > 0) {
            int u = S.get(S.size() - 1);
            boolean unstack = true; //desempilhar
            for (int v = 0; v < this.adjList.get(u).size(); v++) {
                if (!this.adjList.get(u).equals(0) && desc[v] == 0) {
                    S.add(v);
                    R.add(v);
                    desc[v] = 1;
                    unstack = false;
                    break;
                }
            }
            if (unstack) {
                S.remove(S.size() - 1);
            }
        }
        return R;
    }

    public boolean connected() {
        return this.bfs(0).size() == this.countNodes;
    }

    public boolean isOriented() {
        for (int u = 0; u < this.adjList.size(); ++u) {
            for (int idx = 0; idx < this.adjList.get(u).size(); ++idx) {
                int v = this.adjList.get(u).get(idx).getSink();
                boolean hasEdgeVU = false;
                for (int idx2 = 0; idx2 < this.adjList.get(v).size(); ++idx2) {
                    int u2 = this.adjList.get(v).get(idx2).getSink();
                    if (u == u2) {
                        hasEdgeVU = true;
                        break;
                    }
                }
                if (!hasEdgeVU) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Integer> dfsRec(int s) {
        int[] desc = new int[this.countNodes];
        ArrayList<Integer> R = new ArrayList<>();
        dfsRecAux(s, desc, R);
        return R;
    }

    public void dfsRecAux(int u, int[] desc, ArrayList<Integer> R) {
        desc[u] = 1;
        R.add(u);
        for (int idx = 0; idx < this.adjList.get(u).size(); ++idx) {
            int v = this.adjList.get(u).get(idx).getSink();
            if (desc[v] == 0) {
                dfsRecAux(v, desc, R);
            }
        }
    }

    public ArrayList<Edge> kruskal() {
        ArrayList<Edge> T = new ArrayList<Edge>(this.countNodes - 1);
        int[] F = new int[this.countNodes];

        for (int u = 0; u < this.countNodes; ++u)
            F[u] = u;
        edgeList.sort(null);
        for (int idx = 0; idx < edgeList.size(); ++idx) {
            int u = edgeList.get(idx).getSource();
            int v = edgeList.get(idx).getSink();
            if (F[u] != F[v]) {
                T.add(edgeList.get(idx));

                if (T.size() == countNodes - 1)
                    break;

                int k = F[v];
                for (int i = 0; i < F.length; ++i) {
                    if (F[i] == k) {
                        F[i] = F[u];
                    }
                }
            }
        }
        return T;
    }

    public ArrayList<Edge> prim() {
        ArrayList<Edge> T = new ArrayList<Edge>(this.countNodes - 1);
        int s = 0;
        int[] dist = new int[this.countNodes];
        int[] parent = new int[this.countNodes];

        ArrayList<Integer> Q = new ArrayList<Integer>(this.countNodes);
        for (int u = 0; u < this.countNodes; ++u) {
            dist[u] = INF;
            parent[u] = -1;
            Q.add(u);
        }
        dist[s] = 0;
        while (Q.size() != 0) {
            int u = -1;
            int min = INF;
            for (int idx = 0; idx < Q.size(); ++idx) {
                int i = Q.get(idx);
                if (dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }
            Q.remove((Integer) u);
            for (int idx = 0; idx < this.adjList.get(u).size(); ++idx) {
                int v = this.adjList.get(u).get(idx).getSink();
                int w = this.adjList.get(u).get(idx).getWeight();
                if (Q.contains(v) && w < dist[v]) {
                    dist[v] = w;
                    parent[v] = u;
                }
            }
        }

        for (int u = 0; u < parent.length; ++u) {
            if (parent[u] != -1) {
                T.add(new Edge(u, parent[u], 1));
            }
        }
        return T;
    }
/*
    public void dijkstra(int src) {
        this.adjList = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(new Node(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;

            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))

                // Continue keyword skips execution for
                // following check
                continue;

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            e_Neighbours(u);
        }

    }
*/
void bellmanFord( int src)
{
    int V = this.countNodes;
    int E = this.countEdges;
    int dist[] = new int[V];


    for (int i = 0; i < V; i++)
        dist[i] = Integer.MAX_VALUE;
    dist[src] = 0;


    for (int i = 1; i < V; ++i) {
        for (int j = 0; j < E; ++j) {
            int u = this.edgeList.get(j).getSource();
            int v = this.edgeList.get(j).getSink();
            int weight = this.edgeList.get(j).getWeight();
            if (dist[u] != INF && dist[u] + weight < dist[v])
                dist[v] = dist[u] + weight;
        }
    }

    for (int j = 0; j < E; ++j) {
        int u = this.edgeList.get(j).getSource();
        int v = this.edgeList.get(j).getSink();
        int weight = this.edgeList.get(j).getWeight();
        if (dist[u] != INF && dist[u] + weight < dist[v]) {
            System.out.println("O grafo tem ciclo de peso negativo");
            return;
        }
    }
    System.out.println("Distância do vértice da fonte");
    for (int i = 0; i < V; ++i)
        System.out.println(i + "\t\t" + dist[i]);
}

    void improvedBellmanFord( int src)
    {
        int V = this.countNodes;
        int E = this.countEdges;
        int dist[] = new int[this.countNodes];
        int pred[] = new int[this.countNodes];
        boolean trocou;


        for (int i = 0; i < this.countNodes; i++)
            dist[i] = INF;
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            trocou=false;
            for (int j = 0; j < E; ++j) {
                int u = this.edgeList.get(j).getSource();
                int v = this.edgeList.get(j).getSink();
                int weight = this.edgeList.get(j).getWeight();
                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    trocou=true;
                }
            }
            if(trocou=false){
                break;
            }
        }


        for (int j = 0; j < E; ++j) {
            int u = this.edgeList.get(j).getSource();
            int v = this.edgeList.get(j).getSink();
            int weight = this.edgeList.get(j).getWeight();
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                System.out.println("O grafo tem ciclo de peso negativo");
                return;
            }
        }
        System.out.println("Distância do vértice da fonte");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }





}






