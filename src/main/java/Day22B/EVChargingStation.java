package Day22B;

public class EVChargingStation {


    // 1. Deklarasikan atribut private di sini
    private String stationId;
    private double maxCapacityKw;
    private double currentPowerKw;
    private boolean isActive;

    // 2. Constructor
    public EVChargingStation(String stationId, double maxCapacityKw) {
        // Tulis kode di sini
        if (stationId == null || stationId.trim().isEmpty()){
            this.stationId = "STATION-001";
        }else {
            this.stationId = stationId;
        }

        if (maxCapacityKw <= 0.0){
            this.maxCapacityKw = 50.0;
        }else {
            this.maxCapacityKw = maxCapacityKw;
        }
        this.currentPowerKw = 0.0;
        this.isActive = true;
    }

    // 3. Getters
    public String getStationId() {
        // Tulis kode di sini
        return stationId;
    }

    public double getMaxCapacityKw() {
        // Tulis kode di sini
        return maxCapacityKw;
    }

    public double getCurrentPowerKw() {
        // Tulis kode di sini
        return currentPowerKw;
    }

    public boolean isActive() {
        // Tulis kode di sini
        return isActive;
    }

    // 4. Setter Active Status
    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public void setMaxCapacityKw(double maxCapacityKw) {
        this.maxCapacityKw = maxCapacityKw;
    }

    public double setCurrentPowerKw(double currentPowerKw) {
        double oldPower = this.currentPowerKw;
        this.currentPowerKw = currentPowerKw;
        return oldPower;
    }

    public void setActive(boolean active) {
        // Tulis kode di sini
        this.isActive = active;
        if (!this.isActive){
            this.setCurrentPowerKw(0.0);
        }
    }


    // 5. Start Charging Method
    public boolean startCharging(double requestedKw) {
        // Tulis kode di sini
        if (isActive() && requestedKw > 0.0 && requestedKw <= getMaxCapacityKw()){
            this.currentPowerKw = requestedKw;
            return true;
        }
        return false;
    }

    // 6. Stop Charging Method
    public double stopCharging() {
        // Tulis kode di sini
        return this.setCurrentPowerKw(0.0);
    }

}

class StartCharging{
    public static void main(String[] args) {
        EVChargingStation station = new EVChargingStation("FAST-EV-01", 100.0);

        System.out.println(station.startCharging(120.0));   // Output: false (Melebihi maxCapacityKw 100.0)
        System.out.println(station.startCharging(60.0));    // Output: true  (currentPowerKw jadi 60.0)
        System.out.println(station.getCurrentPowerKw());   // Output: 60.0

        System.out.println(station.stopCharging());         // Output: 60.0  (currentPowerKw kembali ke 0.0)
        System.out.println(station.getCurrentPowerKw());   // Output: 0.0

        System.out.println(station.startCharging(80.0));    // Output: true  (currentPowerKw jadi 80.0)
        station.setActive(false);       // Stasiun dinonaktifkan
        System.out.println(station.getCurrentPowerKw());   // Output: 0.0   (Otomatis reset ke 0.0)
        System.out.println(station.startCharging(50.0));    // Output: false (Gagal karena isActive = false)

    }
}
