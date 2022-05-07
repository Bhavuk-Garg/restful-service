package com.spring.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KillerComponent implements IComponent{
    @Value("${killer.name}")
    String killerName;

   KillerComponent() {
       System.out.println("Killer Component Constructor called");
   } 
   public void print() {
       System.out.println("Printing from kill "+killerName);
   }
}
