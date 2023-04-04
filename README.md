# InseranceManagemenPlatform

##Objective
> Build an insurance management platform that allows users to manage insurance policies, clients, and claims using Spring Boot and Java.

##Using Technologies are
 * Spring Boot
 - Spring Data JPA
 + Mysql Database
 * Hibernate
 - Java


*Setup Instructions*
> * Clone the repository to your local machine.
> * Install Maven and Java if not already installed.
> *Open a web browser and go to http://localhost:8080/ to access the insurance management platform.
> or
> * run the springboot main application from the project `src/main/java/com/example/insurancemanagementplatform/insurancemanagementplatform/InsurancemanagementplatformApplication.java


##Domain Models
> The following domain models were created for the application:
> create database tables from file create-database-tables.sql
> * Client: Represents a client with properties such as name, date of birth, address,and contact information.
> * InsurancePolicy: Represents an insurance policy with properties like policynumber, type, coverage amount, premium, start date, and end date. Each policy should be associated with a client.
> * Claim: Represents an insurance claim with properties like claim number,description, claim date, and claim status. Each claim should be associated with an insurance policy.
