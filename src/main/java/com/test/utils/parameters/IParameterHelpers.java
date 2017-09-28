package com.test.utils.parameters;

import java.util.Properties;


public interface IParameterHelpers {

    /**
     * Returns the Parameter Value associated with the passed Parameter Name
     * from the ParameterLoader singleton class
     *
     * @param parameter
     * @return
     */
    public abstract String getRunParameter(String parameter);

    public abstract void setRunParameter(String parameterName,
                                         Object parameterValue);

    public Properties getAllRunParameters();

}
