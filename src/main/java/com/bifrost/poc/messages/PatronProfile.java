package com.bifrost.poc.messages;// automatically generated by the FlatBuffers compiler, do not modify

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class PatronProfile extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_12_0(); }
  public static PatronProfile getRootAsPatronProfile(ByteBuffer _bb) { return getRootAsPatronProfile(_bb, new PatronProfile()); }
  public static PatronProfile getRootAsPatronProfile(ByteBuffer _bb, PatronProfile obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public PatronProfile __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public String name() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nameAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer nameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public String nickname() { int o = __offset(6); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer nicknameAsByteBuffer() { return __vector_as_bytebuffer(6, 1); }
  public ByteBuffer nicknameInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 1); }
  public String emails(int j) { int o = __offset(8); return o != 0 ? __string(__vector(o) + j * 4) : null; }
  public int emailsLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }
  public StringVector emailsVector() { return emailsVector(new StringVector()); }
  public StringVector emailsVector(StringVector obj) { int o = __offset(8); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  public PatronAddress addresses(int j) { return addresses(new PatronAddress(), j); }
  public PatronAddress addresses(PatronAddress obj, int j) { int o = __offset(10); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int addressesLength() { int o = __offset(10); return o != 0 ? __vector_len(o) : 0; }
  public PatronAddress.Vector addressesVector() { return addressesVector(new PatronAddress.Vector()); }
  public PatronAddress.Vector addressesVector(PatronAddress.Vector obj) { int o = __offset(10); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  public String mobilePhones(int j) { int o = __offset(12); return o != 0 ? __string(__vector(o) + j * 4) : null; }
  public int mobilePhonesLength() { int o = __offset(12); return o != 0 ? __vector_len(o) : 0; }
  public StringVector mobilePhonesVector() { return mobilePhonesVector(new StringVector()); }
  public StringVector mobilePhonesVector(StringVector obj) { int o = __offset(12); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  public String homePhones(int j) { int o = __offset(14); return o != 0 ? __string(__vector(o) + j * 4) : null; }
  public int homePhonesLength() { int o = __offset(14); return o != 0 ? __vector_len(o) : 0; }
  public StringVector homePhonesVector() { return homePhonesVector(new StringVector()); }
  public StringVector homePhonesVector(StringVector obj) { int o = __offset(14); return o != 0 ? obj.__assign(__vector(o), 4, bb) : null; }
  public String homeLibraryCode() { int o = __offset(16); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer homeLibraryCodeAsByteBuffer() { return __vector_as_bytebuffer(16, 1); }
  public ByteBuffer homeLibraryCodeInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 16, 1); }
  public String preferredPickupLocationCode() { int o = __offset(18); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer preferredPickupLocationCodeAsByteBuffer() { return __vector_as_bytebuffer(18, 1); }
  public ByteBuffer preferredPickupLocationCodeInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 18, 1); }
  public PreferredNotificationChannel notificationPreference() { return notificationPreference(new PreferredNotificationChannel()); }
  public PreferredNotificationChannel notificationPreference(PreferredNotificationChannel obj) { int o = __offset(20); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createPatronProfile(FlatBufferBuilder builder,
      int nameOffset,
      int nicknameOffset,
      int emailsOffset,
      int addressesOffset,
      int mobilePhonesOffset,
      int homePhonesOffset,
      int homeLibraryCodeOffset,
      int preferredPickupLocationCodeOffset,
      int notificationPreferenceOffset) {
    builder.startTable(9);
    PatronProfile.addNotificationPreference(builder, notificationPreferenceOffset);
    PatronProfile.addPreferredPickupLocationCode(builder, preferredPickupLocationCodeOffset);
    PatronProfile.addHomeLibraryCode(builder, homeLibraryCodeOffset);
    PatronProfile.addHomePhones(builder, homePhonesOffset);
    PatronProfile.addMobilePhones(builder, mobilePhonesOffset);
    PatronProfile.addAddresses(builder, addressesOffset);
    PatronProfile.addEmails(builder, emailsOffset);
    PatronProfile.addNickname(builder, nicknameOffset);
    PatronProfile.addName(builder, nameOffset);
    return PatronProfile.endPatronProfile(builder);
  }

  public static void startPatronProfile(FlatBufferBuilder builder) { builder.startTable(9); }
  public static void addName(FlatBufferBuilder builder, int nameOffset) { builder.addOffset(0, nameOffset, 0); }
  public static void addNickname(FlatBufferBuilder builder, int nicknameOffset) { builder.addOffset(1, nicknameOffset, 0); }
  public static void addEmails(FlatBufferBuilder builder, int emailsOffset) { builder.addOffset(2, emailsOffset, 0); }
  public static int createEmailsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startEmailsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addAddresses(FlatBufferBuilder builder, int addressesOffset) { builder.addOffset(3, addressesOffset, 0); }
  public static int createAddressesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startAddressesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addMobilePhones(FlatBufferBuilder builder, int mobilePhonesOffset) { builder.addOffset(4, mobilePhonesOffset, 0); }
  public static int createMobilePhonesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startMobilePhonesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addHomePhones(FlatBufferBuilder builder, int homePhonesOffset) { builder.addOffset(5, homePhonesOffset, 0); }
  public static int createHomePhonesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startHomePhonesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addHomeLibraryCode(FlatBufferBuilder builder, int homeLibraryCodeOffset) { builder.addOffset(6, homeLibraryCodeOffset, 0); }
  public static void addPreferredPickupLocationCode(FlatBufferBuilder builder, int preferredPickupLocationCodeOffset) { builder.addOffset(7, preferredPickupLocationCodeOffset, 0); }
  public static void addNotificationPreference(FlatBufferBuilder builder, int notificationPreferenceOffset) { builder.addOffset(8, notificationPreferenceOffset, 0); }
  public static int endPatronProfile(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public PatronProfile get(int j) { return get(new PatronProfile(), j); }
    public PatronProfile get(PatronProfile obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}

