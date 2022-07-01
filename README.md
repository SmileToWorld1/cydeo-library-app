# cydeo-library-app
Cucumber framework is implemented for this project.
For just rerun the failing tests, FailedTestRunner class is created and implemented in tihs project.

## Report System
HTML and json reports are generated under the target folder`:`target/cucumber-html-reports and target/cucumber.json.


## Apache POİ
For login functionality, DDT is implemented and **CydeoLibraryApp.xlsx** file data' are verified one by one.
For this purpose, *Apache Poi* dependency is added pom.xml file and also one extra java package designed for this DDT test.

## Parallel Testing
**maven-surefire-plugin** is implemented for parallel testing. This way you can use maven lifecycle and all scenario can trigger with just a one command.

``mvn clear test``

## Configuration Properties
To prevent hard coded, **configuration.properties** file is designed. Browser type and also some important test data's stored in this file.
This way easily browser type can be changed and also if it is necessary every important test data's can control directly from this file.