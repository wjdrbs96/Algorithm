package Algorithm.Greedy;

public class Greedy {
    public static void main(String[] args) {
        int n = 1260;
        int count = 0;

        count += n / 500;  // 500원이 몇개 가능 한지 여부
        n %= 500;          // 500원 나눠진 개수 만큼 빼고 n에 저장
        count += n/ 100;
        n %= 100;
        count += n / 50;
        n %= 50;
        System.out.println(count);
    }
}
