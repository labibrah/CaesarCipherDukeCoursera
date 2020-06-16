
/**
 * Write a description of TestCeaserCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.lang.Character;
public class TestCeaserCipherTwo {
    public String halfOfString(String message,int start){

        String newMessage ="";

        for(int i = start; i< message.length(); i+= 2){
            {

                newMessage = newMessage + message.charAt(i);
            }

        }
        return newMessage;
    }
    public int[] countLetters(String message){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i = 0; i< message.length();i++){
            char ch = message.charAt(i);
            ch = Character.toLowerCase(ch);
            int dex = alphabet.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public Integer maxIndex(int[] counts){
        int maxNum = 0;
        int maxIndx=0;
        for(int i = 0; i < counts.length;i++){

            if(maxNum< counts[i]){
                maxNum = counts[i];
                maxIndx = i;
            }
        }
        return maxIndx;
    }
    public void simpleTests(){
    CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
        FileResource fr = new FileResource();
        String input = fr.asString();

        String encrypted = cc.encrypt(input);
        System.out.println(encrypted);

        String decrypted = cc.decrypt(input);

        System.out.println(decrypted);
    System.out.println(breakCaesarCipher(input));
    }
      public Integer key (String s){
        int[] count = countLetters(s);
        int maxDex = maxIndex(count);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    public String breakCaesarCipher(String input){
     

        

        String firstHalf = halfOfString(input,0);
        String secondHalf = halfOfString(input,1);
        int keyOne = key(firstHalf);
        int keyTwo = key(secondHalf);
        System.out.println("Key one: " + keyOne+"\n"+"Key two: " + keyTwo);
        CaesarCipherTwo cc = new CaesarCipherTwo(keyOne,keyTwo);
        String message = cc.decrypt(input);
        return message;
    }
    
}
