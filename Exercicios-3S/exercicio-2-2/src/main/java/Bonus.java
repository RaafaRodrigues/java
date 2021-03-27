public abstract class Bonus {

    private String nome;
    private Integer qtdAulasSemana;


    public Bonus(String nome,Integer qtdAulasSemana){
        this.nome=nome;
        this.qtdAulasSemana=qtdAulasSemana;
    }
    public abstract Double getValorBonus();

    public String getNome(){
        return nome;

    }
    public Integer getQtdAulasSemana(){
        return qtdAulasSemana;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setQtdAulasSemana(Integer qtdAulasSemana){
        this.qtdAulasSemana=qtdAulasSemana;
    }

    @Override
    public String toString() {
        return String.format("Bonus:{ Nome= %s , Quantidade de aulas na semana= %d ",nome,qtdAulasSemana);
    }
}
