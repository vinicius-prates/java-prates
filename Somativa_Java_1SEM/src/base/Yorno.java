package base;

public enum Yorno {
    No(1),
    Yes(0);

    private int inteiro;

    Yorno(int inteiro) {
        this.inteiro = inteiro;
    }

    public int getValue() {
        return inteiro;
    }

}
