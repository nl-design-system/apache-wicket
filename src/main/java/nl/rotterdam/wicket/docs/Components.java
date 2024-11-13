package nl.rotterdam.wicket.docs;

import org.apache.wicket.markup.html.basic.Label;
// import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

import nl.utrecht.components.UtrechtActionGroup;
import nl.utrecht.components.UtrechtCheckbox;
import nl.utrecht.components.UtrechtCode;
import nl.utrecht.components.UtrechtCodeBlock;
import nl.utrecht.components.UtrechtHeading;
import nl.utrecht.components.UtrechtHeading1;
import nl.utrecht.components.UtrechtHeading2;
import nl.utrecht.components.UtrechtHeading3;
import nl.utrecht.components.UtrechtHeading4;
import nl.utrecht.components.UtrechtHeading5;
import nl.utrecht.components.UtrechtHeading6;

// import nl.utrecht.components.UtrechtUnorderedList;

public class Components extends EmptyPage
{
    public Components()
    {
        add( new Label( TITLE_ID, "Components · Apache Wicket · Rotterdam Design System"));

		// add(new BookmarkablePageLink("body", Changelog.class));
        add( new UtrechtCode( "code-example", Model.of("Reload Page")));

        add( new UtrechtCodeBlock( "code-block-example", Model.of("Reload Page")));

        add( new UtrechtHeading( "heading-level-1-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx"), UtrechtHeading.HeadingLevel.LEVEL_1));
        // add( new UtrechtHeading( "heading-level-2-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx"), UtrechtHeading.HeadingLevel.LEVEL_2));
        // add( new UtrechtHeading( "heading-level-3-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx"), UtrechtHeading.HeadingLevel.LEVEL_3));
        // add( new UtrechtHeading( "heading-level-4-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx"), UtrechtHeading.HeadingLevel.LEVEL_4));
        // add( new UtrechtHeading( "heading-level-5-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx"), UtrechtHeading.HeadingLevel.LEVEL_5));
        // add( new UtrechtHeading( "heading-level-6-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx"), UtrechtHeading.HeadingLevel.LEVEL_6));

        add( new UtrechtHeading1( "heading-1-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx")));
        add( new UtrechtHeading2( "heading-2-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx")));
        add( new UtrechtHeading3( "heading-3-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx")));
        add( new UtrechtHeading4( "heading-4-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx")));
        add( new UtrechtHeading5( "heading-5-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx")));
        add( new UtrechtHeading6( "heading-6-example", Model.of("Op brute wĳze ving de schooljuf de quasi-kalme lynx")));

        add( new UtrechtActionGroup( "action-group-example"));

        add( new UtrechtCheckbox( "form-field-checkbox-example", Model.of(false), "I agree"));
        add( new UtrechtCheckbox( "form-field-checkbox-checked-example", Model.of(true), "I agree"));
        add( new UtrechtCheckbox( "form-field-checkbox-invalid-example", Model.of(false), "I agree"));
        UtrechtCheckbox requiredCheckbox = new UtrechtCheckbox( "form-field-checkbox-required-example", Model.of(false), "I agree");
        requiredCheckbox.setRequired(true);
        add( requiredCheckbox );
        add( new UtrechtCheckbox( "form-field-checkbox-description-example", Model.of(false), Model.of("I agree"), Model.of("Description"), Model.of("error")));

    }
}
