package model;

public class Plan {

        private int planId;
        private String planName;
        private double pricePerMonth;
        private int durationDays;


        public Plan(int planId, String planName, double pricePerMonth, int durationDays) {
            this.planId = planId;
            this.planName = planName;
            this.pricePerMonth = pricePerMonth;
            this.durationDays = durationDays;
        }

        public int getPlanId(){
            return planId;
        }

        public String getPlanName() {
            return planName;
        }

        public double getPrice() {
            return pricePerMonth;
        }

        public int getDurationDays() {
            return durationDays;
        }
    }