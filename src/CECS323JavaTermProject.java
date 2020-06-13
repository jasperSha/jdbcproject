package cecs.pkg323.java.term.project;

import java.sql.*;
import java.util.Scanner;


public class CECS323JavaTermProject {
    //  Database credentials
    static String USER;
    static String PASS;
    static String DBNAME;
    
    //display format should be adjusted for each function according to the VARCHAR size of each column
    static final String displayFormat="%-5s%-15s%-15s%-15s\n";
    
// JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static String DB_URL = "jdbc:derby://localhost:1527/";
//            + "testdb;user=";
/**
 * Takes the input string and outputs "N/A" if the string is empty or null.
 * @param input The string to be mapped.
 * @return  Either the input string or "N/A" as appropriate.
 * 
 * 
 */
    public static String dispNull (String input) {
        //because of short circuiting, if it's null, it never checks the length.
        if (input == null || input.length() == 0)
            return "N/A";
        else
            return input;
    }
    
    //handle year missing
    public static String dispNull (int input) {
        if (input == 0)
            return "N/A";
        else
            return Integer.toString(input);
    }
    public static void queryPublisherData (Connection conn) {
        //list ALL publisher data
        String displayFormat="%-25s%-25s%-15s%-20s\n";
        try {
            
            Statement stmt = conn.createStatement();
            String sql = "SELECT publisherName, publisherAddress, publisherPhone, publisherEmail FROM Publishers";

            ResultSet rs = stmt.executeQuery(sql);
            
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "Name", "Address", "Phone", "Email");

            while (rs.next()) {

                    //Retrieve by column name
                    String name = rs.getString("PUBLISHERNAME");
                    String address = rs.getString("PUBLISHERADDRESS");
                    String phone = rs.getString("PUBLISHERPHONE");
                    String email = rs.getString("PUBLISHEREMAIL");

                    //Display values
                    System.out.printf(displayFormat, 
                            dispNull(name), dispNull(address), dispNull(phone), dispNull(email));
                } 


            rs.close();
            stmt.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        
    }
    
    public static void queryPublisherData (Connection conn, String publisher) {
        //list specific publisher data
        String displayFormat="%-25s%-25s%-15s%-20s\n";
        try {
            
            
            System.out.printf("Querying %s now...\n",publisher);
            String stmt = "SELECT publisherName, publisherAddress, publisherPhone, publisherEmail FROM Publishers  WHERE publisherName = ?";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            pstmt.setString(1, publisher);


            ResultSet rs = pstmt.executeQuery();
            
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "Name", "Address", "Phone", "Email");

            while (rs.next()) {

                    //Retrieve by column name
                    String name = rs.getString("PUBLISHERNAME");
                    String address = rs.getString("PUBLISHERADDRESS");
                    String phone = rs.getString("PUBLISHERPHONE");
                    String email = rs.getString("PUBLISHEREMAIL");

                    //Display values
                    System.out.printf(displayFormat, 
                            dispNull(name), dispNull(address), dispNull(phone), dispNull(email));
                } 


            rs.close();
            pstmt.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        
    }
   
    public static void queryWritingGroups (Connection conn) {
        //list all writing groups
        String displayFormat="%-25s%-25s%-12s%-15s\n";
        try {
            
            Statement stmt = conn.createStatement();
            String sql = "SELECT groupName, headWriter, yearFormed, subject FROM WritingGroups";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "Group Name", "Headwriter", "Year Formed", "Subject");

            while (rs.next()) {

                    //Retrieve by column name
                    String name = rs.getString("groupName");
                    String head = rs.getString("headWriter");
                    int year = rs.getInt("yearFormed");
                    String subject = rs.getString("subject");

                    //Display values
                    System.out.printf(displayFormat, 
                            dispNull(name), dispNull(head), dispNull(year), dispNull(subject));
                } 


            rs.close();
            stmt.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        
   
    }
    
    public static void queryWritingGroups (Connection conn, String group) {
        //query specific writing group
        String displayFormat="%-25s%-25s%-12s%-15s\n";
        try {
            System.out.printf("Querying %s now...\n", group);
            String stmt = "SELECT groupName, headWriter, yearFormed, subject FROM WritingGroups WHERE groupName = ?";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            pstmt.setString(1, group);


            ResultSet rs = pstmt.executeQuery();
            
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "Group Name", "Head Writer", "Year Formed", "Subject");

            while (rs.next()) {

                    //Retrieve by column name
                    String name = rs.getString("groupName");
                    String head = rs.getString("headWriter");
                    int year = rs.getInt("yearFormed");
                    String subject = rs.getString("subject");

                    //Display values
                    System.out.printf(displayFormat, 
                            dispNull(name), dispNull(head), dispNull(year), dispNull(subject));
                } 


            rs.close();
            pstmt.close();
            
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        
   
    }
    
