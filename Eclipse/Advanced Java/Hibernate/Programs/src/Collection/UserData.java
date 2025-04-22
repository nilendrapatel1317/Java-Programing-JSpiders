package Collection;
import java.util.*;

class User {
    int id;
    String name;
    int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class UserData {
    public static void main(String[] args) {
        // Array of 10 User objects
        User[] users = {
            new User(101, "Aman", 25),
            new User(102, "Ravi", 22),
            new User(103, "Aman", 30),
            new User(104, "Suman", 25),
            new User(105, "Pooja", 22),
            new User(106, "Ravi", 24),
            new User(107, "Neha", 25),
            new User(108, "Amit", 30),
            new User(109, "Ravi", 22),
            new User(110, "Pooja", 24)
        };

        // Case 1: Store all user names in a List
        List<String> userNames = new ArrayList<>();
        for (User u : users) {
            userNames.add(u.name);
        }
        System.out.println("List of User Names: " + userNames);

        // Case 2: Store unique names in a Set (or Unique IDs)
        Set<String> uniqueNames = new HashSet<>();
        for (User u : users) {
            uniqueNames.add(u.name);
        }
        System.out.println("Unique Names (Set): " + uniqueNames);

        // Case 3: Count frequency of users based on age using a Map
        Map<Integer, Integer> ageFrequency = new HashMap<>();
        for (User u : users) {
            ageFrequency.put(u.age, ageFrequency.getOrDefault(u.age, 0) + 1);
        }
        System.out.println("Age Frequency (Map): " + ageFrequency);

        Map<Integer, String> ageName = new HashMap<>();
        for (User u : users) {
        	ageName.put(u.age, ageName.getOrDefault(u.age, "") + " "+ u.name + "," );
        }
        System.out.println("Age Frequency (Map): " );
        for (Map.Entry<Integer, String> entry : ageName.entrySet()) {
			System.out.println("At age "+entry.getKey() + " -> " + entry.getValue());
		}
    }
}
