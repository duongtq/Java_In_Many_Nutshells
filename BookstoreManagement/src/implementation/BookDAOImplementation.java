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

package implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDAO;
import model.Author;
import model.Book;
import model.Category;

public class BookDAOImplementation implements BookDAO {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager
            .getConnection("jdbc:mysql://localhost:3306/books?useSSL=false", "tranduong", "09031998d.");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "SELECT * FROM BOOK INNER JOIN AUTHOR ON BOOK.ID = AUTHOR.BOOK_ID";
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            resultSet.first();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();

                book.setId(resultSet.getLong("ID"));
                book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                book.setCategoryId(resultSet.getLong("CATEGORY_ID"));

                author.setId(resultSet.getLong("ID"));
                author.setBookId(resultSet.getLong("BOOK_ID"));
                author.setFirstName(resultSet.getString("FIRST_NAME"));
                author.setLastName(resultSet.getString("LAST_NAME"));

                authorList.add(author);
                book.setAuthors(authorList);
                book.setPublisherName(resultSet.getString("PUBLISHER"));

                result.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Book> searchBooksByKeyword(String keyword) {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();

        String sql = "SELECT * FROM BOOK INNER JOIN AUTHOR ON BOOK.ID = AUTHOR.BOOK_ID"
                    + " WHERE BOOK_TITLE LIKE '%"
                    + keyword.trim()
                    + "%'"
                    + " OR FIRST_NAME LIKE '%"
                    + keyword.trim()
                    + "%'"
                    + " OR LAST_NAME LIKE '%"
                    + keyword.trim()
                    + "%'";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            resultSet.first();

            Book book = new Book();
            Author author = new Author();

            book.setId(resultSet.getLong("id"));
            book.setBookTitle(resultSet.getString("BOOK_TITLE"));
            book.setPublisherName(resultSet.getString("PUBLISHER"));

            author.setFirstName(resultSet.getString("FIRST_NAME"));
            author.setLastName(resultSet.getString("LAST_NAME"));
            author.setBookId(resultSet.getLong("BOOK_ID"));

            authorList.add(author);
            book.setAuthors(authorList);
            result.add(book);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Category> findAllCategories() {
        List<Category> result = new ArrayList<>();
        String sql = "select * from category";

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            resultSet.first();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setCategoryDescription(resultSet.getString("category_description"));
                result.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public void insert(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }
}
