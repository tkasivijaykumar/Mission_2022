package MyJavaProject;

public class V36_Pyramids_Program {

    public static void main(String[] args) {

        String val = "*";
        int n=5;
        for(int i =1; i<=n; i++){
            for(int j=1;j<=i;j++) {
                System.out.print(val);
            }
            System.out.println();
        }


        for(int i =n; i>=1; --i){
            for(int j=1;j<=i;++j) {
                System.out.print(val);
            }
            System.out.println();
        }

//        System.out.println(n);
        for(int i =1; i<=n; i++){
//            System.out.println(i);
            for(int j=1;j<=i;j++) {
//                System.out.println(j);
                int space = n-1;
                for (int s = 1;s<=space;s++){
                    System.out.print(" ");
                }
                System.out.print(val);
//                System.out.println(space);
                n=n-1;
                System.out.println();
            }
//            System.out.println();
        }

    }






}
