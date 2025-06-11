# Floorball_Statistics_Project 


[![License](https://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)


#### Contents:
- [Analysis](#analysis)
  - [Scenario](#scenario)
  - [User Stories](#user-stories)
  - [Use Case](#use-case)
- [Design](#design)
  - [Prototype Design](#prototype-design)
  - [Domain Design](#domain-design)
  - [Business Logic](#business-logic)
- [Implementation](#implementation)
  - [Backend Technology](#backend-technology)
  - [Frontend Technology](#frontend-technology)
- [Project Management](#project-management)
  - [Roles](#roles)
  - [Milestones](#milestones)

## Analysis

### Scenario

The Floorball-Statistics project is about displaying key information about the Swiss floorball league. 
Our main goal with this web application is to display all the relevant stats of teams and players, 
which are needed for teams to prepare for their upcoming games. The application offers filtered and ranked views of player and team performance, with full data editing capabilities for administrators.

### User Stories
- As a user, I want to view the player stats.
- As a user I want to see the players ranked by league.
- As a user, I want to see the teams.
- As a user, I want to be able to filter the data.
- As an Admin, I want to edit and manage the various data.
- As an Admin, I want the website layout to be structured and easy to follow.
- As an Admin I want the website to be accessible by various devices and ensure compatibility.

### Use Case

We created detailed use case diagrams for each of the three main views in the system. These diagrams define how users and admins interact with the system:

### Use Case 100:

Shows the users available actions for the home page
![Team Logo](https://github.com/AG11101/Pizzeria_Project_Clone/blob/main/UC-100.jpg)

### Use Case 200:
Shows the users available actions for the player page
![Team Logo](https://github.com/AG11101/Pizzeria_Project_Clone/blob/main/UC-200.jpg)

### Use Case 300:
Shows the users available actions for the League page
![Team Logo](https://github.com/AG11101/Pizzeria_Project_Clone/blob/main/UC-300.jpg)

## Design

Our frontend is designed with usability and clarity in mind. We follow a minimalist layout that supports: 

- Dark, readable typography
- Button-based navigation
- responsive table components
- Input fields for filtering and search

The layout is consistent across screens and follows a clear hierarchy for users and admins.

The general idea of the design was to have the first few screens be accessible for everyone with the main focus on the data display. All other screens are only accessible to the admins on which a bit more administrative tasks can be done.

### Wireframe

The following wireframes define the structure and layout of the three views: Home, Player and League. 
Each wireframe outlines the major UI elements such as filters, search bar, data tables and navigation bar.

![Wireframe Design](./Wireframe.png)

### Prototype

A geral prototype was never really made and documented because in the view of the developers the created wireframe gave enough of a vision how the frontend should also look like. Still these points were discussed and written down as attributes the frontend should definitely have:

- Being able to navigate between home, player, league and login screen
- Displaying and sorting data in tables
- Using filters and search to dynamically refine results
- After getting access to the dashboard screen, being able to delete, edit and create more data for players and teams to be able to display in the tables

### Domain Design

The domain model is implemented using JPA entities in the package `ch.fhnw.pizza.data.domain`.

We modeled the core entities based on a real-worlds floorball league structure. The relationships between **Player**, **Team**, **League** and **Ranking** follow standard realtional logic.

![Domain Model](./Domain%20Design.png)

### Entities 

- Player: hast attributes like name, last name, goals, assists and is linked to one team
- Team: contains a list of players and is linked to a league
- League: includes multiple teams and defines the league structure
- Ranking: links teams and leagues with ranking data such as total points and position

The relationships are: 
- One **Team** to Many **Players**
- One **League** to Many **Teams**
- One **Team** to Many **Rankings**
- One **League** to Many **Rankings**

### Business Logic 
> 🚧: Describe the business logic for **at least one business service** in detail. If available, show the expected path and HTPP method. The remaining documentation of APIs shall be made available in the swagger endpoint. The default Swagger UI page is available at /swagger-ui.html.

We implemented the business logic in the `ch.fhnw.pizza.business.service` package. Each service class handels the core application logic for its respective entitity.

Below is an example of the business logic for managing player data. 

### PlayerService

This service provides full CRUD operations for `Player` objects, including logic to update only provided fields:

- **GET** `/api/players`
  -> returns all players in the system

- **GET** `/api/players/{id}`
  -> returns one player by ID.
  -> Throws a runtime exception if the ID does not exist.

- **POST** `/api/players`
  -> Adds a new player to the system.  
  -> Validates inpnut.

- **PUT** `/api/players/{id}`
  -> Updates an existing player.
  -> Only updates fields that are explicitly provided in the request body.

- **DELETE** `/api/players/{id}`
  -> Deletes a player by ID
  -> Throws a runtime exception if the player does not exist.

### Example: Update Logic

`java 
if (player.getName() != null) {
	existingPlayer.setName(player.getName());
}
if (player.getGoals() != 0) {
	existingPlayer.setGoals(player.getGoals());
}
`
## Implementation
> 🚧: Briefly describe your technology stack, which apps were used and for what.

Frontend: Built with Budibase, used to create the user interface and manage actions via no-code components.

Backend: Implemented using Github and Spring Boot (Java), exposing RESTful endpoints to handle all application logic.

The application is structured following a layered architecture: 

- **Controller Layer**: Exposes REST endpoints for PLayers, Teams, Leagues and Rankings.
- **Service Layer**: Handles business logic, input validation and entity updates.
- **Repository Layer**: Connects to the database using Spring Data JPA.

This separation makes the code modular, testable and easier to maintain.

### Backend Technology
> 🚧: It is suggested to clone this repository, but you are free to start from fresh with a Spring Initializr. If so, describe if there are any changes to the PizzaRP e.g., different dependencies, versions & etc... Please, also describe how your database is set up. If you want a persistent or in-memory H2 database check [link](https://github.com/FHNW-INT/Pizzeria_Reference_Project/blob/main/pizza/src/main/resources/application.properties). If you have placeholder data to initialize at the app, you may use a variation of the method **initPlaceholderData()** available at [link](https://github.com/FHNW-INT/Pizzeria_Reference_Project/blob/main/pizza/src/main/java/ch/fhnw/pizza/PizzaApplication.java).

The backend is built using **Java 17** and **Spring Boot**, initialized via [Spring Inititializr](https://start.spring.io/). The following key dependencies are used: 

- **Spring Web**: to create RESTful web services.
- **Spring Data JPA**: For easy data access using repositories.
- **H2 Database**: in-memory development database for fast testing.
- **Swagger/OpenAI**: to automatically generate and expose API documentation.

Then, the following further dependencies have been added to the project `pom.xml`:

- DB:
```XML
<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
</dependency>
```

- SWAGGER:
```XML
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.3.0</version>
   </dependency>
```

### Frontend Technology
The frontend was created using Budibase. It follows a modular structure:

- **Home Screen (Use Case 100)**
  The home screen displays only the top ten players according to the total points they have.
  Users can:
  - View table
  - Sort table according to each attribute (either descending or ascending)
  - Navigate to all other screens
  Admins can:
  - Same as Users

  APIs used:
  - `GET /api/players`


  - **League Rankings Screen (Use Case 300)**
  The league view shows rankings and team performance statistics of the entire league.
  Users can:
  - View table
  - Sort table according to each attribute (either descending or ascending)
  - Navigate to all other screens
  Admins can:
  - Same as Users
  
  APIs used:
  - `GET /api/teams`


 - **Player Stats Screen (Use Case 200)**
   The player stats screen view presents a table listing all players and their statistics.
   Users can:
   - Sort table according to each attribute (either descending or ascending)
   - Search for specific players with text fields "name" and "lastName"
   - Navigate to all other screens
   Admins can:
   - Same as Users

   APIs used:
  - `GET /api/players`


- **Login Screen**
  The login screen displays the login for the admins so certain tasks can be done in the dashboard screen after a successful login. If the login is successful the other components in the dashboard are able to be accessed, if not successful a message will pop up.
  Users can:
  - Try to login using the fields Username and Password
  - Navigate to all other screens
  Admins can:
  - Same as Users 
  - In addition: Able to login as admins when using Username: **myadmin** and Password:**1234567**
  - Navigate to dashboard screen with visible fields for actions
 
  APIs used:
  - `GET /user`


- **Dashboard Screen (includes Use Cases 102, 202 and 302)**
  The dashboard screen is the place where most of the actions are able to be made as a admin.
  Users can:
  - Aren't able to do anything
  - Navigate to all other screens
  Admins can:
  - Create, delete and edit players
  - Create, delete and edit teams
  - Logout of the dashboard by pressing a button
  - Navigate to all other screens

  APIs used:
  - `POST /api/teams`
  - `DELETE /api/teams/{{id}}`
  - `PUT /api/teams/{{id}}`
  - `POST /api/players`
  - `DELETE /api/players/{{id}}`
  - `PUT /api/players/{{id}}`


## Execution
> 🚧: Please describe how to execute your app and what configurations must be changed to run it. 

To run the full-stack application, follow these steps:

#### Backend Setup

1. **Clone the Repository**  
   Clone your GitHub project repository that contains the Spring Boot application.

2. **Start Codespace / IDE**  
   Open the project in your IDE (e.g., IntelliJ or VS Code). Alternatively, start a GitHub Codespace.

3. **Run the Application**  
   Execute the `main()` method in `FloorballStatisticsApplication.java`.  
   The backend will start at: `http://localhost:8080/`

4. **Set Public Port (if using Codespaces)**  
   - Expose port 8080 publicly so the Budibase frontend can fetch data.
   - In GitHub Codespaces: Click **Port 8080 > Make Public**

#### Frontend (Budibase) Setup

Link to budibase App: https://inttech.budibase.app/app/brugg_4_floorball_statistics#/home


## Project Management


### Roles
- Back-end developer: Alessandro Gianoli, Jetmir Sylejmani, Sascha Niederhauser
- Front-end developer: Jan Suter

### Milestones
1. **Analysis**: Scenario ideation, use case analysis and user story writing.
2. **Prototype Design**: Creation of wireframe and prototype.
3. **Domain Design**: Definition of domain model.
4. **Business Logic and API Design**: Definition of business logic and API.
5. **Data and API Implementation**: Implementation of data access and business logic layers, and API.
6. **Security and Frontend Implementation**: Integration of security framework and frontend realisation.
7. (optional) **Deployment**: Deployment of Web application on cloud infrastructure.

