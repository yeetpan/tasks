import java.util.*;
public class Tk7 {
    public static void main(String[] args) {
        ArrayList<Integer>nums=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            nums.add(sc.nextInt());
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int num = nums.get(i);

            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("No second largest element (all elements equal or only one unique element).");
        } else {
            System.out.println("Second largest number is: " + secondMax);
        }

            }

    }
