
import java.awt.*;
import java.awt.Rectangle;
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

    //Variable cut 
    int cut;

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


        imagepane = new ImagePane() ; 
        setContentPane(imagepane);

        

        cutButton.addActionListener(ev -> {
            cut++;
            model.saveCut(imagepane.selection.getRectangle());
            repaint();
            cutButton.setEnabled(false);
            undoButton.setEnabled(true);
            redoButton.setEnabled(true);
        });

        undoButton.addActionListener(ev -> {
            if (model.getUndoManager().canUndo()) {
                if(cut <= 1) undoButton.setEnabled(false);
                model.getUndoManager().undo();
                repaint();
            }
        });

        redoButton.addActionListener(ev -> {
            if (model.getUndoManager().canRedo()) {
                System.out.print("impossible");
                model.getUndoManager().redo() ; 
                repaint();
                cutButton.setEnabled(false);
                redoButton.setEnabled(false) ; 
            }
        });

    }

    public class ImagePane extends JPanel{
        Selection selection = new Selection();

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(model.getImage(), 0, 0, this);
            ((Graphics2D)g).draw(selection.getRectangle());
        }

        ImagePane(){
            setPreferredSize(new Dimension(model.getImage().getWidth() , model.getImage().getHeight()));
            addMouseListener(selection);
            addMouseMotionListener(selection);
        }

        public class Selection extends MouseAdapter implements MouseMotionListener{
           int x1;
           int y1;
           int x2;
           int y2;

           Rectangle getRectangle(){
            return new Rectangle(new Point(Math.min(x1, x2) , Math.min(y1 , y2)) , new Dimension(Math.abs(x1-x2) , Math.abs(y1-y2))) ; 
            }

           public void mousePressed(MouseEvent event){
                x1 = event.getX();
                y1 = event.getY();
                x2 = x1;
                y2 = y1;
                cutButton.setEnabled(false);
                imagepane.repaint();
           }

           public void mouseDragged(MouseEvent event){
                x2 = event.getX();
                y2 = event.getY();
                if (x1 != x2 || y1 != y2) {
                    cutButton.setEnabled(true);
                }
                imagepane.repaint();
           }

           public void mouseMoved(MouseEvent event){};

        }
    }
}
