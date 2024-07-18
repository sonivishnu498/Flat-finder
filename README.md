# Flat-finder
Flat Finder is a comprehensive Spring Boot application designed to streamline the process of managing and booking rental flats. The application provides a robust set of RESTful APIs for user registration, flat listings, and booking management. It is built using Java and Spring Boot, making it scalable, efficient, and easy to maintain.
### Flat Finder Project

#### Project Description

**Flat Finder** is a comprehensive Spring Boot application designed to streamline the process of managing and booking rental flats. The application provides a robust set of RESTful APIs for user registration, flat listings, and booking management. It is built using Java and Spring Boot, making it scalable, efficient, and easy to maintain.

#### Key Features

1. **User Management:**
   - User registration and authentication.
   - Retrieve user details.

2. **Flat Management:**
   - Add new flats with details like location, rent, and number of rooms.
   - Retrieve details of individual flats.
   - List all available flats.

3. **Booking Management:**
   - Create and manage bookings for flats.
   - Retrieve booking details.

#### Technologies Used

- **Java 8**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **H2 Database (for development and testing)**
- **JUnit** (for testing)

#### Project Structure

```
Flat_finder/
├── .classpath
├── .gitignore
├── .project
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/Flat_finder/
│   │   │       ├── FlatFinderApplication.java
│   │   │       ├── controller/
│   │   │       │   ├── BookingController.java
│   │   │       │   ├── FlatController.java
│   │   │       │   └── UserController.java
│   │   │       ├── entity/
│   │   │       │   ├── Flat.java
│   │   │       │   └── User.java
│   │   │       ├── repo/
│   │   │       │   ├── FlatRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       ├── service/
│   │   │       │   ├── BookingService.java
│   │   │       │   ├── FlatService.java
│   │   │       │   └── UserService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/Flat_finder/
│               └── FlatFinderApplicationTests.java
└── target/
    └── (compiled classes and resources)
```

#### How to Run

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/Flat_finder.git
   cd Flat_finder
   ```

2. **Build the project using Maven:**
   ```sh
   mvn clean install
   ```

3. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

4. **Access the application:**
   Open your browser and navigate to `http://localhost:8080`

#### API Endpoints

- **User Controller:**
  - `POST /users/register`: Register a new user.
  - `GET /users/{id}`: Retrieve user details by ID.

- **Flat Controller:**
  - `POST /flats`: Add a new flat.
  - `GET /flats/{id}`: Retrieve flat details by ID.
  - `GET /flats`: List all available flats.

- **Booking Controller:**
  - `POST /bookings`: Create a new booking.
  - `GET /bookings/{id}`: Retrieve booking details by ID.

#### Contributions

Contributions are welcome! Please fork this repository and submit pull requests for any features, enhancements, or bug fixes.

#### License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

Feel free to customize this description as per your project specifics and personal preferences.
