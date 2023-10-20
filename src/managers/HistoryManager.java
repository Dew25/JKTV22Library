/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;


/**
 *
 * @author Melnikov
 */
public class HistoryManager{
    private Scanner scanner;
    private ReaderManager readerManager;
    private BookManager bookManager;
    
    public HistoryManager(Scanner scanner,BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = readerManager;
        this.bookManager = bookManager;
    }
    public History giveOutBook(Book[] books, Reader[] readers){
        History history = new History();
        /*
         *  1. вывести спиок читателей
         *  2. попросить прользователя выбрать номер читателя из списка
         *  3. добавить выбранного читателя из массива readers в history
         *  4. сделать 1-3 пункт для книги
         *  5. добавить в history дату выдачи книги (текущую дату)
         */
        readerManager.printListReaders(readers);
        int selectedReaderNumber = scanner.nextInt(); scanner.nextLine();
        history.setReader(readers[selectedReaderNumber-1]);
        bookManager.printListBooks(books);
        int selectedBookNumber = scanner.nextInt(); scanner.nextLine();
        history.setBook(books[selectedBookNumber-1]);
        history.setDateOnHand(new GregorianCalendar().getTime());
        return history;
    }

    public void returnBook(History[] histories) {
        bookManager.printListGiveOutBooks(histories);
        System.out.print("Select book for return: ");
        int historyNumber = scanner.nextInt(); scanner.nextLine();
        histories[historyNumber-1].setDateBack(new GregorianCalendar().getTime());
        System.out.printf("Book \"%s\" returned%n", 
                histories[historyNumber-1].getBook().getTitle()
        );
    }
    
}
