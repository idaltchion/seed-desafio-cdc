package com.idaltchion.cdc.exception;

import java.util.List;

public class Problem {

	private final Integer status;
	private final String title;
	private final List<Field> fields;

	private Problem(Builder builder) {
		this.status = builder.status;
		this.title = builder.title;
		this.fields = builder.fields;
	}

	public Integer getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public List<Field> getFields() {
		return fields;
	}

	public static class Builder {
		private Integer status;
		private String title;
		private List<Field> fields;

		public Builder status(final Integer status) {
			this.status = status;
			return this;
		}

		public Builder title(final String title) {
			this.title = title;
			return this;
		}

		public Builder fields(final List<Field> fields) {
			this.fields = fields;
			return this;
		}

		public Problem build() {
			return new Problem(this);
		}

	}

}
