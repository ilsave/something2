package com.labs;



public class PlanStructure {
   static AcademicPlan plan = null;

    public PlanStructure(AcademicPlan plan) {
        this.plan = plan;
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
