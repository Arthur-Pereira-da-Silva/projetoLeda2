package tad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Fila {
    private NóPrincipal inicial;
    private NóPrincipal top;

    public Fila(){
        this.inicial = null;
        this.top = this.inicial;
    }
    
    //remoção
    public NóPrincipal remove(){
        if(isEmpty()){
            return null;
        }else{
            NóPrincipal aux = this.inicial;
            this.inicial = aux.getProximoValor();
            return aux;
        }
    }

    //inserção
    public void insertion(NóPrincipal novo){
        if(isEmpty()){
            this.inicial = novo;
            this.top = this.inicial;
        }else{
            if(inicial == top){
                this.top = novo;
                this.inicial.setProximoValor(novo);
                novo.setAnteriorValor(this.inicial);
            }else{
                NóPrincipal aux = this.top;
                this.top = novo;
                aux.setProximoValor(novo); 
                this.top.setAnteriorValor(aux);
            }
        }
    }

    public boolean isEmpty(){
        return (inicial == null);
    }
    public void imprime(){
        NóPrincipal aux = this.inicial;

        do{
            System.out.println(aux.getTrip_id());
            aux = aux.getProximoValor();
        }while(aux!=null);

    }

    public void writeCSV(String nomeArquivo){
        try {
            NóPrincipal current = this.inicial;

            File product = new File(nomeArquivo);
            FileWriter escritor = new FileWriter(product);
            BufferedWriter bufEscritor = new BufferedWriter(escritor);
            bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os títulos
            bufEscritor.newLine();

            int count = 0;

            while(current != null){
                bufEscritor.write(current.getTrip_id()+","+current.getDuration()+","+current.getStart_time()+","+current.getEnd_time()+","+current.getBike_id()+","+current.getTrip_route_category()+","+current.getPlan_duration()+","+current.getPassholder_type()+","+current.getBike_type()+","+current.getStart_station()+","+current.getEnd_station()+","+current.getStart_lat()+","+current.getStart_lon()+","+current.getEnd_lat()+","+current.getEnd_lon()+","+current.getTaxicab_distance());
                bufEscritor.newLine();

                current = current.getProximoValor();

                if(count % 1000 == 0){
                    System.out.println(count);
                }
                count++;
            }

            bufEscritor.close();
            escritor.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public NóPrincipal head(){
        return this.inicial;
    }
    
}

