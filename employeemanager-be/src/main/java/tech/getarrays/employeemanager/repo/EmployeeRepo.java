package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
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

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
