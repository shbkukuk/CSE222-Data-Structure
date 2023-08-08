/**
 * The quickSort class provides a sorting algorithm to sort elements in a myMap object based on their counts.
 * It uses the quicksort algorithm to sort the elements in ascending order of their counts, and creates a new sorted myMap.
 */
public class quickSort {
    protected myMap orginalmyMap;  // The original myMap object to be sorted
    protected myMap sortedmyMap;   // The sorted myMap object
    private String[] aux;          // An auxiliary array to store the keys for sorting

    /**
     * Constructs a quickSort object and performs the sorting operation on the provided myMap.
     *
     * @param newMyMap The myMap object to be sorted.
     */
    public quickSort(myMap newMyMap) {
        if (newMyMap.isEmpty() || newMyMap.mapSize() < 2) {
            return;
        }
        this.orginalmyMap = newMyMap;
        this.aux = orginalmyMap.getKeys();
        int n = aux.length;
        sortMap(0, n - 1);
        createSortedMap();
        
        System.out.println(orginalmyMap.toString());
        System.out.println(sortedmyMap.toString());
    }

    /**
     * Creates a new sorted myMap object based on the sorted array of keys.
     */
    private void createSortedMap() {
        this.sortedmyMap = new myMap();
        for (String key : aux) {
            info temp = orginalmyMap.getInfo(key);
            sortedmyMap.putInfo(key, temp);
        }
    }

    /**
     * Swaps the elements at the given indices in the auxiliary array.
     *
     * @param i The first index.
     * @param j The second index.
     */
    private void swap(int i, int j) {
        String temp = aux[i];
        aux[i] = aux[j];
        aux[j] = temp;
    }

    /**
     * Partitions the array based on the selected pivot element.
     *
     * @param low  The starting index of the partition.
     * @param high The ending index of the partition.
     * @return An array containing the indices indicating the partitioned segment.
     */
    private int[] partition(int low, int high) {
        int middlePivot = low + (high - low) / 2; // Selecting middle element as the pivot
        String pivotKey = aux[middlePivot];
        swap(middlePivot, high);
        int pivot = orginalmyMap.getCount(pivotKey);

        int i, j;
        i = low;
        j = low;

        while (j <= high) {
            int element = orginalmyMap.getCount(aux[j]);
            if (element < pivot) {
                swap(i, j);
                i++;
            } else if (element == pivot) {
                swap(j, i + 1);
                i++;
            }
            j++;
        }
        int[] partitionIndex = { i, j - 1 };
        return partitionIndex;
    }

    /**
     * Recursively sorts the array using the quicksort algorithm.
     *
     * @param low  The starting index of the segment to be sorted.
     * @param high The ending index of the segment to be sorted.
     */
    private void sortMap(int low, int high) {
        if (low < high) {
            int[] pi = partition(low, high);
            sortMap(low, pi[0] - 1);
            sortMap(pi[1] + 1, high);
        }
    }

    /**
     * Calculates the average time taken to sort the myMap object based on the current sorting algorithm.
     *
     * @return The average time taken to perform the sorting operation in seconds.
     */
    protected double calculateTime() {
        int t = 100; // It works n times.
        long startTime = System.nanoTime();
        for (int i = 0; i < t; i++) {
            this.aux = orginalmyMap.getKeys();
            int n = aux.length;
            sortMap(0, n - 1);
        }
        long stopTime = System.nanoTime();
        long totalTime = (stopTime - startTime);
        double second = (double) totalTime / 1000000000;

        return second / t;
    }
}
