package com.example.backend.item;

import com.example.backend.common.exception.BusinessException;
import com.example.backend.constant.BusinessResponseCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("api/backend/items")
public class ItemController {
  private final ItemService service;

  public ItemController(ItemService service) {
    this.service = service;
  }

  @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = service.findAll();
        return ResponseEntity.ok().body(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> find(@PathVariable("id") Long id) {
        Optional<Item> item = service.find(id);
        return item
                .map(value -> ResponseEntity.ok().body(value))
                .orElseThrow(() -> new BusinessException(BusinessResponseCode.ID_NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
        Item created = service.create(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody Item updatedItem) {

        Optional<Item> updated = service.update(id, updatedItem);

        return updated
                .map(value -> ResponseEntity.ok().body(value))
                .orElseThrow(() -> new BusinessException(BusinessResponseCode.ID_NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        Map<String, String> map = new HashMap<>(errors.size());
        errors.forEach((error) -> {
            String key = ((FieldError) error).getField();
            String val = error.getDefaultMessage();
            map.put(key, val);
        });
        return ResponseEntity.badRequest().body(map);
    }
}
