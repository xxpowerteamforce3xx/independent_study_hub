package edu.ycp.cs320.independent_study_hub.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.fake_db.user_models.PreviousWork;
import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
import edu.ycp.cs320.independent_study_hub.model.User;
import edu.ycp.cs320.independent_study_hub.persist.IDatabase;


public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}

	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;
	
	@Override
	public ArrayList<User> get_user(String acc_name, int acc_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChemicalInventory> insertChemical(int chemicalID, String chemical, String use, int dom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChemicalInventory> getChemicals(int dom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Project> getWorkFromYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Project> insertPreviousWork(String name, String title, String description, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChemicalInventory> insertChemical(String chemical, String use, int dom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Project> insertProject(String title, Student student, int year, String description, JPEG image,
			int workID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Guest get_guest(String acc_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student get_student(String acc_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Faculty get_faculty(String acc_name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public List<Pair<Author, Book>> findAuthorAndBookByTitle(final String title) {
		return executeTransaction(new Transaction<List<Pair<Author,Book>>>() {
			@Override
			public List<Pair<Author, Book>> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt = conn.prepareStatement(
							"select authors.*, books.* " +
									"  from authors, books " +
									" where authors.author_id = books.author_id " +
									"   and books.title = ?"
							);
					stmt.setString(1, title);

					List<Pair<Author, Book>> result = new ArrayList<Pair<Author,Book>>();

					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						// create new Author object
						// retrieve attributes from resultSet starting with index 1
						Author author = new Author();
						loadAuthor(author, resultSet, 1);

						// create new Book object
						// retrieve attributes from resultSet starting at index 4
						Book book = new Book();
						loadBook(book, resultSet, 4);

						result.add(new Pair<Author, Book>(author, book));
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + title + "> was not found in the books table");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}*/
public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
	try {
		return doExecuteTransaction(txn);
	} catch (SQLException e) {
		throw new PersistenceException("Transaction failed", e);
	}
}

public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
	Connection conn = connect();

	try {
		int numAttempts = 0;
		boolean success = false;
		ResultType result = null;

		while (!success && numAttempts < MAX_ATTEMPTS) {
			try {
				result = txn.execute(conn);
				conn.commit();
				success = true;
			} catch (SQLException e) {
				if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
					// Deadlock: retry (unless max retry count has been reached)
					numAttempts++;
				} else {
					// Some other kind of SQLException
					throw e;
				}
			}
		}

		if (!success) {
			throw new SQLException("Transaction failed (too many retries)");
		}

		// Success!
		return result;
	} finally {
		DBUtil.closeQuietly(conn);
	}
}

private Connection connect() throws SQLException {
	Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");

	// Set autocommit to false to allow execution of
	// multiple queries/statements as part of the same transaction.
	conn.setAutoCommit(false);

	return conn;
}


// TODO: figure out how to create tables 
}


public void createTables() {
	executeTransaction(new Transaction<Boolean>() {
		@Override
		public Boolean execute(Connection conn) throws SQLException {
			PreparedStatement stmt1 = null;
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			PreparedStatement stmt4 = null;

			try {
				stmt1 = conn.prepareStatement(
						"create table students (" +
								"	students_id integer primary key " +
								"		generated always as identity (start with 1, increment by 1), " +									
								"	name varchar(40)," +
								"	password varchar(40)" +
								"   email varchar(40) " +
								")"
						);	
				stmt1.executeUpdate();

				stmt2 = conn.prepareStatement(
						"create table projects (" +
								"	projects_id integer primary key " +
								"		generated always as identity (start with 1, increment by 1), " +
								"	projects_id integer constraint students_id references students, " +
								"	student_name varchar(40)," +
								"	title varchar(40)" +
								"   date varchar(40) " +
								"   description(40)  " +
								"   image_url varchar(40)" +
								")"
						);
				stmt2.executeUpdate();
				
				stmt3 = conn.prepareStatement(
						"create table faculty (" +
						""	
						);
						

				return true;
			} finally {
				DBUtil.closeQuietly(stmt1);
				DBUtil.closeQuietly(stmt2);
			}
		}
	});
}

public void loadInitialData() {
	executeTransaction(new Transaction<Boolean>() {
		@Override
		public Boolean execute(Connection conn) throws SQLException {
			List<Author> authorList;
			List<Book> bookList;

			try {
				authorList = InitialData.getAuthors();
				bookList = InitialData.getBooks();
			} catch (IOException e) {
				throw new SQLException("Couldn't read initial data", e);
			}

			PreparedStatement insertAuthor = null;
			PreparedStatement insertBook   = null;

			try {
				// populate authors table (do authors first, since author_id is foreign key in books table)
				insertAuthor = conn.prepareStatement("insert into authors (lastname, firstname) values (?, ?)");
				for (Author author : authorList) {
					//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
					insertAuthor.setString(1, author.getLastname());
					insertAuthor.setString(2, author.getFirstname());
					insertAuthor.addBatch();
				}
				insertAuthor.executeBatch();

				// populate books table (do this after authors table,
				// since author_id must exist in authors table before inserting book)
				insertBook = conn.prepareStatement("insert into books (author_id, title, isbn, published) values (?, ?, ?, ?)");
				for (Book book : bookList) {
					//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
					insertBook.setInt(1, book.getAuthorId());
					insertBook.setString(2, book.getTitle());
					insertBook.setString(3, book.getIsbn());
					insertBook.setInt(4,  book.getPublished());
					insertBook.addBatch();
				}
				insertBook.executeBatch();

				return true;
			} finally {
				DBUtil.closeQuietly(insertBook);
				DBUtil.closeQuietly(insertAuthor);
			}
		}
	});
}

// The main method creates the database tables and loads the initial data.
public static void main(String[] args) throws IOException {
	System.out.println("Creating tables...");
	DerbyDatabase db = new DerbyDatabase();
	db.createTables();

	System.out.println("Loading initial data...");
	db.loadInitialData();

	System.out.println("Success!");
}
}*/
