public class Information {
    private int v , f , a ; 
    Information (int v , int f , int a) {
        this.v = v ; 
        this.f = f ; 
        this.a = a ; 
    }
    Information ( Information inf) {
        this(inf.v, inf.f, inf.a) ; 
    }
    public int getVitality () {
        return this.v ; 
    }

    public void editVitality (int v) {
        this.v = v ; 
    }

    public int getForce () {
        return this.f ; 
    }

    public void editForce (int f) {
        this.f = f ; 
    }

    public int getAgility () {
        return this.a ; 
    }

    public void editAgility (int a) {
        this.a = a ; 
    }

    public String toString() {
        return "Vitality =" + this.v +
                "\nForce =" + this.f +
                "\nAgility =" + this.a ; 
    }
}
