public class Test2 {

    public static void main(String[] args) throws Exception{
        long startTime = System.nanoTime();
        /*Before start Test2, run Test1 */
        Account users[] = new Account[3];

        users[0] = new Account(1, "gizemsungu", "13.07.1998", "istanbul");
        users[1] = new Account(2, "sibelgunduz", "04.01.1974", "Izmit");
        users[2] = new Account(3, "gokhankaya", "09.12.1998", "istanbul");
        
        for (int i =0; i<users.length;i++){
            System.out.println("An account with username "+users[i].username+ "has been created\n");
        }
       
        users[1].login();
        users[1].sharingPost("I like Java.",1);
        users[1].sharingPost("JAva the coffe..",2);
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


        /**Test 2 Start here */
        //login into gizemsungu
        System.out.println("Loggin into an account (username: "+users[0].username+")\n");
        users[0].login();

        //share two post
        System.out.println("Sharing postss....\n");
        users[0].sharingPost("GTU is the best",1);
        users[0].sharingPost("Life is short,birds fly...",2);
        //log out
        System.out.println("Logging out from account "+"'"+users[0].username+"'\n");
        users[0].logout();
        //login into sibelgunduz
        System.out.println("Loggin into an account (username: "+users[1].username+")\n");
        users[1].login();
        //view gizemsungu account
        System.out.println("View gizemsungu profiles..\n");
        users[1].viewProfile(users[0]);
        //like post
        System.out.println("Like post 1\n");
        users[1].likePost(users[0], 2);
        //log out sibelgunduz
        System.out.println("Logging out from account "+"'"+users[1].username+"'\n");
        users[1].logout();
        //login gokhan kaya
        System.out.println("Loggin into an account (username: "+users[2].username+")\n");
        users[2].login();
        //view gizemsungu profile
        System.out.println("View gizemsungu profiles..\n");
        users[2].viewProfile(users[0]);
        //comment post
        System.out.println("Comment post 1\n");
        users[2].commentPost(users[0], 2, "Nice!!!");
        // send message to gizemsungu 
        System.out.println("Send message\n");
        users[2].sendMessage(users[0], "Hello!!!");
        //log out
        System.out.println("Logging out from account "+"'"+users[2].username+"'\n");
        users[2].logout();
        //log in gizemsungu
        System.out.println("Loggin into an account (username: "+users[0].username+")\n");
        users[0].login();
        //view own profile
        System.out.println("View own profile");
        users[0].viewProfile(users[0]);
        //read message from gokhankaya
        System.out.println("Read message from gokhankaya");
        users[0].checkInbox();
        users[0].viewInbox();
        users[0].logout();

        long stopTime = System.nanoTime();
        long totalTime = (stopTime -startTime);
        double second = (double) totalTime/1000000000;
        System.out.println(second+" second");
    }
    
}
