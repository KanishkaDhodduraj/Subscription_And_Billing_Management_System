package service;

import model.Plan;
import java.util.ArrayList;

public class PlanService {
    private ArrayList<Plan> plans = new ArrayList<>();

    public void addPlan(Plan plan) {
        plans.add(plan);
    }

    public void displayPlans() {
        for(Plan plan : plans) {
            System.out.println(plan.getPlanId() + " " + plan.getPlanName() + " Rs." + plan.getPrice());
        }
    }

    public void deletePlan(int id) {
        plans.removeIf(plan -> plan.getPlanId() == id);
        System.out.println("Plan Deleted");
    }

}