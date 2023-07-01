package main;

import java.io.IOException;

import ordenacoes.Ordenacao1;
import ordenacoes.Ordenacao2;
import ordenacoes.Ordenacao3;
import transformacoes.Transformacao1;
import transformacoes.Transformacao2;
import transformacoes.Transformacao3;

public class App {

    public static void main(String[] args) throws IOException{

        long tempoInicialTotal;

        System.out.println("Temporizador Iniciado");
        tempoInicialTotal = System.currentTimeMillis();

        //transformacoes
        System.out.println("Gerando Transformações");

        Transformacao1 t1 = new Transformacao1();        
        t1.Transformacao();

        Transformacao2 t2 = new Transformacao2();
        t2.filterFile();

        Transformacao3 t3 = new Transformacao3();
        t3.filterFile();

        //ordenacoes
        System.out.println("Iniciando ordenacoes");

        Ordenacao1 ordenaStation = new Ordenacao1();
        ordenaStation.OrdenaStartStation();

        Ordenacao2 ordenaDuration = new Ordenacao2();
        ordenaDuration.OrdenaDuration();

        Ordenacao3 ordenaTempo = new Ordenacao3();
        ordenaTempo.OrdenaStartTime();

        long tempoFinal = (System.currentTimeMillis() - tempoInicialTotal);
        System.out.println("execução terminada em: "+ tempoFinal +" ms"); //mostra tempo total gasto para executar
    }
}

