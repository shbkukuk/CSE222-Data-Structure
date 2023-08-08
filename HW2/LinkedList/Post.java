
import java.util.*;
public class Post {
    /** Post class represent post information 
     * content post ID interactions  
     */

     // Data field
    public int postId;
    protected ArrayList<Like> likeArray;
    protected ArrayList <Comment> commentArray ;
    protected String content;
    /**
    //Constructor
    @param pstID ID of post
    @param context content of post
    */
    public Post(int pstID,String context){
        postId=pstID;
        content = context; 
        likeArray = new ArrayList<Like>();
        commentArray = new ArrayList<Comment>();

    }

}


