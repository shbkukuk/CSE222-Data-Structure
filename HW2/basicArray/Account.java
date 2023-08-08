
public class Account {
    /**Account is a class that represents a social media tools,information etc. */
    //Data field
    private int accountId;
    public String username;
    private String birthDate;
    private String location;
    public Post postsArray[]; //Declaration posts array
    protected Message inboxArray[]; //Declaration inbox array
    protected Message outboxArray[]; //Declaration outbox array
    protected Account followers[]; //Declaration followers array
    protected Account following[]; //Declaration following array
    
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private boolean log = false;
    private Account block[];
    private int blockID = 0;
    private int messageID = 0;
    private int postID = 0;
    private int likeID = 0;
    private int commnetID = 0;
    //constant 
    private static final int DEFAULT_SIZE = 100;
    /** 
    //Constructors:
    @param accID accountId
    @param loginName username
    @param dateOfBirth birth date 
    @param site location
    */
    
    public Account(int accID,String loginName, String dateOfBirth, String site){
        accountId = accID;
        username = loginName;
        birthDate = dateOfBirth;
        location = site;
        following = new Account[DEFAULT_SIZE];
        followers = new Account[DEFAULT_SIZE];
        postsArray = new Post[DEFAULT_SIZE];
        inboxArray = new Message[DEFAULT_SIZE];
        outboxArray = new Message[DEFAULT_SIZE];
        block = new Account[DEFAULT_SIZE];

    }
    // Action Methods
    /**
     Login into current account
     * @return log info as boolen
     */
    protected boolean login(){
        this.log = true;
        return this.log;

    }
    /**
     * Logout from current account
     * @return log info as boolen
     */
    protected boolean logout(){
        this.log = false;
        return this.log;
    }
    /**
     * Block account 
     * @param account Account which will be blocked 
     */
    protected void blockAccount(Account account){
        this.block[this.blockID] = account;

    }
    //Controll Methods
    /**
     * If there are any casue a error then the method execute and
     * print Error message
     */
    private void errorMessage(){
        System.out.println("Firstly You must Login!!!! or another account has not logout please check!!!!");

    }
    /**
     * Check current account followed by another account
     * @param account Checked followed by current account
     * @return boolean value if it followed,true else false
     */
    private boolean followCheck(Account account){
        for(Account acc:this.following){
            if(acc==account){
                return true;
            }
        }
        return false; 
    }
    //Main Methods
    /**
     * Follow The given Account
     * @param account the given account information which will be followed
     */
    protected void follow(Account account){
        if(this.log){
            if (this.i<following.length){
                this.following[this.i] = account;
                account.followers[account.j]= this;
                this.i += 1;
                account.j +=1 ;
            }

        }
        else {
            this.errorMessage();
        }  
    }
    /**
     * Send message current account to receiver account.
     * @param receiver the target account get message from current account 
     * @param message string include message content
     */
    protected void  sendMessage(Account receiver,String message){
       
            
        for(Account account:receiver.block){
            
            if(this==account){
                System.out.println("You can not permision to send message");
                
            }
        }
        
        if (this.log && followCheck(receiver)){
            Message mail = new Message(this.messageID,this ,receiver, message);
            
            if (this.k<this.outboxArray.length){
                this.outboxArray[this.k] = mail;
                receiver.inboxArray[receiver.l]=mail;
                this.k += 1;
                receiver.l += 1;
                this.messageID +=1;
            }
        }
        else { 
            System.out.println("Plese check login or followers");
        }
    }
    /**
     * Control it inbox message 
     * print how many message in message box.
     */
    protected void checkInbox(){
        if (this.log){
            int mailsize = 0;
            for (Message item:this.inboxArray){
                if (item!=null){
                    mailsize++;
                }
            }
            System.out.println("There is/are "+mailsize+" message(s) in the inbox");
        }
        else {
            this.errorMessage();
        }
    }
    /**
     * Control it outbox message 
     * print how many message in message box.
     */
    protected void checkOutbox(){
        if (this.log){
            int mailsize = 0;
            for (Message item:this.outboxArray){
                if (item!=null){
                    mailsize++;
                }
            }
            System.out.println("There is/are "+mailsize+" message(s) in the outbox");
        }
        else {
            this.errorMessage();
        }
    }
    /**
     * The current account share post.
     * @param content string value consist of content
     * @param postID int value post ID.
     */
    protected void sharingPost(String content, int postID){
        if(this.log){
            this.postID = postID;
            Post post = new Post(this.postID, content);
            this.postsArray[this.postID] = post;
            this.postID++;

        }
        else {
            errorMessage();
        }
        
    }
    /**
     * Like post which shared their friends or following
     * @param account an account whose post will be liked
     * @param postId an post value which post will be liked
     */
    protected void likePost(Account account,int postId){
        if (this.log){
            account.postsArray[postId].likeArray[account.likeID]= new Like(account.likeID,this,postId);
            account.likeID++;
        }
        else { 
            errorMessage();
        }
        
    }
    /**
     * Share comment specific post
     * @param account an account whose share comment in shared posted
     * @param postId  an post value which post get comment 
     * @param comment string value has content comment
     */
    protected void commentPost(Account account,int postId,String comment){
        if (this.log && !account.log){
            Comment commentNew = new Comment(account.commnetID,this,postId,comment);
            account.postsArray[postId].commentArray[account.commnetID] = commentNew;
            account.commnetID++;
        }
        else { 
            errorMessage();
        }
        
    }

