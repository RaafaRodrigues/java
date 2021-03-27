import java.util.ArrayList;
import java.util.List;

public class Tributo {

    private List<Tributavel> listaTrib;

    public Tributo(){
        this.listaTrib=new ArrayList<Tributavel>();
    }

    public void adicionaTributavel(Tributavel t){
        listaTrib.add(t);
    }
    public void exibeTodos(){
        System.out.println("\n\n Exibindo todos os impostos \n");
        if(listaTrib.isEmpty()){
            System.out.println("A lista está vazia");
        }else{
            for(Tributavel t:listaTrib){
                System.out.println(t);

            }
        }

    }

    public Double calculaTotalTributo(){
        Double total=0.00;
        for(Tributavel t: listaTrib) {
            total += t.getValorTributo();
        }
        return  total;

    }



}
