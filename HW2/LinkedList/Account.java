import java.util.*;


public class Account {
    /**Account is a class that represents a social media tools,information etc. */
    //Data field

    /** Keeps account id of the user. */
    private int accountId;

    /** Keeps username of the user. */
    public String username;

    /** Keeps birthdate of the user. */
    private String birthDate;
    
    /** Keeps location of the user. */
    private String location;

    /** Keeps all posts of the user. */
    public LinkedList<Post> postsArray; 

    /** Keep all actions of the user */
    protected LinkedList<String> historyActions;

    /** Keep all inbox message of the user */
    protected LinkedList<Message> inboxArray; 

    /** Keep all outbox message of the user */
    protected LinkedList<Message> outboxArray; 

    /** Keep all followers of the user */
    protected LinkedList <Account> followers; 

    /** Keep all following of the user */
    protected LinkedList <Account> following; 

    /**Keep all blocked account by the user */
    private LinkedList <Account> block;

    /**Keeps the boolean indicating if the account has logined or not. */
    private boolean log ;
    
    /** Keeps the last viewed account to be able to make some checks. */
    private String lastViewAccount;

    /**Set ID number for information of actions */
    private int messageID;
    private int postID;
    private int likeID;
    private int commnetID;

    /** 
    //Constructors:
    @param accID accountId
    @param loginName username
    @param dateOfBirth birth date 
    @param site location
    */
    
    public Account(int accID,String loginName, String dateOfBirth, String site){
        this.accountId = accID;
        this.username = loginName;
        this.birthDate = dateOfBirth;
        this.location = site;
        this.lastViewAccount = null;
        this.log = false;

        this.messageID =1;
        this.postID = 1;
        this.likeID = 1;
        this.commnetID =1;

        this.following = new LinkedList<>();
        this.followers = new LinkedList<>();
        this.postsArray = new LinkedList<>();
        this.inboxArray = new LinkedList<>();
        this.outboxArray = new LinkedList<>();
        this.block = new LinkedList<>();
        this.historyActions = new LinkedList<>();

    }
    /**
     * Checks whether given object is equals to the account.
     * @param o The given object that will be compared.
     * @return A boolean indicating if the given object equals to the account or not.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        
        Account a = (Account) o;
        if (a.getAccountId() != accountId) return false;
        if (!a.getUsername().equals(username)) return false;
        if (!a.getBirthDate().equals(birthDate)) return false;
        if (!a.getLocation().equals(location)) return false;

        return true;
    }
    /**
     * Writes the account informations inside the string.
     * @return A string representing account details.
     */
    @Override
    public String toString(){
        int followingSize = following.size();
        int followersSize = followers.size();
        int postSize = postsArray.size();

        System.out.println("----------------------");
        String res =  "User ID: " + accountId + "\n" +
                "Username: " + username + "\n" +
                "Location: " + location + "\n" +
                "Birth Date: " + birthDate + "\n" +
                username + " is following " + followingSize + " account(s) and has " + followersSize + " followers(s)." + "\n";

        if (followersSize != 0) {
            res += "The followers of " + username + " are: ";
            for (int i = 0; i < followersSize; ++i) {
                res += followers.get(i).getUsername() + ", ";
            }
            res += "\n";
        }

        if (followingSize != 0) {
            res += username + " is following: ";
            for (int i = 0; i < followingSize; ++i) {
                res += following.get(i).getUsername() + ", ";
            }
            res += "\n";
        }

        res += username + " has " + postSize + " posts." + "\n";
        return res;
    }
    /**
     * Gets account id.
     * @return An integer representing the account id.
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Set account id.
     * @param accountId The account id of the account.
     */
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    /**
     * Gets username.
     * @return A string representing username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     * @param username The user name of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the birth date of the user.
     * @return A string representing the birth date.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the account.
     * @param birthDate The user's birthdate.
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets the location of the user.
     * @return A string representing user's location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of the user.
     * @param location The user's location.
     */
    public void setLocation(String location) {
        this.location = location;
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
        this.lastViewAccount = null;
        return this.log;
    }
    /**
     * Block account 
     * @param account Account which will be blocked 
     */
    protected void blockAccount(Account account){
        if(this.log){
            this.block.add(account);
            if(account.followCheck(this)){
                account.following.remove(this);
                this.followers.remove(account);
                historyActions.add("You blocked "+account.getUsername());
            }
        }
        else errorMessage(account);
    }
    protected void unblock(Account account){
        if(this.log){
            if(this.block.contains(account)){
                this.block.remove(account);
                historyActions.add("You unblocked "+account.getUsername());
            }
            else{
                System.out.println("!!!!ERROR!!!! You try to blocked account which unblocked by you.");

            }
        }
        else errorMessage(account);   
    }
    private boolean checkBlock(Account account){
            
        if(this.block.contains(account)){
            System.out.println("You can not permision to this action because you are blocked ");
            return false;
            
        }

        return true;

    }
    //Controll Methods
    /**
     * If there are any casue a error then the method execute and
     * print Error message
     */
    private void errorMessage(Account account){
        if(!this.log)
        System.out.println("Firstly You must Login!!!!");
        else if(account.log)
        System.out.println("Another Account must LOGOUT!!!!");
        else if(!followCheck(account))
        System.out.println("You dont follow "+account.username);
        else 
        System.out.println("Non defining Errror");



    }
    /**
     * Check current account followed by another account
     * @param account Checked followed by current account
     * @return boolean value if it followed,true else false
     */
    private boolean followCheck(Account account){
        
        if(this.following.contains(account)){
            return true;
        }
        
        return false; 
    }
    //Main Methods
    /**
     * Follow The given Account
     * @param account the given account information which will be followed
     */
    protected void follow(Account account){
        if(this.log && checkBlock(account)){
            if(!this.following.contains(account)){
                this.following.add(account);
                account.followers.add(this);
                historyActions.add("You followed "+account.getUsername());
            }
            else{
                System.out.println("You try to follow account that already followed by you");
            }
        }
        else if(account==this){
            System.out.println("!!!You can not follow yourself!!!");
        }
        else {
            this.errorMessage(account);
        }  
    }

