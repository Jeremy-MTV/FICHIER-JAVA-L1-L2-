import javax.swing.*;
import java.awt.*;

public class Controleur {
    static Modele modeleC;
    static Vue vueC;

    Controleur(Modele modeleC, Vue vueC){
        this.modeleC = modeleC;
        this.vueC = vueC;
    }

    static void SliderMoved(){
        modeleC.modele = new Color(vueC.Rouge.getValue(), vueC.Vert.getValue(), vueC.Bleu.getValue());
    }
}
