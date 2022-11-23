import javax.swing.*;
import org.w3c.dom.DOMImplementationSource;
import java.awt.*;


public class Vue extends JFrame{
    
    JPanel panneauColore = new JPanel();
    JPanel panneauChoix = new JPanel();
    JLabel etiqCouleur = new JLabel();
    
    Vue(){

        //Fenetre de base
        this.setTitle("Palette");
        this.setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout());
        
        //Panneau de gauche
        panneauChoix.setLayout(new GridLayout(3, 1));
        JButton Memoriser = new JButton("Mémoriser");
        JButton Rappeler = new JButton("S'en Rappeler");
        JButton Complementaire = new JButton("Complémentaire");
        JSlider Rouge = new JSlider(DO_NOTHING_ON_CLOSE, MAXIMIZED_BOTH);
        JSlider Vert = new JSlider(DO_NOTHING_ON_CLOSE, MAXIMIZED_BOTH);
        JSlider Bleu = new JSlider(DO_NOTHING_ON_CLOSE, MAXIMIZED_BOTH);


        //Panneau pour les sliders
        JPanel SliderPanel = new JPanel(new BorderLayout());
        SliderPanel.add(Rouge);
        SliderPanel.add(Vert);
        SliderPanel.add(Bleu);
        panneauChoix.add(SliderPanel);

        //Pannel pour les boutons
        JPanel ButtonPanel = new JPanel(new BorderLayout());
        ButtonPanel.add(Memoriser);
        ButtonPanel.add(Rappeler);
        ButtonPanel.add(Complementaire);
        panneauChoix.add(ButtonPanel);
        


        
        this.getContentPane().add(panneauChoix);

        //Panneau de droite
        Color a = new Color(20,90,10);
        panneauColore.setBackground(a); 
        panneauColore.setLayout(new BorderLayout());
        this.getContentPane().add(panneauColore); 

        


        //Pour le texte
        Font  f3  = new Font(Font.DIALOG,  Font.BOLD, 32);
        etiqCouleur.setText("VERT, C'EST VERT");
        etiqCouleur.setFont(f3);
        etiqCouleur.setHorizontalAlignment(SwingConstants.CENTER);
        panneauColore.add(etiqCouleur, BorderLayout.CENTER);
    }
}
