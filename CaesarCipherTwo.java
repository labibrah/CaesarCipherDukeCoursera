
/**
 * Write a description of CeaserCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class CaesarCipherTwo {

    private String alphabet;

    private String shiftedAlphabet1;
    private String shiftedAlphabet2 ;
    private int keyOne,keyTwo;
    public CaesarCipherTwo(int key1,int key2){
   alphabet  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

   shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2= alphabet.substring(key2) + alphabet.substring(0,key2);
        keyOne = key1;
        keyTwo = key2;

    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);

        
        

        for(int i = 0;i < encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            if(i % 2 == 0){
            if(Character.isUpperCase(currChar)){
                int indxAlpha = alphabet.indexOf(currChar);
               
                if(indxAlpha != -1){
                    char newChar = shiftedAlphabet1.charAt(indxAlpha);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else{
                currChar = Character.toUpperCase(currChar);
                int indxAlpha = alphabet.indexOf(currChar);
                if(indxAlpha != -1){
                    char newChar = shiftedAlphabet1.charAt(indxAlpha);
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i,newChar);}
            }
        }
        else{
            if(Character.isUpperCase(currChar)){
                int indxAlpha = alphabet.indexOf(currChar);
               
                if(indxAlpha != -1){
                    char newChar = shiftedAlphabet2.charAt(indxAlpha);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else{
                currChar = Character.toUpperCase(currChar);
                int indxAlpha = alphabet.indexOf(currChar);
                if(indxAlpha != -1){
                    char newChar = shiftedAlphabet2.charAt(indxAlpha);
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i,newChar);}
            }
       
        }
       
        
        
    }
    return encrypted.toString();
}
    public String decrypt(String input){
        CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - keyOne,26-keyTwo); 
        String messageOut = cc2.encrypt(input);
        return messageOut;
    }
}


