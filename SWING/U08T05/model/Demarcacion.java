package model;

import lang.LangProperties;

public enum Demarcacion {
    PORTERO,
    DEFENSA,
    CENTROCAMPISTA,
    DELANTERO,
    MIXTO;

    @Override
    public String toString() {
        return LangProperties.getInstance().getProperty(this.name());
    }

}
