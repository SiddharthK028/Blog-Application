Sunbase Assignment:

This project aims to develop a web application for managing blog posts with user roles and authentication. The application will have two user roles: Admin and Viewer.
Technologies:
-Java Servlets (backend)
-JSP (frontend)
-MySQL Database

My Approach to this particular requirement:

Phase 1: User Registration and Login (Frontend & Backend):
 
 -Firstly I created user registration form using front end technologies i.e HTML5 and CSS3 that captures the user details i.e name,email,password and role(admin/viwer).(The code will be uploaded into the GITHUB).

Explaination of Registration form.
HTML Structure:

The form is enclosed within <form> tags, specifying action (where form data should be sent) and method (HTTP method to use, typically POST for form submissions).
Form Fields:

Name: <input type="text" id="name" name="name" required> captures the user's name.
Email: <input type="email" id="email" name="email" required> captures the user's email address.
Password: <input type="password" id="password" name="password" required> captures the user's chosen password.
Role: <select id="role" name="role" required> allows the user to select either "Admin" or "Viewer" as their role.
Submit Button:

<input type="submit" value="Register"> is a button that submits the form data to the server.
Styling:

Basic CSS is included within <style> tags to improve the appearance of the form. This includes setting a max-width, adding padding, borders, and box shadows to the form container.
Validation:

The required attribute on input fields ensures that the user must fill out these fields before submitting the form.

Implement user registration logic in a Servlet to validate user data, store it securely in the MySQL database (using hashing for passwords), and assign a role.

-To implement user registration logic in a Servlet that validates user data, securely stores it in a MySQL database (with hashed passwords), and assigns a role. And I followed some steps for this approach:

1.Create Database table:
  
  I created schema called Sunbase in that I created a table called User to store all the data from front end.

2. Create Servlet to handle User Registration:

   I Created a Servlet (UserRegistrationServlet.java) that handles user registration. This   Servlet will receive data from the registration form, validate it, hash the password, and store the user information in the database.

Create a login page with username/email and password fields.

- For this I used HTML5 and CSS3 and created simple login page.

Implement login logic in a Servlet to authenticate users against the database.

-To implement login logic in a Servlet to authenticate users against the database:

Retrieve User Input: Obtain username/email and password from the login form submission.

Database Query: Query the MySQL database to fetch user details based on the provided username/email.

Compare Passwords: Compare the hashed password retrieved from the database with the hashed password provided by the user. If they match, authenticate the user and establish a session; otherwise, deny access.

Upon successful login, establish user sessions using either cookies or sessions for role identification.

-To establish user sessions upon successful login using cookies or sessions for role identification:

Set Session Attributes: In the Servlet handling login, after validating user credentials against the database, set session attributes such as username and role (e.g., "Admin" or "Viewer").

Use HttpSession: Retrieve the HttpSession object from the request and set session attributes using setAttribute() method, e.g., session.setAttribute("username", username) and session.setAttribute("role", userRole).

Access Control: Throughout the application, validate user roles stored in session attributes to control access to different functionalities and pages based on user permissions.


Phase 2: Admin Dashboard (Frontend & Backend):

Develop an Admin dashboard accessible only after successful login with the "Admin" role.

To develop an Admin dashboard accessible only after successful login with the "Admin" role:

Role-Based Access Control: Implement a servlet filter or check within each servlet to verify if the user session contains the "Admin" role attribute.

Redirect Unauthorized Access: If a user attempts to access the Admin dashboard without the "Admin" role, redirect them to a login page or display an access denied message.

Secure Navigation: Ensure that URLs leading to the Admin dashboard are protected and only accessible to users authenticated with the "Admin" role, maintaining security and access control throughout the application.

Design functionalities for the Admin to:
Create new blog posts with title, content, and an option to upload images/videos.
Update existing blog posts (title, content, image/video).
Delete blog posts.

-To design functionalities for the Admin to manage blog posts:

Create Functionality: Develop a form in JSP for Admins to enter blog post details (title, content) and upload images/videos using <input type="file">. Implement a Servlet to handle form submission, store data in the database, and securely store uploaded files.

Update Functionality: Provide an interface to retrieve existing blog posts with options to edit title, content, and replace existing image/video uploads. Implement update logic in a Servlet to modify database records accordingly.

Delete Functionality: Enable Admins to select and delete blog posts via a management interface. Implement a Servlet endpoint to handle delete requests, ensuring proper deletion from both database and file storage (if applicable).


Implement Servlets to handle these functionalities:
Store uploaded images/videos securely in the database (consider using a separate table or library for efficient storage).
Perform data validation and sanitization to prevent security vulnerabilities (e.g., SQL injection).

-To implement Servlets for handling blog post functionalities securely:

File Handling and Storage: Use Apache Commons FileUpload or Servlet 3.0 multipart support to handle file uploads in the Servlet. Store uploaded images/videos securely by saving them to a designated directory on the server and storing file metadata (e.g., file path, content type) in the database.

Data Validation and Sanitization: Validate and sanitize input data (e.g., blog post titles, content) using Java validation APIs (like Bean Validation) and sanitize inputs using methods like PreparedStatement in JDBC to prevent SQL injection attacks. Ensure all user inputs are properly validated and escaped before interacting with the database to mitigate security vulnerabilities.

Phase 3: User Interface for Viewers (Frontend):
-To design a user-friendly interface for viewers to browse blog posts:

Display Blog Posts: Create a JSP page to fetch and display blog posts from the database, showing titles, excerpts, and dates.

Implement Pagination: Implement pagination to limit the number of posts displayed per page, enhancing usability and performance.

Include Search and Sorting: Add functionalities for viewers to search posts by title or date, and provide sorting options to organize posts chronologically or by relevance.

Implement functionalities for viewers to:
Search blog posts by title or date.
Implement pagination and sorting for search results (consider using libraries like Apache Commons DbUtils).
View individual blog posts in detail, opening them in a new tab.

-To implement viewer functionalities:

Search Functionality: Create a form in JSP for users to input search criteria (title or date). Implement a Servlet to query the database based on the search parameters and display results on a dedicated search results page.

Pagination and Sorting: Utilize Apache Commons DbUtils or similar libraries to handle pagination and sorting of search results efficiently in the Servlet. Allow users to navigate through pages of results and sort posts by title or date ascending/descending.

Detailed View: Develop a JSP page to display individual blog posts in detail, accessed via a link on the homepage or search results. Ensure each post opens in a new tab for improved user experience.

Phase 4: Security Enhancements (Backend):

Implement secure password hashing and storage using algorithms like BCrypt.

-To implement secure password hashing and storage using BCrypt:

BCrypt Library: Include a BCrypt library dependency (e.g., org.mindrot:jbcrypt) in your project's build file (e.g., Maven pom.xml).

Hashing Process: In the Servlet handling user registration or password update, use BCrypt to hash user passwords securely. Store the hashed password in the database.

Verification: During login authentication, retrieve the hashed password from the database and verify it using BCrypt's checkpw method to ensure secure authentication without storing plaintext passwords.

Validate user input to prevent SQL injection attacks (use prepared statements).

-To validate user input and prevent SQL injection attacks using prepared statements:

Prepared Statements: Use JDBC's PreparedStatement interface to construct SQL queries with placeholders (?) for dynamic values.

Parameterized Queries: Bind user inputs to these placeholders using methods like setString, setInt, etc., ensuring that inputs are treated as data rather than executable SQL code.

Automatic Escaping: Prepared statements automatically handle escaping special characters, effectively mitigating SQL injection risks by preventing malicious SQL commands from being executed directly.

 
