public class SortedArray {
	static int[] unsortedArray = new int[10000000];
	static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            sort(arr, low, partitionIndex - 1);
            sort(arr, partitionIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
	public static void main(String[]args) {
		for(int i=0; i<unsortedArray.length; i++){
			unsortedArray[i] = (int)Math.round(Math.random()*2000000)-1000000;
		}
		System.out.println("Start");
		sort(unsortedArray, 0, unsortedArray.length - 1);
		System.out.println("Finish");
	}
}
