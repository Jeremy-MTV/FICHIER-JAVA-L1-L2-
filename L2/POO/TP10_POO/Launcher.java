
import java.io.IOException;
import java.awt.*;

public class Launcher {
    
    public static void main(String[] args) throws IOException{
        ImageEditModel img = new ImageEditModel("L2/POO/TP10_POO/landscape.png");
        ImageEditView view = new ImageEditView(img);
        view.pack();
        EventQueue.invokeLater(() -> {
            view.setVisible(true);   
        }); 
    }
}
