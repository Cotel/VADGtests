package com.tonilopezmr.vadgtests.doubles;

import java.util.ArrayList;

public class BookShop {

  private ArrayList<Book> books = new ArrayList<>();
  private DeliveryBooks deliveryBooks = new DeliveryBooks();

  public void add(Book book) {
    books.add(book);
    doesSomethingElse(book);
  }

  public void delivery(String name) throws BookNotFoundException {
    Book book = findBookByName(name);
    if (book == null) throw new BookNotFoundException();
    deliveryBooks.delivery(book);
  }

  public int booksCount() {
    return books.size();
  }

  public double totalAmount() {
    double total = 0;
    for (Book book : books) {
      total += book.price;
    }
    return total;
  }

  private Book findBookByName(String name) {
    for (Book book : books) {
      if (book.name.equals(name)) {
        return book;
      }
    }

    return null;
  }



























































  private void doesSomethingElse(Book book) {
    books.add(book);
  }
}
