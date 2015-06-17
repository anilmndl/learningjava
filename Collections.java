//package com.intone.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @Anil Mandal
 */
public class Collections {
    public static void main(String[] args) {
        
        /*
        List<Integer> oddNums = new Integer<>();
        nums.add(1,3,5,7,9);
	List<Integer> evenNums = new Integer<>();
	  nums.add(2,4,6,8,10);
	List<Integer> nums = new Integer<>();
	Store the elements of oddNums and evenNums in the nums list.
        */
        
        List<Integer> oddNums = new ArrayList<>();
        oddNums.add(1);
        oddNums.add(3);
        oddNums.add(5);
        oddNums.add(7);
        oddNums.add(9);
        
	List<Integer> evenNums = new ArrayList<>();
	evenNums.add(2);
        evenNums.add(4);
        evenNums.add(6);
        evenNums.add(8);
        evenNums.add(10);
          
	List<Integer> nums = new ArrayList<>();
        
	for(Integer num : oddNums){
            nums.add(num);
        }
        for(Integer num : evenNums){
            nums.add(num);
        }
        
        System.out.println(nums);
        
        //---------------------**--------------------
        
        /*
        Perform CRUD operation of for the PetStore / BookStore using Map.
	Hint:	Map<Integer, Book> books = new HashMap<>();
		1. Insert
		2. View
		3. List
		4. Delete
		Choose the operation: 1
                */
        
        Map<Integer, Book> books = new HashMap<>();
        
        Book book = new Book("1a2b","The Awesome Book");
        Book book1 = new Book("adsf1234","The Best Book");
        
        insert(1, book, books);
        insert(2, book1, books);
        
        view(1, books);
        
        list(books);
        
        delete(2, books);
        
        System.out.println("----after deleting key 2----");
        list(books);
    }
    
    public static void insert(Integer key, Book book, Map<Integer, Book> books){
        books.put(key, book);
    }
    
    public static void view(Integer key, Map<Integer, Book> books){
        System.out.println(books.get(key));
    }
    
    public static void list(Map<Integer, Book> books){
        System.out.println(books);
    }
    
    public static void delete(Integer key, Map<Integer, Book> books){
        books.remove(key);
    }
}

class Book{
    String isbn;
    String name;
    
    Book(String isbn, String name){
        this.isbn = isbn;
        this.name = name;
    }
    
    public String getIsbn(){
        return this.isbn;
    }
    
     public String getName(){
        return this.name;
    }
     
    @Override
    public String toString(){
        return "ISBN: "+getIsbn()+"; Name: "+getName();
    }
}
