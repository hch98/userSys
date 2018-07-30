package temp1;

public class Multiton {

    private static Multiton multi1 = new Multiton();
    private static Multiton multi2 = new Multiton();
   
    private Multiton() {}

    public static Multiton getInstance(int key) {

       if(key == 1) {

           return multi1;

       } else {

           return multi2;

       }

    }

   

    /**

     * 获取1—6之间的随机数

     */

    public void getValue() {

       int value = (int)(Math.random()*6+1);

       System.out.println(value);

    }

}