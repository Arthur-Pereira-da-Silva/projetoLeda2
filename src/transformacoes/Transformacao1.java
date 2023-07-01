package transformacoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import tad.Fila;
import tad.NÛPrincipal;

public class Transformacao1 {
    HashMap<Integer, String> estacoes = new HashMap<Integer, String>();

    public Transformacao1(){
        StartHashmap();
    }

    public void Transformacao(){
        Fila arquivo = new Fila();
        try {
            String file = "./arquivos/LA_Metro_BikeSharing_CLEANED_2016quater3-2021q3.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;

            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                arquivo.insertion(new NÛPrincipal(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]), linha[2], linha[3], linha[4], linha[5], Integer.parseInt(linha[6]), linha[7], linha[8], linha[9], linha[10], linha[11], linha[12], linha[13], linha[14], linha[15]));

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            File product = new File("./arquivos/LAMetroTrips.csv");
            FileWriter escritor = new FileWriter(product);
            BufferedWriter bufEscritor = new BufferedWriter(escritor);
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os tÌtulos
            bufEscritor.newLine();

            while(!arquivo.isEmpty()){
                NÛPrincipal current = arquivo.remove();

                current.setStart_station(this.estacoes.get(Integer.parseInt(current.getStart_station())));
                current.setEnd_station(this.estacoes.get(Integer.parseInt(current.getEnd_station())));

                bufEscritor.write(current.getTrip_id()+","+current.getDuration()+","+current.getStart_time()+","+current.getEnd_time()+","+current.getBike_id()+","+current.getTrip_route_category()+","+current.getPlan_duration()+","+current.getPassholder_type()+","+current.getBike_type()+","+current.getStart_station()+","+current.getEnd_station()+","+current.getStart_lat()+","+current.getStart_lon()+","+current.getEnd_lat()+","+current.getEnd_lon()+","+current.getTaxicab_distance());
                bufEscritor.newLine();

                current = current.getProximoValor();
            }

            bufEscritor.close();
            escritor.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer, String> getStations(){
        return this.estacoes;
    }
    
    public void StartHashmap(){
        try {
            String file = "./arquivos/stations.csv";
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            String line;
            while((line = br.readLine()) != null){
                String[] linha = line.split(",");
                estacoes.put(Integer.parseInt(linha[0]), linha[1]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

