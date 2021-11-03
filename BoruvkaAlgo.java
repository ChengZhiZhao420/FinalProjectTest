public class BoruvkaAlgo {
    private int[][] edges;
    private int[] parent;
    private  int[] rank;

    public BoruvkaAlgo(int[][] edges){
        int size = edges.length;
        this.edges = edges;
        this.parent = new int[size];
        this.rank = new int[size];

        for(int i = 0; i < size; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public void MST(){
        int size = edges.length;
        int numTree = size;
        int minWeight = 0;
        int[] des = new int[size];
        int[] sour = new int[size];
        double inf = Double.POSITIVE_INFINITY;

        while(numTree > 1){
            for(int i = 0; i < size; i++){
                des[i] = -1;
                sour[i] = -1;
            }

            for(int j = 0; j < edges.length; j++){
                for (int k = 0; k < edges.length; k++){
                    if(edges[j][k] == (int) inf){
                        continue;
                    }
                    else {
                        int set1 = find(parent, j);
                        int set2 = find(parent, k);

                        if(set1 == set2){
                            continue;
                        }
                        else{
                            if((des[set1] == -1 && sour[set1] == -1) || edges[des[set1]][sour[set1]] > edges[j][k]){
                                des[set1] = j;
                                sour[set1] = k;
                            }

                            if ((des[set2] == -1 && sour[set2] == -1) || edges[des[set2]][sour[set2]] > edges[j][k]){
                                des[set2] = k;
                                sour[set2] = j;
                            }
                        }
                    }
                }
            }

            for(int k = 0; k < size; k++){
                if(des[k] != -1 && sour[k] != -1){
                    int set1 = find(parent, des[k]);
                    int set2 = find(parent, sour[k]);

                    if(set1 == set2){
                        continue;
                    }

                    minWeight += edges[des[k]][sour[k]];
                    union(parent, set1, set2);
                    numTree--;
                }
            }
        }

        System.out.println(minWeight);
    }

    private void union(int[] parent, int set1, int set2) {
        int root1 = find(parent, set1);
        int root2 = find(parent, set2);

        if(rank[root1] > rank[root2]){
            parent[root2] = root1;
        }
        else if(rank[root2] > rank[root1]){
            parent[root1] = root2;
        }
        else{
            parent[root1] = root2;
            rank[root2] += 1;
        }
    }

    private int find(int[] parent, int vertex) {
        if(parent[vertex] == vertex){
            return vertex;
        }
        else {
            return find(parent, parent[vertex]);
        }
    }

}
