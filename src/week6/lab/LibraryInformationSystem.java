package week6.lab;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LibraryInformationSystem {
    class Book
    {
        private String title;
        private String publisher;
        private int year;

        public Book(String title,String publisher, int year)
        {
            this.title=title;
            this.publisher=publisher;
            this.year=year;
        }
        public String title()
        {
            return this.title;
        }

        public String publisher()
        {
            return this.publisher;
        }

        public int year()
        {
            return this.year;
        }
         public String toString()
         {
             return this.title + " " + this.publisher + " " + this.year;
         }
    }
     class Library
    {
        private List<Book> library;  //private static ArrayList<Book> library = new ArrayList<Book>();
        public Library()
        {
            this.library=new ArrayList<Book>();
        }
        public void addBook(Book newBook)
        {
            library.add(newBook);
        }
        public void printBooks()
        {
            for(Book b: library)
            {
                System.out.println(b);
            }
        }
        public ArrayList<Book> searchByTitle(String title)
        {
            ArrayList<Book> found=new ArrayList<Book>(); //program will return what we were looking for(title,publisher and year)
            for(Book b : library)
            {
                if(b.title.contains(title))  //  if(b.title().equals(title)){found.add(b)};
                {
                    found.add(b);
                }
                //if(StringUtils.included(b.title(), title)){
                   // found.add(b);}
            }
            return found;
        }

    }
    class StringUtils
    {
        public static boolean included(String word, String searched)
        {
            word=word.toUpperCase();
            searched=searched.toUpperCase();
            return word.contains(searched);

        }
    }
}
