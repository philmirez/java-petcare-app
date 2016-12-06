# IT 306 Pet Care Java App #

<br>

Installing Maven/Ant
-------------
Install Maven on Windows-based Operating Systems: https://www.mkyong.com/maven/how-to-install-maven-in-windows/
<br><br>
Install Maven on Mac OS X based Operating Systems: http://maven.apache.org/install.html
<br><br>
Install Ant: http://ant.apache.org/manual/install.html

Maven Build Instructions 
-------------
Execute the following steps in the order presented (through a terminal or command prompt, when you are in the project directory) to run the project:
<br><br>
1. mvn clean (cleans the built .class files, removing the entire target/ directory)
<br><br>
2. mvn compile (compiles the classes in the src/ directory into a newly created target/directory)
<br><br>
3. mvn exec:java (executes the AppProcess.java class, which initializes the GUI for the project)

User Credentials
-------------
See chainOwnerObjects.json file in the json directory for credentials

Introduction
-------------
This is the IT 306 Group Project repository, created by Phillip Ramirez and Usman Tahir. This repository contains the implementation for the Pet Care application assignment we were given, the document for which will also be included in the repository. The project has been developed in Java, with a build.xml file that is used for automated building and resource management for the project.

As the project takes shape, this README will be updated, with procedures on how to build and run the project, as well as other pertinent details.

Class details
--------------
This project will have the following classes (subject to change based on development):
<br><br>
1. ChainOwner.java - Used to instantiate Chain Owners, who are responsible for the upkeep of each Kroll Pet Care chain store. Chain Owners all have a first and last name, an email address and phone number, a username and password to log into the Administrative "back panel" (that we will implement through JOptionPane), and a store ID to which they belong.
<br><br>
2. Member.java - Used to instantiate a Member object, which is a representation of an actual customer at Kroll Pet Care. In this project, members are primarily used to create TransactionObjects, since members can spend money at any of the stores, and their details can be used throughout the application.
<br><br>
3. MemberReport.java - This class is used to create Member Reports, which are summaries of member activities, and their spending habits at Kroll Pet Care.
<br><br>
4. Report.java - The abstract Report class which is extended by both the MemberReport and StorePerformanceReport classes.
<br><br>
5. Store.java - Used to instantiate a Store object that is used to store details about each Kroll Pet Care chain store. Each Store object has a store ID, an address, and hours of operation. As of now, we have created a basic implementation for this class, but it will be developed to fit the criteria needed for assigning a Performance Report to it, based on its activities and revenue generated.
<br><br>
6. StorePerformanceReport.java - Similar to the MemberReport class, this class is used to create a store report for each store upon request, and stores the relevant details and implementation logic to do so.
<br><br>
7. TransactionObject.java - A class used to create transaction objects, which allow records to be kept between stores and the chain owner in charge of them. The instantiation(s) of this TransactionObject class are used in a hashmap, and are referred to when creating both types of reports.