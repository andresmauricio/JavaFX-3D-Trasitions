/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp_solucion_andres_acelas;

import com.javafx.experiments.importers.Importer3D;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author PC
 */
public class CP_SOLUCION_ANDRES_ACELAS extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        boolean supported = Platform.isSupported(ConditionalFeature.SCENE3D);
        if (supported) System.out.println("JavaFX 3D Listo");
        else System.out.println("Esta plataforma no soporta JavaFX 3D");    
    }
    
        public void chairScene(Stage stage) throws Exception {
        //StackPane root = new StackPane();        
       // Scene scene = new Scene(root, 300, 250);
       
        PointLight light1 = new PointLight();
        light1.setTranslateZ(-500);

        Node model = Importer3D.load(getClass().getResource("chair.obj").toExternalForm());
        model.setScaleX(4.0);
        model.setScaleY(4.0);
        model.setScaleZ(4.0);
        System.out.println(model.getRotate());  
        model.setRotate(90);
        System.out.println(model.getRotate());    
        
        Text title = new Text("Silla Con Brazos Orlando Blanca.");   
        title.setFont(Font.font ("Verdana", 26));
        title.setFill(Color.RED);
        title.setX(200);    
        title.setY(50);

        
        Text price = new Text("$350.000");
        price.setFont(Font.font ("Verdana", 24));
        price.setFill(Color.GREEN);
        price.setX(200);    
        price.setY(330);
        
        Text description = new Text("Descripción: Material: Tela \n" +
                            "micro perforada tipo malla.\n" +
                            "Componentes: Parte interna \n" +
                            "en madera (triplex 12 mm)\n" +
                            "Espuma: Poliuretano. \n" +
                            "Espesor: 50 mm\n" +
                            "Dimensiones: 48 cm de \n" +
                            "ancho x 51 cm de \n" +
                            "profundidad.");
        description.setFont(Font.font ("Verdana", 20));
        description.setFill(Color.BLACK);
        description.setX(200);    
        description.setY(90);
        

        Group root = new Group(model, title, description, price);

        Scene scene = new Scene(root, 1300, 800, true, SceneAntialiasing.BALANCED);

        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateX(scene.getWidth() / -3.0);
        camera.setTranslateY(scene.getHeight() / -3.0);

        RotateTransition rt = new RotateTransition(Duration.seconds( 10 ), model);
        
        rt.setCycleCount(Animation.INDEFINITE);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        rt.setAxis(new Point3D(0, 1, 0));
        rt.play();

        scene.setFill(Color.ANTIQUEWHITE);
        scene.setCamera(camera);
        stage.setTitle("JavaFX Graficos 3D - aNDRÉS MAURICIO ACELAS AREVALO");
        stage.setScene(scene);
        stage.show();
        
    }

 
}
