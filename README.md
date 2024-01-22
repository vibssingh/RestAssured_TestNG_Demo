**_RestAssured with TestNG_**

1. This framework consists of:
````
Java 17
Maven – 3.9.6
Allure Maven – 2.14.0
Allure Rest Assured – 2.25.0
Allure TestNG – 2.25.0
Aspectj – 1.9.21
Json – 20231013
Maven Compiler Plugin – 3.12.1
Maven Surefire Plugin – 3.2.3
````

2. To run the tests, use the command 
```
mvn clean test
```

3. TestNG Reports are generated in **_'target\surefire-reports'_** folder. There are 2 commonly used reports - **_Index.html_** and **_emailable-report.html_**

4. This framework also generates Allure Report. Use the below command to generate the Allure Report
````
   allure serve
````