import java.lang.reflect.Field;

public class Student {
  int id;
  String name;
  String dob;
  int age;
  

  Student(int id, String name, String dob, int age) {
    this.id = id;
    this.name = name;
    this.dob = dob;
    this.age = age;
   
  }

  // Override the toString() method to dynamically generate JSON-like output using Reflection
  @Override
  public String toString() {
    StringBuilder jsonString = new StringBuilder();
    jsonString.append("{ ");
    Field[] fields = this.getClass().getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      try {
        fields[i].setAccessible(true); // Make private fields accessible if necessary
        jsonString.append("\"").append(fields[i].getName()).append("\": ");
        jsonString.append("\"").append(fields[i].get(this)).append("\"");
        if (i < fields.length - 1) {
          jsonString.append(", ");
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    jsonString.append(" }");
    return jsonString.toString();
  }
  

  public static void main(String[] args) {
    Student s1 = new Student(101, "Nilendra", "1999-05-14", 22);
    Student s2 = new Student(102, "Nilofar", "1995-10-01", 28);

    // Now it will automatically display all fields in JSON format
    System.out.println(s1);
    System.out.println(s2);
  }
}
