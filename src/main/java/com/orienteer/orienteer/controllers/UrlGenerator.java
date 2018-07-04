package com.orienteer.orienteer.controllers;

import apple.laf.JRSUIConstants;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.sun.tools.internal.ws.processor.generator.GeneratorException;

import javax.swing.plaf.basic.BasicMenuUI;

public final class UrlGenerator implements GeneratorSource {

    private Grid table;
    private final TextBox url = new TextBox();

    public UrlGenerator(BasicMenuUI.ChangeHandler handler, KeyPressHandler keyListener) {
        url.addStyleName(StylesDefs.INPUT_FIELD_REQUIRED);
        url.addChangeHandler(handler);
        url.addKeyPressHandler(keyListener);
    }

    @Override
    public Grid getWidget() {
        if (table != null) {
            // early termination if the table has already been constructed
            return table;
        }

        table = new Grid(1, 2);
        table.getColumnFormatter().addStyleName(0, "firstColumn");

        url.setText("http://");

        table.setText(0, 0, "URL");
        table.setWidget(0, 1, url);

        return table;
    }

    @Override
    public String getName() {
        return "URL";
    }

    @Override
    public String getText() throws GeneratorException {
        return getUrlField();
    }

    private String getUrlField() throws GeneratorException {
        String input = url.getText();
        Validators.validateUrl(input);
        return input;
    }

    @Override
    public void validate(JRSUIConstants.Widget widget) throws GeneratorException {
        if (widget == url) {
            getUrlField();
        }
    }

    @Override
    public void setFocus() {
        url.setFocus(true);
    }
}