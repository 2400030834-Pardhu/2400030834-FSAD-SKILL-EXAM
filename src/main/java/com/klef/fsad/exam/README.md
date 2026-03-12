# Hospital Management System - Maven Hibernate Project

This is a Java-based Hospital Management System developed using Maven and Hibernate ORM framework. The project demonstrates the implementation of persistent objects using Hibernate with MySQL database.

## Project Structure

```
2400030834-FSAD-SKILL-EXAM/
├── pom.xml                           # Maven configuration file
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/klef/fsad/exam/
│   │   │       ├── Hospital.java     # Entity class with JPA annotations
│   │   │       └── ClientDemo.java   # Main application class
│   │   └── resources/
│   │       └── hibernate.cfg.xml     # Hibernate configuration
└── schema.sql                        # Database schema
```

## Features

1. **Hospital Entity Class**: Maps to the hospital table with auto-generated ID
   - Properties: ID, Name, Description, Date, Status, Location, Phone
   - Auto-incrementing primary key

2. **ClientDemo Class**: Console-based application providing:
   - **Insert Operation**: Add new hospital records to the database
   - **View Operation**: Retrieve hospital records by ID
   - **User-friendly Menu**: Interactive menu for database operations

3. **Database Configuration**:
   - MySQL database: fsadexam
   - Hibernate automatically creates/updates the hospital table
   - Sample data included in schema.sql

## Prerequisites

- Java 8 or higher
- MySQL Server 5.7 or higher
- Maven 3.6 or higher
- MySQL JDBC Driver (included in pom.xml)
- Hibernate 5.6.0.Final (included in pom.xml)

## Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/2400030834-Pardhu/2400030834-FSAD-SKILL-EXAM.git
   cd 2400030834-FSAD-SKILL-EXAM
   ```

2. **Create the database**
   ```bash
   mysql -u root -p < schema.sql
   ```

3. **Update Hibernate Configuration** (if needed)
   - Edit `src/main/resources/hibernate.cfg.xml`
   - Update database connection properties:
     - `connection.url`: jdbc:mysql://localhost:3306/fsadexam
     - `connection.username`: root
     - `connection.password`: root

4. **Build the project**
   ```bash
   mvn clean install
   ```

5. **Run the application**
   ```bash
   mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"
   ```

## Usage

Once the application is running, you'll see a menu:

```
===== Hospital Management System =====
1. Insert new Hospital Record
2. View Hospital Record by ID
3. Exit
Enter your choice:
```

### Insert Hospital Record
- Select option 1
- Enter hospital details when prompted
- Record is automatically saved to the database
- Auto-generated ID is displayed

### View Hospital Record
- Select option 2
- Enter the Hospital ID
- Complete hospital details are displayed

## Database Schema

```sql
CREATE TABLE hospital (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    date DATE,
    status VARCHAR(50),
    location VARCHAR(100),
    phone VARCHAR(15)
);
```

## Technologies Used

- **Language**: Java
- **Framework**: Hibernate ORM 5.6.0.Final
- **Database**: MySQL
- **Build Tool**: Maven
- **JPA Annotations**: For entity mapping

## Package Details

- **Package**: com.klef.fsad.exam
- **Database**: fsadexam

## Author

2400030834-Pardhu

## License

This is an academic project for FSAD skill exam.
