public class Pilha <T>{


    private T[] pilha;
    private Integer topo;


    public Pilha(Integer tamanho){
        pilha= (T[]) new  Object[tamanho];
        topo=-1;

    }

    public Boolean isEmpty(){
            return topo==-1;
    }


    public Boolean isFull(){
        return  topo==pilha.length-1;

    }

    public void push(T valor){
        if(isFull()){
            System.out.println("A pilha esta cheia");

        }else{
            topo++;
            pilha[topo]=valor;

        }
    }
    public T pop(){

        return isEmpty()?null
                : pilha[topo--];

    }

    public T peek(){

            return isEmpty()? null
                    : pilha[topo];
    }

    public void exibe(){
        if(isEmpty()){
            System.out.println("pilha vazia");
        }else{
            for(Integer i=0;i<topo+1;i++){
                System.out.println(pilha[i]);
            }
        }
    }
    public void limpa(){
        topo=-1;
    }
}
