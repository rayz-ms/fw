package com.ggar.core.math.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Number {

	protected Integer SIZE = size();
	List<Boolean> value;

	protected abstract Integer size();

	public Number() {
		value = Arrays.asList(new Boolean[SIZE]);
	}

	public Number(List<Boolean> value) {
		this();
		if (value.size() > SIZE) {
			throw new UnsupportedOperationException(String.format("Invalid size %s", value.size()));
		}
		for (int i = 0; i < SIZE; i++) {
			this.value.set(i, value.get(i));
		}
	}

	public static <T extends Number> T of(int value) {
		int shortValue = value & 0xff;
		int size = (int) Math.ceil(Math.log(value) / Math.log(2));
		List<Boolean> val = IntStream.range(0, size).boxed()
			.peek(i -> System.out.printf("%x %b\n", (shortValue & (1 << i)), (shortValue & (1 << i)) > 0))
			.map(i -> ((shortValue & (1 << i)) & 0xff) > 0)
			.toList();
		switch (size) {
			case 16: return (T) new UnsignedShort(val);

		}
		return null;
	}

	public Boolean get(int i) {
		if (i >= SIZE) throw new UnsupportedOperationException();
		return this.value.get(i);
	}

//	public <T extends Number> T and(Number value) {
//		return new Number(IntStream.range(0, SIZE).boxed()
//			.map(i -> this.get(i) || value.get(i))
//			.collect(Collectors.toList()));
//	}
}

