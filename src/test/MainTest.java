package src.test;
import org.junit.*; //won't include library but add in read me that this will be necessary to run the test
import src.proj.Customer;
import src.proj.Main;
import src.proj.Queue;
import java.util.*;


public class MainTest {

    @Test
    public void test1(){
        Main main = new Main();

        Assert.assertEquals("olleH", main.reverseString("Hello").toString());
    }

    @Test
    public void test2(){
        Main main = new Main();

        Assert.assertEquals("elppa", main.reverseString("apple").toString());
    }

    @Test
    public void test3(){
        Main main = new Main();

        Assert.assertEquals("ananab", main.reverseString("banana").toString());
    }

    @Test
    public void test4(){
        Main main = new Main();

        Assert.assertEquals("yrrehc", main.reverseString("cherry").toString());
    }

    @Test
    public void test5(){
        Main main = new Main();

        Assert.assertEquals("123321", main.reverseString("123321").toString());
    }
    
    @Test
    public void test6(){
        Main main = new Main();

        Assert.assertEquals("racecar", main.reverseString("racecar").toString());
    }
    
    @Test
    public void test7(){
        Main main = new Main();

        Assert.assertEquals(" ", main.reverseString(" ").toString());
    }
    
    @Test
    public void test8(){
        Main main = new Main();

        Assert.assertEquals("-!@#542", main.reverseString("245#@!-").toString());
    } 

    @Test
    public void test9(){
        Main main = new Main();

        Assert.assertEquals("!eyb yako ,nwonknu si eman ym iH", main.reverseString("Hi my name is unknown, okay bye!").toString());
    } 

    @Test
    public void test11(){
        Main main = new Main();
        Assert.assertEquals(20.0, main.solveArithmeticExpr("(2 + 3) * 4", "Infix"), .0001);
    }

    @Test
    public void test12(){
        Main main = new Main();

        Assert.assertEquals(21, main.solveArithmeticExpr("((2 + 3) * (7 - 4)) + 6", "Infix"), .0001);
    } 

    @Test
    public void test13(){
        Main main = new Main();

        Assert.assertEquals(10.0, main.solveArithmeticExpr("20 / 5 + 3 * 2", "Infix"), .0001);
    } 

    @Test
    public void test14(){
        Main main = new Main();

        Assert.assertEquals(16.0, main.solveArithmeticExpr("(5 + 3) * (6 - 4)", "Infix"), .0001);
    } 

    @Test
    public void test15(){
        Main main = new Main();

        Assert.assertEquals(6, main.solveArithmeticExpr("(10 + 2) / (4 - 2)", "Infix"), .0001);
    } 

    @Test
    public void test16(){
        Main main = new Main();
        Assert.assertEquals(4, main.solveArithmeticExpr("/ 8 2", "Prefix"), .0001);
    }

    @Test
    public void test17(){
        Main main = new Main();

        Assert.assertEquals(6, main.solveArithmeticExpr("/ + 10 2 - 4 2", "Prefix"), .0001);
    } 

    @Test
    public void test18(){
        Main main = new Main();

        Assert.assertEquals(10, main.solveArithmeticExpr("+ / 20 5 * 3 2", "Prefix"), .0001);
    } 

    @Test
    public void test19(){
        Main main = new Main();

        Assert.assertEquals(21, main.solveArithmeticExpr("+ * + 2 3 - 7 4 6", "Prefix"), .0001);
    } 

    @Test
    public void test20(){
        Main main = new Main();

        Assert.assertEquals(2, main.solveArithmeticExpr("/ + 8 * 2 5 + 1 * 4 2", "Prefix"), .0001);
    } 

//Test for postfix
    @Test
    public void test21(){
        Main main = new Main();
        Assert.assertEquals(8.0, main.solveArithmeticExpr("3 5 +", "Postfix"), .0001);
    }

    @Test
    public void test22(){
        Main main = new Main();

        Assert.assertEquals(6.0, main.solveArithmeticExpr("10 2 + 4 2 - /", "Postfix"), .0001);
    } 

    @Test
    public void test23(){
        Main main = new Main();

        Assert.assertEquals(14.0, main.solveArithmeticExpr("9 3 - 2 4 * +", "Postfix"), .0001);
    } 

