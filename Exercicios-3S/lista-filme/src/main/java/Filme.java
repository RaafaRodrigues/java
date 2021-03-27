public class Filme {


private Integer idFilme,idade;
private String nome,genero;
private Double nota;


public Filme(Integer idFilme,String nome,Double nota,String genero,Integer idade){
    this.idFilme=idFilme;
    this.nome=nome;
    this.nota=nota;
    this.genero=genero;
    this.idade=idade;
}

public Integer getIdFilme(){
    return idFilme;
}
public Integer getIdade(){
    return idade;
}
public String getNome(){
    return nome;
}
public  String getGenero(){
    return  genero;

}
public Double getNota(){
    return nota;
}
public void setIdFilme(Integer idFilme){
    this.idFilme=idFilme;
}
public void setIdade(Integer idade){
    this.idade=idade;
}
public void setNome(String nome){
    this.nome=nome;
}
public void setGenero(String genero){
    this.genero=genero;
}
public void setNota(Double nota){
    this.nota=nota;
}

@Override
    public String toString(){
    return String.format("Filme: { idFilme: %d, nome: %s, nota: %2f, genero: %s, idade: %d }",idFilme,nome,nota,genero,idade);
}

}


