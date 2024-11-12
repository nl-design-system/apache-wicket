package nl.utrecht.components;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UtrechtHeading extends Panel {    
    public enum HeadingLevel {
        LEVEL_1("utrecht-heading-1"),
        LEVEL_2("utrecht-heading-2"),
        LEVEL_3("utrecht-heading-3"),
        LEVEL_4("utrecht-heading-4"),
        LEVEL_5("utrecht-heading-5"),
        LEVEL_6("utrecht-heading-6");
        
        private final String cssClass;
        
        HeadingLevel(String cssClass) {
            this.cssClass = cssClass;
        }
        
        public String getCssClass() {
            return cssClass;
        }
    }
    private final Label label;
    
    public UtrechtHeading(String id, IModel<String> labelModel, HeadingLevel level) {
        super(id);
        
        label = new Label("slot", labelModel);
        add(label);
    }
    
    
    public UtrechtHeading addCssClass(String cssClass) {
        // slot.add(new AttributeAppender("class", Model.of(cssClass), " "));
        return this;
    }
}