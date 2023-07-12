package com.brandonn.springboottemplate2.products.core.service.imp;

import com.brandonn.springboottemplate2.products.core.service.ProductService;
import com.brandonn.springboottemplate2.products.integration.database.ProductRepository;
import com.brandonn.springboottemplate2.products.integration.database.entity.ProductEntity;
import com.brandonn.springboottemplate2.shared.errorhandler.customexceptions.ProductsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public BigDecimal calculateTotalPrice(Map<Long, Integer> products) throws ProductsNotFoundException {
        var rows = repository.findAllById(products.keySet());
        List<ProductEntity> productRows = new ArrayList<>();
        rows.forEach(productRows::add);
        if (products.keySet().size() != productRows.size()) {
            throw new ProductsNotFoundException();
        }
        BigDecimal total = BigDecimal.valueOf(0L);
        for (ProductEntity product : productRows) {
            total = total.add(product.getListPrice()
                    .multiply(BigDecimal.valueOf(products
                            .get(product.getProductId()))));
        }
        return total;
    }
}
