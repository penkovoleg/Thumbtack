package net.thumbtack.school.elections.exception;

public class ServerException extends Exception{

    private final ServerErrorCode errorCode;

    public ServerException(ServerErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ServerErrorCode getErrorCode() {
        return errorCode;
    }
}
