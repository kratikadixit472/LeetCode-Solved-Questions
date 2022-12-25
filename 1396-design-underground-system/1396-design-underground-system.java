class UndergroundSystem {

    Map<String, Pair<Double, Double>> journey;
    Map<Integer, Pair<String, Integer>> checkin;
    
    public UndergroundSystem() {
        journey = new HashMap<>();
        checkin = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkin.put(id, new Pair<String, Integer>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkinData = checkin.get(id);
        
        String startStation = checkinData.getKey();
        int startTime = checkinData.getValue();
        String routeKey = getTrip(startStation, stationName);
        
        Pair<Double, Double> routeStation = journey.getOrDefault(routeKey, new Pair<>(0.0, 0.0));
        
        Double totalTripsTime = routeStation.getKey();
        Double totalTrips = routeStation.getValue();
        
        double tripTime = t - startTime;
        journey.put(routeKey, new Pair<>(totalTripsTime + tripTime, totalTrips + 1));
        
        checkin.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = getTrip(startStation, endStation);
        Pair<Double, Double> routeStation = journey.get(routeKey);
        Double avg = routeStation.getKey();
        Double n = routeStation.getValue();
        return avg / n;
    }
    
    private String getTrip(String in, String out){
        return in+" "+ out;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */