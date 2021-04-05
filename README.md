The System Resolves:

The company ACME offers their employees the flexibility to work the hours they want. They will pay for the hours worked based on the day of the week and time of day, according to the following table:

Monday - Friday

00:01 - 09:00 25 USD

09:01 - 18:00 15 USD

18:01 - 00:00 20 USD

Saturday and Sunday

00:01 - 09:00 30 USD

09:01 - 18:00 20 USD

18:01 - 00:00 25 USD

The goal of this exercise is to calculate the total that the company has to pay an employee, based on the hours they worked and the times during which they worked. The following abbreviations will be used for entering data:

MO: Monday

TU: Tuesday

WE: Wednesday

TH: Thursday

FR: Friday

SA: Saturday

SU: Sunday

Input: the name of an employee and the schedule they worked, indicating the time and hours. This should be a .txt file with at least five sets of data. You can include the data from our two examples below.

Output: indicate how much the employee has to be paid

For example:

Case 1:

INPUT

RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00

OUTPUT:

The amount to pay RENE is: 215 USD

Case 2:

INPUT

ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00

OUTPUT:

The amount to pay ASTRID is: 85 USD

Solution

1. Analysis of the requirements given in the problem to be solved. 
2. For the design I used the architecture model view controller. In this phase we identified the classes that would be the model (Day, Person, Employee, Schedule), control classes (EmployeeController and ScheduleController), and the Main class (View) which is in charge of executing the application. The separation of classes, attributes and methods is done based on the relational model.
3. The implementation was done in the Java maven programming language, with a functional and object-based programming paradigm.
4. Unit tests (development-testing) and integral tests were performed. As well as the use of the Junit external library.

System execution

Steps to run the application:
1. Download or clone the java maven project.
2. Execute the executable file ExecuteApp.jar located in the Target folder.
3. Choose the .txt file with the employee(s) data to process (The format of the input data is as given in the problem requirements).
4. After selecting the file the resulting data will be displayed in an informative window. 

Test execution

Execute the EmployeeControllerTest class, located in the com.mycompany.testioet.controller package.
