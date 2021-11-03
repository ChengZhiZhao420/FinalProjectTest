public class AdjacencyMatrix<T> {
    private T[] labels;
    private int size;
    private int[][] edges;

    public AdjacencyMatrix(int size){
        this.size = size;
        this.edges = new int[size][size];
        this.labels = (T[]) new Object[size];
        double inf = Double.POSITIVE_INFINITY;

        for(int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                edges[i][j] = (int) inf;
            }
        }
    }

    public void setLabels(int vertex, T label){
        if(vertex >= 0 || vertex < size){
            labels[vertex] = label;
        }
        else{
            System.out.println("Invalid input");
        }
    }

    public T getLabels(int vertex){return labels[vertex];}

    public void setEdge(int source, int des, int weight){
        if((source >= size || source < 0) || (des >= size || des < 0)){
            System.out.println("Invalid input");
        }
        else{
            edges[source][des] = weight;
            edges[des][source] = weight;
        }
    }

    public int[][] getEdges(){
        return edges;
    }
}
