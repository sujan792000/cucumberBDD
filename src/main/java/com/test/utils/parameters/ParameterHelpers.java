package com.test.utils.parameters;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: SujanthanRajagopal
 * Date: 20/05/14
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class ParameterHelpers implements IParameterHelpers {

    private static ParameterLoader parameterLoader = ParameterLoader.getInstance();


    /**
     * Returns the Parameter Value associated with the passed Parameter Name
     * from the ParameterLoader singleton class
     *
     * @param parameter
     * @return
     */
    public String getRunParameter(String parameter) {
        String value;
        // read from the system properties first
        // if not read from properties file
        if (System.getProperty(parameter) != null) {
            value = System.getProperty(parameter);
        } else {
            Object paramValue = parameterLoader.getRunVar(parameter);
            if (paramValue == null) {
                value = null;
            } else {
                value = parameterLoader.getRunVar(parameter).toString();
            }
        }
        return value;
    }

    public void setRunParameter(String parameterName, Object parameterValue) {
        parameterLoader.resetRunParameter(parameterName, parameterValue);
    }

    @Override
    public Properties getAllRunParameters() {
        return parameterLoader.getRunVars();
    }

}

