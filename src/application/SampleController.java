package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane circle1;

    @FXML
    private AnchorPane circle2;

    @FXML
    private AnchorPane circle3;

    @FXML
    private AnchorPane circle4;

    @FXML
    void initialize() {
    	
    	addRippleBackground();
       
    }
    private void addRippleBackground() {
    	circle1.setVisible(true);
		circle2.setVisible(true);
		circle3.setVisible(true);
		
    scaleTransition(1.5, circle1, 2, 2);
    FadeTransition fade=fadeTransition(1.5, circle1, 1, 0);
    	
    	scaleTransition(1, circle2, 2, 2);
    	fadeTransition(1, circle2, 1, 0);
    	
    		scaleTransition(.5, circle2, 2, 2);
    	fadeTransition(.5, circle2, 1, 0);
		
    	fade.setOnFinished(e->{
    		
    		 scaleTransition(.1, circle1, -2, -2);
    		    fadeTransition(.1, circle1, 0, 1);
    		    	
    		    	scaleTransition(.1, circle2, -2, -2);
    		    	fadeTransition(.1, circle2, 0, 1);
    		    	
    		    	scaleTransition(.1, circle2, -2, -2);
    		    	FadeTransition fade5=fadeTransition(.1, circle2, 0, 1);
    		    	
    		    	circle1.setVisible(false);
    	    		circle2.setVisible(false);
    	    		circle3.setVisible(false);
    		    	fade5.setOnFinished(e4->{
    		    		addRippleBackground();
    		    	});
    	});
	}
	public ScaleTransition scaleTransition(double duration,Node node,double byX,double byY) {
  		ScaleTransition scala1=new ScaleTransition(Duration.seconds(duration),node);
  		scala1.setByX(byX);
  		scala1.setByY(byY);
  		scala1.play();
  		scala1.play();
  		return scala1;
      	
      }
      
      public FadeTransition fadeTransition(double duration,Node node,double from,double to) {
      	
      	FadeTransition fdFadeTransition=new FadeTransition(Duration.seconds(duration),node);
      		fdFadeTransition.setFromValue(from);
      		fdFadeTransition.setToValue(to);
      		fdFadeTransition.play();
      		fdFadeTransition.play();
      		return fdFadeTransition;
      	
      }
}
