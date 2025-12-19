# Social Media Backend (SM-Backend)

**Mentorship Dec 2024 Graduation Project**

This repository contains the backend implementation for a comprehensive Social Media platform. Built with **Java 17** and **Spring Boot 3**, it follows a robust modular architecture designed for scalability, maintainability, and clean separation of concerns.

## 🚀 Key Features

*   **User Management**: Secure handling of user registration, authentication, and profiles.
*   **Post Management**: Core functionality for creating, updating, and managing social posts.
*   **Point System**: Dedicated service for managing user points, rewards, and gamification logic.
*   **Reporting**: Comprehensive reporting and analytics capabilities.
*   **Modular Architecture**: Clear separation between core shared libraries and functional microservices.
*   **API-First Design**: REST APIs defined and generated using OpenAPI (Swagger).
*   **Database Migration**: Automated database schema management using Liquibase.

## 🛠 Technology Stack

*   **Language**: Java 17
*   **Framework**: Spring Boot 3.4.0
*   **Build Tool**: Maven
*   **Database**: MySQL 8.0.33
*   **ORM**: Hibernate 6.6
*   **Schema Migration**: Liquibase
*   **API Documentation**: SpringDoc / Swagger / OpenAPI Generator
*   **Code Utilities**: Lombok, MapStruct

## 📂 Project Structure

The project is strictly organized into library modules (infrastructure) and service modules (business logic):

### 📚 Library Modules (`/library`)
Reusable components and adapters used across the microservices.
*   `common`: Shared constants, utilities, and helper classes.
*   `security-adapter`: authentication and authorization configurations.
*   `sql-db-adapter`: Database connectivity and JPA configurations.
*   `rest-adapter`: Standardized REST API configurations.
*   `session-manager`, `logger-adapter`, `mq-adapter`, and more.

### ⚙️ Service Modules (`/service`)
Functional microservices implementing specific business domains.
*   **User Service** (`user-mgt`): Manages user identity and accounts.
*   **Post Service** (`post-mgt`): Handles content creation and interactions.
*   **Point Service** (`point-mgt`): Manages gamification points.
*   **Report Service** (`report-mgt`): Handles system reports.
*   *Note: Each service has a corresponding `*-model` module defining its data structures.*

## 🚦 Getting Started

### Prerequisites

*   **Java 17** Development Kit (JDK)
*   **Maven** 3.8 or higher
*   **MySQL** Database

### Installation

1.  **Clone the repository**
    ```bash
    git clone https://github.com/ahmed0elseginy/sm-backend.git
    cd sm-backend
    ```

2.  **Database Configuration**
    Ensure your MySQL server is running. The project uses Liquibase for schema initialization.
    *   Check `config/liquibase-local.properties` (or similar environment configs) if you need to adjust database credentials.
    *   The build process automatically attempts to update the database schema based on the active profile.

3.  **Build the Project**
    Run the Maven build to compile code, run tests, and generate API sources.
    ```bash
    mvn clean install
    ```

### Running the Services

You can run individual services using Maven or your IDE.

**Using Maven:**
Navigate to a service directory (e.g., `service/user/user-mgt`) and run:
```bash
mvn spring-boot:run
```

**Using IDE (IntelliJ / Eclipse):**
1.  Import the root `pom.xml` as a Maven project.
2.  Locate the main Application class in the desired service module (e.g., `UserMgtApplication.java`).
3.  Run the class as a Java Application.

**Using Scripts (Optional):**
Utility scripts are located in `_scripts/` for starting and stopping services, typically used for deployment.

## 📄 API Documentation

The project utilizes **OpenAPI Generator**.
*   **Generation**: Controller interfaces and Model classes are generated automatically during the Maven `generate-sources` phase.
*   **Swagger UI**: Once a service is running, you can access its interactive API documentation at:
    `http://localhost:<PORT>/swagger-ui.html`
    *(Replace `<PORT>` with the specific service's configured port).*

## 🤝 Contributing

1.  Fork the repository.
2.  Create a feature branch (`git checkout -b feature/NewFeature`).
3.  Commit your changes (`git commit -m 'Add NewFeature'`).
4.  Push to the branch (`git push origin feature/NewFeature`).
5.  Open a Pull Request.
