# IT 306 Pet Care Java App #

<br>

Maven Build Instructions 
-------------
1. mvn clean
<br><br>
2. mvn compile
<br><br>
3. mvn exec:java

User Credentials
-------------
See chainOwnerObjects.json file in the json directory for credentials


Introduction
-------------

This is the IT 306 Group Project repository, created by Phillip Ramirez and Usman Tahir. This repository contains the implementation for the Pet Care application assignment we were given, the document for which will also be included in the repository. The project has been developed in Java, with a build.xml file that is used for automated building and resource management for the project.

As the project takes shape, this README will be updated, with procedures on how to build and run the project, as well as other pertinent details.

<br>

Class details
--------------

This project will have the following classes (subject to change based on development):
<br><br>
1. ChainOwner.java - Used to instantiate Chain Owners, who are responsible for the upkeep of each Kroll Pet Care chain store. Chain Owners all have a first and last name, an email address and phone number, a username and password to log into the Administrative "back panel" (that we will implement through JOptionPane), and a store ID to which they belong.
<br><br>
2. Store.java - Used to instantiate a Store object that is used to store details about each Kroll Pet Care chain store. Each Store object has a store ID, an address, and hours of operation. As of now, we have created a basic implementation for this class, but it will be developed to fit the criteria needed for assigning a Performance Report to it, based on its activities and revenue generated.
<br><br>
3. Member.java - Used to instantiate a Member object, that is used to store details about the customers that visit Kroll Pet Care. Each member has a first and last name, an email address and phone number, the total amount they have spent at Kroll Pet Care, and a discount amount that applies to them, if they have spent over a certain amount (currently set to $200.00). Each Member also has an indication of whther or not they have an active discount available to use, and this discount functionality will be later built as a separate Discount class, that will allow discounts to expire and become available to use again.
<br><br>
4. MemberNode.java - This is a Linked List implementation that will allow for the efficient storage of member data, so that it can be accessed sequentially, and new members can be added when and if necessary. The MemberNode object has a Member object for its data field, and a link to the next Member object as its link field. This will allow for our MemberReport implementation to easily traverse the list of members and provide a report, based on the functionality that will be implemented.