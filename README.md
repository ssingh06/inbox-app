# Inbox App
Simple Spring Boot app which allows users with a github account to send/receive email-style messages to each other.

## Functional Requirements
1. Compose a message.
2. Send a message.
3. View all messages received by the signed-in user.
4. Organize messages for a user using a folder/label structure.
5. Reply/Reply all to a message.
6. View a single message.

## Non-functional Requirements
1. High availability
2. High scalability
3. Authentication and Authorization

## Tech Stack
* Application backend: Spring Boot
* Application frontend: Thymeleaf
* Authentication and Authorization: Spring Security with Github authentication
* Scalable database provider: Apache Cassandra