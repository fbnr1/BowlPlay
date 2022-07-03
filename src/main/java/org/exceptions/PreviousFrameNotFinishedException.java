package org.exceptions;

/**
 * @author FabianR
 */
public final class PreviousFrameNotFinishedException extends RuntimeException {

    public PreviousFrameNotFinishedException() {
        super();
    }

    public PreviousFrameNotFinishedException(String s) {
        super(s);
    }
}

