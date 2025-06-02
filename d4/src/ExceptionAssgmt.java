import java.util.Scanner;

class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}
public class ExceptionAssgmt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
        // Null pointer exception
            String str=null;
            System.out.println(str);  // throws NullPointerException
        //NumberFormatException
            String input = sc.nextLine(); // Read input as String
            int num = Integer.parseInt(input); // Try to parse as int
            System.out.println("You entered: " + num);
        //IndexOutofBound Exception
            String[] lottery={"1M","250M","5M"};
            System.out.println("Enter a number to win Lottery");
            int ltno=sc.nextInt();
            System.out.println("Congrats");
        //CustomException
            int n=sc.nextInt();
            if(n<0){
                throw new CustomException("No number below 0");
            }

        }
        catch (NullPointerException e) {
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Caught a NumberFormatException: " + e.getMessage());
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Warning:.....Wrong choice, try again");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

    }
}
