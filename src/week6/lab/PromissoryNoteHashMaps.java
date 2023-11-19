package week6.lab;

import java.util.HashMap;

public class PromissoryNoteHashMaps {
    class PromissoryNote
    {
        private HashMap<String, Double> promissoryNote;
        public PromissoryNote()
        {
           this.promissoryNote=new HashMap<String, Double>();
        }
        public void setLoan(String toWhom, double value)
        {
            promissoryNote.put(toWhom, value);
        }
        public double howMuchIsTheDebt(String whose)
        {
            if(promissoryNote.containsKey(whose)) //ako određena osoba koja je preuzeta iz parametra ima dug, return that debt.
            {
                return promissoryNote.get(whose);  //vraća i osobu a i iznos duga (key and value)
            }
            return 0;     //that person doesnt have a debt.
        }
    }
}//Attention! The promissory note does not need to take into account old loans.
// When you set a new debt to a person who has an old one, the old one is canceled.

