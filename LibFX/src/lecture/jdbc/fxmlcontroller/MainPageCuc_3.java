package lecture.jdbc.fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lecture.jdbc.service.BookInfService;
import lecture.jdbc.service.BookService;
import lecture.jdbc.service.PeopleService;
import lecture.jdbc.view.LoginView_1;
import lecture.jdbc.vo.BookInfVO;
import lecture.jdbc.vo.BookVO;
import lecture.jdbc.vo.PeopleVO;

public class MainPageCuc_3 implements Initializable, MainPage {

	LoginView_1 loginView_1 = new LoginView_1();
	String idtext;
	String searchKeyword;
	String bookSearchClickInfhave;
	String bookSearchClickID;
	String bookSearchClickInfbisbn;
	String bookSearchClickInftitle;
	String bookSearchClickInfdate;
	int bookSearchClickInfpage;
	int bookSearchClickInfprice;
	String bookSearchClickInfauthor;
	String bookSearchClickInftranslator;
	String bookSearchClickInfsupplement;
	String bookSearchClickInfpublisher;
	String bookSearchClickInfimgurl;

	ObservableList<BookVO> listM;

	@FXML private TextField IdTextField;
	@FXML private TextField NickTextField;
	@FXML private TextField PointTextField;
	@FXML private Button exitBtn;
	@FXML private Button PersonInfdel_ins;
	@FXML private Button BookHaveReturn;
	@FXML private Button BookDetailInf;
	@FXML private Button BookBorrow;
	@FXML private TextField BookSearchTextField;
	@FXML private Button Search;

	@FXML private TableView<BookVO> BookTableView;
	@FXML private TableColumn<BookVO, String> bisbn;
	@FXML private TableColumn<BookVO, String>  btitle;
	@FXML private TableColumn<BookVO, String>  bdate;
	@FXML private TableColumn<BookVO, Integer>  bpage;
	@FXML private TableColumn<BookVO, Integer> bprice;
	@FXML private TableColumn<BookVO, String> bauthor;
	@FXML private TableColumn<BookVO, String> bhave;
	@FXML private void UpdateTable(){
		bisbn.setCellValueFactory(new PropertyValueFactory<BookVO,String>("bisbn"));
		btitle.setCellValueFactory(new PropertyValueFactory<BookVO,String>("btitle"));
		bdate.setCellValueFactory(new PropertyValueFactory<BookVO,String>("bdate"));
		bpage.setCellValueFactory(new PropertyValueFactory<BookVO,Integer>("bpage"));
		bprice.setCellValueFactory(new PropertyValueFactory<BookVO,Integer>("bprice"));
		bauthor.setCellValueFactory(new PropertyValueFactory<BookVO,String>("bauthor"));
		bhave.setCellValueFactory(new PropertyValueFactory<BookVO,String>("bhave"));

		BookTableView.setItems(listM);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		exitBtn.setOnAction(e -> {
			System.exit(0);
		});
		PersonInfdel_ins.setOnAction(e -> { 
			new lecture.jdbc.view.PeopleInfdel_ins(idtext);
		});
		BookHaveReturn.setOnAction(e -> {
			new lecture.jdbc.view.BookHaveReturn(idtext, this);
		});
		BookDetailInf.setOnAction(e -> {
			new lecture.jdbc.view.BookDetailInf();
		});

		BookTableView.setRowFactory(e -> {
			TableRow<BookVO> row = new TableRow<>();
			row.setOnMouseClicked(e1 -> {
				BookVO book = row.getItem();
				bookSearchClickInfbisbn = book.getBisbn();
			});
			return row;
		});
		BookBorrow.setOnAction(e -> {
			if(bookSearchClickInfbisbn == null) {
				(new Alert(AlertType.WARNING, "대여하실 책을 클릭해주세요")).showAndWait();
			} else if (bookSearchClickInfbisbn != null) {
				BookService service2 = new BookService();
				BookVO rowbookborrow = service2.Bookborrowcheck(bookSearchClickInfbisbn);
				bookSearchClickInftitle = rowbookborrow.getBtitle();
				bookSearchClickInfdate = rowbookborrow.getBdate(); 
				bookSearchClickInfpage = rowbookborrow.getBpage();
				bookSearchClickInfprice = rowbookborrow.getBprice(); 
				bookSearchClickInfauthor = rowbookborrow.getBauthor(); 
				bookSearchClickInfhave = rowbookborrow.getBhave();
				bookSearchClickInftranslator = rowbookborrow.getBtranslator();
				bookSearchClickInfsupplement = rowbookborrow.getBsupplement();
				bookSearchClickInfpublisher = rowbookborrow.getBpublisher(); 
				bookSearchClickInfimgurl = rowbookborrow.getBimgurl();
				
				if (bookSearchClickInfhave.equals("대여중")) { Alert alert = new
						Alert(AlertType.ERROR); alert.setTitle("대여 불가");
						alert.setHeaderText("책의 재고가 없습니다."); alert.showAndWait();
						} else {
							BookInfService service1 = new BookInfService();

							service1.Bookborrowinfvo(idtext, bookSearchClickInfbisbn, bookSearchClickInftitle,
									bookSearchClickInfdate , bookSearchClickInfpage, bookSearchClickInfprice, bookSearchClickInfauthor,
									bookSearchClickInftranslator, bookSearchClickInfsupplement,
									bookSearchClickInfpublisher, bookSearchClickInfimgurl);

							BookService service = new BookService();
							service.Bookborrow(bookSearchClickInfbisbn);

							Alert alert = new Alert(AlertType.INFORMATION); alert.setTitle("대여 확인");
							alert.setHeaderText("책을 대여하였습니다."); alert.showAndWait(); 
							Search.fire();
						}
			}
		}); 

		// 책검색작동
		Search.setOnAction(e -> {
			BookService service = new BookService();
			ObservableList<BookVO> list= 
					service.selectBooksByKeyword(BookSearchTextField.getText());
			UpdateTable();
			BookTableView.setItems(list);
			searchKeyword = BookSearchTextField.getText();
			BookSearchTextField.clear();
		});
		BookSearchTextField.setOnAction(e -> {
			BookService service = new BookService();
			ObservableList<BookVO> list= 
					service.selectBooksByKeyword(BookSearchTextField.getText());
			UpdateTable();
			BookTableView.setItems(list);
			searchKeyword = BookSearchTextField.getText();
			BookSearchTextField.clear();
		});
		// 책검색작동
	}

	public void setArgAndRender(String idtext) {
		this.idtext = idtext;
		IdTextField.setText(idtext);

		PeopleService service = new PeopleService();
		PeopleVO person = service.Peopleinf(idtext);
		NickTextField.setText(person.getPname());
		
		BookInfService service2 = new BookInfService();
		BookInfVO pointView = service2.mainPointView(idtext);
		if (pointView == null) {
			PointTextField.setText("0");
		} else {
		PointTextField.setText(String.valueOf(pointView.getBpoint()));
		}
	}	

}