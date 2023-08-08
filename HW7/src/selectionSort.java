/**
 * The selectionSort class provides a sorting algorithm to sort elements in a myMap object based on their counts.
 * It uses the selection sort algorithm to sort the elements in ascending order of their counts, and creates a new sorted myMap.
 */
class selectionSort {
    protected myMap orginalmyMap;  // The original myMap object to be sorted
    protected myMap sortedmyMap;   // The sorted myMap object
    private String[] aux;          // An auxiliary array to store the keys for sorting

    /**
     * Constructs a selectionSort object and performs the sorting operation on the provided myMap.
     *
     * @param newmMyMap The myMap object to be sorted.
     */
    public selectionSort(myMap newmMyMap) {
        if (newmMyMap.isEmpty() || newmMyMap.mapSize() < 2) {
            /* We don't need to sort the map because there are not enough elements. */
            return;
        }

        this.orginalmyMap = newmMyMap;
        this.aux = newmMyMap.getKeys();
        sortMap();
        createSortedMap();

        System.out.println(orginalmyMap.toString());
        System.out.println(sortedmyMap.toString());
    }

    /**
     * Sorts the keys in the auxiliary array based on their counts in the original myMap.
     * Uses the selection sort algorithm to perform the sorting.
     */
    private void sortMap() {
        int n = aux.length;
        int i, j;

        for (i = 0; i < n - 1; i++) {
            int min_index = i;
            for (j = i + 1; j < n; j++) {
                int counti = orginalmyMap.getCount(aux[min_index]);
                int countj = orginalmyMap.getCount(aux[j]);
                if (counti > countj) {
                    min_index = j;
                } else if (counti == countj) {
                    if (j < min_index) {
                        min_index = j;
                    }
                }
            }
            String temp = aux[min_index];
            aux[min_index] = aux[i];
            aux[i] = temp;
        }
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
