package com.spring.components;

import org.springframework.stereotype.Component;

// @Component("justAliveComponent")
class AliveComponent implements IComponent {

    public void print() {
        System.out.println("Alive Component printing");
    }
    
}
