package com.example.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta") //mapeia pra uri começar com "/conta"
public class ContaCorrenteController {
    Integer quantidadeSaque=0,quantidadeDeposito=0;
    private Double saldo=0.00;

    @GetMapping("/saldo")
    public Double getSaldo() {
        return saldo;
    }
    @GetMapping("/depositar10")
    public void setSaldoColoca10() {
        quantidadeDeposito++;
        saldo += 10;
    }

    @GetMapping("/retirar5")
    public void setSaldoRetira5() {
        quantidadeSaque++;
        saldo -= 10;
    }

    @GetMapping("/conta/quantidade")
    public String quantidade(){
        return String.format("saques: %d  depositos: %d",quantidadeSaque ,quantidadeDeposito);
    }
    @GetMapping("/conta/depositar/{valor}")
    public void depositarValor(@PathVariable double valor){
        if(saldo>=0){
            quantidadeDeposito++;
            saldo+=valor;
        }
    }
    @GetMapping("/conta/sacar/{valor}")
    public void sacarValor(@PathVariable double valor){
        if(saldo !=0){
            quantidadeSaque++;
            saldo-=valor;
        }
        }
}
