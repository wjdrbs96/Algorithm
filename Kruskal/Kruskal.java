package Algorithm.Kruskal;

import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {  // cost를 가지고 정렬을 하겠다고 기준을 만듬
        if (this.cost < o.cost) {
            return - 1;
        }
        else if (this.cost == o.cost) {
            return 0;
        }
        else {
            return 1;
        }
    }
}

public class Kruskal {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static int find(int x) {  // 부모 노드 찾는 메소드
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);  // find 메소드를 통해서 부모 노드 번호를 리턴 받음
        y = find(y);

        if (x == y) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        edgeList = new ArrayList<Edge>();

        edgeList.add(new Edge(1,7,12));
        edgeList.add(new Edge(1,4,28));
        edgeList.add(new Edge(1,2,67));
        edgeList.add(new Edge(1,5,17));
        edgeList.add(new Edge(2,4,24));
        edgeList.add(new Edge(2,5,62));
        edgeList.add(new Edge(3,5,20));
        edgeList.add(new Edge(3,6,37));
        edgeList.add(new Edge(4,7,13));
        edgeList.add(new Edge(5,6,45));
        edgeList.add(new Edge(5,7,73));

        parent = new int[8];

        for (int i = 1; i <=7; ++i) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0;
        for (int i = 0; i < edgeList.size(); ++i) {
            Edge edge = edgeList.get(i);
            if(!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }

        System.out.println(sum);
    }
}
