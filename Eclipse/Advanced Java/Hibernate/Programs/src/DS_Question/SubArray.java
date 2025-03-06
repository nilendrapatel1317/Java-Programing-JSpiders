package DS_Question;

public class SubArray {
	public static void main(String[] args) {
//		int[] arr = {1,2,1,3,5,2,4,2};
//		int[] arr = {3,1,5,4,3,6,3};
		int[] arr = {3,1,5,4,3,6,3};
		
		System.out.println(sum(arr,arr.length));
	}

	public static int sum(int[] arr, int n) {
        int count = 0;
        
        for (int i = 0; i <= n - 3; i++) {
            if (arr[i] + arr[i + 2] == arr[i + 1]) {
                count++;
            }
        }
        
        return count;
    }
}
