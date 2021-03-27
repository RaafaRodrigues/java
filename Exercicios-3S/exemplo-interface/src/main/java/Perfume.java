public class Perfume extends Produto{

    private String fragancia;

    public Perfume(Integer codigo,String descricao,Double preco, String fragancia){
        super(codigo, descricao, preco);
        this.fragancia=fragancia;
    }


    public Double getValorTributo() {
        return getPreco()*0.27;
    }

    public String getFragancia() {
        return fragancia;
    }

    @Override
    public String toString() {
        return  super.toString()+ " Perfume{" +
                "fragancia= " + fragancia +
                " Imposto= " + getValorTributo() +'\'' +
                "} " ;
    }
}
