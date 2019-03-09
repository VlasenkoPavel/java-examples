public class Emploee {
    public static int count;
    private String firstName;
    private String secondName;

    static          // static init block
    {
        count = 0;
    }

    {               // static init block
        firstName = "anonimus";
    }

    public Emploee() {}

    public Emploee(String name) {
        firstName = name;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }
}
