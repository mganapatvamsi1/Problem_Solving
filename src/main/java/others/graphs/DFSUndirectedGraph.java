package others.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class DFSUndirectedGraph {
    private int V;
    private int E;
    LinkedList<Integer>[] adjacent;

    public DFSUndirectedGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjacent = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjacent[i] = new LinkedList<>();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices, " + E + " edges " + "\n");
        for(int v = 0; v < V; v++) {
            sb.append(v + ": ");
            for(int w : adjacent[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addEdge(int u, int v) {
        this.adjacent[u].add(v);
        this.adjacent[v].add(u);
        E++;
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");
                for (int i : adjacent[u]) {
                    if (!visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        DFSUndirectedGraph dfs = new DFSUndirectedGraph(5);
        dfs.addEdge(0, 1);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 0);
        dfs.addEdge(2, 4);
        dfs.dfs(0);
    }
}
