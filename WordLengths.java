
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
import java.lang.Character;
public class WordLengths {
    public void countWordLengths (FileResource resource, int[] counts){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for(String s : resource.words()){
            int currLen = s.length();
            int currCounter = 0;
            //StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < s.length();i++){
                char ch = s.charAt(i);
                char qu = '\'';

                if(Character.isAlphabetic(ch) || ch =='\''||ch =='-'){
                    currCounter += 1;
                }

        
            }
            if(currCounter >= 30){counts[currCounter] += 1;}
            else{counts[currCounter] += 1;};
        }

    }

    public Integer indexOfMax(int[] counts){
        int maxIndx = 0;
        for(int i = 1; i < counts.length;i++){

            if(maxIndx< counts[i]){
                maxIndx = counts[i];
            }
        }
        return maxIndx;
    }


    public void testcountWordLengths(){
        FileResource fr = new FileResource();

        int[] counts = new int[30];
        countWordLengths(fr, counts);
        for(int i = 1; i < counts.length;i++){
            if(counts[i] != 0){
                System.out.println(counts[i]+ " words of length: "+ i);
            }

        }
        System.out.println("The most common word length in the file: "+ indexOfMax(counts));
    }
}
