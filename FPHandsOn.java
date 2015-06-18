
import java.util.function.Predicate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FPHandsOn{
    /*
    1. refactor the following code to use lambda expression:
    interface Calc {
    public int add(int x);
    }
    Calc c = new Calc() { public int add(int x) {
                return x+100;
             }
         };
    c.add(100);
    */
    
    public static void main(String[] args) {
        //Calc calc = (x) -> {return x+100;};
        Calc calc = (x) -> x+100;
        System.out.println(calc.add(100));
        
         //2. Use java.util.function.Predicate interface to compare two Product objects
        Product p1 = new Product(1, "Hello Java");
        Product p2 = new Product(2, "Hello Java");
        Product p3 = new Product(2, "Hello Java SE 8");
        
        Predicate<Product> p = (product) -> p1.equals(product);
        System.out.println(p.test(p2));
        
        System.out.println(p.test(p3));
    }
   
}

@FunctionalInterface
interface Calc {
    public int add(int x);
}

class Product{
    private Integer id;
    private String title;
    
    Product(Integer id, String title){
        this.id = id;
        this.title = title;
    }
    
    @Override
    public boolean equals(Object obj){
        Product p = (Product) obj;
        if (this.title == p.title){
            return true;
        }
        return false;
    }
}
