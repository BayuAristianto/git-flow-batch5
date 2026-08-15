package Day22B;

public class Notification {
    protected String recipient;
    protected String message;

    public Notification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public String send() {
        // Tulis kode di sini
        return "Sending notification to " + recipient + ": " + message;
    }
}

// Subclass 1
class EmailNotification extends Notification {
    private String subject;

    public EmailNotification(String recipient, String subject, String message) {
        super(recipient, message);
        // Tulis kode di sini
        this.subject=subject;
    }

    @Override
    public String send() {
        // Tulis kode di sini
        return "Sending EMAIL to "+recipient+" | Subject: "+subject+" | Body: "+message;
    }
}

// Subclass 2
class SMSNotification extends Notification {
    private String phoneNumber;

    public SMSNotification(String recipient, String phoneNumber, String message) {
        super(recipient, message);
        // Tulis kode di sini
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String send() {
        // Tulis kode di sini
        if(this.message.length() > 20){
            this.message = this.message.substring(0, 17) + "...";
        }
        return "Sending SMS to "+this.phoneNumber+" ("+this.recipient+"): "+this.message;
    }
}

// Service Class (Polymorphic Handler)
class NotificationService {
    public static int processBatch(Notification[] notifications) {
        // Tulis kode di sini
        if (notifications == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < notifications.length; i++) {
            System.out.println(notifications[i].send());
            count++;
        }
        return count;
    }

}

class contohNotif{
    public static void main(String[] args) {
        Notification[] batch = new Notification[] {
                new EmailNotification("john@mail.com", "Promo", "Diskon 50% untuk Anda!"),
                new SMSNotification("Budi", "08123456789", "Kode OTP Anda adalah 4321"), // Pesan > 20 char -> "Kode OTP Anda ada..."
                new Notification("Alice", "Selamat datang di aplikasi kami")
        };

        int totalSent = NotificationService.processBatch(batch);
        // Output yang dicetak ke konsol:
        // Sending EMAIL to john@mail.com | Subject: Promo | Body: Diskon 50% untuk Anda!
        // Sending SMS to 08123456789 (Budi): Kode OTP Anda ada...
        // Sending notification to Alice: Selamat datang di aplikasi kami

        System.out.println("Total diproses: " + totalSent); // Output: Total diproses: 3

    }
}