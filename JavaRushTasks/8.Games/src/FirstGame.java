import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstGame extends Game {
    @Override
    public void initialize() {
        setScreenSize(7, 9);

        setCellValueEx(1, 1, Color.BLUE, "X", Color.ORANGE, 50);
        //super.initialize();
    }
}
