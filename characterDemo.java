
/**
 * Write a description of characterDemo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;


public class characterDemo {
    public void testChar(){
    String test = "ABC123aa#$";
    for(int i =0; i<test.length();i++){
        char ch = test.charAt(i);
    if(Character.isDigit(ch)){
        System.out.println(ch + " is digit");
        
    
    }
    else if(Character.isAlphabetic(ch)){System.out.println(ch + "is an alphabet");}
    }
    }
    public void conversionTest(){
        String test = "ABC123aa#$";
        char ch;
        char upch;
        char lch;
        for(int i =0; i<test.length();i++){
         ch = test.charAt(i);
         upch = Character.toUpperCase(ch);
         lch =  Character.toLowerCase(ch);
        
    
        System.out.println(ch + " " + upch + " " + lch);
        
    
    }
   
    }
    
    }


