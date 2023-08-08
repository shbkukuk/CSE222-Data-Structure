public class Password2 {
    /** Password 2  a class that represent a password for userç*/

    //Data Field
    private int password2;


    //Constructor
    /**
     * Create new object from Password2
     * @param password int value
     */
    public Password2(int password)
    {
        this.password2 = password;
    }
    

    //Set and Get functions 
    /**
     * Set new valur to password2
     * @param password
     */
    public void setpassword(int password)
    {
        this.password2 = password;
        
    }
    
    /**
     * Get password2 
     * @return int password
     */
    protected int getpassword()
    {
        return this.password2;

    }

    /**
     * Considering the given list of the denominations, the function determines 
     * if it is possible to obtain the assword by the summation 
     * of denominations along with arbitrary coefficients, which are
     * non-negative integers
     * @param password int value of password2
     * @param denominations Array of intenger
     * @return IF it is valid, True else False
     */
    public  boolean isExactDivision(int password, int[] denominations) {
        return exactDivisionHelper(password, denominations, 0);
    }

    /**
     * function checks if the remainder is zero, which means we have found a valid 
     * combination of denominations that adds up to the password.
     * @param remainder After submission we get int value.
     * @param denominations  Array of intenger
     * @param index int index of denominations
     * @return If the remainder is zero, we return true.
     */
    private boolean exactDivisionHelper(int remainder, int[] denominations, int index) {
        // Base case: the remainder is zero, so the function have found a valid combination of denominations
        if (remainder == 0) {
            return true;
        }
        
        // Recursive case: try subtracting each denomination from the remainder
        for (int i = index; i < denominations.length; i++) {
            int denomination = denominations[i];
            if (denomination <= remainder) {
                boolean result = exactDivisionHelper(remainder - denomination, denominations, i);
                if (result) {
                    return true;
                }
            }
        }
        
        // If the function reach this point, the function  have tried all possible combinations without success
        return false;
    }

}
