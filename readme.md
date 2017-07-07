### Required software:

* JDK 1.8
* Don't forget to set the JAVA_HOME variable to jdk path


1. Delete the build directory:
    ```
    gradlew clean
    ```
     
2. Create the build directory:
    ```
    gradlew build
    ```
    
3. Run database server:
    ```
    gradlew startDatabaseServer
    ```
    
4. Create tables (only on first run):
    ```
    gradlew createTables
    ```
    
3. Run web application:
    ```
    gradlew startServer
    ```
    
4. All done, main page of application is
    ```
    http://localhost:8080/
    ```
To terminate all servers:
```
gradlew stopServer
gradlew stopDatabaseServer
```

If you want to fill the tables with test data, run this after starting database server:
```
gradlew insertTestData
```

If you want drop the tables, run this code when database server is up:
```
gradlew dropTables
```
To terminate all servers:
```
gradlew stopServer
gradlew stopDatabaseServer
```

If you want to fill the tables with test data, run this after starting database server:
```
gradlew insertTestData
```

If you want drop the tables, run this code when database server is up:
```
gradlew dropTables
```

Default Admin account:

    login: buck@gmail.com
    password: 123

Default User account:
    
    login: Manning@gmail.com
    password: 32
    
Don't remind passwords from test data emails!