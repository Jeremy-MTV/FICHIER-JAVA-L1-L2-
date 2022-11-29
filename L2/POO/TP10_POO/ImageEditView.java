
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;

public class ImageEditView extends JFrame {
    
    //Bouton pour les actions de la frame
    JButton cutButton;
    JButton undoButton;
    JButton redoButton;

    //Champs graphique
    ImagePane imagepane;
    ImageEditModel model;

    ImageEditView(ImageEditModel model){
        this.model = model;
        this.setTitle("TP10 POO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Menu de barre
        JMenuBar barre = new JMenuBar();
        this.setJMenuBar(barre);
        cutButton = new JButton("Cut");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");
        barre.add(cutButton);
        barre.add(undoButton);
        barre.add(redoButton);


        this.imagepane = new ImagePane();
        this.add(this.imagepane);    
        imagepane.paintComponent(model.getImage().getGraphics()) ;  
    }

    public class ImagePane extends JPanel{
        Selection selection = new Selection();

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(model.getImage(), 0, 0, this);
            ((Graphics2D) g).draw(selection.getRectangle());
        }

        ImagePane(){
            this.setPreferredSize(new Dimension(this.getSize()));
            this.addMouseListener(selection);
            this.addMouseMotionListener(selection);
        }

        public class Selection extends MouseAdapter implements MouseMotionListener{
           int x1;
           int y1;
           int x2;
           int y2;

           Rectangle getRectangle(){
            return new Rectangle(x2-x1, y2-y1);
           }

           public void mousePressed(MouseEvent event){
            x1 = event.getX();
            y1 = event.getY();
            cutButton.setEnabled(false);
            imagepane.repaint();
           }

           public void mouseDragged(MouseEvent event){
            x2 = event.getX();
            y2 = event.getY();
            cutButton.setEnabled(false);
            imagepane.repaint();
           }

           public void mouseMoved(MouseEvent event){};

        }
    }
}
