package pancito.fxtransitions.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Animate a fade out up big effect on a node
 * 
 * Port of FadeOutDownBig from Animate.css http://daneden.me/animate by Dan Eden
 * 
 * {@literal @}keyframes fadeOutDownBig {
 * 	0% {
 * 		opacity: 1;
 * 		transform: translateY(0);
 * 	}
 * 	100% {
 * 		opacity: 0;
 * 		transform: translateY(2000px);
 * 	}
 * }
 * 
 * @author Jasper Potts
 */
public class FadeOutDownBigTransition extends CachedTimelineTransition {
    /**
     * Create new FadeOutDownBigTransition
     * 
     * @param node The node to affect
     */
    public FadeOutDownBigTransition(final Node node) {
        super(node, null);
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0.2));
    }

    @Override protected void starting() {
        double endY = node.getScene().getHeight() - node.localToScene(0, 0).getY();
        timeline = new Timeline(
                    new KeyFrame(Duration.millis(0),    
                        new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                        new KeyValue(node.translateYProperty(), 0, WEB_EASE)
                    ),
                    new KeyFrame(Duration.millis(1000),    
                        new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                        new KeyValue(node.translateYProperty(), endY, WEB_EASE)
                    )
                );
        super.starting();
    }

    @Override protected void stopping() {
        super.stopping();
        node.setTranslateY(0); // restore default
    }
}
