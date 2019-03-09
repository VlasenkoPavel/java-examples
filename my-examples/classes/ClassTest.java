public class ClassTest {
    public static void main(String args[]) {    // (String... args) (String ...args) (String[] args) (String args[])
        Emploee e = new Emploee();
        Emploee e2 = new Emploee("Bill");

        print(e.getFullName());    // -> anonimus null
        print(e2.getFullName());    // -> Bill null
    }

    private static void print(String arg) {
        System.out.println(arg);
    }
}
