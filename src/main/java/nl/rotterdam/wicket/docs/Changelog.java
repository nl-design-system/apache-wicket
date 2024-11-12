package nl.rotterdam.wicket.docs;

import nl.utrecht.components.UtrechtCodeBlock;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

public class Changelog extends EmptyPage
{
    public Changelog()
    {
        add( new Label( TITLE_ID, "Changelog · Apache Wicket · Rotterdam Design System"));

        add( new UtrechtCodeBlock( "changelog", Model.of("Reload Page")));
    }
}
