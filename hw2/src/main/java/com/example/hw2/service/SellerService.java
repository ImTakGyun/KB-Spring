package com.example.hw2.service;

import com.example.hw2.domain.Product;
import com.example.hw2.domain.Seller;
import com.example.hw2.mapper.ProductMapper;
import com.example.hw2.mapper.SellerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final ProductMapper productMapper;
    private final SellerMapper sellerMapper;

    @Transactional
    public void registerProduct(List<Product> products) throws Exception{
        for(Product product : products){
            productMapper.insert(product);
        }
    }
}
