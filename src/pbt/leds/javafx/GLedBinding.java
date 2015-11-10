package pbt.leds.javafx;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Les avec deux propriétés. L'une est boolean tandis que l'autre est de type
 * Color. La mise à jour graphique se fait par un binding et plus dans le
 * setter.
 * 
 * Le binding est un peu complexe et nécessite une classe non anonyme. En 
 * effet, les deux propriétés interviennent lors du coloriage de la led. 
 * 
 * Avec ce binding, il ne faut plus rien écrire de spécial dans les setters. 
 *
 * Merci à Jonathan pour l'info. 
 * 
 * @author Pierre Bettens (pbt) <pbettens@heb.be>
 * @author Jonathan Lechien (jlc) <jlechien@heb.be> 
 */
public class GLedBinding extends Parent {

    protected BooleanProperty on;
    protected ObjectProperty<Color> color;

    private final Circle circle;

    public GLedBinding() {
        on = new SimpleBooleanProperty(true);
        color = new ObjectPropertyBase<Color>(Color.RED) {

            @Override
            public Object getBean() {
                return this;
            }

            @Override
            public String getName() {
                return "Color";
            }
        };
        circle = new Circle(50);
        circle.setFill(color.get());
        circle.setStroke(Color.BLACK);
        /* 
         * Révision du binding. 
         * Je ne peux pas me contenter de ce qui suit si je veux que la mise
         * à jour se fasse aussi lorsque je change de couleur. 
         * (impossible d'utiliser un setter sur une propriété liée)
         *  
        circle.fillProperty().bind(
                Bindings.when(on)
                        .then(color.get())
                        .otherwise(Color.TRANSPARENT));
        */
        circle.fillProperty().bind(new FillShapeBinding());
        getChildren().add(circle);
    }

    public final void setOn(boolean aon) {
        on.set(aon);
    }

    public final boolean isOn() {
        return on.get();
    }

    public final BooleanProperty onProperty() {
        return on;
    }

    public final Color getColor() {
        return color.get();
    }

    public final void setColor(Color c) {
        color.set(c);  
    }

    public final ObjectProperty<Color> colorProperty() {
        return color;
    }
    
    private class FillShapeBinding extends ObjectBinding<Color> {

        public FillShapeBinding() {
            bind(color, on);
        }       
        
        @Override
        protected Color computeValue() {
            return isOn() ? getColor() : Color.TRANSPARENT;
        }
        
    }

}
