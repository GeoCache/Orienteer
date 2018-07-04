package com.orienteer.orienteer.controllers;

import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextArea;

public final class TextGenerator implements GenratorSource {

    private Grid table;
    private final TextArea text = new TextArea();



    public TextGenerator(ChangeHandler changeHandler) {
        text.addStyleName(StylesDefs.INPUT_FIELD_REQUIRED);
        text.addChangeHandler(changeHandler);
        text.setVisibleLines(5);
    }

    @Override
    public String getName() {
        return "Text";
    }

    @Override
    public String getText() throws GenratorException {

    }
}
