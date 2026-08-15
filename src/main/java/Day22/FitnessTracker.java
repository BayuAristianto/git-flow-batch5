package Day22;

public class FitnessTracker {
    private String userName;
    private int stepGoal;
    private int currentSteps;

    public FitnessTracker (String userName, int stepGoal){
        if (userName == null || userName.trim().isEmpty()){
            this.userName = "Guest";
        }else {
            this.userName = userName;
        }
        if(stepGoal <= 0){
            this.stepGoal = 10000;
        }else {
            this.stepGoal = stepGoal;
        }
    }

    public String getUserName(){
        return this.userName;
    }
    public int getStepGoal(){
        return this.stepGoal;
    }
    public int getCurrentSteps(){
        return this.currentSteps;
    }

    public boolean setStepGoal(int newGoal){
        if(newGoal > 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean logSteps(int steps){
        if (steps > 0){
            this.currentSteps += steps;
            return true;
        }else{
            return false;
        }
    }

    public double getCaloriesBurned(){
        return currentSteps * 0.04;
    }

    public boolean isGoalAchieved(){
        if (currentSteps >= stepGoal){
            return true;
        }else{
            return false;
        }
    }

    public int resetProgress(){
        this.currentSteps = 0;
        return this.currentSteps;
    }
}

class Running {
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker("Budi", 5000);

        System.out.println(tracker.logSteps(3000));       // Output: true  (currentSteps jadi 3000)
        System.out.println(tracker.isGoalAchieved());     // Output: false (3000 < 5000)

        System.out.println(tracker.logSteps(2500));       // Output: true  (currentSteps jadi 5500)
        System.out.println(tracker.isGoalAchieved());     // Output: true  (5500 >= 5000)
        System.out.println(tracker.getCaloriesBurned());  // Output: 220.0 (5500 * 0.04)

        System.out.println(tracker.setStepGoal(-500));    // Output: false (Target tidak berubah)
        System.out.println(tracker.resetProgress());      // currentSteps kembali ke 0
        System.out.println(tracker.getCurrentSteps());    // Output: 0

    }
}
