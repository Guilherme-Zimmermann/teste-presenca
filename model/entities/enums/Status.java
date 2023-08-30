package model.entities.enums;

public enum Status {
    
    PENDENTE(1),
    COMPLETO(2);

    private int code;

    private Status(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Status valueOf(int code){
        for (Status value : Status.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Código de status inválido");
    }
}
