public class Alimento  extends  Produto{

    private Integer qtdVitamina;

    public Alimento(Integer codigo,String descricao,Double preco,Integer qtdVitamina){
        super(codigo,descricao,preco);
        this.qtdVitamina=qtdVitamina;
    }


    public Double getValorTributo() {
        return getPreco()*0.15;
    }

    public Integer getQtdVitamina() {
        return qtdVitamina;
    }

    @Override
    public String toString() {
        return  super.toString()+" Alimento{" +
                "qtdVitamina=" + qtdVitamina +
                " Imposto= " + getValorTributo() +
                "} " ;
    }
}
