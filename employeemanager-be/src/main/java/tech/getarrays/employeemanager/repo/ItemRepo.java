package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {
}