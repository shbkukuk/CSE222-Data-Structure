public class Comment extends Interaction{
    /** Comment is a class that inherit class from Interaction.
     * This class contain comment 
     */
    //Data field
    protected String content;

    /**
    // Constructors:
    @param interID ID of interaction
    @param acc ID of account
    @param pstID ID of  Post
    @param contentPost content of published post
     */
    public Comment (int interID, Account acc, int pstID,String contentPost){
        super(interID, acc, pstID);
        content = contentPost;
    }
}
