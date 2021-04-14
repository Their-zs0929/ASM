/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lucires
 */
public class Cart implements Serializable{
    private Map<Integer,Product> cart;

    public Cart() {
    }

    public Cart(Map<Integer, Product> cart) {
        this.cart = cart;
    }

    public Map<Integer, Product> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Product> cart) {
        this.cart = cart;
    }
    
    public void add(Product p) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (cart.containsKey(p.getId())){
            int quantity = cart.get(p.getId()).getQuantity();
            p.setQuantity(quantity + p.getQuantity());           
        }
        this.cart.put(p.getId(), p);
    }
    
    public void remove(int id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void update(Product p) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(p.getId())) {
            this.cart.replace(p.getId(), p);
        }
    }
}
