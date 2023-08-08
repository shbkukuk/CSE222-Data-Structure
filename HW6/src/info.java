import java.util.ArrayList;

/**
 * The info class represents information about a word, including its count and a list of occurrences.
 */
public class info {
    // Data fields
    protected int count;
    protected ArrayList<String> words;

    /**
     * Default Constructor.
     * Initializes the count to 0 and creates an empty ArrayList for words.
     */
    public info() {
        this.count = 0;
        this.words = new ArrayList<>();
    }

    /**
     * Constructor with a new word.
     * Initializes the count to 1 and adds the new word to the list.
     *
     * @param newWord The new word to be added.
     */
    public info(String newWord) {
        this.count = 1;
        this.words = new ArrayList<>();
        this.words.add(newWord);
    }

    /**
     * Pushes a new word to the list and increments the count.
     *
     * @param newWord The new word to be added.
     */
    public void push(String newWord) {
        this.count++;
        this.words.add(newWord);
    }

    /**
     * Returns the count of words.
     *
     * @return The count of words.
     */
    public int size() {
        return count;
    }

    /**
     * Returns the list of words.
     *
     * @return The list of words.
     */
    public ArrayList<String> getWords() {
        return words;
    }

    /**
     * Sets the count to a new value.
     *
     * @param newCount The new count value.
     */
    public void setSize(int newCount) {
        this.count = newCount;
    }

    /**
     * Returns a string representation of the info object.
     *
     * @return A string representation of the info object.
     */
    @Override
    public String toString() {
        String res = "Count: " + this.count + " - " + "Words: " + this.words;
        return res;
    }
}
