package nl.utrecht.components;

import nl.utrecht.components.UtrechtHeading1;
import nl.utrecht.components.UtrechtHeading2;
import nl.utrecht.components.UtrechtHeading3;
import nl.utrecht.components.UtrechtHeading4;
import nl.utrecht.components.UtrechtHeading5;
import nl.utrecht.components.UtrechtHeading6;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.ComponentTag;
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
    label = new Label("slot", labelModel) {
      @Override
      protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (level == HeadingLevel.LEVEL_1) {
          tag.setName("h1");
          tag.put("class", "utrecht-heading-1");
        } else if (level == HeadingLevel.LEVEL_2) {
          tag.setName("h2");
          tag.put("class", "utrecht-heading-2");
        } else if (level == HeadingLevel.LEVEL_3) {
          tag.setName("h3");
          tag.put("class", "utrecht-heading-3");
        } else if (level == HeadingLevel.LEVEL_4) {
          tag.setName("h4");
          tag.put("class", "utrecht-heading-4");
        } else if (level == HeadingLevel.LEVEL_5) {
          tag.setName("h5");
          tag.put("class", "utrecht-heading-5");
        } else if (level == HeadingLevel.LEVEL_6) {
          tag.setName("h6");
          tag.put("class", "utrecht-heading-6");
        } else {
          tag.setName("p");
          tag.put("class", "utrecht-heading-6");
        }
      }
    };

    add(label);
  }
}
