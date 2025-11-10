import javax.jws.soap.SOAPBinding;

class Subham1{

}


public class Exp {
    public static void main(String[] args) throws RuntimeException{


       try {
           int b = 0 ;
           if(b==0){
           //    throw new Exception("this is not possible due to 0");
           }
           int a = 10/b;

       }catch (ArithmeticException e){
           System.out.println("message"+ e.getMessage());
          // System.exit(0);
       }
       finally {
           System.out.println("done");
       }


        // outOFMemoery issue
//        while (true){
//            new Subham1();
//        }

     //Exp.print(1);

    }

    public static void print(int n){
        // base condition
        if(n==11){
            return;
        }
      else {
            print(n+1);
            System.out.println(" no = "+ n);
        }
    }}
