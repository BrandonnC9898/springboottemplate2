package com.brandonn.springboottemplate2.shared.errorhandler.customexceptions;

public class ProductsNotFoundException extends RuntimeException {
    public ProductsNotFoundException() {
        super("Some of the products couldn't be found");
    }
}
