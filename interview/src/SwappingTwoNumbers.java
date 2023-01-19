public class SwappingTwoNumbers {
    public static void main(String[] args) {
         int a = 10;
         int b = 20;
        System.out.println("Before Swapping Values are.."+a+" & "+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After Swapping Values are.."+a+" & "+b);
    }
}
