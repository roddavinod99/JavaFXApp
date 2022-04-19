import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application
{

	public static void main(String[] args)
	{
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar=  createMenu();
		rootNode.getChildren().addAll(menuBar);
		// this atatement will add the menu bar in the VBox
		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}

	private MenuBar createMenu() {

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem= new MenuItem("New");

		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("new Menu Item Clicked");        // print the statement when the new MenuItem is clicked.
			}
		});

		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
		MenuItem quitMenuItem= new MenuItem("Quit");
		quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();                    // shut down the current application.
			}
		});
		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp= new Menu("About");
		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar= new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}
	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}
