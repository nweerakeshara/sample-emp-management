package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    /*
    1 - Why do we use this?

    This is used to interact with the database without writing SQL.
    In Spring Boot:
    You don’t write queries manually
    Spring Data JPA generates them for you



    2 - What is JpaRepository<Employee, Integer>?

    It’s an interface that gives you ready-made CRUD operations
    Employee - The Entity class
    Integer - The type of the primary key (ID)
    */

    void deleteById(Long id);

    Optional<Employee> findEmployeeById(Long id);
        /*
        * In your repo:

            Optional<Employee> findEmployeeById(Long id);

            This works because of Spring Data JPA query derivation.

            👉 Spring reads the method name and automatically builds the query.

            🔥 How Spring understands it

            Spring breaks the method name like this:

            find → operation (SELECT)
            Employee → ignored (just descriptive)
            ById → condition (WHERE id = ?)

            👉 It internally creates something like:

            SELECT * FROM employee WHERE id = ?

            So you didn’t write SQL — Spring generated it for you.
    * */
}
