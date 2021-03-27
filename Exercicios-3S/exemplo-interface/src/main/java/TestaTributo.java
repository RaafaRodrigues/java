public class TestaTributo {


    public static void main(String[] args) {
        Tributavel a = new Alimento(1,"TESTE",20.00,12);
        Tributavel p = new Perfume(2,"boticario",20.00,"jonas");
        Tributavel s = new Servico("testeServ",20.00);

        System.out.println(a);
        System.out.println("\n"+p);
        System.out.println("\n"+s);


        Tributo t1=new Tributo();
        t1.adicionaTributavel(a);
        t1.adicionaTributavel(p);
        t1.adicionaTributavel(s);
        t1.exibeTodos();


        System.out.println("Total de impostos: "+t1.calculaTotalTributo());


    }
}
