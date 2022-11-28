import javax.swing.*;
import java.awt.*;


    public class Palette{
        private Vue view ;
        private Modele mod = new Modele(110, 242, 144);
        private Controleur controle = new Controleur(mod, view);


        public Palette () {
            view = new Vue (controle);
            view.setVisible(true);
        }

    public static void main ( String [] args ) {
        new Palette ();
    }

}