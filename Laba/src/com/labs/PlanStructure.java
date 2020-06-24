package com.labs;

public class PlanStructure {

    public final Object object;

   public static AcademicPlan plan = null;


    public PlanStructure() {
        object = new Object();
    }

    public AcademicPlan getPlan() {
        synchronized (object) {
            return plan;
        }
    }

    public void setPlan(AcademicPlan plan) {
        synchronized (object) {
            this.plan = plan;
        }
    }
}
