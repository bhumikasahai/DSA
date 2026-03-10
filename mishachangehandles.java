import java.util.*;

public class mishachangehandles {
    static int[] parent;
    static Map<String, Integer> idMap = new HashMap<>();
    static List<String> idToHandle = new ArrayList<>();

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    if (!sc.hasNextInt()) return;
    int q = sc.nextInt();
    
    parent = new int[2 * q];
    for (int i = 0; i < 2 * q; i++) parent[i] = i;

    // We use these to track who started the chain
    Set<String> allHandles = new LinkedHashSet<>(); // Keeps track of unique handles in order
    Set<String> changedFromNew = new HashSet<>();   // Tracks handles that were 'new' at some point

    for (int i = 0; i < q; i++) {
        String oldH = sc.next();
        String newH = sc.next();

        int u = getID(oldH);
        int v = getID(newH);

        union(u, v);

        allHandles.add(oldH);
        allHandles.add(newH);
        changedFromNew.add(newH); 
    }
    List<String> results = new ArrayList<>();
    int count = 0;
    for (String h : allHandles) {
        if (!changedFromNew.contains(h)) {
            int finalID = find(getID(h));
            String finalHandle = idToHandle.get(finalID);
            results.add(h + " " + finalHandle);
            count++;
        }
    }
    System.out.println(count);
    for (String res : results) {
        System.out.println(res);
    }
}
    static int getID(String s) {
        if (!idMap.containsKey(s)) {
            idMap.put(s, idToHandle.size());
            idToHandle.add(s);
        }
        return idMap.get(s);
    }
    static int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            parent[rootU] = rootV; 
        }
    }
}