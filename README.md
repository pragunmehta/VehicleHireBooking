========================================================================================================
# VehicleHireBooking
Vehicle Hire Booking System
========================================================================================================
 
 (1) Prerequisite : Java Runtime Environment must be installed on your machine
 
 (2) Download Project Source Zip from the GIT Hub Repository 
     https://github.com/pragunmehta/VehicleHireBooking 
	 to your local machine and extract it to C:\demo
 
 (3) Run Test Cases
     - Go to Windows command prompt C:\demo\VehicleHireBooking-master
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

 (4) Run the application 
     - Go to Windows command prompt C:\demo\VehicleHireBooking-master
     - Run following command 
       mvnw.cmd spring-boot:run
     - The Spring Boot application will start in console

 (5) Test different Scenarios by typing following URL to the browser
  	 (A) Get all the Vehicles which are available to hire
         http://localhost:8080/vehicles/hire
		 
	 (B) Get cost of the specific Vehicle by giving Registratoin Number and Hire From Date / Hire To Date
         http://localhost:8080/vehicles/REG-4/2020-01-01/2020-01-31
		 
     (C) Get all the Vehicles hired and not hired
         http://localhost:8080/vehicles/all
		 
	 (D) Type incorrect URL to get Not Found status 404 
	     http://localhost:8080/XXXXXXX
		 
	 (E) Get Vehicle by giving Registratoin Number
         http://localhost:8080/vehicles/REG-4
		 
	 (F) Get Vehicle Not Found Exception by giving incorrect Registratoin Number
	     http://localhost:8080/vehicles/XXXXXXX
		 

