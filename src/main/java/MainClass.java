import java.util.Arrays;

public class MainClass {
        public static void main(String[] args) {
                int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
                int[] arr2 = arr.clone();
                System.out.println(Arrays.toString(arr2));
                arr[0] *= 100;
                System.out.println(Arrays.toString(arr));
                System.out.println(Arrays.toString(arr2));
        }
}