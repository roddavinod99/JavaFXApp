import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

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
		// this statement will add the menu bar in the VBox
		Scene scene = new Scene(rootNode, 300, 275);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.show();
	}

	private MenuBar createMenu() {

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem= new MenuItem("New");

		newMenuItem.setOnAction(event -> {
			System.out.println("new Menu Item Clicked");        // print the statement when the new MenuItem is clicked.
		});

		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
		MenuItem quitMenuItem= new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();                  // shut down the current application.
		    System.exit(0);             // to shut down the virtual machine
		});

		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp= new Menu("About");

		aboutApp.setOnAction(event -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		MenuBar menuBar= new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
			Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
			alertDialog.setTitle("My First Desktop App");
			alertDialog.setHeaderText("Learning JavaFX");
			alertDialog.setContentText("I am Just a beginner but soon I will be a pro and start developing awesome games.");
			ButtonType yesBtn= new ButtonType("yes");
			ButtonType noBtn = new ButtonType("No");

			alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
			Optional<ButtonType> clickBtn = alertDialog.showAndWait();

			if (clickBtn.isPresent() && clickBtn.get() == yesBtn){
				System.out.println("Yes button was clicked");
			}

			if (clickBtn.isPresent() && clickBtn.get() == noBtn){
				System.out.println("No button was clicked");
			}
		}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}
