    package com.grovia.backend.controller;

    import java.util.List;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.DeleteMapping;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.PutMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.grovia.backend.entity.Category;
    import com.grovia.backend.service.CategoryService;

    @RestController
    @RequestMapping("/api/categories")
    public class CategoryController {

        private final CategoryService categoryService;

        public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }

        @GetMapping
        public List<Category> getAllCategories() {
            return categoryService.getAllCategories();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
            Category category = categoryService.getCategoryById(id);

            if (category == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Category not found");
            }

            return ResponseEntity.ok(category);
        }

        @PostMapping
        public ResponseEntity<?> createCategory(@RequestBody Category category) {
            Category savedCategory = categoryService.createCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
            Category category = categoryService.updateCategory(id, updatedCategory);
            if (category == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Category not found");
            }
            return ResponseEntity.ok(category);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
            if (categoryService.deleteCategory(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("Category not found");
            }
        }
    }

