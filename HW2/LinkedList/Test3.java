public class Test3 {
    public static void main(String[] args) throws Exception{
        long startTime = System.nanoTime();
        /*Before start Test3, run Test1 and Test 2 */
        Account users[] = new Account[3];

        users[0] = new Account(1, "gizemsungu", "13.07.1998", "istanbul");
        users[1] = new Account(2, "sibelgunduz", "04.01.1974", "Izmit");
        users[2] = new Account(3, "gokhankaya", "09.12.1998", "istanbul");
        
        for (int i =0; i<users.length;i++){
            System.out.println("An account with username "+users[i].username+ "has been created\n");
        }
       
        users[1].login();
        users[1].sharingPost("I like Java.");
        users[1].sharingPost("JAva the coffe..");
        users[1].follow(users[0]);
        users[1].follow(users[2]);
        users[1].logout();
        users[2].login();
        users[2].viewProfile(users[1]);
        users[2].viewPost(users[1]);
        users[2].likePost(users[1], 1);
        users[2].commentPost(users[1], 2, "me too!!");
        users[2].follow(users[0]);
        users[2].follow(users[1]);
        users[2].sendMessage(users[0], "Homework is easy!!");
        users[2].logout();
        users[0].login();
        users[0].checkOutbox();
        users[0].checkInbox();
        users[0].viewInbox();
        users[0].viewProfile(users[1]);
        users[0].viewPost(users[1]);
        users[0].viewInteractions(users[1]);
        users[0].likePost(users[1], 1);
        users[0].viewInteractions(users[1]);
        users[0].logout();
        users[0].login();
        users[0].sharingPost("GTU is the best");
        users[0].sharingPost("Life is short,birds fly...");
        users[0].logout();
        users[1].login();
        users[1].viewProfile(users[0]);
        users[1].likePost(users[0], 2);
        users[1].logout();
        users[2].login();
        users[2].viewProfile(users[0]);
        users[2].commentPost(users[0], 2, "Nice!!!");
        users[2].sendMessage(users[0], "Hello!!!");
        users[2].logout();
        users[0].login();
        users[0].viewProfile(users[0]);
        users[0].checkInbox();
        users[0].viewInbox();
        users[0].logout();

        //login into gizemsungu
        System.out.println("Loggin into an account (username: "+users[0].username+")\n");
        users[0].login();
        //block sibelgunduz
        System.out.println("Block sibelgunuz...\n");
        users[0].blockAccount(users[1]);
        //log out
        users[0].logout();
        //login sibelgunduz
        System.out.println("Loggin into an account (username: "+users[1].username+")\n");
        users[1].login();
        //try send message to gizemsungu
        users[1].sendMessage(users[0], "How are you? ");

        long stopTime = System.nanoTime();
        long totalTime = (stopTime -startTime)/1000000000;
        System.out.println(totalTime+" second");
    }
    
}
