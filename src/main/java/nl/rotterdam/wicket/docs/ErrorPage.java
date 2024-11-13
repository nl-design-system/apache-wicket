package nl.rotterdam.wicket.docs;

import nl.utrecht.components.UtrechtButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class ErrorPage extends EmptyPage {

  public static final String ERROR_MESSAGE_ID = "error-message";
  public static final String ERROR_ACTION_ID = "error-action";

  public ErrorPage() {
    add(new Label(ERROR_MESSAGE_ID, "An error occured."));
    add(new UtrechtButton(ERROR_ACTION_ID, Model.of("Reload Page"), UtrechtButton.ButtonStyle.PRIMARY_ACTION));
  }
}
