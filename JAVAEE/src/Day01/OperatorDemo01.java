package Day01;

public class OperatorDemo01 {
    public static void main(String[] args) {
        int a[]={5,3,4,5,9};
        int max=a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i]>max){
                max=a[i];
            }
        }
        System.out.println(max);
    }
}