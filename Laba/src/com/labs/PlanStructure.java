package com.labs;



public class PlanStructure {
   public volatile static AcademicPlan plan = null;

    public PlanStructure(AcademicPlan plan) {
        PlanStructure.plan = plan;
    }

    public PlanStructure() {
    }

    public AcademicPlan getPlan() {
        synchronized (this) {
            return plan;
        }
    }

    public void setPlan(AcademicPlan plan) {
        synchronized (this) {
            this.plan = plan;
        }
    }
}