    public static void queryBookData (Connection conn) {
        //list ALL book data
        String displayFormat="%-25s%-25s%-12s%-15s\n";
        try {
            
            Statement stmt = conn.createStatement();
            String sql = "SELECT groupName, bookTitle, publisherName, yearPublished, numberPages FROM Books";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "Group Name", "Title", "Publisher", "Publication Year", "Number of Pages");

            while (rs.next()) {

                    //Retrieve by column name
                    String groupName = rs.getString("groupName");
                    String title = rs.getString("bookTitle");
                    String publisher = rs.getString("publisherName");
                    int year = rs.getInt("yearPublished");
                    int pages = rs.getInt("numberPages");

                    //Display values
                    System.out.printf(displayFormat, 
                            dispNull(groupName), dispNull(title), dispNull(publisher), dispNull(year), dispNull(pages));
                } 


            rs.close();
            stmt.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        
    }
    
    public static void queryBookData (Connection conn, String book) {
        //query specific book
        String displayFormat="%-25s%-25s%-12s%-15s\n";
        try {
            System.out.printf("Querying %s now...\n", book);
            String stmt = "SELECT groupName, bookTitle, publisherName, yearPublished, numberPages FROM Books WHERE bookTitle = ?";
            PreparedStatement pstmt = conn.prepareStatement(stmt);
            pstmt.setString(1, book);


            ResultSet rs = pstmt.executeQuery();
            
            //STEP 5: Extract data from result set
            System.out.printf(displayFormat, "Group Name", "Title", "Publisher", "Publication Year", "Number of Pages");

            while (rs.next()) {

                    //Retrieve by column name
                    String groupName = rs.getString("groupName");
                    String title = rs.getString("bookTitle");
                    String publisher = rs.getString("publisherName");
                    int year = rs.getInt("yearPublished");
                    int pages = rs.getInt("numberPages");

                    //Display values
                    System.out.printf(displayFormat, 
                            dispNull(groupName), dispNull(title), dispNull(publisher), dispNull(year), dispNull(pages));
                } 
            
            
            rs.close();
            pstmt.close();
            
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } 
        
   
    }
    
    
    
    
    public static void main(String[] args) {
        //Prompt the user for the database name, and the credentials.
        //If your database has no credentials, you can update this code to 
        //remove that from the connection string.
        Scanner scnr = new Scanner(System.in);
        System.out.print("Name of the database is jdbcwritinggroupsproject.");
        DBNAME = "jdbcwritinggroupsproject";
        System.out.print("\nNo credentials required for this database...");
        
        //Constructing the database URL connection string
        DB_URL = DB_URL + DBNAME;
        Connection conn = null; //initialize the connection
        Statement stmt = null;  //initialize the statement that we're using
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //STEP 3: Open a connection
            System.out.println("\nConnecting to database...");
            conn = DriverManager.getConnection(DB_URL);
            
            //testing publisher query with user input
            Boolean input = true;
            while (input) {
                System.out.println("\nWhat would you like to do?"
                        + "\n1) List all writing groups"
                        + "\n2) Query data for a specific writing group"
                        + "\n3) List all publishers"
                        + "\n4) Query publisher data"
                        + "\n10) Quit");
                int choice = scnr.nextInt();
                scnr.nextLine(); //handles the carriage return bug of scanner
                switch (choice) {
                    case 1: 
                        queryWritingGroups(conn);
                        break;
                        
                    case 2: 
                        System.out.println("Enter name of Writing Group");
                        String group = scnr.nextLine();
                        queryWritingGroups(conn, group);
                        break;
                        
                    case 3:
                        queryPublisherData(conn);
                        break;
                        
                    case 4: 
                        System.out.println("Please enter the name of the publisher");
                        String publisher = scnr.nextLine();
                        queryPublisherData(conn, publisher);
                        break;
                            
                            
                    case 10: 
                        System.out.println("Shutting down.");
                        input = false;
                        break;
                        
                    default: 
                        System.out.println("Invalid input, please enter an integer");
                    

                }
          
            
            }
            
            //STEP 6: Clean-up environment
            
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample}
