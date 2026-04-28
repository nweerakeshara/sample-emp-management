package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.model.Item;
import tech.getarrays.employeemanager.repo.EmployeeRepo;
import tech.getarrays.employeemanager.repo.ItemRepo;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemService {
    private final ItemRepo itemRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo, EmployeeRepo employeeRepo) {
        this.itemRepo = itemRepo;
        this.employeeRepo = employeeRepo;
    }

    public Item addItem(String itemName, Long employeeId) {
        Employee employee = employeeRepo.findEmployeeById(employeeId)
                .orElseThrow(() -> new UserNotFoundException("Employee by id " + employeeId + " was not found"));

        Item newItem = new Item(itemName, employee);
        return itemRepo.save(newItem);
    }

    public List<Item> findAllItems() {
        return itemRepo.findAll();
    }
}