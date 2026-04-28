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

    /*
        @Query("SELECT e FROM Employee e WHERE e.salary > :salary AND e.department = :dept")
        List<Employee> findHighSalary(@Param("salary") double salary, @Param("dept") String dept);

        or

        @Query(value = "SELECT * FROM employee WHERE salary > ?1 AND age < ?2", nativeQuery = true)
        List<Employee> findEmployees(double salary, int age);
    * */




  /*         // Repository
                @Query("SELECT e FROM Employee e WHERE e.jobTitle = :title")
                List<Employee> findByJobTitle(@Param("title") String title);

            // Service - Stream used bcz Data type changes
                public List<EmployeeDTO> getEmployees(String title) {
                    return repo.findByJobTitle(title).stream()
                               .map(emp -> new EmployeeDTO(emp.getId(), emp.getName(), emp.getEmail()))
                               .collect(Collectors.toList());

    */


    /*
            WITH PAGINATION - Pageable pageable

            // Repository - Custom JPQL query with Pagination
                @Query("SELECT e FROM Employee e WHERE e.jobTitle LIKE %:title%")
                Page<Employee> findByJobTitleContaining(@Param("title") String title, Pageable pageable);

            //Service
                public Page<Employee> searchEmployeesByTitle(String title, Pageable pageable) {
                    return employeeRepo.findByJobTitleContaining(title, pageable);
                }


           //Controller
           @GetMapping("/search")
                public ResponseEntity<Page<Employee>> searchEmployees(
                        @RequestParam String title,
                        @PageableDefault(size = 10) Pageable pageable) {

                    return ResponseEntity.ok(employeeService.searchEmployeesByTitle(title, pageable));
                }
    */


}
