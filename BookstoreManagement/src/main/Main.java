/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package main;

import java.util.List;

import dao.BookDAO;
import implementation.BookDAOImplementation;
import model.Book;

public class Main {
    public static BookDAO bookDAO = new BookDAOImplementation();

    public static void main(String[] args) {
        // List all books
        System.out.println("Listing all books:");
        findAllBooks();
        System.out.println();

        // search book by keyword
        // By book title
        System.out.println("Search book by keyword in book title: Groovy");
        searchBooks("Groovy");
        System.out.println();

        // By author name
        System.out.println("Search book by keyword in author's name: Josh");
        searchBooks("Josh");
        System.out.println();
    }

    private static void findAllBooks() {
        List<Book> books = bookDAO.findAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void searchBooks(String keyWord) {
        List<Book> books = bookDAO.searchBooksByKeyword(keyWord);
        for (Book book : books) {
            System.out.println(book);
        }
    }
}