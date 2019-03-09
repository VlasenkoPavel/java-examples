public class Base {
    public static void main(String[] args) {
        multiValCicle();
    }

    private void endlessСycle() {
        while (true) { break; }  // v1
        for (;;) { break; } //v2
    }

    private static void multiValCicle() {
        for (int i = 0, j = 0; i+j < 10; i++, j++) {
            print("i=" + i);
            print("j=" + j);
        }
    }

    private static void print(Object obj) {
        System.out.println(obj);
    }
}
