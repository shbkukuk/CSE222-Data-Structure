public class Test1 {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        //Create 3 different account with their information
        Account users[] = new Account[3];

        System.out.println("Creating accounts...");
        users[0] = new Account(1, "gizemsungu", "13.07.1998", "istanbul");
        users[1] = new Account(2, "sibelgunduz", "04.01.1974", "Izmit");
        users[2] = new Account(3, "gokhankaya", "09.12.1998", "istanbul");
        
        for (int i =0; i<users.length;i++){
            System.out.println("An account with username "+users[i].username+ "has been created\n");
        }
        //Login into sibelgunduz
        System.out.println("Loggin into an account (username: "+users[1].username+")\n");
        users[1].login();

        //share two post on sibelgunduz
        System.out.println("sharing two posts\n");
        users[1].sharingPost("I like Java.");
        users[1].sharingPost("JAva the coffe..");

        //following gizemdungu and gokhankaya
        System.out.println("Following gizemsungu and gokhankaya...\n");
        users[1].follow(users[0]);
        users[1].follow(users[2]);

        //logout sibelgunduz
        System.out.println("Logging out from account "+"'"+users[1].username+"'\n");
        users[1].logout();

        //login into gokhankaya
        System.out.println("Logging in another account (username:"+users[2].username+")\n");
        users[2].login();

        //view sibelgunduz account
        System.out.println("Viewing sibelgulmez's profile...\n");
        users[2].viewProfile(users[1]);

        //view sibelgunduz accounts 
        System.out.println("Viewing sibelgulmez'posts...\n");
        users[2].viewPost(users[1]);

        //like sibelgunduz post
        System.out.println("Liking a post of sibelgulmez...\n");
        users[2].likePost(users[1], 1);

        //comment on shared post by sibelgunduz
        System.out.println("Adding a comment on a post of sibelgulmez...\n");
        users[2].commentPost(users[1], 2, "me too!!");

        //following sibelgunduz and gizemsungu
        System.out.println(" Following sibelgulmez and gizemsungu...\n");
        users[2].follow(users[0]);
        users[2].follow(users[1]);

        //send message gizemsungu
        System.out.println("Sending message to gizemsungu\n");
        users[2].sendMessage(users[0], "Homework is easy!!");

        //log out gokhankaya
        System.out.println("Logging out from account 'gokhankaya'..\n");
        users[2].logout();

        //login gizemsungu account
        System.out.print("Logging into another account (username: gizemsungu)...\n");
        users[0].login();

        //check send messages
        System.out.print("Checking outboox\n");
        users[0].checkOutbox();

        //check inbox messege 
        System.out.println("Checking inbox.\n");
        users[0].checkInbox();

        //view message
        System.out.println("Viewing inbox... \n");
        users[0].viewInbox();
        
        //view sibelgunduz profile
        System.out.println("Viewing sibelgulmez's profile...\n");
        users[0].viewProfile(users[1]);

        //view sibelgunduz post
        System.out.println("Viewing sibelgulmez's posts...\n");
        users[0].viewPost(users[1]);

        //view sibelgunduz intereaction
        System.out.println("Viewing sibelgulmez's posts' interactions..\n");
        users[0].viewInteractions(users[1]);
        //like sibelgunduz post 
        System.out.println("Liking sibelgulmez's posts...\n");
        users[0].likePost(users[1], 1);

        //view sibelgunduz intereaction
        System.out.println("Viewing sibelgulmez's posts' interactions..\n");
        users[0].viewInteractions(users[1]);
        users[0].logout();

        long stopTime = System.nanoTime();
        long totalTime = (stopTime -startTime);
        double second = (double) totalTime/1000000000;
        System.out.println(second+" second");
    }
}
