package Algorithm.Dijkstra;

import java.util.PriorityQueue;

class Element implements Comparable<Element> {
    int index;
    int distance;

    public Element(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Element o) {
        return this.distance - o.distance;
    }
}

public class DijkstraTest {
    static boolean[] visited;
    static int[] dist;
    static int[][] ad;
    static int E = 9, V = 6;
    static int inf = 100000;

    public static void DijkstaMethod(int start) {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Element(start, dist[start]));

        while(!pq.isEmpty()) {
            int cost = pq.peek().distance;
            int here = pq.peek().index;
            pq.poll();

            if (cost > dist[here]) {   // 현재 배열에 있는 값(최단 거리)보다 cost(거리)가 더 길면 continue
                continue;
            }

            System.out.print(here + " ");

            for (int i = 1; i <= V; ++i) {   // 업데이트 시켜주는 for문
                if (ad[here][i] != 0 && dist[i] > (dist[here] + ad[here][i])) {
                    dist[i] = dist[here] + ad[here][i];
                    pq.offer(new Element(i, dist[i]));
                }
            }

            System.out.println();

            for (int i = 1; i <= V; ++i) {   // dist 배열의 중간 결과 보여주기
                System.out.print(dist[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        ad = new int[V + 1][V + 1];

        for (int i = 1; i <= V; ++i) {
            dist[i] = inf;
        }

        ad[1][2] = 8;
        ad[1][3] = 1;
        ad[1][4] = 2;
        ad[3][4] = 2;
        ad[3][2] = 5;
        ad[4][5] = 3;
        ad[4][6] = 5;
        ad[5][6] = 1;
        ad[6][1] = 5;

        DijkstaMethod(1);

    }
}
