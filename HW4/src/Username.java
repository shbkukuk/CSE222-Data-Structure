import java.util.Stack;

public class Username{
    /*USernam is a class that represent a security profile tools */
    
    //Data Field
    private String username;
    private Stack<Character> stack;
   

    //Construct
    /**
     * Create new object from Username
     * @param username String USername
     */
    public Username(String username)
    {
        this.username = username;
        this.stack = new Stack<>();
        
    }
    //Set and Get functions 

    /**
     * Define new username to object
     * @param username String Username
     */
    public void setUsername(String username)
    {
        this.username = username;

    }
    
    /**
     * Get username
     * @return String username
     */
    public String getUsername()
    {
        return this.username;

    }

    /**
     * Size information of String Username
     * @return intenger value of size
     */
    public int getSize()
    {
        return this.username.length();
    }

    //Stack Helper Functions 
    /**
     * Push character of String in the stack 
     */
    public void stackPush()
    {
        int size = getSize();
        for(int i=0; i<size ; i++)
        {
            stack.push(this.getUsername().charAt(i));
        }
    }

    /**
     * Get top of stack and  remove it.
     * @return Character from  String Username 
     */
    public Character stackPop()
    {
        return stack.pop();
    }

    /**
     * Push into stack 
     * @param letter Character of username
     */
    public void stackPushLetter(Character letter)
    {
        stack.push(letter);
    }
    
    /**
     * a function which checks if it contains only letters, 
     * and the minimum length is 1
     * @param username String Username
     * @return If it valid return True, otherwise return False
     */
    public boolean checkIfValidUsernameRecursive(String username)
    {
        if(username.isEmpty())
            return false;
        else if(!username.matches("[a-zA-Z]+"))
            return false;
        else if(username.length() ==1)
            return true;
        else
            return checkIfValidUsernameRecursive(username.substring(1));
        
    }

    /**
     * The function write for overloading 
     * @return If it valid return True, otherwise return False
     */
    public boolean checkIfValidUsername()
    {
        boolean result;
        result = checkIfValidUsernameRecursive(this.getUsername());
        return result;
    }


    /**
     * a function which checks if the string password contains
     * at least one letter of the username.
     * @param password Password1 create for User
     * @return If it valid return True, otherwise return False
     */
    public boolean containUserNameSpirit( Password1 password)
    {
        
        //Create Stack Structure 
        stackPush(); //Stack consist username of letter
        password.stackPush(password.stackPasword); //stack consist password of letter

        while (!password.stackPasword.isEmpty()) {
            char c = password.stackPop(password.stackPasword);
            if (username.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}
