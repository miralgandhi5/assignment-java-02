package com.knoldus;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class MyAppTest {
    public static void main(String[] args) throws Exception {
        add(1, 2);
        System.out.println(add1(20, 45));
        System.out.println("Hi I am doing great!");
        try {
            //Optional.of(null).orElseThrow({throw new NullPointerException("hey");});
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    
        System.out.println("Before Call");
        Thread.sleep(1000);
        System.out.println(add1(1,2));
        System.out.println("After call");
    
        System.out.println("Before Call");
    //    add1(1,2);
        CompletableFuture completableFuture = CompletableFuture.completedFuture(add1(1,2));
        completableFuture.thenApply(a -> {
            System.out.println(a+"hello");
            return null;
        } );
        Thread.sleep(1000);
        System.out.println("After call");
    
    }
        private static int add ( int a, int b){
            int c;
            System.out.println("In call");
            return a + b;
        }
    
        private static int add1 ( int a, int b){
            return a + b;
        }
        
        
        
    }



