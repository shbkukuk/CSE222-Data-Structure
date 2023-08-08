/**
 * A class that represents a merge sort algorithm applied to a custom map implementation.
 */
public class mergeSort {

    protected myMap orginalmyMap;
    protected myMap sortedmyMap;
    private String[] aux; 

     /**
     * Constructs a mergeSort object with the given map, sorts it, and creates a sorted map.
     *
     * @param newMyMap the map to be sorted.
     */
    public mergeSort(myMap newMyMap)
    {
        if(newMyMap.isEmpty() || newMyMap.mapSize()<2)
        {
            return;
        }
        this.orginalmyMap = newMyMap;
        this.aux = orginalmyMap.getKeys();

        int n = aux.length;
        String[] temp = new String[n];
        mergerHelp(aux, 0, n-1, temp);
        createSortedMap();

        System.out.println(orginalmyMap.toString());
        System.out.println(sortedmyMap.toString());
    }

    /**
     * Creates a sorted map based on the sorted array of keys.
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
     * Helper method for the merge sort algorithm.
     *
     * @param aux   the array of keys to be sorted.
     * @param left  the left index of the subarray.
     * @param right the right index of the subarray.
     * @param temp  a temporary array for merging.
     */
    private void mergerHelp(String[] aux,int left, int right, String[] temp)
    {
        if (left >= right) {
            return; // base case, single element in the array
        }

        int mid = left + (right - left) / 2; // calculate the midpoint
        mergerHelp(aux, left, mid, temp); // sort the left half
        mergerHelp(aux, mid+1, right, temp); // sort the right half
        merge(aux, left, mid, right, temp);
    }

    /**
     * Merges two sorted subarrays.
     *
     * @param aux   the array of keys to be sorted.
     * @param left  the left index of the subarray.
     * @param mid   the middle index of the subarray.
     * @param right the right index of the subarray.
     * @param temp  a temporary array for merging.
     */
    private void merge(String[] aux,int left, int mid, int right, String[] temp)
    {
        for (int i = left; i <= right; i++) {
            temp[i] = aux[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            int tempCount1 = orginalmyMap.getCount(temp[i]);
            int tempCount2 = orginalmyMap.getCount(temp[j]);

            if(tempCount1<tempCount2)
            {
                aux[k++]=temp[i++];

            }
            else if(tempCount1==tempCount2)
            {
                if(i<j)
                {
                    aux[k++]=temp[i++];;
  
                }
                else
                {
                    aux[k++]=temp[j++];;

                }
            }
            else
            {
                aux[k++]=temp[j++];;
            }
        }
        while(i<=mid)
        {
            aux[k++]=temp[i++];;
        }

        while(j<=mid)
        {
            aux[k++]=temp[j++];;
        }

    }
      
}
