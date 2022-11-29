
import java.io.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;

public class ImageEditModel {
    
    private BufferedImage image;

    public ImageEditModel(String path) throws IOException {
        this.image = ImageIO.read(new File(path));
    }

    public BufferedImage getImage() {
        return image;
    }

    private static boolean verifyLength(Rectangle z, int[][] pixels){
        int Rwidth = (int) z.getWidth();
        int Rheight = (int) z.getHeight();

        for(int i=0; i<pixels.length; i++){
            if(pixels.length == Rwidth && pixels[i].length == Rheight ){
                return true;
            }
        }
        return false;
    }

    public void fillzone(Rectangle z, int[][] pixels){
        if(verifyLength(z, pixels)){
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
    }

    public void clearzone(Rectangle z){
        Color c = Color.WHITE;
        int White = c.getRGB();

        for(int i=z.x; i<z.x + z.getWidth(); i++ ){
            for(int j= z.y; j<z.y + z.getHeight(); j++){
                image.setRGB(i, j, White);
            }
        }
    }

    
}
