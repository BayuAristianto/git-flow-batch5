package Day22B;

    // Base Class
    class Employee {
        // 1. Deklarasikan atribut private/protected di sini
        private String id;
        private String name;
        private double baseSalary;

        public Employee(String id, String name, double baseSalary) {
            this.id = id;
            this.name = name;
            if (baseSalary < 0){
                this.baseSalary = 0;
            }else {
                this.baseSalary = baseSalary;
            }
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        public double calculateTotalSalary() {
            return baseSalary;
        }

        public String getEmployeeDetails() {
            return "Employee [ID: " + getId() + ", Name: " + getName() + ", Total Salary: " + calculateTotalSalary()+"]";
        }
    }

    // Subclass
    class Manager extends Employee {
        // 2. Deklarasikan atribut tambahan di sini
        private double bonus;

        public Manager(String id, String name, double baseSalary, double bonus) {
            super(id, name, baseSalary);
            // Tulis kode di sini
            if (bonus <0){
                this.bonus = 0.0;
            }else{
                this.bonus=bonus;
            }
        }

        public double getBonus() {
            // Tulis kode di sini
            return bonus;
        }

        public void setBonus(double bonus) {
            // Tulis kode di sini
            if(bonus > 0){
                this.bonus = bonus;
            }
        }

        @Override
        public double calculateTotalSalary() {
            // Tulis kode di sini
            return getBaseSalary() + getBonus();
        }

        @Override
        public String getEmployeeDetails() {
            // Tulis kode di sini
            return "Manager [ID: "+ getId() + ", Name: "+getName()+", Total Salary: "+calculateTotalSalary()+", Bonus: "+getBonus()+"]";
        }


}

class Exercise{
    public static void main(String[] args) {
        Employee emp = new Employee("E01", "Alice", 5000.0);
        System.out.println(emp.calculateTotalSalary()); // Output: 5000.0
        System.out.println(emp.getEmployeeDetails());// Output: Employee [ID: E01, Name: Alice, Total Salary: 5000.0]

        Manager mgr = new Manager("M01", "Bob", 8000.0, 2000.0);
        System.out.println(mgr.calculateTotalSalary());// Output: 10000.0
        System.out.println(mgr.getEmployeeDetails());// Output: Manager [ID: M01, Name: Bob, Total Salary: 10000.0, Bonus: 2000.0]

        mgr.setBonus(-500.0); // Bonus negatif diabaikan
        System.out.println(mgr.getBonus());  // Output: 2000.0
    }
}




