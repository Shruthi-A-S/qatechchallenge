## qatechchallenge

Implemented test cases using selenium webdriver and Java programming

### _Steps to run scripts_


- Download and install Apache Maven  https://maven.apache.org/install.html 
- Download the project from https://github.com/Shruthi-A-S/qatechchallenge/tree/master 
- Open command prompt -> change directory to project location 
    - For Test Case 1: mvn clean test -DsuiteXmlFile=TestNG.xml -DBROWSER=CHROME -DENV=local -DUserName=Test 
    - For Test Case 2: mvn clean test -DsuiteXmlFile=LoginSuite.xml -DBROWSER=CHROME -DENV=test -DUserName=Test
