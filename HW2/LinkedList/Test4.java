public class Test4 {
    public static void main(String[] args) throws Exception{
        long startTime = System.nanoTime();
        /*Before start Test3, run Test1 and Test 2 */
        Account users[] = new Account[5];

        users[0] = new Account(1, "gizemsungu", "13.07.1998", "istanbul");
        users[1] = new Account(2, "sibelgunduz", "04.01.1974", "Izmit");
        users[2] = new Account(3, "gokhankaya", "09.12.1998", "istanbul");
        users[3] = new Account(4, "aysekal", "04.01.1274", "Antalya");
        users[4] = new Account(5, "ahmetkaya", "09.12.1928", "MALATYA");
        
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
        users[0].login();
        users[0].blockAccount(users[1]);
        users[0].logout();
        users[1].login();
        users[1].sendMessage(users[0], "How are you? ");

        /**Test 4 Start Here */
        System.out.println("TEST 4");
        
        
        for (int i =0; i<users.length;i++){
            System.out.println("An account with username "+users[i].username+ "has been created\n");
        }

        //login aysekal
        users[3].login();
        System.out.println("Loggin into an account aysekal");
        
        //Share post
        System.out.println("Sharing Post");
        users[3].sharingPost("Insan yalniz dogar da yalniz olmesmis? n'aber");
        
        
        //Follow accounts : 
        users[3].follow(users[0]);
        users[3].follow(users[1]);
        users[3].follow(users[2]);
        System.out.println("Follow accounts");
        
        //view account
        System.out.println("View gizemsungu profile... ");
        users[3].viewProfile(users[0]);
        

        //Block
        users[3].blockAccount(users[0]);
        System.out.println("Block gizemsungu profile... ");

        //View Actions
        users[3].logout();
        System.out.println("Logout... ");

        //login ahmetkaya
        users[4].login();
        System.out.println("Login... ");

        //view account
        System.out.println("View ahmetkaya profile... ");
        users[4].viewProfile(users[3]);
        

        //View Post
        System.out.println("View ahmetkaya post... ");
        users[4].viewPost(users[3]);
        

        //Comment post 
        users[4].commentPost(users[3], 1, "soylenmedi hic sana layik dusler benden once");
        System.out.println("Add comment post that view... ");

        //like Post
        users[4].likePost(users[3], 1);
        System.out.println("Like post that view... ");

        //view Profile
        System.out.println("View ahmetkaya profile... ");
        users[4].viewProfile(users[3]);
        

        //uncomment
        users[4].uncommentPost(users[3], 1);
        System.out.println("Remove comment post that add comment before");

        //unlike
        users[4].unlikePost(users[3], 1);
        System.out.print("Remove like from post");

        //view Profile
        System.out.println("View ahmetkaya profile... ");
        users[4].viewProfile(users[3]);

        //Log out
        System.out.println("Logout");
        users[4].logout();

        //login
        System.out.println("Login into aysekal");
        users[3].login();

        //unfollow account
        System.out.println("unfollow gokhankaya");
        users[3].unfollow(users[2]);

        //view profile 
        System.out.println("try view profile which unfollow by ayse");
        users[3].viewProfile(users[0]);

        long stopTime = System.nanoTime();
        long totalTime = (stopTime -startTime);
        double second = (double) totalTime/1000000000;
        System.out.println(second+" second");



    }
    
}
