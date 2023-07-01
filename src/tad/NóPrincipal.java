package tad;

public class N�Principal {
    
    public int trip_id;
    public int duration;
    public String start_time;
    public String end_time;
    public String bike_id;
    public String trip_route_category;
    public int plan_duration;
    public String passholder_type;
    public String bike_type;
    public String start_station;
    public String end_station;
    public String start_lat;
    public String start_lon;
    public String end_lat;
    public String end_lon;
    public String taxicab_distance;

    public String DataPadronizada;

    //func�es
    N�Principal proximoValor;
    N�Principal anteriorValor;

   
    public String ModificaData(){
        String NovaData;

        NovaData = this.start_time;
        NovaData = NovaData.replace("-", "");
        NovaData = NovaData.replace(":", "");
        NovaData = NovaData.replace("/", "");
        NovaData = NovaData.replace(" ", "");

        return NovaData;
    } 

    public int getTrip_id() {
        return trip_id;
    }

    public int getDuration() {
        return duration;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getBike_id() {
        return bike_id;
    }

    public String getTrip_route_category() {
        return trip_route_category;
    }

    public int getPlan_duration() {
        return plan_duration;
    }

    public String getPassholder_type() {
        return passholder_type;
    }

    public String getBike_type() {
        return bike_type;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getEnd_station() {
        return end_station;
    }

    public void setEnd_station(String end_station) {
        this.end_station = end_station;
    }
    
    public String getStart_lat() {
        return start_lat;
    }

    public String getStart_lon() {
        return start_lon;
    }

    public String getEnd_lat() {
        return end_lat;
    }

    public String getEnd_lon() {
        return end_lon;
    }

    public String getTaxicab_distance() {
        return taxicab_distance;
    }
    public String getDataFormatada(){
        return DataPadronizada;
    }

    //funcionalidade de lista encadeada
    public N�Principal getProximoValor() {
        return proximoValor;
    }

    public void setProximoValor(N�Principal proximoDado) {
        this.proximoValor = proximoDado;
    }

    public N�Principal getDadoAnterior() {
        return anteriorValor;
    }
    public void setAnteriorValor(N�Principal dadoAnterior) {
        this.anteriorValor = dadoAnterior;
    }
    
    public N�Principal(int trip_id, int duration, String start_time, String end_time, String bike_id, String trip_route_category,
            int plan_duration, String passholder_type, String bike_type, String start_station, String end_station,
            String start_lat, String start_lon, String end_lat, String end_lon, String taxicab_distance) {
        this.trip_id = trip_id;
        this.duration = duration;
        this.start_time = start_time;
        this.end_time = end_time;
        this.bike_id = bike_id;
        this.trip_route_category = trip_route_category;
        this.plan_duration = plan_duration;
        this.passholder_type = passholder_type;
        this.bike_type = bike_type;
        this.start_station = start_station;
        this.end_station = end_station;
        this.start_lat = start_lat;
        this.start_lon = start_lon;
        this.end_lat = end_lat;
        this.end_lon = end_lon;
        this.taxicab_distance = taxicab_distance;

        this.proximoValor = null;

        DataPadronizada = ModificaData();
    }  

}

