import java.util.*;

class State {
    int R, C, o;
    State(int R, int C, int o) {
        this.R = R;
        this.C = C;
        this.o = o;
    }
}

public class Main_tcs {
    static int M, N, K;
    static char[][] g;
    static int[][][] dist;

    static boolean in(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }

    static boolean cell_ok(int r, int c) {
        return in(r, c) && g[r][c] != 'B';
    }

    static boolean occ_ok(int R, int C, int o) {
        if (o == 0) { // horizontal
            int r = R / 2;
            for (int t = -(K - 1); t <= K - 1; t += 2) {
                int c = (C + t) / 2;
                if (!cell_ok(r, c)) return false;
            }
        } else { // vertical
            int c = C / 2;
            for (int t = -(K - 1); t <= K - 1; t += 2) {
                int r = (R + t) / 2;
                if (!cell_ok(r, c)) return false;
            }
        }
        return true;
    }

    static boolean rot_ok(int R, int C) {
        for (int rr = R - (K - 1); rr <= R + (K - 1); rr += 2) {
            for (int cc = C - (K - 1); cc <= C + (K - 1); cc += 2) {
                int r = rr / 2, c = cc / 2;
                if (!cell_ok(r, c)) return false;
            }
        }
        return true;
    }

    static void get_center(List<int[]> v, int[] res) {
        v.sort(Comparator.comparingInt(a -> a[0]));
        if (v.get(0)[0] == v.get(v.size() - 1)[0]) { // same row => horizontal
            res[2] = 0;
            int r = v.get(0)[0];
            int c0 = v.stream().min(Comparator.comparingInt(a -> a[1])).get()[1];
            int c1 = v.stream().max(Comparator.comparingInt(a -> a[1])).get()[1];
            res[0] = 2 * r;
            res[1] = c0 + c1;
        } else { // vertical
            res[2] = 1;
            int c = v.get(0)[1];
            int r0 = v.stream().min(Comparator.comparingInt(a -> a[0])).get()[0];
            int r1 = v.stream().max(Comparator.comparingInt(a -> a[0])).get()[0];
            res[1] = 2 * c;
            res[0] = r0 + r1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        M = sc.nextInt();
        N = sc.nextInt();
        g = new char[M][N];
        for (int i = 0; i < M; i++) {
            String s = "";
            while (s.length() < N && sc.hasNext()) {
                String line = sc.next();
                for (char ch : line.toCharArray()) {
                    if (ch != ' ') s += ch;
                    if (s.length() == N) break;
                }
            }
            g[i] = s.toCharArray();
        }

        List<int[]> I = new ArrayList<>(), L = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (g[i][j] == 'I') I.add(new int[]{i, j});
                if (g[i][j] == 'L') L.add(new int[]{i, j});
            }
        }

        K = I.size();
        int[] sCenter = new int[3];
        int[] tCenter = new int[3];
        get_center(I, sCenter);
        get_center(L, tCenter);

        Queue<State> q = new LinkedList<>();
        Map<String, Integer> dist = new HashMap<>();

        if (!occ_ok(sCenter[0], sCenter[1], sCenter[2])) {
            System.out.print("Impossible");
            return;
        }

        q.add(new State(sCenter[0], sCenter[1], sCenter[2]));
        dist.put(sCenter[0] + "," + sCenter[1] + "," + sCenter[2], 0);

        int ans = -1;
        int[] dr = {-2, 2, 0, 0};
        int[] dc = {0, 0, -2, 2};

        while (!q.isEmpty()) {
            State cur = q.poll();
            int d = dist.get(cur.R + "," + cur.C + "," + cur.o);

            if (cur.R == tCenter[0] && cur.C == tCenter[1] && cur.o == tCenter[2]) {
                ans = d;
                break;
            }

            for (int k = 0; k < 4; k++) {
                int nR = cur.R + dr[k], nC = cur.C + dc[k];
                if (occ_ok(nR, nC, cur.o)) {
                    String key = nR + "," + nC + "," + cur.o;
                    if (!dist.containsKey(key)) {
                        dist.put(key, d + 1);
                        q.add(new State(nR, nC, cur.o));
                    }
                }
            }

            int no = cur.o ^ 1;
            if (rot_ok(cur.R, cur.C)) {
                if (occ_ok(cur.R, cur.C, no)) {
                    String key = cur.R + "," + cur.C + "," + no;
                    if (!dist.containsKey(key)) {
                        dist.put(key, d + 1);
                        q.add(new State(cur.R, cur.C, no));
                    }
                }
            }
        }

        if (ans == -1) System.out.print("Impossible");
        else System.out.print(ans);
    }
}

