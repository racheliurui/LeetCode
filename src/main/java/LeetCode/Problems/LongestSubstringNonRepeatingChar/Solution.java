package LeetCode.Problems.LongestSubstringNonRepeatingChar;

import java.util.HashMap;

/**
 * Created by Rachel on 6/19/2017.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength=0;
        int startingPosition=0;
        int sLength= s.length();
        char[] stringchar = s.toCharArray();
        HashMap<Character, Integer>  uniqueChars =  new HashMap<Character, Integer>();
        for (int i=0;i<sLength;i++){
           Character currentChar = new Character(stringchar[i]);

           //already exist, found a unique substring, start a new hashmap
           if(uniqueChars.containsKey(currentChar)){
              if(maxLength<=(i-startingPosition))
                  maxLength=i-startingPosition; //update maxlengh

               //new start from after the duplicate; reset
               startingPosition =  uniqueChars.get(currentChar).intValue()+1;
               uniqueChars =  new HashMap<Character, Integer>();
               for(int j=startingPosition;j<=i;j++){
                   uniqueChars.put(new Character(stringchar[j]),new Integer(j));
               }

           }else{
               uniqueChars.put(new Character(stringchar[i]),new Integer(i));

               //if current char already is the last one, then check the current maxlengh
               if(i==sLength-1){
                   if(maxLength<=(i-startingPosition))
                       maxLength=i-startingPosition+1; //update maxlengh
               }
           }
        }

        return maxLength;

    }
}
