package com.test.utils.parameters;



public class ParameterHelpersFactory {

    private IParameterHelpers ParameterHelpers;

    private static ParameterHelpersFactory factory = new ParameterHelpersFactory();

    /**
     * Singleton.
     */
    private ParameterHelpersFactory() {
        // default injection
        setParameterHelpers(new ParameterHelpers());
    }

    public static ParameterHelpersFactory getInstance() {
        return factory;
    }

    public IParameterHelpers getParameterHelpers() {

        return ParameterHelpers;
    }

    public void setParameterHelpers(IParameterHelpers ParameterHelpers) {
        this.ParameterHelpers = ParameterHelpers;
    }
}
