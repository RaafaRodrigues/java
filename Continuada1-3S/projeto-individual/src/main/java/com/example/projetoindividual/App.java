package com.example.projetoindividual;

public class App {
    //Celia
    public static void main(String[] args) {
     Monstro m=new Kaiju("godzilla",9,20.00,2.00,20.0);
     Humano h = new Heroi("jta",2,200.00,2,20.00);
     Humano j= new Jaegers("Ultraman",21,20.00,"Dean","Sam",2.0,17.00);
     ConfrontoController conf=new ConfrontoController();

     conf.addSerVivo(m);
     conf.addSerVivo(h);

        System.out.println(conf.getForcaTotalHumanos()+"\n");
        System.out.println(conf.getForcaTotalMonstros());

        conf.confronto(h,m);
        conf.confronto(j,m);

    }
}
