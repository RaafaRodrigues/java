public class App {


    public static void main(String[] args) {
        Bonus p = new Professor("Kakaroto",8,20.00);
        Bonus c = new Coordenador("Brolly",7,160.00);
        Bonus p2 = new Professor("Gohan",8,200.00);
        Bonus c2= new Coordenador("Trunks",7,100.00);

        ControleBonus cb=new ControleBonus();

        cb.addBonus(p);
        cb.addBonus(c);
        cb.addBonus(p2);
        cb.addBonus(c2);
        cb.exibeBonus();
        System.out.println("\nTotal de bonus= "+cb.getTotalBonus());




    }
}
