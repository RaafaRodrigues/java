import java.util.Calendar;
import java.util.Scanner;


public class Exercicio6 {

    public static void main(String[] args) {
        Scanner lerI=new Scanner(System.in);
        Calendar data= Calendar.getInstance();
        Integer[] vetorDias;
        Integer ano=data.get(Calendar.YEAR);
        Integer dia,mees,diaAno=0;


        if(((ano % 4==0)&&(ano % 100!=0))||(ano % 400==0)){
             vetorDias = new Integer[]{31,29,31,30,31,30,31,31,30,31,30,31};
        }else{
            vetorDias = new Integer[]{31,28,31,30,31,30,31,31,30,31,30,31};
        }
        System.out.println("Digite o dia 1 á 31");
        dia= lerI.nextInt();
        if(dia<1||dia>31){
            System.out.println("Dia invalido");
        }else {
            System.out.println("Digite o mes 1 á 12");
            mees= lerI.nextInt();
            if (mees < 1 || mees > 12) {
                System.out.println("Mes invalido");
            }else{
                for (Integer i =0;i<mees-1;i++){
                    diaAno+=vetorDias[i];

                }
                System.out.println(((ano % 4==0)&&(ano % 100!=0))||(ano % 400==0)? "\nDia do ano: "+(diaAno+dia)+" OBS: Ano Bissexto":"\nDia do ano: "+(diaAno+dia));
            }
        }



    }
}
