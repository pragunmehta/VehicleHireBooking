# VehicleHireBooking System
========================================================================================================
 
 (1) Prerequisite : Java Runtime Environment must be installed on your machine
 
 (2) Download Project Source Zip 
 
     From : GIT Hub Repository https://github.com/pragunmehta/VehicleHireBooking 
	 To : Your local machine and extract it to say C:\demo
 
 (3) Run Test Cases
 
     - Go to Windows command prompt
	   C:\demo\VehicleHireBooking-master
	 
     - Run following command 
	   mvnw.cmd test
	   
	 - All the Test cases should run successfully displaying following results in Concole
	   "Tests run: 12, Failures: 0, Errors: 0, Skipped: 0"
	   
     - Test Results stored under the folder 
	   C:\apps\workspace_git\VehicleHireBooking\target\surefire-reports
	   
	 - Test case of the project are follows 
	   under the folder C:\demo\VehicleHireBooking-master\src\test\java\com\demo\
	   (A) controller\VehicleControllerTest.java
	   (B) repository\VehicleServiceTest.java
	   (C) service\VehicleRepositoryTest.java
	   
 (4) Run the Application 
 
     - Go to Windows command prompt C:\demo\VehicleHireBooking-master
	 
     - Run following command 
	   mvnw.cmd spring-boot:run
	   
     - The Spring Boot application will start in console

 (5) Test different scenarios by accessing the application from the browser
 
     URL : http://localhost:8080
 
     (A) Get all the Vehicles hired / not hired
	 
  	 (B) Get all the Vehicles which are available to hire
		 
	 (B) Get cost of a specific Vehicle by Registratoin Number and Hire From Date / Hire To Date
		 
	 (E) Get Vehicle by Registratoin Number
		 
	 (F) Get Vehicle Not Found Exception for incorrect Registratoin Number
		 

