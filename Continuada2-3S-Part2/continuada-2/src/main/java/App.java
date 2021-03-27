import java.util.InputMismatchException;


public class App {

    public static void main(String[] args) {
        MetodoUtil m = new MetodoUtil();
        try {
            m.loop(true);
        }catch(InputMismatchException err){
            System.out.println();
            System.out.println("O valor digitado não é valido");
            System.out.println(err.toString());
        }

    }
}
