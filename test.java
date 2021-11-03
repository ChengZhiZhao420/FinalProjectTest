public class test {
    public static void main(String[] args){
        AdjacencyMatrix<Integer> graph = new AdjacencyMatrix<>(7);
        graph.setLabels(0, 0);
        graph.setLabels(1, 1);
        graph.setLabels(2, 2);
        graph.setLabels(3, 3);
        graph.setLabels(4, 3);
        graph.setLabels(5, 3);
        graph.setLabels(6, 3);

        graph.setEdge(0, 1, 20);
        graph.setEdge(0, 6, 1);
        graph.setEdge(0, 5, 23);
        graph.setEdge(1, 2, 15);
        graph.setEdge(1, 6, 4);
        graph.setEdge(2, 6, 9);
        graph.setEdge(2, 3, 3);
        graph.setEdge(3, 6, 16);
        graph.setEdge(3, 4, 17);
        graph.setEdge(4, 6, 25);
        graph.setEdge(4, 5, 28);
        graph.setEdge(5, 6, 36);
        int[][] edges = graph.getEdges();
        BoruvkaAlgo ba = new BoruvkaAlgo(edges);
        ba.MST();
    }
}