    //MAKE : Comment
    protected void unfollow(Account account){
        if(this.log){
            if(this.following.contains(account)){
                this.following.remove(account);
                historyActions.add("You unfollowed "+account.getUsername());
            }
            else{
                System.out.println("!!!!ERROR!!!! You try to unfollow account which followed by you.");
            }
        }
        else if(account==this){
            System.out.println("You can not unfollow yourself!!!");
        }
        else{
            errorMessage(account);
        }
    }

    /**
     * Send message current account to receiver account.
     * @param receiver the target account get message from current account 
     * @param message string include message content
     */
    protected void  sendMessage(Account receiver,String message){
       
        
        if (this.log && followCheck(receiver) && checkBlock(receiver)){
            Message mail = new Message(this.messageID,this ,receiver, message);
            
            this.outboxArray.add(mail);
            receiver.inboxArray.add(mail);   
            this.messageID +=1;
            this.historyActions.add("You send message to "+ receiver.username);
            
        }
        else { 
            errorMessage(receiver);
        }
    }
    /**
     * Control it inbox message 
     * print how many message in message box.
     */
    protected void checkInbox(){
        if (this.log){
            if(this.inboxArray.isEmpty())

                System.out.println("There is/are 0 message(s) in the inbox");
            System.out.println("There is/are "+this.inboxArray.size()+" message(s) in the inbox");
        }
        else {
            errorMessage(this);
        }
    }
    /**
     * Control it outbox message 
     * print how many message in message box.
     */
    protected void checkOutbox(){
        if (this.log){
            if(this.outboxArray.isEmpty()){
                System.out.println("There is/are 0 message(s) in the inbox");

            }
            System.out.println("There is/are "+this.outboxArray.size()+" message(s) in the inbox");
            }
        else {
            errorMessage(this);
        }
    }
    /**
     * The current account share post.
     * @param content string value consist of content
     * @param postID int value post ID.
     */
    protected void sharingPost(String content){
        if(this.log){
            Post post = new Post(this.postID, content);
            this.postsArray.add(post);
            this.historyActions.add("You shared post ID:"+this.postID);
            this.postID++;
        }
        else {
            errorMessage(this);
        }
        
    }
    /**
     * Like post which shared their friends or following
     * @param account an account whose post will be liked
     * @param postId an post value which post will be liked
     */
    protected void likePost(Account account,int postId){
        if (this.log){
            account.postsArray.get(postId-1).likeArray.add(new Like(account.likeID,this,postId));
            this.historyActions.add("You liked "+account.getUsername()+"'s "+"this Post ID: "+account.postID);
            account.likeID++;
        }
        else { 
            errorMessage(account);
        }
        
    }
    //MAKE : Comment
    protected void unlikePost(Account account, int postId){
        if(this.log){
            int size = account.postsArray.get(postId-1).likeArray.size();
            int delete =0;
            for(int i =0;i<size;i++){
                if (this==account.postsArray.get(postId-1).likeArray.get(i).account){
                    account.postID = postId;
                    account.likeID = likeID;
                    account.postsArray.get(postId-1).likeArray.remove(account.postsArray.get(postId-1).likeArray.get(i));
                    this.historyActions.add("You unliked "+account.getUsername()+"'s "+"this Post ID: "+account.postID);
                    delete++;
                }  
            }
            if(delete==0){
                System.out.println("!!!!ERROR!!!! You try to unlike post which liked by you.");
            }
        }
        else{
            errorMessage(account);
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
            account.postsArray.get(postId-1).commentArray.add(commentNew);
            this.historyActions.add("You commnet "+account.getUsername()+"'s "+"this Post ID: "+account.postID);
            account.commnetID++;
        }
        else { 
            errorMessage(account);
        }
        
    }
    // Make : Comment here.
    protected void uncommentPost(Account account,int postId){
        if(this.log){
            int size = account.postsArray.get(postId-1).commentArray.size();
            int delete =0;
            for(int i =0;i<size;i++){
                if (this==account.postsArray.get(postId-1).commentArray.get(i).account){
                    account.postID = postId;
                    account.commnetID = commnetID;
                    account.postsArray.get(postId-1).commentArray.remove(account.postsArray.get(postId-1).commentArray.get(i));
                    this.historyActions.add("You unliked "+account.getUsername()+"'s "+"this Post ID: "+account.postID);
                    delete++;
                }  
            }
            if(delete==0){
                System.out.println("!!!!ERROR!!!! You try to unlike post which liked by you.");
            }
        }
        else{
            errorMessage(account);
        }
    }

