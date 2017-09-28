package com.test.utils.parameters;


public class ParameterManagementException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    protected ParameterManagementException() {
    }

    public ParameterManagementException(Throwable cause) {
        super(cause);
    }

    public ParameterManagementException(String errorString, Throwable cause) {
        super(errorString, cause);
    }

    public ParameterManagementException(String message) {
        super(message);
    }

    public ParameterManagementException(Error e) {
        super(e);
    }

    public ParameterManagementException(String errorString, Error e) {
        super(errorString, e);
    }
}
