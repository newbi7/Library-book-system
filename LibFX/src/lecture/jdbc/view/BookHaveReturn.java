package lecture.jdbc.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lecture.jdbc.fxmlcontroller.BookHaveReturnc;
import lecture.jdbc.fxmlcontroller.MainPage;

public class BookHaveReturn extends Stage {
	
	public BookHaveReturn() {
	}

	public BookHaveReturn(String arg, MainPage parentController) {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmlcontroller/BookHaveReturn.fxml"));
			Parent root = loader.load();
			BookHaveReturnc controller = loader.getController();
			controller.setArgAndRender(arg);
			Scene scene = new Scene(root);
			this.setScene(scene);
			this.showAndWait();
			parentController.setArgAndRender(arg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}