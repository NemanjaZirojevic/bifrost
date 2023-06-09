package com.bifrost.poc;

import com.google.common.base.Preconditions;
import com.google.flatbuffers.Table;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = false, includeFieldNames = true)
public class FlatBuffersMessage {

	private final String id;

	private final Class<?> klass;

	private final Method buildMethod;

	public FlatBuffersMessage(String id, Class<? extends Table> klass) throws Exception {
		this.id = id;
		this.klass = klass;
		final Method m = klass.getMethod("getRootAs" + klass.getSimpleName(), ByteBuffer.class);
		Preconditions.checkArgument(m != null, "This message is not FlatBuffers message");
		this.buildMethod = m;
	}

	public Table build(final ByteBuffer bytes)
			throws FlatBuffersMessageProtocolException {
		try {
			return (Table) this.buildMethod.invoke(klass, bytes);
		} catch (Exception e) {
			throw new FlatBuffersMessageProtocolException("Unavailable flatbuffers message.", e);
		}
	}
}
