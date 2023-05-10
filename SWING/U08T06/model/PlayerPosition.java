package model;

import programLanguage.LangHandler;

public enum PlayerPosition {
    PORTERO,
    DEFENSA,
    CENTROCAMPISTA,
    DELANTERO,
    MIXTO;

    @Override
    public String toString() {
        return LangHandler.getInstance().getProperty(this.name());
    }

}