    @Test
    public void test24(){
        Main main = new Main();

        Assert.assertEquals(2.0, main.solveArithmeticExpr("8 2 5 * + 3 3 2 * + /", "Postfix"), .00001);
    } 

    @Test
    public void test25(){
        Main main = new Main();

        Assert.assertEquals(10.0, main.solveArithmeticExpr("4 18 9 6 - / +", "Postfix"), .0001);
    } 

//Test for custoemer in queue similation
    @Test
    public void test26(){
        Main main = new Main();
        ArrayList<Customer> customeList = main.createCustomers();
        customeList = main.createCustomers();

        Assert.assertEquals(false, customeList.isEmpty());

    } 

    @Test
    public void test27(){
        Main main = new Main();
        Queue<Customer> customerQueue = new Queue<>();
        ArrayList<Customer> customeList = main.createCustomers();
        customeList = main.createCustomers();

        //Simulating a customer joining the line
        main.joinLine(customerQueue, customeList.get(0));
        Assert.assertEquals(1, customerQueue.size());

        //Simulating a customer leaving the line
        main.exitLine(customerQueue);
        Assert.assertEquals(0, customerQueue.size());
    } 


    @Test
    public void test28(){
        Main main = new Main();
        Queue<Customer> customerQueue = new Queue<>();
        ArrayList<Customer> customeList = main.createCustomers();
        customeList = main.createCustomers();

        //Simulating a customer joining the line
        main.joinLine(customerQueue, customeList.get(0));
        main.joinLine(customerQueue, customeList.get(1));
        main.joinLine(customerQueue, customeList.get(2));
        main.joinLine(customerQueue, customeList.get(3));

        Assert.assertEquals(4, customerQueue.size());

         //Simulating a customer leaving the line
         main.exitLine(customerQueue);
         main.exitLine(customerQueue);

         Assert.assertEquals(2, customerQueue.size());
         Assert.assertEquals(customeList.get(2).getName(), customerQueue.peek().getName());
    } 

     
    @Test
    public void test29(){
        Main main = new Main();
        Queue<Customer> customerQueue = new Queue<>();
        ArrayList<Customer> customeList = main.createCustomers();
        customeList = main.createCustomers();

        //Simulating a customer joining the line
        main.joinLine(customerQueue, customeList.get(7));
        main.joinLine(customerQueue, customeList.get(1));
        main.joinLine(customerQueue, customeList.get(5));
        main.joinLine(customerQueue, customeList.get(3));
        main.joinLine(customerQueue, customeList.get(6));

        Assert.assertEquals(5, customerQueue.size());

         //Simulating a customer leaving the line
         main.exitLine(customerQueue);
         main.exitLine(customerQueue);
         main.exitLine(customerQueue);

         //Simulating a customer joining the line 
        main.joinLine(customerQueue, customeList.get(2));

         Assert.assertEquals(3, customerQueue.size());
         Assert.assertEquals(customeList.get(3).getName(), customerQueue.peek().getName());
    } 

    
    @Test
    public void test30(){
        Main main = new Main();
        Queue<Customer> customerQueue = new Queue<>();
        ArrayList<Customer> customeList = main.createCustomers();
        customeList = main.createCustomers();

        //Simulating a customer joining the line
        main.joinLine(customerQueue, customeList.get(7));
        main.joinLine(customerQueue, customeList.get(4));
        main.joinLine(customerQueue, customeList.get(5));
        main.joinLine(customerQueue, customeList.get(3));
        main.joinLine(customerQueue, customeList.get(6));

        Assert.assertEquals(5, customerQueue.size());

         //Simulating a customer leaving the line
         main.exitLine(customerQueue);
         main.exitLine(customerQueue);

         //Simulating a customer joining the line 
        main.joinLine(customerQueue, customeList.get(2));
        main.joinLine(customerQueue, customeList.get(1));
        main.joinLine(customerQueue, customeList.get(0));

        //Simulating a customer leaving the line
        main.exitLine(customerQueue);
         main.exitLine(customerQueue);
         main.exitLine(customerQueue);

         Assert.assertEquals(3, customerQueue.size());
         Assert.assertEquals(customeList.get(2).getName(), customerQueue.peek().getName());
    } 
}
