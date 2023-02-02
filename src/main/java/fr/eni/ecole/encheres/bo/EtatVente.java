package fr.eni.ecole.encheres.bo;

public enum EtatVente {
    CREE("CR"), EN_COURS("EC"), VENDU("VD"), RETIRE("RT");
    private final String state;
    EtatVente(String state){
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
