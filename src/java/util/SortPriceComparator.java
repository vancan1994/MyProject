package util;


import business.Product;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class SortPriceComparator implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice()< o2.getPrice()) {
            return -1;
        } else if (o1.getPrice() == o2.getPrice()) {
            return 0;
        } else {
            return 1;
        }
    }
    
}
