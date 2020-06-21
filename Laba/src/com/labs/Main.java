package com.labs;

import java.util.List;

import static com.labs.PlanStructure.plan;

public class Main {

    private static PlanStructure planStructure;

    private static void printQuery(AcademicPlan plan, String subjectName) {
        SubjectQuery q = plan.query(subjectName);
        System.out.println(String.format("%s {", subjectName));

        // Печатаем входные ЗУНы
        System.out.println("  INPUTS");
        for (SkillQuery sq: q.requiredSkills()) {
            System.out.print("    ");
            System.out.print(sq.skill().toString());

            List<Subject> subjects = sq.subjects();
            if (!subjects.isEmpty()) {
                // Печатаем дисциплины, для которых
                // текущий ЗУН явялется выходным
                System.out.print(" produced by {");
                for (Subject s: subjects) {
                    System.out.print(" ");
                    System.out.print(s.name());
                }
                System.out.print(" }");
            }
            System.out.println();
        }

        // Печатаем выходные ЗУНы
        System.out.println("  OUTPUTS");
        for (SkillQuery sq: q.producedSkills()) {
            System.out.print("    ");
            System.out.print(sq.skill().toString());

            List<Subject> subjects = sq.subjects();
            if (!subjects.isEmpty()) {
                // Печатаем дисциплины, для которых
                // текущий ЗУН явялется входным
                System.out.print(" required by {");
                for (Subject s: subjects) {
                    System.out.print(" ");
                    System.out.print(s.name());
                }
                System.out.print(" }");
            }
            System.out.println();
        }

        System.out.println("}");
    }
    public static void main(String[] args) throws InterruptedException {
        // Используем паттерн БИЛДЕР, чтобы красиво
        // инициализировать учебный план
//        AcademicPlan plan = AcademicPlanBuilder.stream()
//                // Регистрируем ЗУНы
//                // ability -> умения
//                .ability("a")
//                .ability("b")
//                .ability("c")
//                // experience -> навыки
//                .experience("d")
//                .experience("e")
//                .experience("f")
//                // knowledge -> знания
//                .knowledge("g")
//                .knowledge("h")
//                .knowledge("i")
//                // Добавляем дисциплины
//                .subject("Subject_1")
//                    .requires("a")
//                    .requires("b")
//                    .produces("d")
//                .subject("Subject_2")
//                    .requires("c")
//                    .requires("g")
//                    .produces("i")
//                    .produces("f")
//                .subject("Subject_3")
//                    .requires("c")
//                    .requires("d")
//                    .requires("i")
//                    .produces("h")
//                .subject("Subject_4")
//                    .requires("c")
//                    .requires("d")
//                    .requires("i")
//                    .requires("h")
//                    .produces("e")
//                .build();

        TaskAddThread myThread = new TaskAddThread();
        myThread.start();
        myThread.join();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Работает поток с выводом данных");
                // Печетаем дисциплины
                PlanStructure planStructure = new PlanStructure();
                printQuery( planStructure.getPlan(), "Subject_1");
                printQuery( planStructure.getPlan(), "Subject_2");
                printQuery( planStructure.getPlan(), "Subject_3");
                printQuery( planStructure.getPlan(), "Subject_4");
            }
        }).start();

    }
}
