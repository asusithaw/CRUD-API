// Java program to implement
// the above approach
import java.util.*;
class GFG{

    // Function to convert vowels
// into uppercase
    static void conVowUpp(char[] str)
    {
// Stores the length
// of str
        int N = str.length;

        for (int i = 0; i < N; i++)
        {
            if (str[i] == 'a' || str[i] == 'e' ||
                    str[i] == 'i' || str[i] == 'o' ||
                    str[i] == 'u')
            {
                char c = Character.toUpperCase(str[i]);
                str[i] = c;
            }
        }

        for(char k : str) {
            System.out.print( k);}
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str = "eutopia";
        conVowUpp(str.toCharArray());
    }
}

// This code is contributed by 29AjayKumar
