package com.bifrost.poc.messages;// automatically generated by the FlatBuffers compiler, do not modify

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class PatronProfileList extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_12_0(); }
  public static PatronProfileList getRootAsPatronProfileList(ByteBuffer _bb) { return getRootAsPatronProfileList(_bb, new PatronProfileList()); }
  public static PatronProfileList getRootAsPatronProfileList(ByteBuffer _bb, PatronProfileList obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public PatronProfileList __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public PatronProfile patrons(int j) { return patrons(new PatronProfile(), j); }
  public PatronProfile patrons(PatronProfile obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int patronsLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public PatronProfile.Vector patronsVector() { return patronsVector(new PatronProfile.Vector()); }
  public PatronProfile.Vector patronsVector(PatronProfile.Vector obj) { int o = __offset(4); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }

  public static int createPatronProfileList(FlatBufferBuilder builder,
      int patronsOffset) {
    builder.startTable(1);
    PatronProfileList.addPatrons(builder, patronsOffset);
    return PatronProfileList.endPatronProfileList(builder);
  }

  public static void startPatronProfileList(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addPatrons(FlatBufferBuilder builder, int patronsOffset) { builder.addOffset(0, patronsOffset, 0); }
  public static int createPatronsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startPatronsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endPatronProfileList(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
  public static void finishPatronProfileListBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedPatronProfileListBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public PatronProfileList get(int j) { return get(new PatronProfileList(), j); }
    public PatronProfileList get(PatronProfileList obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
