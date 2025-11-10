package map.doubt;

import java.util.*;
import java.util.stream.Collectors;

class MyException extends Exception{
    // way to create custom Exception
    public MyException(String message){
        super(message);
    }
}

public class MapTest {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            if(b==0 ){
                throw new MyException("this no is not correct becasuse we can not divide by 0");
            }
            int c = a/b;
        }catch (MyException e){
            System.out.println(e.getMessage());
        }

    }
}
