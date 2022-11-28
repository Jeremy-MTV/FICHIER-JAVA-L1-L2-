import javax.swing.*;
import org.w3c.dom.DOMImplementationSource;
import java.awt.*;
import java.math.*;


public class Vue extends JFrame{
    
    //Initialisation des panneaux
    JPanel panneauColore = new JPanel();
    JPanel panneauChoix = new JPanel();
    JLabel etiqCouleur = new JLabel();

    //Initialisation des sliders et de la couleur pour le bouton Mémoriser
    static JSlider Rouge = new JSlider(DO_NOTHING_ON_CLOSE, MAXIMIZED_BOTH);
    static JSlider Vert = new JSlider(DO_NOTHING_ON_CLOSE, MAXIMIZED_BOTH);
    static JSlider Bleu = new JSlider(DO_NOTHING_ON_CLOSE, MAXIMIZED_BOTH);
    static Color save;

    Modele mod;
    Controleur Controle;
    
    Vue(Controleur Controle){

        this.mod = Controle.modeleC;
        

        //Fenetre de base
        this.setTitle("Palette");
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout());
        
        //Panneau de gauche
        GridLayout grid = new GridLayout(4, 0);
        grid.setVgap(100);
        panneauChoix.setLayout(grid);
        JButton Memoriser = new JButton("Mémoriser");
        JButton Rappeler = new JButton("S'en Rappeler");
        JButton Complementaire = new JButton("Complémentaire");

        //Configuration des sliders
        Rouge.setMajorTickSpacing(25);
        Rouge.setMinorTickSpacing(10);
        Rouge.setPaintTicks(true);
        Rouge.setPaintLabels(true);
        Rouge.setMaximum(255);
        Rouge.setMinimum(0);
        Vert.setMajorTickSpacing(25);
        Vert.setMinorTickSpacing(10);
        Vert.setPaintTicks(true);
        Vert.setPaintLabels(true);
        Vert.setMaximum(255);
        Vert.setMinimum(0);
        Bleu.setMajorTickSpacing(25);
        Bleu.setMinorTickSpacing(10);
        Bleu.setPaintTicks(true);
        Bleu.setPaintLabels(true);
        Bleu.setMaximum(255);
        Bleu.setMinimum(0);

        
        //Panneau pour les sliders
        GridLayout gridSlider = new GridLayout(1, 0);
        JPanel SliderPanelR = new JPanel(gridSlider);
        SliderPanelR.add(Rouge);
        panneauChoix.add(SliderPanelR);
        JPanel SliderPanelV = new JPanel(new GridLayout(1, 0));
        SliderPanelV.add(Vert);
        panneauChoix.add(SliderPanelV);
        JPanel SliderPanelB = new JPanel(new GridLayout(1, 0));
        SliderPanelB.add(Bleu);
        panneauChoix.add(SliderPanelB);



        //Pannel pour les boutons
        JPanel ButtonPanel = new JPanel(new GridLayout(1, 3));
        ButtonPanel.add(Memoriser);
        ButtonPanel.add(Rappeler);
        ButtonPanel.add(Complementaire);
        panneauChoix.add(ButtonPanel);
    
        //Ajout du panneau gauche
        this.getContentPane().add(panneauChoix);

        //Panneau de droite
        panneauColore.setBackground(Controle.modeleC.modele); 
        panneauColore.setLayout(new BorderLayout());
        this.getContentPane().add(panneauColore);
    

        //Pour le texte
        Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 32);
        etiqCouleur.setText("#" + Integer.toHexString(Controle.modeleC.modele.getRGB()));
        etiqCouleur.setFont(f3);
        etiqCouleur.setHorizontalAlignment(SwingConstants.CENTER);
        panneauColore.add(etiqCouleur, BorderLayout.CENTER);


        //Initialisation des valeurs par defaut des sliders
        Rouge.setValue(this.mod.modele.getRed());
        Bleu.setValue(this.mod.modele.getBlue());
        Vert.setValue(this.mod.modele.getGreen());


        //Action des sliders quand ils sont bouger
        Rouge.addChangeListener((event) -> {
            Controle.SliderMoved();
            miseAJour();
        });

        Vert.addChangeListener((event) -> {
            Controle.SliderMoved();
            miseAJour();
        });

        Bleu.addChangeListener((event) -> {
            Controle.SliderMoved();
            miseAJour();
        });

        Memoriser.addActionListener((event) ->{
            save = this.mod.modele;
        });

        Rappeler.addActionListener((event) ->{
            this.mod.modele = save;
            miseAJour();
            Rouge.setValue(save.getRed());
            Bleu.setValue(save.getBlue());
            Vert.setValue(save.getGreen());
        });

        Complementaire.addActionListener((event) ->{
          Color complementaire = new Color(getComplementaryColor(this.mod.modele.getRGB()));
          this.mod.modele = complementaire;
          miseAJour();
          Rouge.setValue(complementaire.getRed());
          Bleu.setValue(complementaire.getBlue());
          Vert.setValue(complementaire.getGreen());
        });

    }

    //Méthode pour obtenir la couleur complémentaire de la couleur courante
    private int getComplementaryColor(int color) {
        int R = color & 255;
        int G = (color >> 8) & 255;
        int B = (color >> 16) & 255;
        int A = (color >> 24) & 255;
        R = 255 - R;
        G = 255 - G;
        B = 255 - B;
        return R + (G << 8) + ( B << 16) + ( A << 24);
    }

    private void miseAJour(){
        this.panneauColore.setBackground(this.mod.modele);
        this.etiqCouleur.setText("#" + Integer.toHexString(this.mod.modele.getRGB()));
    }

    
}
