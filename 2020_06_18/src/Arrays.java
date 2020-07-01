public class Arrays {
    public static void main(String[] args) {
        boolean[][] bools = new boolean[4][];

        for (boolean[] x : bools) {
            x = new boolean[4];
            for (boolean y : x) {
                y = true;
            }
        }
    }
}
