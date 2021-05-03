/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp_solucion_andres_acelas;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

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
 
}
