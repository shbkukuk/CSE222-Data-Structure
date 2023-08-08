/**
 * The bubbleSort class provides a sorting algorithm to sort elements in a myMap object based on their counts.
 * It uses the bubble sort algorithm to sort the elements in ascending order of their counts, and creates a new sorted myMap.
 */
public class bubbleSort {
    protected myMap orginalmyMap;  // The original myMap object to be sorted
    protected myMap sortedmyMap;   // The sorted myMap object
    private String[] aux;          // An auxiliary array to store the keys for sorting

    /**
     * Constructs a bubbleSort object and performs the sorting operation on the provided myMap.
     *
     * @param newMyMap The myMap object to be sorted.
     */
    public bubbleSort(myMap newMyMap) {
        if (newMyMap.isEmpty() || newMyMap.mapSize() < 2) {
            return;
        }

        this.orginalmyMap = newMyMap;
        this.aux = orginalmyMap.getKeys();
        sortMap();
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
     * Sorts the keys in the auxiliary array based on their counts in the original myMap.
     * Uses the bubble sort algorithm to perform the sorting.
     */
    private void sortMap() {
        int n = aux.length;
        int i, j;
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                int countj = orginalmyMap.getCount(aux[j]);
                int countj_1 = orginalmyMap.getCount(aux[j + 1]);
                if (countj > countj_1) {
                    String temp = aux[j];
                    aux[j] = aux[j + 1];
                    aux[j + 1] = temp;
                }
            }
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
            sortMap();
        }
        long stopTime = System.nanoTime();
        long totalTime = (stopTime - startTime);
        double second = (double) totalTime / 1000000000;

        return second / t;
    }
}
