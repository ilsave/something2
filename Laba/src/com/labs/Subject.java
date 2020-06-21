package com.labs;

// Класс для представления дисциплины
public class Subject {
    private SkillSet _requiredSkills;
    private SkillSet _producedSkills;
    private String _name;

    public Subject(String name) {
        _requiredSkills = new SkillSetHashed();
        _producedSkills = new SkillSetHashed();
        _name = name;
    }

    // Название дисциплины
    String name() {
        return _name;
    }

    // Множество входных ЗУНов
    public SkillSet requiredSkills() {
        return _requiredSkills;
    }

    // Множество выхожных ЗУНов
    public SkillSet producedSkills() {
        return _producedSkills;
    }
}
