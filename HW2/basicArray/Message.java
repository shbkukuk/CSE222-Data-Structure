public class Message {
    /** Message is a class that represent send and receive message from
     * each account.
     */
    //Data field
    public int messageId = 0;
    public Account senderId;
    public Account receiverId;
    public String content;

    //Constructors:
    public Message(int messageID, Account sender, Account receive, String message ){
        messageId = messageID;
        senderId = sender;
        receiverId = receive;
        content = message;

    }
}
