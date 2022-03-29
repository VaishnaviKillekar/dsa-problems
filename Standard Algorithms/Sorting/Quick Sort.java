/**
 * The last element of array is taken as pivot. quickSort() recurses until low < high.
 * The partition() determines the position - all elements before this position are smaller and all elements after it are greater
 * than the element at position.
 * Using this position as reference, we call quickSort() on the left and right sides of the position.
 *
 * partition() uses i and j which sort elements before the pivot, if current element at j is smaller than pivot.
 * In the end, the pivot is swapped with the element at i+1 and that is its correct position and it is sorted.
 *
 * Time complexity - O(n^2)
 * Space complexity - O(n)
 */
class Solution
{
    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;

        // i and j sort the array between low and high
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // put pivot in it's right place
        return i + 1; // pivot sorted into its correct position
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int q = partition(arr, low, high);
            quickSort(arr, low, q - 1);
            quickSort(arr, q + 1, high);
        }
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 80, 30, 100, 40, 50, 70, 10 };
        int n = arr.length;

        quickSort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
