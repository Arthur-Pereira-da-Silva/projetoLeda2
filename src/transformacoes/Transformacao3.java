package transformacoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import tad.Fila;
import tad.NÛPrincipal;

public class Transformacao3 {
    private int totalSum;
    private int contadorViagem;
    private int media;

    public void filterFile(){
        Fila FilteredFile = new Fila();

        try {
            String path = "./arquivos/LAMetroTrips.csv";
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            String line;


            while((line = br.readLine()) != null){
                String[] linha = line.split(",");

                if(Integer.parseInt(linha[1]) > this.media){
                    FilteredFile.insertion(new NÛPrincipal(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File product = new File("./arquivos/LAMetroTrips_F2.csv");
            FileWriter escritor = new FileWriter(product);
            BufferedWriter bufEscritor = new BufferedWriter(escritor);
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os tÌtulos
            bufEscritor.newLine();

            while(!FilteredFile.isEmpty()){
                NÛPrincipal atual = FilteredFile.remove();

                bufEscritor.write(atual.getTrip_id()+","+atual.getDuration()+","+atual.getStart_time()+","+atual.getEnd_time()+","+atual.getBike_id()+","+atual.getTrip_route_category()+","+atual.getPlan_duration()+","+atual.getPassholder_type()+","+atual.getBike_type()+","+atual.getStart_station()+","+atual.getEnd_station()+","+atual.getStart_lat()+","+atual.getStart_lon()+","+atual.getEnd_lat()+","+atual.getEnd_lon()+","+atual.getTaxicab_distance());
                bufEscritor.newLine();

                atual = atual.getProximoValor();
            }

            bufEscritor.close();
            escritor.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Transformacao3(){
        try {
            String file = "./arquivos/LAMetroTrips.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                this.totalSum += Integer.parseInt(linha[1]);
                this.contadorViagem += 1;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.media = this.totalSum / this.contadorViagem;
    }
}

