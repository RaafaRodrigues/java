public class Professor extends Bonus {


    private Double valorHoraAula;

    public Professor(String nome,Integer qtdAulasSemana,Double valorHoraAula){
        super(nome, qtdAulasSemana);
        this.valorHoraAula=valorHoraAula;
    }
    @Override
   public Double getValorBonus(){
        return (((getQtdAulasSemana()*valorHoraAula)*4.5)*0.15);
   }

   public Double getValorHoraAula(){
        return  valorHoraAula;
   }
   public void setValorHoraAula(Double valorHoraAula){
        this.valorHoraAula=valorHoraAula;
   }

    @Override
    public String toString() {
        return String.format("%s ,Professor={ Valor da hora aula= %.2f , Total bonus= %.2f } }",super.toString(),valorHoraAula,getValorBonus());
    }
}
