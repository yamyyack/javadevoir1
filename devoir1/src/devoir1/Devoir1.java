/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoir1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 *
 * @author yamyyack
 */
public class Devoir1 {

    /**
     * @param args the command line arguments
     */
    // Function to find maximum
// of the two variables
    static int max(int x, int y)
    {
        return (x > y) ? x : y;
    }

    // Function to find the longest
// palindromic subString : Recursion
    static int longestPalindromic(String str, int i, int j, int count)
    {

        // Base condition when the start
        // index is greater than end index
        if (i > j)
            return count;

        // Base condition when both the
        // start and end index are equal
        if (i == j)
            return (count + 1);

        // Condition when corner characters
        // are equal in the String
        if (str.charAt(i) == str.charAt(j)) {

            // Recursive call to find the
            // longest Palindromic String
            // by excluding the corner characters
            count = longestPalindromic(str, i + 1,
                    j - 1, count + 2);
            return max(count,
                    max(longestPalindromic(str, i + 1, j, 0),
                            longestPalindromic(str, i, j - 1, 0)));
        }

        // Recursive call to find the
        // longest Palindromic String
        // by including one corner
        // character at a time
        return Math.max(
                longestPalindromic(str, i + 1, j, 0),
                longestPalindromic(str, i, j - 1, 0));
    }

    // Function to find the longest
// palindromic sub-String
    static int longest_palindromic_substr(String str)
    {
        // Utility function call
        return longestPalindromic(str, 0,
                str.length() - 1, 0);
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str = "aaaabbaa";

        // Function Call
        System.out.print(longest_palindromic_substr(str));
    }
    
}
