package com.attraya.service;

import com.attraya.entity.Product;
import com.attraya.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

//    @PostConstruct
//    public void initDB() {
//        List<Product> products = IntStream.rangeClosed(1, 200)
//                .mapToObj(i -> new Product("product" + i, new Random().nextInt(100), new Random().nextInt(50000)))
//                .collect(Collectors.toList());
//        repository.saveAll(products);
//    }

    public List<Product> findAllProducts(){
        return repository.findAll();
    }

    public List<Product> findProductsWithSorting(String field){
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Product> findProductsWithPagination(int pageNumber, int pageSize){
        Page<Product> products = repository.findAll(PageRequest.of(pageNumber, pageSize));
        return products;
    }

    public Page<Product> findProductsWithPaginationAndSorting(int pageNumber, int pageSize, String field){
        Page<Product> products = repository.findAll(PageRequest.of(pageNumber, pageSize).withSort(Sort.by(field)));
        return products;
    }
}
