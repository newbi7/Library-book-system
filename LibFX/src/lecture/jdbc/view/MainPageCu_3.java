package lecture.jdbc.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lecture.jdbc.fxmlcontroller.MainPageCuc_3;

public class MainPageCu_3 extends Stage {

	public MainPageCu_3() {
	}
	
	public MainPageCu_3(String arg) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmlcontroller/MainPageCu_3.fxml"));
			Parent root = loader.load();
			MainPageCuc_3 controller = loader.getController();
			controller.setArgAndRender(arg);
			Scene scene = new Scene(root);
			this.setScene(scene);
			this.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}