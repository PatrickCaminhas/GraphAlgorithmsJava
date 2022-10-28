public class Edge implements Comparable<Edge>  {
    private int source;
    private int sink;
    private int weight;
    private int path;
    private int wall;

    public Edge(int source, int sink, int weight){
        this.source=source;
        this.sink=sink;
        this.weight=weight;
    }
    public Edge( int path, int wall){
        this.path=path;
        this.wall=wall;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getSink() {
        return sink;
    }

    public void setSink(int sink) {
        this.sink = sink;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + source + ", " + sink + ", " + weight + ")";
    }
    @Override
    public int compareTo(Edge e) {
        if (this.weight > e.weight)
            return 1;
        return -1;
    }
}