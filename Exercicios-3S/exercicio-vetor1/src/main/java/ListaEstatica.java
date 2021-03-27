public class ListaEstatica {
    int[] vetor;
    int nroElem;

    public ListaEstatica(Integer tamanho) {
        this.vetor = new int[tamanho];
        this.nroElem = 0;
    }

    public Boolean add(Integer valor) {
        if (nroElem <= vetor.length) {
            vetor[nroElem++] = valor;
            return true;
        } else {
            System.out.println("Vetor cheio");
            return false;
        }
    }

    public void exibeVetor(int[] v) {
        if (nroElem == 0) {
            System.out.println("Vetor vazio");
        } else {
            for (int in = 0; in < nroElem; in++) {
                System.out.print(vetor[in] + "\t");
            }
        }
    }

    public Integer busca(Integer i) {


        for (Integer in = 0; in < nroElem;in++) {
            if (i == vetor[in]) {
                return in;
            }
        }
        return -1;


    }

    public static void main(String[] args) {
        ListaEstatica l = new ListaEstatica(5);
        l.add(1);

        l.adicionaNoInicio(75);
        l.adicionaNoInicio(88);
        l.adicionaNoInicio(90);
        l.adicionaNoInicio(100);


        System.out.println(l.nroElem+" <nr"+l.vetor.length+"< vector");

        l.exibeVetor(l.vetor);
    }
    public Boolean adicionaNoInicio(Integer valor){
        if(nroElem==vetor.length){
            System.out.println("Lista cheia mano brow");
            return false;
        }else {
            nroElem++;
            for(int indice=nroElem-1;indice >0;indice--){

               vetor[indice]=vetor[indice-1];
            }

            vetor[0]=valor;
            return true;


        }

    }

    public Integer contaOcorrencias(Integer valor){
        Integer vezes=0;
        for(Integer i = 0;i<nroElem;i++){
            if(vetor[i]==valor){
                vezes++;
            }
        }
        return vezes !=0? vezes: -1;
    }
    public Boolean substitui(Integer numAnt, Integer numNov){
        for(Integer i = 0;i<nroElem;i++){
            if(vetor[i]==numAnt){
                vetor[i]=numNov;
                return true;
            }
        }
        System.out.println("n tem esse numero nao meu chapa");
        return false;

    }

    public Boolean delete(Integer i) {

        if (i >= nroElem || i < 0) {
            return false;
        } else {

            for (int in = i+1; i < nroElem; in++) {
                if (i == in) {
                    vetor[in-1] = vetor[i];
                    return true;

                }

            }
            nroElem--;
            return null;
        }

    }

}
