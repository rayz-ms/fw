package com.ggar.core.math.domain;

import lombok.AccessLevel;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Accessors(fluent = true)
public class UnsignedShort extends Number {

	public static int MAX_VALUE = (int) Math.pow(2, 0xff - 1);

	public static UnsignedShort of(int value) {
		return Number.of(value & 0xff);
	}

	@Override
	protected Integer size() {
		return 0xff;
	}

	public UnsignedShort() {
		super();
	}

	public UnsignedShort(List<Boolean> value) {
		super(value);
	}
}