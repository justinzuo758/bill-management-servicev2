Bill Manager Service
======================================

This application is trying to implement a Bill Manager service api to track bills among friends.

**Table of Contents**
- [Requirements]
- [Technology Stack]
- [How to run the app]
- [Todo List]


Requirements
------------
Basically, 

This service api is try to add, edit, and delete n number of friends and m number of bills:
-The API should be able to associate friends to a bill and split the bill equally among all friends associated to that bill
-The API should be able to retrieve the list of bills with each friend's share
-The API should be able to retrieve the list of friends with their bill associations
-Persist the data or create datastore

Technology Stack
-------------
The logic in this service api is a little bit complicated. Here friend and bill are many-to-many bidirectional relationship.
We can use Collections to setup some data structure for this application instead of using a data store, that means we will use
a traditional way to deal with this many-to-many relation. It is not a good option. In this case, I have decided to use a datastore
and use ORM framework. At beginning, I want to use memory database h2, but later I installed MySql and used MySql as a datastore.

Here are technology stack:
- Object-oriented design using Java
- Hibernate
- Spring data JPA: I tried to use JPA repository as DAO implementation, but that part still has some problem. So I finally use 
Hibernate SessionFactory to manage the transaction.
- Spring boot 
- Java 8


How to run the app
-----------------
This is Spring boot application, so we can run it in IDE and also on Command line.

Here are data source in my machine:
	spring.datasource.url = jdbc:mysql://localhost:3307/billservice?useSSL=false
	spring.datasource.username = root
	spring.datasource.password = Qian02bei21$
I run Mysql on 3307 port because 3306 is used by other application.        

Improvement area
------------------
- Creating controller to expose the api.
- Correcting delete logic.
- Adding more unit test and integration test.
- Creating a UI component for this api.

