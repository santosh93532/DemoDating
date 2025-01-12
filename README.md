# DemoDating
# Dating Recommendation Engine

This project implements a Dating Recommendation Engine using **Spring Boot**, **Java**, and **JPA**. The engine matches users based on their gender preference, age similarity, and shared interests, providing an efficient way to find compatible matches.

## Features

- User registration with details: Name, Gender, Age, and Interests.
- Recommendation engine with the following rules:
  1. **Gender Rule**: Matches users with the opposite gender as a preference.
  2. **Age Rule**: Matches users based on the closest age.
  3. **Interest Rule**: Matches users based on the number of shared interests.
- Robust matching algorithm with customizable rules and extendable design.
- REST API endpoints to create users and fetch matches.
- Extensible architecture to add more features (e.g., location-based matching).

---

## Technology Stack

- **Backend**: Spring Boot (Java 17+)
- **Database**: H2 (in-memory for development) or MySQL (production)
- **Build Tool**: Maven
- **Testing**: JUnit 5
- **Tools**: Lombok for boilerplate reduction

---

## Project Setup

### Prerequisites

- **Java 17 or later**
- **Maven 3.6+**
- **MySQL** (optional, for production database)

---

### Steps to Run the Application

1. **Clone the Repository**
   ```bash
   git clone <repository_url>
   cd dating-engine
