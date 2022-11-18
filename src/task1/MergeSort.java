package task1;

public class MergeSort {
    public int[] mergeSort(int[] array, int n) {
        if (n < 2) return array;

        int sizeNewArray = n / 2;
        int[] leftSizeArray = new int[sizeNewArray];
        int[] rightSizeArray = new int[n - sizeNewArray];

        System.arraycopy(array, 0, leftSizeArray, 0, sizeNewArray);
        System.arraycopy(array, sizeNewArray, rightSizeArray, 0, n - sizeNewArray);

        mergeSort(leftSizeArray, sizeNewArray);
        mergeSort(rightSizeArray, n - sizeNewArray);

        merge(array, leftSizeArray, rightSizeArray, sizeNewArray, n - sizeNewArray);
        return array;
    }
    public static void merge(int[] sortArray, int[] left, int[] right, int leftSize, int rightSize) {
        int k = 0, i = 0, j = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j])
            {
                sortArray[k++] = left[i++];
            }
            else
            {
                sortArray[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            sortArray[k++] = left[i++];
        }

        while (j < rightSize) {
            sortArray[k++] = right[j++];
        }
    }
}