    /**
     * The account view get interaction on shared post like,comment 
     * @param account an acoount whose get information interaction on shared post
     */
    protected void viewInteractions(Account account){
        if (this.log){
            for (Post post:account.postsArray){
                String accounts = "";
                String comments = "";
                int commentValue = 0;
                if (post != null){
                    for(Like like:post.likeArray){
                        if (like != null){
                            accounts +=(like.account.username)+", ";
                        }
                    }
                    for(Comment comment:post.commentArray){
                        if(comment!= null){
                            comments +=("Comment "+comment.interactionId+": "+"'"+comment.account.username+"'"+"said"+"'"+comment.content+"'\n"); 
                            commentValue++;
                        }
                    }                      
                    
                    System.out.println("(PostID :"+post.postId+"):"+post.content+"\n"+
                                    "The post was liked by the following account(s): "+ accounts +"\n"+
                                    "The post has "+commentValue+" comments.....\n"+
                                    comments+"\n"+
                                    "----------------------------------------------------\n");
    
                }
            }
        }

        else {
            errorMessage();
        }
        
    }
    /**
     * The account view shared post information
     * @param account an acoount whose get information shared posts
     */
    public void viewPost(Account account){
        if (this.log && !account.log){
            for (Post post:account.postsArray){
                if(post != null){
                    System.out.println("(Post ID: "+post.postId+") "+post.content+"\n");
                }
            }
        }
    }
    /**
     * Reivew message senden by followers
     * print message information sender username, content and message ID
     */
    protected void viewInbox(){
        if (this.log){
            for(Message item:this.inboxArray){
                if (item != null){
                    System.out.println("Message ID: " +  item.messageId +"\n" +
                                "From: " + item.senderId.username + "\n" +
                                "To: " + item.receiverId.username + "\n" +
                                "Message: " + item.content + "\n" +
                                "-------------------------------------------\n");
                }
            }

        }
        else {
            errorMessage();
        } 
    }
    /**
     * Retrives the information in a Account object
     * @param account The account object view information
     * print the object state as a string
     */
    protected void viewProfile(Account account){
        for(Account accountView:this.block){
            
            if(this==accountView){
                System.out.println("You can not permision to view Profile");
                
            }
        }
        if((!account.log || account==this) && this.log){
            String followersNames = "";
        String followingNames = "";
        for(int i=0;i<=account.i;i++){
            if(account.following[i]!=null){
                followingNames += (account.following[i].username)+",";
            }
            
        }
        for (int j=0;j<=account.j;j++){
            if(account.followers[j]!=null){
                followersNames += (account.followers[j].username)+",";
            }
        }
        System.out.println("User ID: "+account.accountId+"\n"+
                        "Username: "+account.username+"\n"+
                        "Location: "+account.location+"\n"+
                        "Birth date: " +account.birthDate+"\n"+
                        account.username+ " is following" + account.i + " account(s) and "+ account.j +" follower(s) "+"\n"+
                        account.username+" is following "+followingNames+"\n"+
                        "The followers of " +account.username +" are " + followersNames +"\n"+
                        account.username+ " has " +(account.postID+1)+" post(s).\n");

        }
        else {
            errorMessage();
        }
    }
    

}
