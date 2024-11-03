# API-REST

Project Description
This is a basic REST API project developed in Java with Spring Boot. The API allows user management, offering CRUD functionalities (Create, Read, Update, and Delete) for user resources. The main goal of this project is to provide a simple example of how to structure a REST API using best practices with the Spring Framework.

Features
The API offers the following endpoints for user management:

GET /api/users: Returns a list of all registered users.
POST /api/users: Creates a new user with the provided data.
GET /api/users/{id}: Returns the data of a specific user based on the ID.
PUT /api/users/{id}: Updates the data of a specific user.
DELETE /api/users/{id}: Deletes a user based on the provided ID.
Project Structure
The project is divided into three main layers:

Model: Contains the User class, which represents the user data model, with attributes id, name, and email.

Service: Contains the business logic of the application. The UserService class is responsible for managing operations related to users, such as creating, retrieving, updating, and deleting users.

Controller: Contains the UserController class, responsible for exposing the API endpoints. Each endpoint calls the service methods (UserService) to perform the required operation and returns the result.

Main Classes
User
The User class represents the user data model with the following attributes:

id: Unique identifier for the user.
name: Name of the user.
email: Email of the user.
The class includes getters and setters for attribute manipulation.

UserService
The UserService class contains the business logic of the API and manages an in-memory list of users. The main operations of this class are:

findAll(): Returns all registered users.
save(User user): Adds a new user to the list and assigns an ID.
findById(Long id): Returns a specific user based on the ID.
deleteById(Long id): Removes a user from the list based on the ID.
update(Long id, User userDetail): Updates a user’s data based on the ID.
UserController
The UserController class is the control layer that defines the REST endpoints. This class injects UserService and exposes endpoints for manipulating user resources.

Required Dependencies
This project uses the following dependencies:

Spring Boot Web: for creating REST endpoints.
Spring Framework: for dependency injection and service management.
How to Run
Make sure you have Java and Maven installed on your environment.

Clone this repository to your local environment.

Navigate to the project folder and run the command:

mvn spring-boot:run

Access the endpoints via http://localhost:8080/api/users.

Usage Examples
To test the API, use tools like Postman or cURL.

Create a New User
POST /api/users

{
  "name": "John Doe",
  "email": "johndoe@example.com"
}

Get All Users
GET /api/users

Get a Specific User
GET /api/users/{id}

Update a User
PUT /api/users/{id}

{
  "name": "Jane Doe",
  "email": "janedoe@example.com"
}

Delete a User
DELETE /api/users/{id}

Notes
This project stores user data in memory, meaning all data is lost when the server is restarted. In a production environment, it is recommended to use a database for persistent storage.

Conclusion
This basic REST API serves as a good starting point to understand Spring Boot project structure and REST API development practices.
