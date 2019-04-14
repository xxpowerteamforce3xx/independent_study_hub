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

import com.sun.imageio.plugins.jpeg.JPEG;

import edu.ycp.cs320.independent_study_hub.model.ChemicalInventory;
import edu.ycp.cs320.independent_study_hub.model.Faculty;
import edu.ycp.cs320.independent_study_hub.model.Guest;
import edu.ycp.cs320.independent_study_hub.model.Project;
import edu.ycp.cs320.independent_study_hub.model.Student;
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
	public ArrayList<Student> get_all_students() {
		return executeTransaction(new Transaction<ArrayList<Student>>() {
			@Override
			public ArrayList<Student> execute(Connection conn) throws SQLException {
				PreparedStatement stmt_student = null;
				ResultSet resultSet_student = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_student = conn.prepareStatement(
							"select students.* " +
									"  from students " + 
									" order by students.name asc"
							);


					ArrayList<Student> result = new ArrayList<Student>();

					resultSet_student = stmt_student.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_student.next()) {
						found = true;

						// creates a student object, and starts the index at 1
						Student student = new Student();
						loadStudent(student, resultSet_student, 1);


						result.add(student);
					}

					// check if the title was found
					if (!found) {
						System.out.println("Nothing was found");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet_student);
					DBUtil.closeQuietly(stmt_student);
				}
			}
		});
	}

	@Override
	public ArrayList<Faculty> get_all_faculty() {
		return executeTransaction(new Transaction<ArrayList<Faculty>>() {
			@Override
			public ArrayList<Faculty> execute(Connection conn) throws SQLException {
				PreparedStatement stmt_fac = null;
				ResultSet resultSet_fac = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_fac = conn.prepareStatement(
							"select faculty.* " +
									"  from faculty " +
									" order by faculty.name asc"
							);


					ArrayList<Faculty> result = new ArrayList<Faculty>();

					resultSet_fac = stmt_fac.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_fac.next()) {
						found = true;

						// creates a student object, and starts the index at 1
						Faculty faculty = new Faculty();
						loadFaculty(faculty, resultSet_fac, 1);


						result.add(faculty);
					}

					// check if anything was found
					if (!found) {
						System.out.println("Nothing was found");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet_fac);
					DBUtil.closeQuietly(stmt_fac);
				}
			}
		});
	}

	@Override
	public ArrayList<Project> get_all_projects() {
		return executeTransaction(new Transaction<ArrayList<Project>>() {
			@Override
			public ArrayList<Project> execute(Connection conn) throws SQLException {
				PreparedStatement stmt_prj = null;
				ResultSet resultSet_prj = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_prj = conn.prepareStatement(
							"select projects.* " +
									"  from projects " +
									" order by projects.student_name asc"
							);


					ArrayList<Project> result = new ArrayList<Project>();

					resultSet_prj = stmt_prj.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet_prj.next()) {
						found = true;
						
						// project : student__id, tudent, title, year, desc
						//jpeg is not in table creation as of now
						Project project = new Project();
						loadProject(project, resultSet_prj, 1);


						result.add(project);
					}

					// check if anything was found
					if (!found) {
						System.out.println("Nothing was found");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet_prj);
					DBUtil.closeQuietly(stmt_prj);
				}
			}
		});
	}

	@Override
	public ArrayList<ChemicalInventory> get_all_chemicals() {
		return executeTransaction(new Transaction<ArrayList<ChemicalInventory>>() {
			@Override
			public ArrayList<ChemicalInventory> execute(Connection conn) throws SQLException {
				PreparedStatement stmt_chem = null;
				ResultSet resultSet_chem = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_chem = conn.prepareStatement(
							"select chemicals.* " +
									"  from chemicals " +
									" order by chemicals.name asc"
							);


					ArrayList<ChemicalInventory> result = new ArrayList<ChemicalInventory>();

					resultSet_chem = stmt_chem.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_chem.next()) {
						found = true;
						int i = 1;
						// creates a student object, and starts the index at 1
						ChemicalInventory chem = new ChemicalInventory();
						loadChemical(chem, resultSet_chem, i);


						result.add(chem);
					}

					// check if anything was found
					if (!found) {
						System.out.println("Nothing was found");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet_chem);
					DBUtil.closeQuietly(stmt_chem);
				}
			}
		});
	}
	
	@Override
	public ArrayList<Project> getWorkFromYear(final int year) {
		return executeTransaction(new Transaction<ArrayList<Project>>() {
			@Override
			public ArrayList<Project> execute(Connection conn) throws SQLException {
				PreparedStatement stmt_getWork = null;
				ResultSet resultSet_getWork = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_getWork = conn.prepareStatement(
							"select projects.* " +
									"  from projects " +
									" where projects.date = ?"
							);
					stmt_getWork.setInt(year, 1);
					ArrayList<Project> result = new ArrayList<Project>();

					resultSet_getWork = stmt_getWork.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet_getWork.next()) {
						found = true;
						
						// project : student__id, tudent, title, year, desc
						//jpeg is not in table creation as of now
						Project project = new Project();
						loadProject(project, resultSet_getWork, 1);
						result.add(project);
					}

					// check if anything was found
					if (!found) {
						System.out.println("Nothing was found");
					}

					return result;
				} finally {
					DBUtil.closeQuietly(resultSet_getWork);
					DBUtil.closeQuietly(stmt_getWork);
				}
			}
		});
	}

	@Override
	public boolean insertChemical(String chemical, String use, int dom) {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean insertProject(String title, Student student, int year, String description, JPEG image,
			int workID) {
				return false;
		// TODO Auto-generated method stub
	}

	@Override
	public Guest get_guest(String acc_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student get_student(final String acc_name) {
		return executeTransaction(new Transaction<Student>() {
			@Override
			public Student execute(Connection conn) throws SQLException {
				PreparedStatement stmt_1_student = null;
				ResultSet resultSet_1_student = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_1_student = conn.prepareStatement(
							"select students.* " +
									"  from students " +
									" where students.name = ?"
							);
					stmt_1_student.setString(1, acc_name);

					Student student = new Student();

					resultSet_1_student = stmt_1_student.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_1_student.next()) {
						found = true;
						// loads our student object with what was found in the table
						loadStudent(student, resultSet_1_student, 1);
					}

					// check if anything was found
					if (!found) {
						System.out.println("No Student was found");
					}

					return student;
				} finally {
					DBUtil.closeQuietly(resultSet_1_student);
					DBUtil.closeQuietly(stmt_1_student);
				}
			}
		});
	}

	@Override
	public Faculty get_faculty(String acc_name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ChemicalInventory getChemical(String chemcial) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void loadStudent(Student student, ResultSet resultSet, int i) throws SQLException {
		student.setID(resultSet.getInt(i++));
		student.setName(resultSet.getString(i++));
		student.setPassword(resultSet.getString(i++));
		student.setEmail(resultSet.getString(i++));
	}
	
	private void loadFaculty(Faculty faculty, ResultSet resultSet, int i) throws SQLException {
		faculty.setID(resultSet.getInt(i++));
		faculty.setName(resultSet.getString(i++));
		faculty.setPassword(resultSet.getString(i++));
		faculty.setEmail(resultSet.getString(i++));
	}
	
	private void loadProject(Project p, ResultSet r, int i) throws SQLException {
		p.set_p_id(r.getInt(i++));
		p.set_s_id(r.getInt(i++));
		p.set_student(get_student(r.getString(i++)));
		p.set_title(r.getString(i++));
		p.set_year(r.getInt(i++));
		p.set_description(r.getString(i++));
	}
	
	private void loadChemical(ChemicalInventory c, ResultSet r, int i) throws SQLException {
		c.setChemicalID(r.getInt(i++));
		c.setChemical(r.getString(i++));
		c.setUseOfChemcial(r.getString(i++));
		c.setDom(r.getInt(i++));
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
									"	name varchar(40), " +
									"	password varchar(40), " +
									"   email varchar(40) " +
									")"
							);	
					stmt1.executeUpdate();
					System.out.println("students table created");
	
					stmt2 = conn.prepareStatement(
							"create table projects (" +
									"	projects_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									"	students_id integer constraint students_id references students, " +
									"	student_name varchar(40), " +
									"	title varchar(40), " +
									"   date integer, " +
									"   description varchar(40), " +
									"   image_url varchar(40)" +
									")"
							);
					stmt2.executeUpdate();
					System.out.println("projects table created");
					
					stmt3 = conn.prepareStatement(
							"create table faculty (" +
									"	faculty_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									" 	name varchar(40)," +
									" 	password varchar(40)," +
									" 	email varchar(40)" +
									")"
							);
					stmt3.executeUpdate();
					System.out.println("faculty table completed");
					
					stmt4 = conn.prepareStatement(
							"create table chemicals (" +
									" 	chemicals_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									" 	name varchar(40)," +
									"   use  varchar(40)," +
									" 	quantity integer" +
									")"
							);
					stmt4.executeUpdate();
					System.out.println("chemicals table completed");
					
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
				List<Faculty> facultyList;
				List<Student> studentList;
				List<Project> projectList;
				List<ChemicalInventory> chemicalList;
	
				try {
					facultyList = InitialData.get_faculty_users();
					studentList = InitialData.get_student_users();
					projectList = InitialData.getProjects();
					chemicalList = InitialData.getChemicals();
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}
	
				PreparedStatement insertStudents  = null;
				PreparedStatement insertProjects  = null;
				PreparedStatement insertFaculty   = null;
				PreparedStatement insertChemicals = null;
				
				try {
					// populate student table first since it is foreign key in projects table
					insertStudents = conn.prepareStatement("insert into students (name, password, email) values (?, ?, ?)");
					for (Student student : studentList) {
						//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertStudents.setString(1, student.get_name());
						insertStudents.setString(2, student.get_password());
						insertStudents.setString(3, student.get_email());
						insertStudents.addBatch();
					}
					insertStudents.executeBatch();
	
					// populate projects table
					insertProjects = conn.prepareStatement("insert into projects (students_id, student_name, title, date, description) values (?, ?, ?, ?, ?)");
					for (Project project : projectList) {
						insertProjects.setInt(1, project.get_s_id());
						insertProjects.setString(2, project.get_student().get_name());
						insertProjects.setString(3, project.get_title());
						insertProjects.setInt(4, project.get_year());
						insertProjects.setString(5, project.get_description());
						insertProjects.addBatch();
					}
					insertProjects.executeBatch();
					
					// populate faculty table
					insertFaculty = conn.prepareStatement("insert into faculty (name, password, email) values (?, ?, ?)");
					for (Faculty faculty : facultyList) {
						insertFaculty.setString(1, faculty.get_name());
						insertFaculty.setString(2, faculty.get_email());
						insertFaculty.setString(3, faculty.get_email());
						insertFaculty.addBatch();
					}
					insertFaculty.executeBatch();
					
					// populate the chemical table
					insertChemicals = conn.prepareStatement("insert into chemicals (name, use, quantity) values (?, ?, ?)");
					for (ChemicalInventory chemical : chemicalList) {
						insertChemicals.setString(1, chemical.getChemical());
						insertChemicals.setString(2, chemical.getUseOfChemical());
						insertChemicals.setInt(3, chemical.getDom());
						insertChemicals.addBatch();
					}
					insertChemicals.executeBatch();
					return true;
				} finally {
					DBUtil.closeQuietly(insertProjects);
					DBUtil.closeQuietly(insertStudents);
					DBUtil.closeQuietly(insertFaculty);
					DBUtil.closeQuietly(insertChemicals);
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

}
