
public class Ant {
  public static int getLastMoment(int plankLength, int[] positions, char[] directions) {
    int maxTime = 0;

    for (int i = 0; i < positions.length; i++) {
      int position = positions[i];
      char direction = directions[i];

      // Calculate time to fall off
      if (direction == 'L') {
        maxTime = Math.max(maxTime, position);
      } else if (direction == 'R') {
        maxTime = Math.max(maxTime, plankLength - position);
      }
    }

    return maxTime;
  }

  public static void main(String[] args) {
    // Example input
    int plankLength = 4;
    int[] positions = { 0, 1, 2, 3 , 4 };
    char[] directions = { 'R', 'R', 'R', 'R' , 'R' };

    // Find the last moment
    int lastMoment = getLastMoment(plankLength, positions, directions);
    System.out.println("The last moment before all ants fall off is: " + lastMoment + " seconds");
  }
}
