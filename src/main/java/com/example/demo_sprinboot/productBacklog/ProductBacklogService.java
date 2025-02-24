package com.example.demo_sprinboot.productBacklog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductBacklogService {
    private final ProductBacklogRepository productBacklogRepository;

    @Autowired
    public ProductBacklogService(ProductBacklogRepository productBacklogRepository) {
        this.productBacklogRepository = productBacklogRepository;
    }

    public List<ProductBacklog> getAllProductBacklogs() {
        return productBacklogRepository.findAll();
    }

    public ProductBacklog getProductBacklogById(long id) {
        return productBacklogRepository.getReferenceById(id);
    }

    public ProductBacklog createProductBacklog(ProductBacklog productBacklog) {
        return productBacklogRepository.save(productBacklog);
    }

    public ProductBacklog updateProductBacklog(long id, ProductBacklog productBacklog) {
        Optional<ProductBacklog> ExistingProductBacklog = productBacklogRepository.findById(id);
        if (ExistingProductBacklog.isPresent()) {
            ProductBacklog existingProductBacklog = ExistingProductBacklog.get();
            existingProductBacklog.setName(productBacklog.getName());
            return productBacklogRepository.save(existingProductBacklog);
        }else {
            throw new RuntimeException("Product backlog with: "+id+" not found");
        }

    }

    public void deleteProductBacklogById(long id) {
        Optional<ProductBacklog> ExistingProductBacklog = productBacklogRepository.findById(id);
        if (ExistingProductBacklog.isPresent()) {
            productBacklogRepository.deleteById(id);
        }else {
            throw new RuntimeException("Product backlog with: "+id+" not found");
        }
    }
}
