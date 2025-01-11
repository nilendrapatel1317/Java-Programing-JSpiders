public class LastMomentAnts {

  public static int getLastMoment(int n, int[] left, int[] right) {
      int maxTime = 0;

      // Calculate the maximum time for ants falling to the left
      for (int position : left) {
          maxTime = Math.max(maxTime, position);
      }

      // Calculate the maximum time for ants falling to the right
      for (int position : right) {
          maxTime = Math.max(maxTime, n - position);
      }

      return maxTime;
  }

  public static void main(String[] args) {

      // Example input
      int n = 4;
      int[] left = {4, 3}; // Positions of ants moving left
      int[] right = {0,1};  // Positions of ants moving right

      // Find the last moment
      int lastMoment = getLastMoment(n, left, right);
      System.out.println("The last moment before all ants fall off is: " + lastMoment + " seconds");
  }
}
