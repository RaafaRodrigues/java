package com.example.projeto02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlacarController {

    private  Integer golDoTime1=0,getGolDoTime2=0;

    @GetMapping("/placar/gol/{time}")
    public void registrarGol(@PathVariable int time){
        if(time ==1){
            golDoTime1++;

        }else if(time==2){
            getGolDoTime2++;
        }
    }
    @GetMapping("/placar/atual")
    public String placarAtual(){
        return String.format("Placar: time1 : %d  x time2 : %d",golDoTime1,getGolDoTime2);
    }






}
