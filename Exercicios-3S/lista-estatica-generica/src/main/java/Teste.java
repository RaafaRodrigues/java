import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ListaObj<String> l= new ListaObj(5);
        l.adiciona("a");
        l.adiciona("b");
        l.adiciona("c");
        l.adiciona("d");
        l.adiciona("a");
        l.adiciona("b");
        l.adiciona("c");
        l.adiciona("d");
        l.exibe();
        l.removePeloIndice(2);
        l.exibe();
        l.removeElemento("h");

        System.out.println(l.getTamanho());
        System.out.println(l.busca("h"));
        System.out.println( l.getElemento(2));
        l.limpa();
        l.exibe();

    }
}
