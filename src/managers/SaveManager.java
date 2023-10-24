/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Melnikov
 */
public class SaveManager {
    public void saveBooks(Book[] books){
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream("books");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
            fos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("File \"books\" does not exist");
        } catch (IOException ex) {
            System.out.println("Error I/O books");
        }
    }
    public Book[] loadBooks(){
        Book[] books = new Book[0];
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream("books");
            ois = new ObjectInputStream(fis);
            books = (Book[]) ois.readObject();
        } catch (FileNotFoundException ex) {
           System.out.println("File \"books\" does not exist"); 
        } catch (IOException ex) {
           System.out.println("Error I/O books");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Book not found");
        }
        return books;
    }
}
