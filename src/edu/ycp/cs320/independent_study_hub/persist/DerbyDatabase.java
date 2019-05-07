package edu.ycp.cs320.independent_study_hub.persist;

import java.io.IOException;
import java.io.InputStream;
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
	public ArrayList<Project> selectProjectsByStudent(final String name) {
		return executeTransaction(new Transaction<ArrayList<Project>>() {
		@Override
			public ArrayList<Project> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					// retreive all attributes from both Books and Authors tables
					stmt = conn.prepareStatement(
							"select projects.* " +
									"  from projects " +
									" where projects.student_name = ?"
							);
					stmt.setString(1, name);
					ArrayList<Project> result = new ArrayList<Project>();
	
					resultSet = stmt.executeQuery();
	
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						
						// project : student__id, tudent, title, year, desc
						//jpeg is not in table creation as of now
						Project project = new Project();
						loadProject(project, resultSet, 1);
						result.add(project);
					}
	
					// check if anything was found
					if (!found) {
						System.out.println("Nothing was found");
					}
	
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	@Override
	public ArrayList<Student> selectStudentsByFacCode(final String code) {
		return executeTransaction(new Transaction<ArrayList<Student>>() {
			@Override
				public ArrayList<Student> execute(Connection conn) throws SQLException {
					PreparedStatement stmt = null;
					ResultSet resultSet = null;
					try {
						// retreive all attributes from both Books and Authors tables
						stmt = conn.prepareStatement(
								"select students.* " +
										"  from students " +
										" where students.faculty_code = ?"
								);
						stmt.setString(1, code);
						ArrayList<Student> result = new ArrayList<Student>();
		
						resultSet = stmt.executeQuery();
		
						// for testing that a result was returned
						Boolean found = false;
						
						while (resultSet.next()) {
							found = true;
							
							// project : student__id, tudent, title, year, desc
							//jpeg is not in table creation as of now
							Student s = new Student();
							loadStudent(s, resultSet, 1);
							result.add(s);
						}
		
						// check if anything was found
						if (!found) {
							System.out.println("Nothing was found");
						}
		
						return result;
					} finally {
						DBUtil.closeQuietly(resultSet);
						DBUtil.closeQuietly(stmt);
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
			
					stmt_prj = conn.prepareStatement(
							"select projects.* " +
									"  from projects " 
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
						System.out.println(project.get_student().get_name());

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
					stmt_getWork.setInt(1, year);
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
	public boolean insertChemical(final String chemical, final String use, final String dom, final int amount, final String media) {
		return executeTransaction(new Transaction<Boolean>()  {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				try {
					stmt = conn.prepareStatement(
							"insert into chemicals (name, use, dom, amount, media) " +
							"  values(?, ?, ?, ?, ?) "
					);
					stmt.setString(1, chemical);
					stmt.setString(2, use);
					stmt.setString(3, dom);
					stmt.setInt(4, amount);
					stmt.setString(5, media);
					// execute the update
					stmt.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});	
	}
	@Override
	public boolean deleteChemical(final String chemical, final String use, final String dom, final int amount, final String media) {
		return executeTransaction(new Transaction<Boolean>()  {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				try {
					stmt = conn.prepareStatement(
							"DELETE FROM chemicals where chemicals.name = ? and chemicals.use = ? and chemicals.dom = ? and chemicals.amount = ? and chemicals.media = ?"
						
					);
					stmt.setString(1, chemical);
					stmt.setString(2, use);
					stmt.setString(3, dom);
					stmt.setInt(4, amount);
					stmt.setString(5, media);
					// execute the update
					int del = stmt.executeUpdate();
				    System.out.println("Number of deleted records: " + del);
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});	
	}
	@Override
	public boolean insertStudent(final String name, final String password, final String email) {
		return executeTransaction(new Transaction<Boolean>()  {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				try {
					stmt = conn.prepareStatement(
							"insert into students (name, password, email) " +
							"  values(?, ?, ?) "
					);
					stmt.setString(1, name);
					stmt.setString(2, password);
					stmt.setString(3, email);
					
					// execute the update
					stmt.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});	
	}
	
	
	@Override
	public boolean insertFaculty(final String name, final String password, final String email) {
		return executeTransaction(new Transaction<Boolean>()  {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				try {
					stmt = conn.prepareStatement(
							"insert into faculty (name, password, email) " +
							"  values(?, ?, ?) "
					);
					stmt.setString(1, name);
					stmt.setString(2, password);
					stmt.setString(3, email);
					
					// execute the update
					stmt.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});	
	}
	
	@Override
	public boolean insertPendingFaculty(final String name, final String password, final String email) {
		return executeTransaction(new Transaction<Boolean>()  {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				try {
					stmt = conn.prepareStatement(
							"insert into pending_faculty (name, password, email) " +
							"  values(?, ?, ?) "
					);
					stmt.setString(1, name);
					stmt.setString(2, password);
					stmt.setString(3, email);
					
					// execute the update
					stmt.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});	
	}
	
	@Override
	public boolean deletePendingFaculty(final String name) {
		return executeTransaction(new Transaction<Boolean>()  {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				try {
					stmt = conn.prepareStatement(
							"delete from pending_faculty " +
							"  where name = ? "
					);
					stmt.setString(1, name);
					
					// execute the update
					stmt.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});	
	}
			
	@Override
	public boolean insertProject(final String title, final Student student, final String date, final String description, final InputStream inputStream, final String file_name) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;				
				ResultSet resultSet1 = null;
				ResultSet resultSet3 = null;
				ResultSet resultSet5 = null;				
				
				// for saving author ID and book ID
				Integer student_id = -1;
				Integer project_id   = -1;

				// try to retrieve author_id (if it exists) from DB, for Author's full name, passed into query
				try {
					stmt1 = conn.prepareStatement(
							"select students_id from students" +
							"  where students.name = ? "
					);
					stmt1.setString(1, student.get_name());
					
					
					// execute the query, get the result
					resultSet1 = stmt1.executeQuery();

					
					// if Author was found then save author_id					
					if (resultSet1.next())
					{
						student_id = resultSet1.getInt(1);
						System.out.println("Student <" + student.get_name() + "> found with ID: " + student_id);						
					}
					else
					{
						System.out.println("Student <" + student.get_name() + "> found with ID: " + student_id);
				
						// if the Author is new, insert new Author into Authors table
						if (student_id <= 0) {
							// prepare SQL insert statement to add Author to Authors table
							stmt2 = conn.prepareStatement(
									"insert into students (name, password, email) " +
									"  values(?, ?, ?) "
							);
							stmt2.setString(1, student.get_name());
							stmt2.setString(2, student.get_password());
							stmt2.setString(3, student.get_email());
							
							// execute the update
							stmt2.executeUpdate();
							
							System.out.println("New student <" + student.get_name() + ", " + student.get_password() + "," + student.get_email() + "> inserted into students table");						
						
							// try to retrieve author_id for new Author - DB auto-generates author_id
							stmt3 = conn.prepareStatement(
									"select student_id from students " +
									"  where students.name = ?"
							);
							stmt3.setString(1, student.get_name());
							
							// execute the query							
							resultSet3 = stmt3.executeQuery();
							
							// get the result - there had better be one							
							if (resultSet3.next())
							{
								student_id = resultSet3.getInt(1);
								System.out.println("New Student <" + student.get_name() + "> ID: " + student_id);						
							}
							else	// really should throw an exception here - the new author should have been inserted, but we didn't find them
							{
								System.out.println("New student <" + student.get_name() +  "> not found in Authors table (ID: " + student_id);
								return false;
							}
						}
					}
					
					// now insert new Book into Books table
					// prepare SQL insert statement to add new Book to Books table
					stmt4 = conn.prepareStatement(
							"insert into projects (students_id, student_name, title, date, description, image, file_name) " +
							"  values(?, ?, ?, ?, ?, ?, ?) "
					);
					stmt4.setInt(1, student_id);
					stmt4.setString(2, student.get_name());
					stmt4.setString(3, title);
					stmt4.setString(4, date);
					stmt4.setString(5, description);
					stmt4.setBlob(6,  inputStream);
					stmt4.setString(7,  file_name);
					
					// execute the update
					stmt4.executeUpdate();
					
					System.out.println("New project <" + title + "> inserted into projects table");					


					stmt5 = conn.prepareStatement(
							"select projects_id from projects " +
							"  where title = ? and date = ? and student_name = ? "
									
					);
					stmt5.setString(1, title);
					stmt5.setString(2, date);
					stmt5.setString(3, student.get_name());

					// execute the query
					resultSet5 = stmt5.executeQuery();
					
					// get the result - there had better be one
					if (resultSet5.next())
					{
						project_id = resultSet5.getInt(1);
						System.out.println("New project <" + title + "> ID: " + project_id);						
					}
					else	// really should throw an exception here - the new book should have been inserted, but we didn't find it
					{
						System.out.println("New project <" + title + "> not found in projects table (ID: " + project_id);
						return false;
					}
					
					// if we got down here, everything worked! so =return true
					return true;
					
				} finally {
					DBUtil.closeQuietly(resultSet1);
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);					
					DBUtil.closeQuietly(resultSet3);
					DBUtil.closeQuietly(stmt3);					
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(resultSet5);
					DBUtil.closeQuietly(stmt5);
				}
			}
		});
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
						return null;
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
	public Project get_project(final String title) {
		return executeTransaction(new Transaction<Project>() {
			@Override
			public Project execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt = conn.prepareStatement(
							"select projects.* " +
									"  from projects " +
									" where projects.title = ?"
							);
					stmt.setString(1, title);

					Project project = new Project();

					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;
						// loads our student object with what was found in the table
						loadProject(project, resultSet, 1);
					}

					// check if anything was found
					if (!found) {
						System.out.println("No Project was found");
						return null;
					}

					return project;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public Faculty get_faculty(final String acc_name) {
		return executeTransaction(new Transaction<Faculty>() {
			@Override
			public Faculty execute(Connection conn) throws SQLException {
				PreparedStatement stmt_1_fac = null;
				ResultSet resultSet_1_fac = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_1_fac = conn.prepareStatement(
							"select faculty.* " +
									"  from faculty " +
									" where faculty.name = ?"
							);
					stmt_1_fac.setString(1, acc_name);

					Faculty faculty = new Faculty();

					resultSet_1_fac = stmt_1_fac.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_1_fac.next()) {
						found = true;
						// loads our student object with what was found in the table
						//loadFaculty(faculty, resultSet_1_fac, 1);
						loadFaculty(faculty, resultSet_1_fac, 1);
					}

					// check if anything was found
					if (!found) {
						System.out.println("No Faculty was found with name: <" + acc_name + ">");
					}
					System.out.println(faculty.get_name() + "<-- from derby");
					return faculty;
				} finally {
					DBUtil.closeQuietly(resultSet_1_fac);
					DBUtil.closeQuietly(stmt_1_fac);
				}
			}
		});
	}
	
	@Override
	public ArrayList<Faculty> get_all_pending_faculty() {
		return executeTransaction(new Transaction<ArrayList<Faculty>>() {
			@Override
			public ArrayList<Faculty> execute(Connection conn) throws SQLException {
				PreparedStatement stmt_1_fac = null;
				ResultSet resultSet_1_fac = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_1_fac = conn.prepareStatement(
							"select pending_faculty.* " +
									"  from pending_faculty " 
							);

					ArrayList<Faculty> f_list = new ArrayList<Faculty>();

					resultSet_1_fac = stmt_1_fac.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_1_fac.next()) {
						found = true;
						Faculty f = new Faculty();
						loadPendingFaculty(f, resultSet_1_fac, 1);
						f_list.add(f);
					}

					// check if anything was found
					if (!found) {
						System.out.println("No Faculty was found");
					}
					return f_list;
				} finally {
					DBUtil.closeQuietly(resultSet_1_fac);
					DBUtil.closeQuietly(stmt_1_fac);
				}
			}
		});
	}
	
	@Override
	public ChemicalInventory get_chemical(final String chemical) {
		return executeTransaction(new Transaction<ChemicalInventory>() {
			@Override
			public ChemicalInventory execute(Connection conn) throws SQLException {
				PreparedStatement stmt_1_chem = null;
				ResultSet resultSet_1_chem = null;

				try {
					// retreive all attributes from both Books and Authors tables
					stmt_1_chem = conn.prepareStatement(
							"select chemicals.* " +
									"  from chemicals " +
									" where chemicals.name = ?"
							);
					stmt_1_chem.setString(1, chemical);

					ChemicalInventory chem = new ChemicalInventory();

					resultSet_1_chem = stmt_1_chem.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet_1_chem.next()) {
						found = true;
						// loads our student object with what was found in the table
						loadChemical(chem, resultSet_1_chem, 1);
					}

					// check if anything was found
					if (!found) {
						System.out.println("No Faculty was found with name: <" + chemical + ">");
					}

					return chem;
				} finally {
					DBUtil.closeQuietly(resultSet_1_chem);
					DBUtil.closeQuietly(stmt_1_chem);
				}
			}
		});
	}
	
	@Override
	public boolean update_faculty(final String email, final String old_name, final String pw, final String new_name, final String fac_code) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				System.out.println(old_name + "<- old name");
				Faculty f = get_faculty(old_name);
				System.out.println("old fac: " + f.get_name() + ", " + f.getID());
				try {
					// retreive all attributes from both Books and Authors tables
					stmt = conn.prepareStatement(
							"update faculty " +
									"  set email = ?, " +
									"  name = ?, " +
									"  password = ?, " +
									"  faculty_code = ? " +
									" where faculty.faculty_id = ?"
							);
					stmt.setString(1, email);
					System.out.println(new_name + " name from derby");
					stmt.setString(2, new_name);
					System.out.println(pw + " password from derby");
					stmt.setString(3,  pw);
					stmt.setString(4,  fac_code);
					stmt.setInt(5, f.getID());

					stmt.executeUpdate();

					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	
	
	@Override
	public boolean update_student(final String email, final String old_name, final String pw, final String new_name) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				System.out.println(old_name + "<- old name");
				Student s = get_student(old_name);
				System.out.println("old student: " + s.get_name() + ", " + s.getID());
				try {
					// retreive all attributes from both Books and Authors tables
					stmt = conn.prepareStatement(
							"update students " +
									"  set email = ?, " +
									"  name = ?, " +
									"  password = ? " +
									" where students_id = ?"
							);
					
					stmt.setString(1, email);
					System.out.println(new_name + " name from derby");
					stmt.setString(2, new_name);
					System.out.println(pw + " password from derby");
					stmt.setString(3,  pw);
					stmt.setInt(4, s.getID());

					stmt.executeUpdate();
					
					stmt2 = conn.prepareStatement( 
							"update projects " +
							"  set student_name = ? " +
							" where students_id = ?"
							);
					
					stmt2.setString(1,  new_name);
					stmt2.setInt(2,  s.getID());
					
					stmt2.executeUpdate();
					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	private void loadStudent(Student student, ResultSet resultSet, int i) throws SQLException {
		student.setID(resultSet.getInt(i++));
		student.setName(resultSet.getString(i++));
		student.setPassword(resultSet.getString(i++));
		student.setEmail(resultSet.getString(i++));
		student.set_faculty_code(resultSet.getString(i++));
	}
	
	private void loadFaculty(Faculty faculty, ResultSet resultSet, int i) throws SQLException {
		faculty.setID(resultSet.getInt(i++));
		faculty.setName(resultSet.getString(i++));
		faculty.setPassword(resultSet.getString(i++));
		faculty.setEmail(resultSet.getString(i++));
		faculty.setTitle(resultSet.getString(i++));
		faculty.setInterest(resultSet.getString(i++));
		faculty.setDescription(resultSet.getString(i++));
		String code = resultSet.getString(i++);
		System.out.println(code + "from db");
		faculty.setFacultyCode(code);
		faculty.setImg(resultSet.getString(i++));
	}
	
	private void loadPendingFaculty(Faculty faculty, ResultSet resultSet, int i) throws SQLException {
		faculty.setID(resultSet.getInt(i++));
		faculty.setName(resultSet.getString(i++));
		faculty.setPassword(resultSet.getString(i++));
		faculty.setEmail(resultSet.getString(i++));
	}
	
	private void loadProject(Project p, ResultSet r, int i) throws SQLException {
		p.set_p_id(r.getInt(i++));
		p.set_s_id(r.getInt(i++));
		String s = r.getString(i++);
		System.out.println(s);
		p.set_student(get_student(s));
		p.set_title(r.getString(i++));
		String date = r.getString(i++);
		p.set_date(date);
		p.set_description(r.getString(i++));
		p.set_image(r.getBytes(i++));
		p.set_file_name(r.getString(i++));
	}
	
	private void loadChemical(ChemicalInventory c, ResultSet r, int i) throws SQLException {
		c.setChemicalID(r.getInt(i++));
		c.setChemical(r.getString(i++));
		c.setUseOfChemcial(r.getString(i++));
		c.setDom(r.getString(i++));
		c.setAmount(r.getInt(i++));
		c.setMedia(r.getString(i++));
	}
	
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
				PreparedStatement stmt5 = null;
	
				try {
					stmt1 = conn.prepareStatement(
							"create table students (" +
									"	students_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +									
									"	name varchar(40), " +
									"	password varchar(40), " +
									"   email varchar(40), " +
									"   faculty_code varchar(40)" +
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
									"   date varchar(40), " +
<<<<<<< HEAD
									"   description varchar(1400), " +
									"   image blob, " +  
									"   file_name varchar(1400) " +
=======
									"   description varchar(1400) " +
							//		"   image varbinary(max)" +
>>>>>>> work
									")"
							);
					stmt2.executeUpdate();
					System.out.println("projects table created");
					
					//Creates the faculty table, sets the max value for each column in the
					//faculty table (i.e. a max of 40 characters can go in a cell under the name column)
					stmt3 = conn.prepareStatement(
							"create table faculty (" +
									"	faculty_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									" 	name varchar(40)," +
									" 	password varchar(40)," +
									" 	email varchar(40)," +
									"   title varchar(40)," +
									"   interest varchar(1400)," +
									"   description varchar(1400)," +
									"   faculty_code varchar(40), " +
<<<<<<< HEAD
									"   img varchar(100)" +
=======
									"   img varchar(40)" +
>>>>>>> work
									")"
							);
					stmt3.executeUpdate();
					System.out.println("faculty table completed");
					
					stmt5 = conn.prepareStatement(
							"create table pending_faculty (" +
									"	faculty_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									" 	name varchar(40)," +
									" 	password varchar(40)," +
									" 	email varchar(40)" +
									")"
								);
					
					stmt5.executeUpdate();
					System.out.println("pending faculty table completed");
					
					stmt4 = conn.prepareStatement(
							"create table chemicals (" +
									" 	chemicals_id integer primary key " +
									"		generated always as identity (start with 1, increment by 1), " +
									" 	name varchar(40)," + //Stores chemical name
									"   use  varchar(40)," + //Stores chemical use (class or research use)
									"   dom  varchar(10), " + //Stores date chemical was purchased (in format of MM/DD/YY)
									"   amount  integer, " +
									"   media  varchar(20) " +
									//" 	quantity integer" +
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
					insertStudents = conn.prepareStatement("insert into students (name, password, email, faculty_code) values (?, ?, ?, ?)");
					for (Student student : studentList) {
						//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertStudents.setString(1, student.get_name());
						insertStudents.setString(2, student.get_password());
						insertStudents.setString(3, student.get_email());
						insertStudents.setString(4, student.get_faculty_code());
						insertStudents.addBatch();
					}
					insertStudents.executeBatch();
	
					// populate projects table
					insertProjects = conn.prepareStatement("insert into projects (students_id, student_name, title, date, description) values (?, ?, ?, ?, ?)");
					for (Project project : projectList) {
						insertProjects.setInt(1, project.get_s_id());
						insertProjects.setString(2, project.get_student().get_name());
						insertProjects.setString(3, project.get_title());
						insertProjects.setString(4, project.get_date());
						insertProjects.setString(5, project.get_description());
						insertProjects.addBatch();
					}
					insertProjects.executeBatch();
					
					// populate faculty table
					insertFaculty = conn.prepareStatement("insert into faculty (name, password, email, title, interest, description, faculty_code, img) values (?, ?, ?, ?, ?, ?, ?, ?)");
					for (Faculty faculty : facultyList) {
						insertFaculty.setString(1, faculty.get_name());
						insertFaculty.setString(2, faculty.get_password());
						insertFaculty.setString(3, faculty.get_email());
						insertFaculty.setString(4, faculty.get_title());
						insertFaculty.setString(5, faculty.get_interest());
						insertFaculty.setString(6, faculty.get_description());
						insertFaculty.setString(7, faculty.get_fac_code());
						insertFaculty.setString(8, faculty.get_img());
						insertFaculty.addBatch();
					}
					insertFaculty.executeBatch();
					
					// populate the chemical table
					insertChemicals = conn.prepareStatement("insert into chemicals (name, use, dom, amount, media) values (?, ?, ?, ?, ?)");
					for (ChemicalInventory chemical : chemicalList) {
						insertChemicals.setString(1, chemical.getChemical());
						insertChemicals.setString(2, chemical.getUseOfChemical());
						insertChemicals.setString(3, chemical.getDom());
						insertChemicals.setInt(4, chemical.getAmount());
						insertChemicals.setString(5, chemical.getMedia());
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
