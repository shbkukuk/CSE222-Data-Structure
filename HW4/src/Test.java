public class Test {
    static void test(Username user, Password1 password1,Password2 password2)
    {
        boolean validUSername, usernameSplit, balancePass, palindromePass, exactDivison;
        validUSername = user.checkIfValidUsername();
        usernameSplit = user.containUserNameSpirit(password1);
        balancePass = password1.isBalancedPassword();
        palindromePass = password1.isPalindromePossibleCheck();
        int[] denominations = {4,17,29};
        exactDivison = password2.isExactDivision(password2.getpassword(), denominations);

        if(validUSername && usernameSplit && balancePass && palindromePass && exactDivison)
            System.out.println("The Username and Password valid. Please wait the door opening");
        else if (!validUSername)
            if (user.getSize()==0)
                System.out.println("Invalid Username. You should at least 1 letter");
            else 
                System.out.println("Invalid Username. Your username must not contain number ");
        else if (!usernameSplit)
            System.out.println("Invalid Username. Please Check it.");

        else if (!balancePass)
            System.out.println("Invalid password.You should check brackets.");

        else if (!palindromePass)
            System.out.println("The password not palindrome.");

        else if (!exactDivison)
            System.out.println("The second password not possbile exact divison");
        
    }


    public static void main(String[] args) {
        
        //Create username, password1, password2
        Username user1 = new Username("gizemsolmaz");
        Password1 pass1 = new Password1("[rac()ecar]");
        Password2 pass2 = new Password2(74);

        //test params
        System.out.println("Test1....");
        System.out.println(user1.getUsername() + ", " + pass1.getpassword() + ", " + pass2.getpassword() );
        test(user1, pass1, pass2);
        
        System.out.println("___________________________________________________________");

        //Create username, password1, password2
        Username user2 = new Username("gizems45olmaz");
        Password1 pass12 = new Password1("[rac()ecar]");
        Password2 pass22 = new Password2(74);

        //test params
        System.out.println("Test2....");
        System.out.println(user2.getUsername() + ", " + pass12.getpassword() + ", " + pass22.getpassword() );
        test(user2, pass12, pass22);

        System.out.println("___________________________________________________________");
        //Create username, password1, password2
        Username user3 = new Username("gizemsolmaz");
        Password1 pass13 = new Password1("[rac()eascar]");
        Password2 pass23 = new Password2(74);

        //test params
        System.out.println("Test3....");
        System.out.println(user3.getUsername() + ", " + pass13.getpassword() + ", " + pass23.getpassword() );
        test(user3, pass13, pass23);

        System.out.println("___________________________________________________________");
        //Create username, password1, password2
        Username user4 = new Username("gizemsolmaz");
        Password1 pass14 = new Password1("[rac()ecar]");
        Password2 pass24 = new Password2(10);

        //test params
        System.out.println("Test4....");
        System.out.println(user4.getUsername() + ", " + pass1.getpassword() + ", " + pass2.getpassword() );
        test(user4, pass14, pass24);


        System.out.println("___________________________________________________________");

        //Create username, password1, password2
        Username user5 = new Username("gizemsasd12olmaz");
        Password1 pass15 = new Password1("[rac()e123car]");
        Password2 pass25 = new Password2(74);

        //test params
        System.out.println("Test5....");
        System.out.println(user5.getUsername() + ", " + pass15.getpassword() + ", " + pass25.getpassword() );
        test(user5, pass15, pass25);





    }
}