    /**
     * The account view get interaction on shared post like,comment 
     * @param account an acoount whose get information interaction on shared post
     */
    protected void viewInteractions(Account account){
        if (!this.log && account.log ){
            errorMessage(account); 
        }
        else if(!lastViewAccount.equals(account.getUsername())){
            System.out.println("You first view Account");
        }
        else {
            String accounts = "";
            String comments = "";
            int commentValue = 0;
            if (!account.postsArray.isEmpty()){
                for(Post post:account.postsArray){
                    for(Like like:post.likeArray){
                        if (like != null){
                            accounts +=(like.account.getUsername())+", ";
                        }
                    }
                    for(Comment comment:post.commentArray){
                        if(comment!= null){
                            comments +=("Comment "+comment.interactionId+": "+"'"+comment.account.getUsername()+"'"+"said"+"'"+comment.content+"'\n"); 
                            commentValue++;
                        }
                    }                      
                    
                    System.out.println("(PostID :"+post.postId+"):"+post.content+"\n"+
                                    "The post was liked by the following account(s): "+ accounts +"\n"+
                                    "The post has "+commentValue+" comments.....\n"+
                                    comments+"\n"+
                                    "----------------------------------------------------\n");
                    }
                    this.historyActions.add("You look interactions of "+account.getUsername()+"'s posts.");
                }
            
        }  
    }
    /**
     * The account view shared post information
     * @param account an acoount whose get information shared posts
     */
    public void viewPost(Account account){
        if (!this.log && account.log){
            errorMessage(account);
        }
        else if(!lastViewAccount.equals(account.getUsername())){
            System.out.println("You first view Account");
        }
        else
        {
            if(!account.postsArray.isEmpty()){
                for (Post post:account.postsArray){
                
                    System.out.println("(Post ID: "+post.postId+") "+post.content+"\n"); 
                    this.historyActions.add("You view post ID: "+post.postId+" of "+account.getUsername()+"'s.");
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
            if (!this.inboxArray.isEmpty()){
                for(Message item:this.inboxArray){
                    
                        System.out.println("Message ID: " +  item.messageId +"\n" +
                                    "From: " + item.senderId.username + "\n" +
                                    "To: " + item.receiverId.username + "\n" +
                                    "Message: " + item.content + "\n" +
                                    "-------------------------------------------\n");
                    }
                }
            }
        else {
            errorMessage(this);
        } 
    }
    /**
     * Retrives the information in a Account object
     * @param account The account object view information
     * print the object state as a string
     */
    protected void viewProfile(Account account){   
        if(!(!account.log || account==this) && !this.log){
            errorMessage(account);
        }
        else if(this.block.contains(account)){
            System.out.println("You can not permision to view Profile");  
        }
        
        else {
            
            System.out.println(account);
            this.lastViewAccount = account.getUsername();
            this.historyActions.add("You view "+account.getUsername()+"'s profile.");

            }

        }
    
        protected void viewHistory(){
            if(!this.log){
                errorMessage(this);
            }
            else{
                int size = this.historyActions.size();
                for(int i=0;i<size;i++){
                    System.out.println(this.historyActions.get(i));
                }
            }
        }
}
    


