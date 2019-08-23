package dao;

import java.util.List;

import model.Book;
import model.Category;

public interface BookDAO {
	public List<Book> findAllBooks();
	public List<Book> searchBooksByKeyword(String keyword);
	public List<Category> findAllCategories();
	public void insert(Book book);
	public void update(Book book);
	public void delete(Book book);
}