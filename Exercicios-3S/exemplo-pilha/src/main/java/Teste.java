public class Teste {


    public static void main(String[] args) {
        Pilha<Aluno> pilha = new Pilha<Aluno>(5);
        Pilha<Integer> pilhaInt=new Pilha<Integer>(5);


        Aluno a= new Aluno("rafael","oliveira");
        Aluno a2= new Aluno("cami","mieko");
        Aluno a3= new Aluno("judite","verissimo");
        Aluno a4= new Aluno("vilma","oliveira");
        Aluno a5= new Aluno("Ricardo","Verissimo");

        pilha.push(a);
        pilha.push(a2);
        pilha.push(a3);
        pilha.push(a4);
        pilha.push(a5);
        pilha.push(a5);

        System.out.println( pilha.isEmpty());
        System.out.println(pilha.isFull());
        System.out.println("Ta no topo :");
        System.out.println(pilha.peek());
        System.out.println("Removendo");
        System.out.println(pilha.pop());

        System.out.println("Exibindo");
        pilha.exibe();
    }
}
