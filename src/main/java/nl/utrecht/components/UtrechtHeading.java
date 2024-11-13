package nl.utrecht.components;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import nl.utrecht.components.UtrechtHeading1;
import nl.utrecht.components.UtrechtHeading2;
import nl.utrecht.components.UtrechtHeading3;
import nl.utrecht.components.UtrechtHeading4;
import nl.utrecht.components.UtrechtHeading5;
import nl.utrecht.components.UtrechtHeading6;

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
        /*
        // label.add(new AttributeModifier("aria-level", "2"));

        
        if (level == HeadingLevel.LEVEL_1) {
            add(new UtrechtHeading1(id, labelModel));
        }
        else if (level == HeadingLevel.LEVEL_2) {
            add(new UtrechtHeading2(id, labelModel));
        }
        else if (level == HeadingLevel.LEVEL_3) {
            add(new UtrechtHeading3(id, labelModel));
        }
        else if (level == HeadingLevel.LEVEL_4) {
            add(new UtrechtHeading4(id, labelModel));
        }
        else if (level == HeadingLevel.LEVEL_5) {
            add(new UtrechtHeading5(id, labelModel));
        }
        else if (level == HeadingLevel.LEVEL_6) {
            add(new UtrechtHeading6(id, labelModel));
        }
        else {
            add(label);
        } */
    }

    @Override
    protected void onComponentTag(final ComponentTag tag){
        super.onComponentTag(tag);
        tag.put("aria-level", "42");
    }
    
    
    public UtrechtHeading addCssClass(String cssClass) {
        // slot.add(new AttributeAppender("class", Model.of(cssClass), " "));
        return this;
    }
}