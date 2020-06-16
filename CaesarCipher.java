
/**
 * Write a description of CeaseeCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;

public class CaesarCipher {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);

        mainKey = key;

    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        //System.out.println(alphabet);

        for(int i = 0;i < encrypted.length();i++){
            char currChar = encrypted.charAt(i);
            //System.out.println(currChar);
            if(Character.isUpperCase(currChar)){
                int indxAlpha = alphabet.indexOf(currChar);
                //System.out.println(indxAlpha);
                if(indxAlpha != -1){
                    char newChar = shiftedAlphabet.charAt(indxAlpha);
                    encrypted.setCharAt(i,newChar);
                }
            }
            else{
                currChar = Character.toUpperCase(currChar);
                int indxAlpha = alphabet.indexOf(currChar);
                if(indxAlpha != -1){
                    char newChar = shiftedAlphabet.charAt(indxAlpha);
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i,newChar);}
            }

       
        }
        return encrypted.toString();
    }

    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey); 
        String messageOut = cc.encrypt(input);
        return messageOut;
    }
}

/*public String encryptTwoKeys(String input, int key1,int key2){
StringBuilder encrypted = new StringBuilder(input);
String encryptKeyOne = encrypt(input, key1);
String encryptKeyTwo = encrypt(input, key2);
for(int i = 0;i < encrypted.length();i++){

if(i % 2 == 0){
char currChar = encryptKeyOne.charAt(i);
encrypted.setCharAt(i,currChar);
}
else{
char currChar = encryptKeyTwo.charAt(i);
encrypted.setCharAt(i,currChar);
}
}
return encrypted.toString();
}
public void testEncryptTwoKeys(){
int i,j;
for(i = 0;i< 26;i++){
for(j = 0;j < 26;j++){
System.out.println(encryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko",i,j));
}
}
}*/

