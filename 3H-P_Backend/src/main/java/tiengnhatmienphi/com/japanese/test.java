package tiengnhatmienphi.com.japanese;

public class test {
    public static void main(String[] args) {
        String a = "a-b-c-";
        String[] b = a.split("-");
        System.out.println(b.length);
        for (String c:b) {
            System.out.println(c);
        }
    }
}
