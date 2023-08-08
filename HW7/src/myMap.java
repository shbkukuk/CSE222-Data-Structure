import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;

/**
 * The myMap class represents a mapping of letters to information objects.
 */
public class myMap {
    

    //Data Field 

    private int mapSize;
    protected String str;
    protected LinkedHashMap<String,info> map;

    
    /**
     * Default Constructor.
     * Initializes the mapSize to 0 and creates a new LinkedHashMap for the mapping.
     */
     public myMap()
     {
        this.mapSize =0 ;
        this.map = new LinkedHashMap<>();

     }
     /**
     * Constructor with input string.
     * Performs preprocessing on the input string and creates a mapping of letters to information objects.
     *
     * @param input The input string.
     */
     public myMap(String input)
     {
        this.str = preprocessing(input);
        this.map = new LinkedHashMap<>();

        List<String> items = createWords();
        List<String> letters = createLetter();

        int index = 0;
        for(String ch:letters)
        {
            if(ch.isBlank())
            {
                index++;
            }

            String word = items.get(index);
            if(word.contains(ch))
            {
                if(map.containsKey(ch))
                {
                info temp = map.get(ch);
                temp.push(word);
                map.put(ch,temp);
                }

                else
                {
                    info newInfo = new info(word);
                    map.put(ch, newInfo);
                }
            }
            
        }
        this.mapSize = map.size();
     }

     /**
     * Puts a new information object in the mapping with the specified key.
     *
     * @param key     The key for the mapping.
     * @param newInfo The information object to be added.
     */
     protected void putInfo(String key,info newInfo)
     {
        map.put(key, newInfo);
     }

     /**
     * Retrieves the information object associated with the specified key from the mapping.
     *
     * @param key The key for the mapping.
     * @return The information object associated with the key, or null if the key is not found.
     */
     protected info getInfo(String key)
     {
        return map.get(key);
     }

     //helper Functions 

     /**
     * Creates a list of words from the given string.
     *
     * @return a list of words extracted from the string.
     */
     private List<String> createWords()
     {
        List<String> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        while (end < this.str.length()) {
            while (end < this.str.length() && this.str.charAt(end) != ' ') {
                end++;
            }
            list.add(this.str.substring(start, end));
            start = end + 1;
            end = start;
     }

     return list;
    }

    /**
     * Creates a list of letters from the given string.
     *
     * @return a list of letters extracted from the string.
     */
    private List<String> createLetter()
    {
        char[] charArray = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (char ch : charArray) {
            list.add(Character.toString(ch));
        }
        return list;
    }

    /**
     * Prints the mapping to the console.
     */
    public void printMap()
    {
        System.out.println(this.map.toString());
    }

    /**
     * Retrieves the count of occurrences for the specified key in the mapping.
     *
     * @param key The key for the mapping.
     * @return The count of occurrences for the key, or 0 if the key is not found.
     */
    protected int getCount(String key)
    {
        info temp = map.get(key);
        return temp.size();
    }

    /**
     * Retrieves an array of keys from the mapping.
     *
     * @return An array of keys.
     */
    protected String[] getKeys()
    {
        String[] keys = map.keySet().toArray(new String[0]);
        return keys;
    }

    /**
     * Checks if the letter map is empty.
     *
     * @return true if the letter map is empty, false otherwise.
     */
    protected boolean isEmpty()
    {
        if(map.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Retrieves the size of the letter map.
     *
     * @return the size of the letter map.
     */
    protected int mapSize()
    {
        return this.mapSize;
    }

    /**
     * Returns a string representation of the letter map.
     *
     * @return a string representation of the letter map.
     */
    @Override
    public String toString()
    {   
        String res="";
        String[] keys = map.keySet().toArray(new String[0]);
        for(String key:keys)
        {
            String temp = "Letter: " + key + " - " + map.get(key).toString() + "\n";
            res += temp;
        }

        return res;
    }

    /**
     * Preprocesses a given string by removing non-alphabetic characters and converting it to lowercase.
     *
     * @param str the string to be preprocessed.
     * @return the preprocessed string.
     */
    private String preprocessing(String str)
    {
        if(str.isEmpty())
        {
            System.out.println("The stirng is empty. You will get error");  
        }
        else if(str.matches("\\d+"))
        {
            System.out.println("The string just contains number. You will not run this program with strinh that contains just numbers.");
        }
        else
        {
        String lowercaseString = str.toLowerCase();
        System.out.println("Original String: " +str);
        String processedString = lowercaseString.replaceAll("[^a-z ]", "");
        System.out.println("Prepocessing String: " +processedString);
        return processedString;
        }
        return "";
        
    }
}
