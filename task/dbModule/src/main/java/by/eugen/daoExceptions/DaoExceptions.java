package by.eugen.daoExceptions;


import org.apache.log4j.Logger;

public class DaoExceptions extends Exception {


    private Exception handlerException;
    private Logger logger = Logger.getLogger(this.getClass());

    public DaoExceptions(String message, Exception cause) {
        super(message, cause);
        logger.error(message + "\n caused by: " + cause.toString());
        handlerException = cause;
    }

    public Exception getHandlerException() {
        return handlerException;
    }
}
