public class MyTest {
    static int i = 0;
    public static void main(String[] args) {
        new Thread(t1).start();
        new Thread(t2).start();
    }

    private static void countMe(String name){
        i++;
        System.out.println("Current Counter is: " + i + ", updated by: " + name);
    }

    private static Runnable t1 = new Runnable() {
        public void run() {
            try{
                for(int i=0; i<5; i++){
                    countMe("t1");
                }
            } catch (Exception e){}

        }
    };

    private static Runnable t2 = new Runnable() {
        public void run() {
            try{
                for(int i=0; i<5; i++){
                    countMe("t2");
                }
            } catch (Exception e){}
       }
    };
}