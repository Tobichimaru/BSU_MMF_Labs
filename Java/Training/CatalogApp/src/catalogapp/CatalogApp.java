/*
Создать класс Catalog с внутренним классом, с помощью объектов которого можно 
хранить информацию об истории выдач книги читателям.
*/

package catalogapp;

import java.security.InvalidParameterException;
import java.util.ArrayList;

class Book {
    private String name;
    private String author;
    
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
    
    public String toString() {
        return "Book \"" + name + "\" by " + author;
    }
}
    
class Reader {
    private static int counter;
    private int id;
    private String name;

    //Статический конструктор, вызывается один раз за время работы приложения
    static {
        counter = 0;
    }

    public Reader(String name) {
        counter++;
        id = counter;
        this.name = name;
    }
    
    public String toString() {
        return "Reader id = " + Integer.toString(id) + "; Name = " + name;
    }
}

class Catalog {
    private ArrayList<Record> records;
    
    public Catalog() {
        records = new ArrayList<Record>();
    }
            
    public void addRecord(Reader reader, Book book, int days) {
        records.add(new Record(reader, book, days));
    }     
    
    public String toString() {
        return records.toString();
    }

    private class Record {
        private Book book;
        private Reader reader;
        private int days; //количество дней, на которое выдали книгу
        
        public Record(Reader reader, Book book, int days) {
            if (days <= 0)
                throw new InvalidParameterException("Rent period should be positive!");
            this.book = book;
            this.reader = reader;
            this.days = days;
        }
        
        public String toString() {
            return "\n\nRecord:\n" + book.toString() + "\n" + reader.toString();
        }
    }
}

public class CatalogApp {
    
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Book book1 = new Book("Harry Potter", "J.K.Rowling");
        Book book2 = new Book("The lord of the Rings", "Tolkien");
        Book book3 = new Book("Sherlock Holmes", "K.Doyle");
        Reader reader1 = new Reader("John");
        Reader reader2 = new Reader("Teddy");
        
        catalog.addRecord(reader1, book1, 3);
        catalog.addRecord(reader1, book2, 14);
        catalog.addRecord(reader2, book1, 7);
        catalog.addRecord(reader1, book3, 5);
        catalog.addRecord(reader2, book2, 25);
        
        System.out.println(catalog.toString());
    }
    
}
