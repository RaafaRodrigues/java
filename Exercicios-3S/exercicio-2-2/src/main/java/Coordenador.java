public class Coordenador  extends  Bonus{

    private Double valorHoraCordenacao;

    public Coordenador(String nome,Integer qtdAulasSemana,Double valorHoraCordenacao){
        super(nome, qtdAulasSemana);
        this.valorHoraCordenacao=valorHoraCordenacao;
    }

    @Override
    public Double getValorBonus(){
        return (((getQtdAulasSemana()*valorHoraCordenacao)*4.5)*0.2);
    }

    public Double getValorHoraCordenacao(){
        return valorHoraCordenacao;
    }
    public void setValorHoraCordenacao(Double valorHoraCordenacao){
        this.valorHoraCordenacao=valorHoraCordenacao;
    }

    @Override
    public String toString() {
        return String.format("%s , Coordenador={ Quantidade de horas Coordenação= %.2f , Total Bonus= %.2f} }",super.toString(),valorHoraCordenacao,getValorBonus());
    }
}
