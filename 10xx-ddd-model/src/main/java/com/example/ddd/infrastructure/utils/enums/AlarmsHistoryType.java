package com.example.ddd.infrastructure.utils.enums;

public enum AlarmsHistoryType {
    EARLY_WARNING(1),
    CONFIRM(2),
    ELIMINATE(3);


    private Integer type;

    AlarmsHistoryType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
