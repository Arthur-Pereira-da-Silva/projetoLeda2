package tad;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaEncadeada {
    private NóPrincipal primeiro;

    public ListaEncadeada(){
        primeiro = null;
    }
    
	    public void inserirStart_Time(NóPrincipal newNó) {
	
	        if(primeiro == null){
	            primeiro = newNó;
	        }else{
	            NóPrincipal atual = primeiro;
	            NóPrincipal anterior = null;
	
	            
	            while(atual != null){
	                
	                if(atual.getDataFormatada().compareTo(newNó.getDataFormatada()) > 0){
	                    break;
	                }
	              
	                anterior = atual;
	                atual = atual.getProximoValor();
	            }
	            if(anterior == null){
	                primeiro.setAnteriorValor(newNó);
	                newNó.setProximoValor(primeiro);
	                primeiro = newNó;
	            }else{
	                anterior.setProximoValor(newNó);
	                newNó.setAnteriorValor(anterior);
	                newNó.setProximoValor(atual);
	                if(atual != null){
	                    atual.setAnteriorValor(newNó);
	                }else{
	                    newNó.setProximoValor(null);
	                }
	            }
	
	        }
	    }


    
        public void inserirStart_station(NóPrincipal newNó) {

            if(primeiro == null){
                primeiro = newNó;
            }else{
                NóPrincipal atual = primeiro;
                NóPrincipal anterior = null;
    
                
                while(atual != null){

                    if(atual.getStart_station().compareTo(newNó.getStart_station()) > 0){
                        break;
                    }
                    
                    anterior = atual;
                    atual = atual.getProximoValor();
                }
                if(anterior == null){
                    primeiro.setAnteriorValor(newNó);
                    newNó.setProximoValor(primeiro);
                    primeiro = newNó;
                }else{
                    anterior.setProximoValor(newNó);
                    newNó.setAnteriorValor(anterior);
                    newNó.setProximoValor(atual);
                    if(atual != null){
                        atual.setAnteriorValor(newNó);
                    }else{
                        newNó.setProximoValor(null);
                    }
                }
    
            }
        }

       public void inserirDuration(NóPrincipal novoNó) {

            if(primeiro == null){
                primeiro = novoNó;
            }else{
                NóPrincipal atual = primeiro;
                NóPrincipal anterior = null;
    
                
                while(atual != null){
                    if(atual.getDuration() > novoNó.getDuration() ){
                        break;
                    }

                    anterior = atual;
                    atual = atual.getProximoValor();
                }
                if(anterior == null){
                    primeiro.setAnteriorValor(novoNó);
                    novoNó.setProximoValor(primeiro);
                    primeiro = novoNó;
                }else{
                    anterior.setProximoValor(novoNó);
                    novoNó.setAnteriorValor(anterior);
                    novoNó.setProximoValor(atual);
                    if(atual != null){
                        atual.setAnteriorValor(novoNó);
                    }else{
                        novoNó.setProximoValor(null);
                    }
                }
    
            }
        }


    public void writeCSV(String nomeArquivo) throws IOException{
        NóPrincipal atual = primeiro;

        File product = new File(nomeArquivo);
        FileWriter escritor = new FileWriter(product);
        BufferedWriter bufEscritor = new BufferedWriter(escritor);
        bufEscritor.write("trip_id,duration,start_time,end_time,bike_id,trip_route_category,plan_duration,passholder_type,bike_type,start_station,end_station,start_lat,start_lon,end_lat,end_lon,taxicab_distance");//escreve os títulos
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

