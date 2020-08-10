# VehicleHireBooking
 Vehicle Hire Booking System
 
 (1) Prerequisite : Java Runtime Environment must be installed on your machine
 
 (2) Download Project Source Zip from the GIT Hub Repository https://github.com/pragunmehta/VehicleHireBooking to your local machine and extract it to C:\demo
 
 (3) Run the application 
     - Go to Windows command prompt C:\demo\VehicleHireBooking
     - Run following command 
       mvnw.cmd spring-boot:run
     - The Spring Boot application will start
     
 (4) Test different Scenarios by typing following URL to the browser
     http://localhost:8080/vehicles/all
     http://localhost:8080/vehicles/REG-4
     http://localhost:8080/vehicles/hire
     http://localhost:8080/vehicles/REG-4/2020-01-01/2020-01-31
     
 (5) Run Test Cases
     - Go to Windows command prompt C:\demo\VehicleHireBooking
     - Run following command 
       mvnw.cmd test
     - Test Results stored under the folder C:\apps\workspace_git\VehicleHireBooking\target\surefire-reports
