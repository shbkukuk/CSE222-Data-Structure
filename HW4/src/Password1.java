import java.util.Stack;

public class Password1 {
    /** The Password1 a class for Username for check the password1 is valid */

    //Data Field
    private String password;
    private int palindrome;
    private Stack<Character> stackBalance;
    protected Stack<Character> stackPasword;
    protected Stack<Character> stackPalindrome;


    //Constructor
    /**
     * Default Constructor
     * @param password1 String password.
     */
    public Password1(String password1){
        this.password = password1;
        this.stackPasword = new Stack<>();
        this.stackBalance = new Stack<>();
        this.stackPalindrome = new Stack<>();
        this.palindrome = 0;
    }

    //Set and Get functions 
    /**
     * Set new password
     * @param password1
     */
    public void setpassword(String password1)
    {
        this.password = password1;
    }
    
    /**
     * Get password
     * @return String password
     */
    protected String getpassword()
    {
        return this.password;

    }
    /**
     * Get lenght of password
     * @return int size of String
     */
    protected int getSize()
    {
        return this.password.length();
    }

    //Stack Helper Functions 
    /**
     * Create Stack and push chareacter of String password
     * one by one
     * @param stack
     */
    protected void stackPush(Stack<Character> stack)
    {
        int size = getSize();
        for(int i=0; i<size ; i++)
        {   if(Character.toString(this.getpassword().charAt(i)).matches("[a-zA-Z]+"))
                stack.push(this.getpassword().charAt(i));
        }
    }

    /**
     * Get top of stack and remove it
     * @param stack Stack 
     * @return Charachter of password
     */
    protected Character stackPop(Stack<Character> stack)
    {
        return stack.pop();
    }

    /**
     * See top of stack
     * @param stack Stack
     * @return Character of password
     */
    protected Character stackPeek(Stack<Character> stack)
    {
        return stack.peek();
    }

    /**
     * Push new element to stack
     * @param letter Character 
     * @param stack Stack
     */
    protected void stackPushLetter(Character letter,Stack<Character> stack)
    {
        stack.push(letter);
    }


    /**
     * Helper function for isBalancedPassword
     * @param c Character of bracklet 
     * @return If it is open True else False
     */
    private  boolean isOpenBracket(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    /**
     * Helper function for isBalancedPassword
     * @param c Character of bracklet 
     * @return  If it is closed True else False
     */
    private  boolean isCloseBracket(char c) {
        return c == ')' || c == '}' || c == ']';
    }
    
    /**
     * Helper function for isBalancedPassword
     * @param open Character of bracklet 
     * @param close Character of bracklet 
     * @return If it is matched True else False
     */
    private boolean isMatchingBracket(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }

    /**
     * In the given string  sequence, the function considers two
     *  brackets to be matching if the first bracket is an open 
     * bracket
     * @return If it is valid return True else False.
     */
    protected boolean isBalancedPassword()
    {
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (isOpenBracket(c)) {
                stackBalance.push(c);
            } else if (isCloseBracket(c)) {
                if (stackBalance.empty() || !isMatchingBracket(stackBalance.peek(), c)) {
                    return false;
                }
                stackBalance.pop();
            }
        }
        return stackBalance.empty();
    }

    /**
     * In the given string sequence, the function considers 
     * if it is possible to obtain a palindrome by rearranging the letters 
     * in the string.
     * @param stack Stack
     * @return If its valid return True, else False.
     */
    protected boolean isPalindromePossible(Stack<Character> stack)
    {
        
        int sizePassword = stack.capacity();;
        stackPush(stack);
        char x = stackPop(stack);
        for(int i=1; i<sizePassword; i++)
        {
            if(x==stackPeek(stack))
            {
                stackPop(stack);
                this.palindrome += 2;
                return isPalindromePossible(stack);
            }

        }
        if (this.palindrome %2 <=1)
            return true;
        else
            return false;
    }
    
    /**
     * Overlaoding function for any given password value
     * @return If its valid return True, else False.
     */
    protected boolean isPalindromePossibleCheck(){
        stackPush(stackPalindrome);
        return isPalindromePossible(stackPalindrome);
    }
}
