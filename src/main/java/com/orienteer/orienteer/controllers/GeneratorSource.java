
        package com.orienteer.orienteer.controllers;


        import apple.laf.JRSUIConstants;
        import com.google.gwt.user.client.ui.Grid;
        import com.sun.tools.internal.ws.processor.generator.GeneratorException;


public interface GeneratorSource {

    Grid getWidget();

    String getName();
    /**
     * @return the text to be encoded into the QR code.
     * @throws GeneratorException if the input data contains errors.
     */
    String getText() throws GeneratorException;
    /**
     * @param widget the widget that was last modified, and that we want to
     *        validate the content.
     * @throws GeneratorException if the widget contains errors.
     */
    void validate(JRSUIConstants.Widget widget) throws GeneratorException;

    void setFocus();
}
