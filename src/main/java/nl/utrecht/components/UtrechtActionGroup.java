package nl.utrecht.components;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class UtrechtActionGroup extends Panel {

    public static final String SLOT_ID = "slot";
    private final Label label;

	public UtrechtActionGroup(String id,IModel<String> textContent) {
		super(id);
		label = new Label(SLOT_ID, textContent);
        add(label);
	}
}