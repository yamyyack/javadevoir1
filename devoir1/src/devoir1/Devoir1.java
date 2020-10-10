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
    private static String OldWord = "";

    public static String palindrome(String str, int start, int end, int center){


        try{
            //exit recursion (doesnt work)
            if(center > str.length() - 1)
            {
                return OldWord;
                
            }
            //check if the character next to it is the same (aaa)
            if(str.charAt(center)==str.charAt(center+1)){
                return palindrome(str, start, end+1,center+1);
            }
            //checks to see if both ajacent are the same (aba)
            else if(str.charAt(start-1) == str.charAt(end+1)){
                return palindrome(str, start-1, end+1, center);
            }
            //if non are move to next starting character
            else{
                getword(str, start, end);
                return palindrome(str, center+1, center+1, center+1);
            }
        }
        catch(StringIndexOutOfBoundsException e)
        {
            if(center != str.length())
                getword(str, start, end);
            return palindrome(str, center+1, center+1, center+1);

        }
    }
    
    public static void getword(String str, int start, int end)
    {
        String NewWord = str.substring(start, end+1);
        if(NewWord.length() > OldWord.length()){
            OldWord = NewWord;
        }
        
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(palindrome(name,0,0,0));
        System.out.println(OldWord.length());
    }

}