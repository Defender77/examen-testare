package com.testing.SerializeXML;

public class Cd {
    private String id;
    private Cd bonusCd;

    Cd(String id, Cd bonusCd) {
        this.id = id;
        this.bonusCd = bonusCd;
    }

    Cd(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Cd getBonusCd() {
        return bonusCd;
    }

}
