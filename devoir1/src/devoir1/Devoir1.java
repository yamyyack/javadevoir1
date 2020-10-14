/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devoir1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 *
 * @author yamyyack
 */
public class Devoir1 {
    private static ArrayList<String> WordList = new ArrayList<String>();

    public static ArrayList<String> 
        palindrome(String str, int start, int end, int center){
            
        try{
            //exit recursion (doesnt work)
            if(center > str.length() - 1)
            {
                return WordList;
            }
            //verifie si le charactere a la droite est identique au centre (aaa)
            if(str.charAt(center)==str.charAt(center+1)){
                return palindrome(str, start, end+1,center+1);
            }
            //verifie si les deux charactere adjacent au centre sont pareil (aba)
            else if(str.charAt(start-1) == str.charAt(end+1)){
                return palindrome(str, start-1, end+1, center);
            }
            //sinon il deplace le centre de une case (loop)
            else{
                setword(str, start, end);
                return palindrome(str, center+1, center+1, center+1);
            }
        }
        //si la position desirer est pas dispobible (position -1)
        catch(StringIndexOutOfBoundsException e)
        {
            if(center != str.length())
                setword(str, start, end);
            return palindrome(str, center+1, center+1, center+1);

        }
    }
    
    public static void setword(String str, int start, int end)
    {
        //trouve le mot a la position definit pas l'algorithm
        String NewWord = str.substring(start, end+1);
        //si le mot est plus grand on efface la list et ajoute le mot
        if(NewWord.length() > WordList.get(0).length()){
            WordList.clear();
            WordList.add(NewWord);
        }
        //si le mot est la meme longeur on l'ajoute dans la liste
        else if(NewWord.length() == WordList.get(0).length()){
            WordList.add(NewWord);
        }
    }

    public static void main(String[] args) throws IOException
    {
        //initialise la liste de mot
        WordList.add("");
        //initialise l'entrer d'information
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        //les espace sont conciderer comme un charactere valid dans ce programme
        System.out.print("ecrire le mot que vous "+
                "voulez trouver un palendrome : ");
        //prend l'entrer de l'utilisateur
        String name = reader.readLine();
        //cherche le palendrome dans le mot
        palindrome(name,0,0,0);
        System.out.println("Le plus long palendrome est de longeur " 
                + WordList.get(0).length());
        System.out.println("il y en a " + WordList.size() 
                + " de cette longeur : ");
        for(String word : WordList)
        {
            System.out.println(word);
        }
    }

}