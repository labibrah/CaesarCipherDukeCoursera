
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class TestCaesarCipher {
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
        CaesarCipher cc = new CaesarCipher(15);
        FileResource fr = new FileResource();
        String input = fr.asString();

        String encrypted = cc.encrypt(input);
        System.out.println(encrypted);

        String decrypted = cc.decrypt(encrypted);

        System.out.println(decrypted);
        String broken = breakCaesarCipher(input);

        System.out.println(input);
        

    }

    public String breakCaesarCipher(String input){
        int freqs[] = countLetters(input);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4-maxDex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        String message = cc.decrypt(input);

        return message;
    }
}
