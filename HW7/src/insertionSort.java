/**
 * The insertionSort class provides a method to perform insertion sort on a myMap object.
 * It sorts the keys in ascending order based on their corresponding count values.
 */
public class insertionSort {

    protected myMap orginalmyMap;
    protected myMap sortedmyMap;
    private String[] aux; 

     /**
     * Constructs an insertionSort object with the specified myMap.
     * If the provided map is empty or contains less than two elements, no sorting is performed.
     * 
     * @param newMyMap the myMap object to be sorted
     */
    public insertionSort(myMap newMyMap)
    {
        if(newMyMap.isEmpty() || newMyMap.mapSize()<2)
        {
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
     * Creates a sorted map based on the sorted array of keys.
     * The sorted map is stored in the sortedmyMap field.
     */
    private void createSortedMap()
    {
        this.sortedmyMap = new myMap();
        for(String key:aux)
        {
            info temp = orginalmyMap.getInfo(key);
            sortedmyMap.putInfo(key, temp);
        }
    }
    /**
     * Sorts the array of keys using the insertion sort algorithm.
     * The sorted array is stored in the aux field.
     */
    private void sortMap()
    {
        int n = aux.length;
        int i,j;

        for(i=1;i<n;i++)
        {
            int counti = orginalmyMap.getCount(aux[i]);
            String key = aux[i];
            j=i-1;
            int countj =orginalmyMap.getCount(aux[j]);
            while(j>=0 && countj>counti)
            {
                aux[j+1] = aux[j];
                j = j-1;
                
                if(j != -1)
                {
                    countj = orginalmyMap.getCount(aux[j]);
                }
                
            }
            aux[j+1] = key;
        }
        
    }

    /**
     * Calculates the average time taken to perform sorting.
     * The method measures the execution time of sorting the map t times and returns the average time in seconds.
     * 
     * @return the average time taken to perform sorting in seconds
     */
    protected double calculateTime()
    {
        int t = 100; //it works n times.
        long startTime = System.nanoTime();
        for(int i=0; i<t;i++)
        {
            this.aux = orginalmyMap.getKeys();
            sortMap();
        }
        long stopTime = System.nanoTime();
        long totalTime = (stopTime -startTime);
        double second = (double) totalTime/1000000000;

        return second/t;
    }
    
}
