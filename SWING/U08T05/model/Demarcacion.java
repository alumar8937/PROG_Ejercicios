package model;

import programLanguage.ProgramLanguageProperties;

public enum Demarcacion {
    PORTERO,
    DEFENSA,
    CENTROCAMPISTA,
    DELANTERO,
    MIXTO;

    @Override
    public String toString() {
        return ProgramLanguageProperties.getInstance().getProperty(this.name());
    }

}
