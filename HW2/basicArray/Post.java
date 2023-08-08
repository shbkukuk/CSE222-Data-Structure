
public class Post {
    /** Post class represent post information 
     * content post ID interactions  
     */

     // Data field
    public int postId;
    protected Like likeArray[];
    protected Comment commentArray[];
    protected String content;
    //Constant
    private static final int DEFAULT_SIZE = 10;
    /**
    //Constructor
    @param pstID ID of post
    @param context content of post
    */
    public Post(int pstID,String context){
        postId=pstID;
        content = context; 
        likeArray = new Like[DEFAULT_SIZE];
        commentArray = new Comment[DEFAULT_SIZE];

    }

}


