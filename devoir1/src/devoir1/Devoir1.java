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
    
    
    
public static void main(String[] args) throws IOException
    {
        BufferedReader reader =
                   new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(name);       
    }
    
}
