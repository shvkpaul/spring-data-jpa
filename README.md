# Technologies Used

1. Language : Java 17
2. Framework : Spring Boot
3. Database : MySQL
4. Maven

# Build/Execute

Import this maven project in your IDE (I am using IntelliJ IDEA).
Please run docker/local-dev.yml -> services to set up mysql

Follow below page for get the query creation from method names
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

Course_material table column course_id actually holds the foreign key value referencing the other table Course primary key column course_id.

Teacher_id primary key of Teacher table and foreign key in course table

New table created for many-to-many relationship from student and course