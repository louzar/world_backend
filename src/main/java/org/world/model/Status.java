package org.world.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Status.
 */
public class Status {

	/** The code. */
	private int code;
	
	/** The message. */
	private String message;

	/**
	 * The Constructor.
	 */
	public Status() {
	}

	/**
	 * The Constructor.
	 *
	 * @param code the code
	 * @param message the message
	 */
	public Status(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the code
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
