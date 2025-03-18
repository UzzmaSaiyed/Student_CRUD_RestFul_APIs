# Student CRUD RESTFul APIs

## Overview
This is a simple RESTful API for managing student records. It allows users to perform CRUD operations on student data using Java, Jakarta EE, and Jersey (JAX-RS). The API is designed to be deployed on a Jakarta EE-compliant server such as Apache Tomcat.

## Features
- Register a new student
- Retrieve all students or a student by ID
- Update student details
- Delete a student record
- Uses in-memory storage (HashMap) for simplicity
- JSON-based request and response

## Technologies Used
- Java (Jakarta EE)
- Jersey (JAX-RS) for RESTful API
- Apache Tomcat as the application server
- JSON for data exchange

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/Student_CRUD_RestFul_APIs.git
   cd Student_CRUD_RestFul_APIs
   ```
2. Build the project using Maven:
   ```sh
   mvn clean package
   ```
3. Deploy the generated `.war` file to your Tomcat server:
   ```sh
   cp target/StudentForm.war $TOMCAT_HOME/webapps/
   ```
4. Start your Tomcat server and access the API at:
   ```sh
   http://localhost:8080/StudentForm
   ```

## API Endpoints

### 1. Get All Students
**Endpoint:** `GET api/students`

**Response:**
```json
{
  "1": "John Doe",
  "2": "Jane Smith"
}
```

### 2. Get a Student by ID
**Endpoint:** `GET api/students/{id}`

**Example Request:**
```sh
GET api/students/1
```

**Response:**
```json
{
  "1": "John Doe"
}
```

### 3. Register a New Student
**Endpoint:** `POST api/students`

**Request Headers:**
```json
Content-Type: application/json
```

**Request Body:**
```json
{
  "id": 3,
  "name": "Alice Johnson"
}
```

**Response:**
```json
{
  "status": 201,
  "message": "Student added successfully"
}
```

### 4. Update a Student Record
**Endpoint:** `PUT api/students/{id}`

**Request Headers:**
```json
Content-Type: application/json
```

**Request Body:**
```json
{
  "name": "Alice Brown"
}
```

**Response:**
```json
{
  "status": 200,
  "message": "Student updated successfully"
}
```

### 5. Delete a Student
**Endpoint:** `DELETE api/students/{id}`

**Example Request:**
```sh
DELETE api/students/3
```

**Response:**
```json
{
  "status": 204,
  "message": "Student deleted successfully"
}
```

## Error Handling
- **400 Bad Request** – Invalid input or missing fields
- **404 Not Found** – Student not found
- **409 Conflict** – Student already exists
- **500 Internal Server Error** – Unexpected server errors

## Contributing
Feel free to fork this repository, make improvements, and submit a pull request!

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author
**Uzzma Saiyed**

---
Happy Coding! 🚀

