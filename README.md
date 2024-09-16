Quiz App
A RESTful Quiz Application built using Spring Boot that allows users to create, retrieve, and submit quizzes.

Features:
Create Quiz: Allows users to create quizzes with a specific number of questions and a title.
Retrieve Quiz Questions: Fetches quiz questions by quiz ID.
Submit Quiz: Submits quiz responses and returns the total number of correct answers.


Technologies Used:
Java
Spring Boot
RESTful APIs


API Endpoints:
Create Quiz:
POST /quiz/create?numQ={numQ}&title={title}

Get Quiz Questions:
GET /quiz/get/{id}

Submit Quiz:
POST /quiz/submit/{id}

How to Run:
Clone the repository:
git clone https://github.com/adi001-hash/Quiz-App.git

Navigate to the project directory:
cd Quiz-App

Build and run the application:
./mvnw spring-boot:run
