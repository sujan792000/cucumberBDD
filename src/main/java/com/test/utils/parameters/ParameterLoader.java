package com.test.utils.parameters;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;



public class ParameterLoader {
     /*
      * private instance variables to enforce Singleton creation use of public getters
      */

    private Properties runVars = new Properties();
    private static ParameterLoader _instance;
    //private final static Logger log = Logger.getLogger(ParameterLoader.class);
    private final static String FILE_ENCODING = "utf-8";


    /**
     * @return
     */
    protected Properties getRunVars() {
        return runVars;
    }

    /**
     * This is a singleton class, only one instance can be created
     */
    ParameterLoader() {
        populateGlobalParameters();
    }

    /* Prevents any thread issues */
    public static synchronized ParameterLoader getInstance() {
        if (_instance == null) {
            _instance = new ParameterLoader();
        }
        return _instance;
    }

    /* Overwrite clone method to stop any cloning */
    public ParameterLoader clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


    private void loadRuntimeParameters() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            InputStream runtimePropStream = loader.getResourceAsStream("RuntimeParams.properties");
            if (runtimePropStream == null) {
                return;
            }
            Reader reader = new InputStreamReader(runtimePropStream, FILE_ENCODING);
            runVars.load(reader);
            reader.close();
            runtimePropStream.close();
        } catch (IOException e) {
        }


    }

    protected void populateGlobalParameters() {
        loadRuntimeParameters();
    }

    protected void resetRunParameter(String parameterName, Object parameterValue) {
        runVars.put(parameterName, parameterValue);
    }

    protected Object getRunVar(String varName) {
        if (runVars.containsKey(varName)) {
            return runVars.get(varName);
        } else {
            return null;
        }
    }
}
