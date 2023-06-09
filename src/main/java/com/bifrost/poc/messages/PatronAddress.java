package com.bifrost.poc.messages;// automatically generated by the FlatBuffers compiler, do not modify

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class PatronAddress extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_12_0(); }
  public static PatronAddress getRootAsPatronAddress(ByteBuffer _bb) { return getRootAsPatronAddress(_bb, new PatronAddress()); }
  public static PatronAddress getRootAsPatronAddress(ByteBuffer _bb, PatronAddress obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public PatronAddress __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String line1() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer line1AsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer line1InByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public String line2() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer line2AsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer line2InByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  public String city() { int o = __offset(8); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer cityAsByteBuffer() { return __vector_as_bytebuffer(8, 1); }
  public ByteBuffer cityInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 8, 1); }
  public String stateCode() { int o = __offset(10); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer stateCodeAsByteBuffer() { return __vector_as_bytebuffer(10, 1); }
  public ByteBuffer stateCodeInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 10, 1); }
  public String postalCode() { int o = __offset(12); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer postalCodeAsByteBuffer() { return __vector_as_bytebuffer(12, 1); }
  public ByteBuffer postalCodeInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 12, 1); }

  public static int createPatronAddress(FlatBufferBuilder builder,
      int line1Offset,
      int line2Offset,
      int cityOffset,
      int stateCodeOffset,
      int postalCodeOffset) {
    builder.startTable(5);
    PatronAddress.addPostalCode(builder, postalCodeOffset);
    PatronAddress.addStateCode(builder, stateCodeOffset);
    PatronAddress.addCity(builder, cityOffset);
    PatronAddress.addLine2(builder, line2Offset);
    PatronAddress.addLine1(builder, line1Offset);
    return PatronAddress.endPatronAddress(builder);
  }

  public static void startPatronAddress(FlatBufferBuilder builder) { builder.startTable(5); }
  public static void addLine1(FlatBufferBuilder builder, int line1Offset) { builder.addOffset(0, line1Offset, 0); }
  public static void addLine2(FlatBufferBuilder builder, int line2Offset) { builder.addOffset(1, line2Offset, 0); }
  public static void addCity(FlatBufferBuilder builder, int cityOffset) { builder.addOffset(2, cityOffset, 0); }
  public static void addStateCode(FlatBufferBuilder builder, int stateCodeOffset) { builder.addOffset(3, stateCodeOffset, 0); }
  public static void addPostalCode(FlatBufferBuilder builder, int postalCodeOffset) { builder.addOffset(4, postalCodeOffset, 0); }
  public static int endPatronAddress(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public PatronAddress get(int j) { return get(new PatronAddress(), j); }
    public PatronAddress get(PatronAddress obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

