
/**
 * Write a description of wordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.lang.Character;
/*Write a method isVowel that has one Char parameter named ch. This method returns true 
if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and 
false otherwise. You should write a tester method to see if this method works correctly. 
For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.*/

public class wordPlay {
    /*Write a method isVowel that has one Char parameter named ch. This method returns true 
     * if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and 
     * false otherwise. You should write a tester method to see if this method works correctly. 
     * For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.*/
    public boolean isVowel(Character ch){
        String vowels = "AEIOUaeiou";

        StringBuilder character = new StringBuilder(ch);

        
        for(int i = 0;i < vowels.length();i++){
            char currChar = ch;
            int indxAlpha = vowels.indexOf(currChar);
            if(indxAlpha != -1){
                return true;
            }

        }

       
        return false;
    }

    public void testIsVowel(){
        System.out.println(isVowel('A'));
    }
    
    /*Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. 
    This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. 
    For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. 
    Be sure to call the method isVowel that you wrote and also test this method.*/
    
    public String replaceVowels(String phrase, Character ch){
        StringBuilder input = new StringBuilder(phrase);

        for (int i = 0;i< phrase.length() ;i++){
            char currCh = input.charAt(i);
            if(isVowel(currCh)){
             input.setCharAt(i,ch);
            }
        }
        String output = input.toString();
        return output;
    }
    public void testReplaceVowels(){
        System.out.println(replaceVowels("Hello world",'*'));
    }
    
    public String emphasize(String phrase, Character ch){
        StringBuilder input = new StringBuilder(phrase);
        for (int i = 0;i< phrase.length() ;i++){
            char currCh = input.charAt(i);
            if(phrase.charAt(i) == ch){
                if(i % 2 == 0){
             input.setCharAt(i,'*');
            }
            else{
                 input.setCharAt(i,'+');
            }
            }
            
        }
        String output = input.toString();
        return output;
    }
    public void testEmphasize(){
        System.out.println(emphasize("dna ctgaaactga",'a'));
    }
    
}
