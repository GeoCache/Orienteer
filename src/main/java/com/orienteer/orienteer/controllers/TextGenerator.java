package com.orienteer.orienteer.controllers;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.sun.tools.internal.ws.processor.generator.GeneratorException;

public final class TextGenerator implements GenratorSource, GeneratorSource {

    private Grid table;
    private final TextArea text = new TextArea();



    public TextGenerator(ChangeHandler changeHandler) {
        text.addStyleName(StylesDefs.INPUT_FIELD_REQUIRED);
        text.addChangeHandler(changeHandler);
        text.setVisibleLines(5);
    }

    @Override
    public Grid getWidget() {
        return null;
    }

    @Override
    public String getName() {
        return "Text";
    }

    @Override
    public String getText() throws GenratorException {

        return null;
    }

    @Override
    public void validate(TextBox widget) throws GeneratorException {

    }

    @Override
    public void setFocus() {

    }
}
