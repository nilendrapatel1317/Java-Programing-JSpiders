public class B {
  int id;
  String name;

  B(int i , String n){
    id=i;
    name=n;
  }

  // COPY CONSTRUCTOR
  B(B b){
    id = b.id;
    name= b.name;
  }

  void dispaly(){
    System.out.println("id= "+ id + " name= " + name);
  }

  public static void main(String[] args) {
    B b1 = new B(101, "Nilendra");
    B b2 = new B(b1);

    b1.dispaly();
    b2.dispaly();
  }
}
