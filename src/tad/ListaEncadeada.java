package tad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaEncadeada {
    private N�Principal primeiro;

    public ListaEncadeada(){
        primeiro = null;
    }
    
	    public void inserirStart_Time(N�Principal newN�) {
	
	        if(primeiro == null){
	            primeiro = newN�;
	        }else{
	            N�Principal atual = primeiro;
	            N�Principal anterior = null;
	
	            
	            while(atual != null){
	                
	                if(atual.getDataFormatada().compareTo(newN�.getDataFormatada()) > 0){
	                    break;
	                }
	              
	                anterior = atual;
	                atual = atual.getProximoValor();
	            }
	            if(anterior == null){
	                primeiro.setAnteriorValor(newN�);
	                newN�.setProximoValor(primeiro);
	                primeiro = newN�;
	            }else{
	                anterior.setProximoValor(newN�);
	                newN�.setAnteriorValor(anterior);
	                newN�.setProximoValor(atual);
	                if(atual != null){
	                    atual.setAnteriorValor(newN�);
	                }else{
	                    newN�.setProximoValor(null);
	                }
	            }
	
	        }
	    }


    
        public void inserirStart_station(N�Principal newN�) {

            if(primeiro == null){
                primeiro = newN�;
            }else{
                N�Principal atual = primeiro;
                N�Principal anterior = null;
    
                
                while(atual != null){

                    if(atual.getStart_station().compareTo(newN�.getStart_station()) > 0){
                        break;
                    }
                    
                    anterior = atual;
                    atual = atual.getProximoValor();
                }
                if(anterior == null){
                    primeiro.setAnteriorValor(newN�);
                    newN�.setProximoValor(primeiro);
                    primeiro = newN�;
                }else{
                    anterior.setProximoValor(newN�);
                    newN�.setAnteriorValor(anterior);
                    newN�.setProximoValor(atual);
                    if(atual != null){
                        atual.setAnteriorValor(newN�);
                    }else{
                        newN�.setProximoValor(null);
                    }
                }
    
            }
        }

       public void inserirDuration(N�Principal novoN�) {

            if(primeiro == null){
                primeiro = novoN�;
            }else{
                N�Principal atual = primeiro;
                N�Principal anterior = null;
    
                
                while(atual != null){
                    if(atual.getDuration() > novoN�.getDuration() ){
                        break;
                    }

                    anterior = atual;
                    atual = atual.getProximoValor();
                }
                if(anterior == null){
                    primeiro.setAnteriorValor(novoN�);
                    novoN�.setProximoValor(primeiro);
                    primeiro = novoN�;
                }else{
                    anterior.setProximoValor(novoN�);
                    novoN�.setAnteriorValor(anterior);
                    novoN�.setProximoValor(atual);
                    if(atual != null){
                        atual.setAnteriorValor(novoN�);
                    }else{
                        novoN�.setProximoValor(null);
                    }
                }
    
            }
        }


    public void writeCSV(String nomeArquivo) throws IOException{
        N�Principal atual = primeiro;

        File product = new File(nomeArquivo);
        FileWriter escritor = new FileWriter(product);
        BufferedWriter bufEscritor = new BufferedWriter(escritor);
        bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os t�tulos
        bufEscritor.newLine();

        while(atual !=null){
            bufEscritor.write(atual.getTrip_id()+","+atual.getDuration()+","+atual.getStart_time()+","+atual.getEnd_time()+","+atual.getBike_id()+","+atual.getTrip_route_category()+","+atual.getPlan_duration()+","+atual.getPassholder_type()+","+atual.getBike_type()+","+atual.getStart_station()+","+atual.getEnd_station()+","+atual.getStart_lat()+","+atual.getStart_lon()+","+atual.getEnd_lat()+","+atual.getEnd_lon()+","+atual.getTaxicab_distance());
            bufEscritor.newLine();

            atual = atual.getProximoValor();
        }

        bufEscritor.close();
        escritor.close();
    }
}

