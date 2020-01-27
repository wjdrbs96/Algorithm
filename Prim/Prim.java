package Algorithm.Prim;

import java.util.*;

public class Prim {
    static int V, E, min = 0;
    static Graph graph;
    static boolean[] visited;
    static ArrayList<Edge> mst;

    public static void main(String[] args) {
        V = 7;
        E = 9;
        visited = new boolean[V + 1];
        mst = new ArrayList<>();
        graph = new Graph(V);

        graph.AddEdge(1, 6, 10);
        graph.AddEdge(1, 2, 29);
        graph.AddEdge(2, 3, 16);
        graph.AddEdge(2, 7, 15);
        graph.AddEdge(3, 4, 12);
        graph.AddEdge(4, 5, 22);
        graph.AddEdge(4, 7, 18);
        graph.AddEdge(5, 7, 25);
        graph.AddEdge(5, 6, 27);

        PrimMethod();

        for (Edge edge : mst) {
            System.out.println(edge.start + " - " + edge.end + " cost : " + edge.cost);
        }
        System.out.println(min);
    }

    public static void PrimMethod() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();  // 가중치가 낮은 순대로 간선은 정렬함
        Queue<Integer> q = new LinkedList<>();           // 정점 방문 스케줄 처리를 위한 큐
        q.add(1);                                        // 시작 정점은 1로 선택

        while(!q.isEmpty()) {
            int start = q.poll();
            visited[start] = true;

            for (Edge edge : graph.edge[start]) {        // 현재 정점 start와 연결된 간선중
                if (!visited[edge.end]) {                // 아직 정점 end를 방문하지 않았다면
                    pq.add(edge);                        // 우선순위 큐에 간선을 추가한다.
                }
            }

            while(!pq.isEmpty()) {
                Edge edge = pq.poll();                  // 가중치가 가장 적은 간선이 나올 것이며
                if (!visited[edge.end]) {               // 간선이 연결된 정점 end를 방문한 적이 없다면
                    q.add(edge.end);                    // 큐에 넣고 다음에 방문한다.
                    visited[edge.end] = true;           // 방문했떤 정점을 다시 방문하지 않도록 표시
                    mst.add(edge);                      // 최소 스패닝 트리를 구성하는 간선 추가
                    System.out.println(edge.cost);
                    min += edge.cost;                   // 가중치 최소 값을 하나씩 더함
                    break;                             // break 하는 이유는 1과 연결된 간선 중 최소 간선만 더하고
                }                                      // 나머지 간선은 더하지 않기 위해서 탈출 하는 것임
            }
        }

    }
}

class Graph {
    List<Edge>[] edge;

    public Graph(int V) {
        edge = new LinkedList[V + 1];
        for (int i = 1; i <= V; ++i) {
            edge[i] = new LinkedList<>();
        }
    }

    // 양방향 그래프
    public void AddEdge(int start, int end, int cost) {
        edge[start].add(new Edge(start, end, cost));
        edge[end].add(new Edge(end, start, cost));
    }
}

class Edge implements Comparable<Edge> {
    int start, end, cost;

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
