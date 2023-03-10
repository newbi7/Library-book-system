package lecture.jdbc.view;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import lecture.jdbc.service.PeopleService;
import lecture.jdbc.vo.PeopleVO;

public class PWFind {

	public Parent getRoot() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setAlignment(Pos.CENTER);

		Label title = new Label("PW 찾기");
		title.setMaxWidth(Double.MAX_VALUE);
		title.setAlignment(Pos.CENTER);
		title.setFont(Font.font(25));

		Label label1 = new Label("성명 : ");
		TextField textf1 = new TextField();
		textf1.setPromptText(" ");

		Label label2 = new Label("주민번호 : ");
		TextField textf2 = new TextField();
		textf2.setPromptText("숫자만입력해주세요");

		Label label3 = new Label("ID : ");
		TextField textf3 = new TextField();
		textf3.setPromptText(" ");

		Label label4 = new Label("PW : ");
		TextField textf4 = new TextField();
		textf4.setPromptText(" ");

		Button btn1 = new Button("닫기");
		Button btn2 = new Button("찾기");

		ColumnConstraints cc1 = new ColumnConstraints();
		ColumnConstraints cc2 = new ColumnConstraints();
		cc1.setPercentWidth(23);
		cc2.setPercentWidth(23);

		GridPane btmgridPane = new GridPane();
		btmgridPane.getColumnConstraints().addAll(cc1, cc2);
		btmgridPane.setHgap(10);
		btmgridPane.setAlignment(Pos.CENTER);

		btn1.setMaxWidth(Double.MAX_VALUE);
		btn2.setMaxWidth(Double.MAX_VALUE);

		gridPane.add(btn1, 0, 4);
		gridPane.add(btn2, 1, 4);

		gridPane.add(title, 0, 0, 2, 1);

		gridPane.add(label1, 0, 1);
		gridPane.add(textf1, 1, 1);

		gridPane.add(label2, 0, 2);
		gridPane.add(textf2, 1, 2);

		gridPane.add(label3, 0, 3);
		gridPane.add(textf3, 1, 3);

		gridPane.add(label4, 0, 5);
		gridPane.add(textf4, 1, 5);

		gridPane.add(btmgridPane, 0, 5, 2, 1);

		btn1.setOnAction(e -> { 
			((Button)btn1).getScene().getWindow().hide();
		});

		btn2.setOnAction(e -> {
			try {
				String idfname = textf1.getText().trim();
				String idfsnumber = textf2.getText().trim();
				String idfsid = textf3.getText().trim();
				PeopleService service = new PeopleService();
				ObservableList<PeopleVO> list= service.PWFindpssnumber(idfname, idfsnumber, idfsid);
				String idfspw = list.get(0).getPpw();
				
				if (textf1.getText().equals("") || textf2.getText().equals(""))	{
					textf4.setText("");
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("오류");
					alert.setHeaderText("빈칸이 있습니다.");
					alert.showAndWait();
				} else if (idfspw != null) {
					textf4.setText(idfspw);
				} else if (!textf4.getText().equals(idfspw)) {
					textf4.setText("없습니다.");
				} else {
					textf4.setText("없습니다.");
				}
			} catch (Exception e1) {
				textf4.setText("없습니다.");
			}
			return;
		});
		return gridPane;
	}
}