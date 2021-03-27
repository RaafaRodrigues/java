import javax.swing.*;

public class ExercicioExcecao {
    public static void main(String[] args) {
        Boolean controle=false;
        while (controle!=true){
            try {

                String salario = JOptionPane.showInputDialog("Digite o valor do salario");
                String reajuste = JOptionPane.showInputDialog("Valor do reajuste");
                if(reajuste!=null && reajuste!="" && salario!=null && salario!="") {
                    if (Double.valueOf(reajuste) > 100 || Double.valueOf(reajuste) < 0) {
                        JOptionPane.showMessageDialog(null, "Valor de reajuste invalido");
                    } else {
                        JOptionPane.showMessageDialog(null, "O reajuste é de :" + (Double.valueOf(reajuste) + Double.valueOf(salario)));
                        controle = true;
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Não pode deixar o campos vazio");
                }
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "o valor digitado não é um numero");

            }

        }
    }
}
