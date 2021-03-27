import java.util.ArrayList;
import java.util.List;

public class ControleBonus {

    private List<Bonus> listaBonus;

    public ControleBonus(){
        this.listaBonus=new ArrayList<Bonus>();
    }

    public void addBonus(Bonus b){
        listaBonus.add(b);
    }

    public void exibeBonus(){
        if(listaBonus.isEmpty()){
            System.out.println("Não há Bonus para exibir!");
        }else{
            for (Bonus b: listaBonus) {
                System.out.println("\n"+b);

            }
        }

    }

    public Double getTotalBonus(){
        Double total=0.00;
        if (listaBonus.isEmpty()){
            System.out.println("Não há Bonus para exibir!");
        }else{
            for(Bonus b: listaBonus){
                total+= b.getValorBonus();
            }
        }
        return total;
    }

    public List<Bonus> getListBonus(){
        return listaBonus;
    }

    @Override
    public String toString() {

        return String.format("ControleBonus: lista de Bonus= %s",listaBonus);
    }
}
