package ordenacoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import tad.ListaEncadeada;
import tad.N�Principal;

public class Ordenacao1{
    ListaEncadeada InicialStationLista;

    public Ordenacao1(){
        this.InicialStationLista = new ListaEncadeada();
    }

    public void OrdenaStartStation(){
        String file = "./arquivos/LAMetroTrips.csv";
        
        String FileStartStation = "./arquivos/LAMetroTripsStartStation.csv";

        String line = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();

            while((line = br.readLine()) != null){
                String[] linha = line.split(",");    
                
                this.InicialStationLista.inserirStart_station(new N�Principal(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            InicialStationLista.writeCSV(FileStartStation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    

}
