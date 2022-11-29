
import java.io.IOException;

public class Launcher {
    
    public static void main(String[] args) throws IOException{
        ImageEditModel img = new ImageEditModel("L2/POO/TP10_POO/landscape.png");
        ImageEditView view = new ImageEditView(img);
        view.pack();
        view.setVisible(true);
    }
}
