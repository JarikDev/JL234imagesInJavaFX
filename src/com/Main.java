package com;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image=new Image(new FileInputStream("D:\\prog\\javalessons\\javafx\\JL234imagesInJavaFX\\pr.jpg"));
        ImageView imageView=new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(500);
        PixelReader pixelReader= image.getPixelReader();
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color color=pixelReader.getColor(i,j);
            }
        }
        WritableImage writableImage=new WritableImage((int)image.getWidth(),(int)image.getHeight());
        PixelWriter pixelWriter=writableImage.getPixelWriter();
        for (int i = 0; i < image.getHeight(); i++) {
            for (int  j = 0; j <image.getHeight(); j++) {
                pixelWriter.setColor(j,i,Color.ALICEBLUE);
            }
        }
        ImageIO.write(SwingFXUtils.fromFXImage(writableImage,null),"png",new FileOutputStream("test.png"));

        Group root=new Group();
        root.getChildren().add(new ImageView(writableImage));
        primaryStage.setTitle("Hello World !!!");
        primaryStage.setScene(new Scene(root,500,400));
        primaryStage.show();
    }
}


























