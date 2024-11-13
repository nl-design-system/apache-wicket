package nl.utrecht.components;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class UtrechtCheckbox extends Panel {
    private static final long serialVersionUID = 1L;
    
    private final CheckBox checkbox;
    private final Label description;
    private final IModel<String> errorMessageModel;
    private final Label errorMessage;
    private final String checkboxId;
    private final String fieldId;
    private final String descriptionId;
    private final String errorMessageId;
    
    public static final String FORM_FIELD_CLASSNAME = "utrecht-form-field";
    public static final String FORM_FIELD_CHECKBOX_CLASSNAME = "utrecht-form-field--checkbox";
    public static final String FORM_FIELD_INVALID_CLASSNAME = "utrecht-form-field--invalid";
    public static final String FORM_LABEL_CLASSNAME = "utrecht-form-label utrecht-form-label--checkbox";
    public static final String CHECKBOX_CLASSNAME = "utrecht-checkbox utrecht-checkbox--html-input utrecht-checkbox--custom";
    public static final String INVALID_CLASSNAME = "utrecht-checkbox--invalid";
    public static final String FORM_FIELD_INPUT_CLASSNAME = "utrecht-form-field__input";

    public UtrechtCheckbox(String id, IModel<Boolean> model, String labelText) {
        this(id, model, Model.of(labelText), null, null);
    }

    public static String joinTokens(String... classes) {
        return Arrays.asList(classes).stream()
            .filter(className -> className != null && !className.trim().isEmpty())
            .collect(Collectors.joining(" "));
    }

    public UtrechtCheckbox(String id, IModel<Boolean> model, IModel<String> labelModel,
                          IModel<String> descriptionModel, IModel<String> errorModel) {
        super(id);
        
            errorMessageModel = errorModel;
        
        // Generate unique IDs `for` and `aria-describedby` ID references
        fieldId = UUID.randomUUID().toString();
        checkboxId = UUID.randomUUID().toString();
        descriptionId = UUID.randomUUID().toString();
        errorMessageId = UUID.randomUUID().toString();
        
        // Create the checkbox input
        checkbox = new CheckBox("checkbox", model) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("id", checkboxId);
                tag.put("class", joinTokens(
                    UtrechtCheckbox.CHECKBOX_CLASSNAME,
                    UtrechtCheckbox.FORM_FIELD_INPUT_CLASSNAME,
                    isInvalid() ? UtrechtCheckbox.INVALID_CLASSNAME : null
                ));

                String ariaDescribedBy = joinTokens(
                    descriptionModel != null && descriptionModel.getObject() != null ? descriptionId : null,
                    isInvalid() ? errorMessageId : null
                );
                
                if (!ariaDescribedBy.isEmpty()) {
                    tag.put("aria-describedby", ariaDescribedBy);
                }
                
                if (isRequired()) {
                    tag.put("aria-required", "true");
                }
                if (isInvalid()) {
                    tag.put("aria-invalid", "true");
                }
            }
        };
        
        // Create the label
        Label label = new Label("label", labelModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("for", checkboxId);
                tag.put("class", UtrechtCheckbox.FORM_LABEL_CLASSNAME);
            }
        };
        
        // Create description and error message
        description = new Label("description", descriptionModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("id", descriptionId);
            }
            
            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };
        
        errorMessage = new Label("error", errorModel) {
            @Override
            protected void onComponentTag(ComponentTag tag) {
                super.onComponentTag(tag);
                tag.put("id", errorMessageId);
            }
            
            @Override
            public boolean isVisible() {
                return getDefaultModelObject() != null;
            }
        };
        
        // Add all components
        add(checkbox);
        add(label);
        add(description);
        add(errorMessage);
    }
    
    protected boolean isInvalid() {
        return errorMessageModel != null && errorMessageModel.getObject() != null;
    }
    protected boolean isRequired() {
        return checkbox.isRequired();
    }
    
    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.put("id", fieldId);
        tag.put("class", joinTokens(
            UtrechtCheckbox.FORM_FIELD_CLASSNAME,
            UtrechtCheckbox.FORM_FIELD_CHECKBOX_CLASSNAME,
            isInvalid() ? UtrechtCheckbox.FORM_FIELD_INVALID_CLASSNAME : null
        ));
    }
    
    public UtrechtCheckbox setRequired(boolean required) {
        checkbox.setRequired(required);
        return this;
    }
    
    public CheckBox getCheckbox() {
        return checkbox;
    }
}