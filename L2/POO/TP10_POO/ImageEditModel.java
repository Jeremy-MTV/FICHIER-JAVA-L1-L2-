
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Rectangle;

public class ImageEditModel {
    private UndoManager undoManager = new UndoManager() ; 
    private BufferedImage image;

    public ImageEditModel(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
    }

    // private static boolean verifyLength(Rectangle z, int[][] pixels){
    //     int Rwidth = (int) z.getWidth();
    //     int Rheight = (int) z.getHeight();

    //     for(int i=0; i<pixels.length; i++){
    //         if(pixels.length == Rwidth && pixels[i].length == Rheight ){
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    public UndoManager getUndoManager() {
        return undoManager;
    }

    public class Coupe {
        private Rectangle z ; 
        private int [][] pixels ; 

        Coupe (int x , int y , int width , int height , BufferedImage image) {
            z = new Rectangle (x , y , width , height) ;
            pixels = new int [(int)image.getHeight()][(int)image.getWidth()] ;
            for (int i = 0 ; i<pixels.length ; i++) {
                for (int k = 0 ; k<pixels[i].length ; k++) {
                    pixels[i][k] = image.getRGB(k, i) ;
                    System.out.print(pixels[i][k] + " "); 
                }
                System.out.println();
            }
        }
    
        void doit () {
            clearzone(z);
        }

        void undo() {
            fillZone(z, pixels);
        }
    }

    public class CutEdit extends AbstractUndoableEdit {
        Coupe c ;
        
        CutEdit (Coupe c) {
            this.c = c ; 
        }
    
        @Override
        public void undo(){
            c.undo();
        }

        @Override
        public void redo(){
            c.doit();
        }

    }

    public BufferedImage getImage() {
        return image;
    }

    public void saveCut (Rectangle z) {
        BufferedImage sousIm =  image.getSubimage((int)z.getX(),(int)z.getY(), (int)z.getWidth(), (int)z.getHeight()) ; 
        Coupe c = new Coupe((int)z.getX(), (int)z.getY(), (int)z.getWidth(), (int)z.getHeight(), sousIm) ; 
        c.doit();
        undoManager.addEdit(new CutEdit(c)) ; 
    }

    public void fillzone1(Rectangle z, int[][] pixels){ //Les deux fillzone fonctionne, deux méthodes différentes ! 
        int p = 0;
        int l = 0;
        for(int i= z.x;  i<z.x + z.getWidth(); i++){
          for(int j= z.y; j<z.y + z.getHeight(); j++){
             int rgb = pixels[p][l];
             image.setRGB(i, j, rgb);
             if(pixels.length > p) p++;
             if(pixels[p].length > l) l++;
          }
        } 
    }

    public void fillZone(Rectangle z, int[][] pixels){
        for (int x = (int)z.getX() ; x < z.getX()+z.getWidth() ; x++) {
            for (int y = (int)z.getY() ; y< z.getY()+z.getHeight() ; y++) {
                image.setRGB(x, y,pixels[y-((int)z.getY())][x-((int)z.getX())]);
            }
        }
    }


    public void clearzone(Rectangle z){
        int [][] pixels = new int[z.height][z.width] ; 
        int rgb = Color.WHITE.getRGB() ; 
        for (int i = 0 ; i<pixels.length ; i++) {
            for (int k = 0 ; k<pixels[i].length ; k++) {
                pixels[i][k] = rgb ; 
            }
        }
        fillZone(z, pixels);
    }

    
}
