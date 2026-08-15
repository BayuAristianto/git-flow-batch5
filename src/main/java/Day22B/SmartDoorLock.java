package Day22B;

public class SmartDoorLock {
    // 1. Deklarasikan atribut private di sini
    private String pinCode;
    private boolean isLocked;
    private int failedAttempts;
    private boolean isBlocked;

    // Helper Method untuk mengecek apakah PIN valid (4 digit angka)
    private boolean isValidPin(String pin) {
        if (pin == null || pin.length() != 4) {
            return false;
        }
        for (int i = 0; i < pin.length(); i++) {
            if (!Character.isDigit(pin.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // 2. Constructor
    public SmartDoorLock(String pinCode) {
        // Tulis kode di sini
        if (isValidPin(pinCode)) {
            this.pinCode = pinCode;
        } else {
            this.pinCode = "0000";
        }

        this.isLocked = true;
        this.failedAttempts = 0;
        this.isBlocked = false;
    }

    // 3. Getters
    public boolean isLocked() {
        // Tulis kode di sini
        return isLocked;
    }

    public boolean isBlocked() {
        // Tulis kode di sini
        return isBlocked;
    }

    // 4. Unlock Method
    public boolean unlock(String pin) {
        // Tulis kode di sini
        if(isBlocked() == true){
            return false;
        }
        if (pin == pinCode){
            this.isLocked=false;
            this.failedAttempts = 0;
            return true;
        }else{
            this.failedAttempts++;
            if (this.failedAttempts >= 3) {
                this.isBlocked = true;
            }
        return false;
        }
    }

    // 5. Lock Method
    public void lock() {
        // Tulis kode di sini
        this.isLocked = true;
    }

    // 6. Change PIN Method
    public boolean changePin(String oldPin, String newPin) {
        // Tulis kode di sini
        if(isBlocked == false && isLocked == false && oldPin != null && oldPin.equals(this.pinCode) && isValidPin(newPin)){
            this.pinCode =newPin;
            return true;
        }
        return false;
    }

    // 7. Reset Lock Method
    public boolean resetLock(String adminKey) {
        // Tulis kode di sini
        if (adminKey == "ADMIN123"){
            this.isBlocked = false;
            this.failedAttempts = 0;
            this.isLocked = true;
            return true;
        }
        return false;
    }

}

class LockDoor {
    public static void main(String[] args) {
        SmartDoorLock lock = new SmartDoorLock("1234");

        System.out.println(lock.unlock("9999"));         // Output: false (failedAttempts = 1)
        System.out.println(lock.unlock("8888"));         // Output: false (failedAttempts = 2)
        System.out.println(lock.unlock("7777"));         // Output: false (failedAttempts = 3 -> isBlocked jadi true)

        System.out.println(lock.unlock("1234"));         // Output: false (Gagal karena isBlocked = true)
        System.out.println(lock.isBlocked());            // Output: true

        System.out.println(lock.resetLock("ADMIN123"));  // Output: true  (isBlocked jadi false, failedAttempts jadi 0)
        System.out.println(lock.unlock("1234")) ;         // Output: true  (Pintu berhasil terbuka, isLocked = false)

        System.out.println(lock.changePin("1234", "5678")); // Output: true (PIN berhasil diubah ke "5678")

    }
}