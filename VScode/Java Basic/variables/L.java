public class L {
    static int i;
    int j;
    public static void main(String[] args) {
        System.out.println(L.i);
        
        L obj1 = new L();
        L obj2 = new L();

        obj1.i = 1;
        obj2.i = 2;

        System.out.println(obj1.i);
        System.out.println(obj2.i);
    }
}
