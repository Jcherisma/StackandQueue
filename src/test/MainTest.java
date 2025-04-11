package src.test;
import org.junit.*; //won't include library but add in read me that this will be necessary to run the test
import src.proj.Main;

public class MainTest {
   /*  public static void main(String[] args) {
        System.out.println("Hello, World1!");

            @Test
    public void test23(){
        Main main = new Main();

       // main.methodToTest();
        Assert.assertEquals("Expected Result", main.methodToTest());
    }   
        
    }*/

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
}
