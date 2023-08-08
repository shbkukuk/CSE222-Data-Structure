public class App {
    public static void main(String[] args) throws Exception {
        String worst_avg = "with greenery,she looked around in astonishment. Emerald shinintion wiath nature and decided to spend more time in its embrace. She started noticing the small details in life and savored every moment. She was grateful for the beauties of life and felt an indescribable happiness.Filled with excitement, she stepped into the forest.Taking a deep breath, she walked ahead and arrived at the edge of a flowing river. She found a peaceful corner for herself and began to relax. Beautiful memories from her childhood started to emerge in her mind, bringing a smile to her face. The days she roamed on her father's back, playing ball with her childhood friends.She sat there for a long time, savoring the tranquility offered by nature. Memories of her childhood, she recalled countless beautiful moments, filling her face with a smile. Suddenly, she noticed that the sun was beginning to set, as darkness started to descend around her. Reluctantly, she got up and started on her way back. The happiness inside her lightened her steps. Along the winding path, as she looked around, she suddenly saw something.Filled with excitement, she stepped into the forest.Taking a deep breath, she walked ahead and arrived at the edge of a flowing river. She found a peaceful corner for herself and began to relax. Beautiful memories from her childhood started to emerge in her mind, bringing a smile to her face. The days she roamed on her father's back, playing ball with her childhood friendsconfidently and continued on her way. After a while, she saw";
        myMap mapis = new myMap(worst_avg);

        String best = "Hi where where are are  are but but but but";
        myMap mapbest = new myMap(best);

        /*For the mergeSort Algorithm all-case have same time complexity. */
        
        mergeSort mergeSorted = new mergeSort(mapis);
        double totalTime = mergeSorted.calculateTime();
        System.out.println("Merge sorted all cases: " + totalTime);

        /*For the Selection Sort Algorithm all-case have same time complexity. */
        selectionSort selectionSorted = new selectionSort(mapis);
        totalTime = selectionSorted.calculateTime();
        System.out.println("Selection Sort all cases: " + totalTime);

        /*For the Insertion Sort Algorithm worst and avarage have same time complexity but best case is not same so 
         * i create two scnerio both of them.
         */
        
        insertionSort sorted = new insertionSort(mapis);
        totalTime = sorted.calculateTime();
        System.out.println("Worst and AVG: " + totalTime);

        
        insertionSort bestSorted = new insertionSort(mapbest);
        totalTime = bestSorted.calculateTime();
        System.out.println("Best Case :" +totalTime);

        /*For the Insertion Sort Algorithm worst and avarage have same time complexity but best case is not same so 
         * i create two scnerio both of them.
         */
        bubbleSort sortedBuble = new bubbleSort(mapis);
        totalTime = sortedBuble.calculateTime();
        System.out.println("Buble Worst and AVG: " + totalTime);

        bubbleSort bestBuble = new bubbleSort(mapbest);
        totalTime = bestBuble.calculateTime();
        System.out.println("Buble Best Case :" +totalTime);

        /*For the Quick Sort Algorithm worst and avarage have same time complexity but best case is not same so 
         * i create two scnerio both of them.
         */
        //worst and avarage scnerio happen when pivot is selected first or last element.
        quickSort quickSorted = new quickSort(mapbest);
        totalTime = quickSorted.calculateTime();
        System.out.println("Quick Worst and AVG: " + totalTime);

    }
}
