/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5:5]
- Comment: Method defined correctly as Arraylist.
- My method reads the words from the "words.txt" file. [Mark out of 5:5]
- Comment: Yes.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5:5]
- Comment: Yes.

2. readWordList
- I have the correct method definition [Mark out of 5:5]
- Comment: Method defined correctly as Arraylist.
- My method reads the words provided (which are separated by commas, saves them to an array or ArrayList of String references and returns it. [Mark out of 5:5]
- Comment: Yes returned as an ArrayList.

3. isUniqueList
- I have the correct method definition [Mark out of 5:5]
- Comment: Method defined correctly as Boolean.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5:5]
- Comment: Yes.
- Exits the loop when a non-unique word is found. [Mark out of 3:5]
- Comment: Not sure.
- Returns true is all the words are unique and false otherwise. [Mark out of 5:5]
- Comment: Yes, I think so.

4. isEnglishWord
- I have the correct method definition [Mark out of 5:5]
- Comment: Method defined correctly as Boolean.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3:3]
- Comment: Used binarySearch function.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2:2]
- Comment: Used as recommended.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5:5]
- Comment: Method defined correctly as Boolean.
- My method loops through the length of a words comparing characters at the same position in both words searching for one difference. [Mark out of 10:10]
- Comment: Inputs two words and compares them by incrementing through the characters.

6. isWordChain
- I have the correct method definition [Mark out of 5:]
- Comment: Method defined correctly as Boolean
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 4]
- Comment: Doesn't acknowledge the for loop for some reason.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using the any of teh Java.IO classes covered in lectures [Mark out of 10:10]
- Comment: Done correctly
- Asks the user for input and calls isWordChain [Mark out of 5:5]
- Comment: Done correctly

 Total Mark out of 100 (Add all the previous marks): 92
*/



import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;


public class WordGame {

	public static void main(String[] args) {
		
        ArrayList<String> dictionary = new ArrayList<String>();
        try{
            FileReader fileReader = new FileReader("words.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            dictionary = readDictionary(bufferedReader);
        } catch (Exception e){
            System.out.print(e);
        }
        
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        while(!finished){
            System.out.print("Enter a comma separated list of words (or an empty list to quit):");
            String words = input.nextLine();
            
            if(words.equals("")){
            	System.out.print("Aight, Imma head out");
            	finished = true;
            } else {
                ArrayList<String> wordList = readWordList(words);
                
                isWordChain(wordList, dictionary);
                
            }
        }
        input.close();          
	}

	 public static ArrayList<String> readDictionary(BufferedReader dictionary){
	        ArrayList<String> listOfWords = new ArrayList<String>();
	        
	        try {
		        String word = dictionary.readLine();
		        while(word != null){
		        	listOfWords.add(word);
		            word = dictionary.readLine();
		        }
	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	        return listOfWords;
	    }
	 
	 
	 public static ArrayList<String> readWordList(String words){
		 ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words.split(" , ")));
		 return wordList;
	 }
	 
	 
	 public static Boolean isEnglishWord(String word, ArrayList<String> dictionary) {
		 String[] dictionaryArray = dictionary.toArray(new String[dictionary.size()]);
		 if(Arrays.binarySearch(dictionaryArray, word) >= 0) return true;
		 else return false;
	 }
	 
	 
	 public static boolean isUniqueList(ArrayList<String> wordList){
		 boolean unique = true;
	        for (int i = 0;i<wordList.size();i++) {
	            String wordOne = wordList.get(i);
	            for (int j=0;j<wordList.size();j++) {
	                if (i!=j) {
	                    String wordTwo = wordList.get(j);
	                    if (wordOne.equalsIgnoreCase(wordTwo))
	                        unique = false;
	                }
	            }
	        }
	        return unique;
	 }
	 
	 
	 public static Boolean isDifferentByOne(String word, String otherWord) {
		 if(word.length() == otherWord.length()){
	            boolean different =  false;
	            for(int i = 0; i < word.length(); i++){
	                if(word.charAt(i) != otherWord.charAt(i)) {
	                    if(different)
	                        return false;
	                    else
	                        different = true;
	                }
	            }
	            return true;
	        }
	        return false;
	 }

	
	public static void isWordChain(ArrayList<String> wordList, ArrayList<String> dictionary){
		if(isUniqueList(wordList)){
			for(int i = 0; i < wordList.size()-1; i++){
				if(isEnglishWord(wordList.get(i), dictionary) && isEnglishWord(wordList.get(i+1), dictionary)){
					if(isDifferentByOne(wordList.get(i), wordList.get(i+1))) System.out.println("Valid chain of words from Lewis Carroll's word-links game.");
		                } else {
		                	System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
		                }
		            }
		       	} else {
		       		System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
		       	}
		System.out.println("Not a valid chain of words from Lewis Carroll's word-links game.");
		    }
		}
