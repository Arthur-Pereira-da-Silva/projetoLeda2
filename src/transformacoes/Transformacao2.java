package transformacoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import tad.NÛPrincipal;
import tad.Fila;

public class Transformacao2 {
    ArrayList<String> EstacoesPasadena = new ArrayList<>();

    public Transformacao2(){
        StartArrrayList();
    }

    public void filterFile(){
        Fila FileFiltered = new Fila();

        try {
            String file = "./arquivos/LAMetroTrips.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;

            while((line = br.readLine()) != null){
                String[] linha = line.split(",");

                if(this.EstacoesPasadena.contains(linha[9]) || this.EstacoesPasadena.contains(linha[10])){
                    FileFiltered.insertion(new NÛPrincipal(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            File product = new File("./arquivos/LAMetroTrips_F1.csv");
            FileWriter escritor = new FileWriter(product);
            BufferedWriter bufEscritor = new BufferedWriter(escritor);
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os tÌtulos
            bufEscritor.newLine();

            while(!FileFiltered.isEmpty()){
                NÛPrincipal atual = FileFiltered.remove();

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
    
    public void StartArrrayList(){
        try {
            String file = "./arquivos/pivot_stations.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                EstacoesPasadena.add(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

