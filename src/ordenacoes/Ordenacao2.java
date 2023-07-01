package ordenacoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tad.ListaEncadeada;
import tad.NÛPrincipal;

public class Ordenacao2{
    ListaEncadeada DuracaoLista;

    public Ordenacao2(){
        this.DuracaoLista = new ListaEncadeada();
    }

    public void OrdenaDuration(){
        String file = "./arquivos/LAMetroTrips.csv";

        String ArquivoDuration = "./arquivos/LAMetroTripsDuration.csv";

        String line = "";
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();

            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                
                this.DuracaoLista.inserirDuration(new NÛPrincipal(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DuracaoLista.writeCSV(ArquivoDuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
