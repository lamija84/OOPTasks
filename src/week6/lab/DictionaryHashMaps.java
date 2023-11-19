package week6.lab;

import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryHashMaps {
    class Dictionary
    {
        private HashMap<String, String> dictionary;
        public Dictionary()
        {
            this.dictionary=new HashMap<String, String>();
        }
        public String translate(String word)
        {
           if(dictionary.containsKey(word))
           {
               return dictionary.get(word);
           }
        return null;
        }
        public void add(String word, String translation)
        {
            dictionary.put(word, translation);
        }
        public int amountOfWords()
        {
            return dictionary.size();   //size() method to get the number of key-value mappings in the map.
        }
        public ArrayList<String> translationList()
        {
            ArrayList<String> translationList=new ArrayList<String>();

            for(String k : dictionary.keySet())
            {
                translationList.add(k + " = " + dictionary.get(k));
            }
            return translationList;
        }
    }
}
