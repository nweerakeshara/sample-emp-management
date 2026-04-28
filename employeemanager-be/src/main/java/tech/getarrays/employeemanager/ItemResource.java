package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Item;
import tech.getarrays.employeemanager.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemResource {
    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems () {
        List<Item> items = itemService.findAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/add/{employeeId}")
    public ResponseEntity<Item> addItem(@RequestBody String itemName, @PathVariable("employeeId") Long employeeId) {
        Item newItem = itemService.addItem(itemName, employeeId);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }
}