package com.idaltchion.cdc.exception;

public class Field {

	private final String name;
	private final String message;

	private Field(Builder builder) {
		this.name = builder.name;
		this.message = builder.message;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public static class Builder {
		private String name;
		private String message;

		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		public Builder message(final String message) {
			this.message = message;
			return this;
		}

		public Field build() {
			return new Field(this);
		}

	}
}
