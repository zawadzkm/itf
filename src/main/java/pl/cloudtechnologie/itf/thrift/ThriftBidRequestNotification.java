package pl.cloudtechnologie.itf.thrift;
/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-05-18")
public class ThriftBidRequestNotification implements org.apache.thrift.TBase<ThriftBidRequestNotification, ThriftBidRequestNotification._Fields>, java.io.Serializable, Cloneable, Comparable<ThriftBidRequestNotification> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ThriftBidRequestNotification");

  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("user_id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField HOST_HASH_FIELD_DESC = new org.apache.thrift.protocol.TField("host_hash", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField USER_AGENT_FIELD_DESC = new org.apache.thrift.protocol.TField("user_agent", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField IP_ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("ip_address", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)5);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ThriftBidRequestNotificationStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ThriftBidRequestNotificationTupleSchemeFactory();

  public long user_id; // required
  public long host_hash; // required
  public int user_agent; // required
  public int ip_address; // required
  public long timestamp; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_ID((short)1, "user_id"),
    HOST_HASH((short)2, "host_hash"),
    USER_AGENT((short)3, "user_agent"),
    IP_ADDRESS((short)4, "ip_address"),
    TIMESTAMP((short)5, "timestamp");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_ID
          return USER_ID;
        case 2: // HOST_HASH
          return HOST_HASH;
        case 3: // USER_AGENT
          return USER_AGENT;
        case 4: // IP_ADDRESS
          return IP_ADDRESS;
        case 5: // TIMESTAMP
          return TIMESTAMP;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __USER_ID_ISSET_ID = 0;
  private static final int __HOST_HASH_ISSET_ID = 1;
  private static final int __USER_AGENT_ISSET_ID = 2;
  private static final int __IP_ADDRESS_ISSET_ID = 3;
  private static final int __TIMESTAMP_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("user_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.HOST_HASH, new org.apache.thrift.meta_data.FieldMetaData("host_hash", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER_AGENT, new org.apache.thrift.meta_data.FieldMetaData("user_agent", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.IP_ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("ip_address", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ThriftBidRequestNotification.class, metaDataMap);
  }

  public ThriftBidRequestNotification() {
  }

  public ThriftBidRequestNotification(
    long user_id,
    long host_hash,
    int user_agent,
    int ip_address,
    long timestamp)
  {
    this();
    this.user_id = user_id;
    setUser_idIsSet(true);
    this.host_hash = host_hash;
    setHost_hashIsSet(true);
    this.user_agent = user_agent;
    setUser_agentIsSet(true);
    this.ip_address = ip_address;
    setIp_addressIsSet(true);
    this.timestamp = timestamp;
    setTimestampIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ThriftBidRequestNotification(ThriftBidRequestNotification other) {
    __isset_bitfield = other.__isset_bitfield;
    this.user_id = other.user_id;
    this.host_hash = other.host_hash;
    this.user_agent = other.user_agent;
    this.ip_address = other.ip_address;
    this.timestamp = other.timestamp;
  }

  public ThriftBidRequestNotification deepCopy() {
    return new ThriftBidRequestNotification(this);
  }


  public void clear() {
    setUser_idIsSet(false);
    this.user_id = 0;
    setHost_hashIsSet(false);
    this.host_hash = 0;
    setUser_agentIsSet(false);
    this.user_agent = 0;
    setIp_addressIsSet(false);
    this.ip_address = 0;
    setTimestampIsSet(false);
    this.timestamp = 0;
  }

  public long getUser_id() {
    return this.user_id;
  }

  public ThriftBidRequestNotification setUser_id(long user_id) {
    this.user_id = user_id;
    setUser_idIsSet(true);
    return this;
  }

  public void unsetUser_id() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __USER_ID_ISSET_ID);
  }

  /** Returns true if field user_id is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_id() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __USER_ID_ISSET_ID);
  }

  public void setUser_idIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __USER_ID_ISSET_ID, value);
  }

  public long getHost_hash() {
    return this.host_hash;
  }

  public ThriftBidRequestNotification setHost_hash(long host_hash) {
    this.host_hash = host_hash;
    setHost_hashIsSet(true);
    return this;
  }

  public void unsetHost_hash() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __HOST_HASH_ISSET_ID);
  }

  /** Returns true if field host_hash is set (has been assigned a value) and false otherwise */
  public boolean isSetHost_hash() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __HOST_HASH_ISSET_ID);
  }

  public void setHost_hashIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __HOST_HASH_ISSET_ID, value);
  }

  public int getUser_agent() {
    return this.user_agent;
  }

  public ThriftBidRequestNotification setUser_agent(int user_agent) {
    this.user_agent = user_agent;
    setUser_agentIsSet(true);
    return this;
  }

  public void unsetUser_agent() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __USER_AGENT_ISSET_ID);
  }

  /** Returns true if field user_agent is set (has been assigned a value) and false otherwise */
  public boolean isSetUser_agent() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __USER_AGENT_ISSET_ID);
  }

  public void setUser_agentIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __USER_AGENT_ISSET_ID, value);
  }

  public int getIp_address() {
    return this.ip_address;
  }

  public ThriftBidRequestNotification setIp_address(int ip_address) {
    this.ip_address = ip_address;
    setIp_addressIsSet(true);
    return this;
  }

  public void unsetIp_address() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __IP_ADDRESS_ISSET_ID);
  }

  /** Returns true if field ip_address is set (has been assigned a value) and false otherwise */
  public boolean isSetIp_address() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __IP_ADDRESS_ISSET_ID);
  }

  public void setIp_addressIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __IP_ADDRESS_ISSET_ID, value);
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public ThriftBidRequestNotification setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUser_id();
      } else {
        setUser_id((java.lang.Long)value);
      }
      break;

    case HOST_HASH:
      if (value == null) {
        unsetHost_hash();
      } else {
        setHost_hash((java.lang.Long)value);
      }
      break;

    case USER_AGENT:
      if (value == null) {
        unsetUser_agent();
      } else {
        setUser_agent((java.lang.Integer)value);
      }
      break;

    case IP_ADDRESS:
      if (value == null) {
        unsetIp_address();
      } else {
        setIp_address((java.lang.Integer)value);
      }
      break;

    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((java.lang.Long)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return getUser_id();

    case HOST_HASH:
      return getHost_hash();

    case USER_AGENT:
      return getUser_agent();

    case IP_ADDRESS:
      return getIp_address();

    case TIMESTAMP:
      return getTimestamp();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUser_id();
    case HOST_HASH:
      return isSetHost_hash();
    case USER_AGENT:
      return isSetUser_agent();
    case IP_ADDRESS:
      return isSetIp_address();
    case TIMESTAMP:
      return isSetTimestamp();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ThriftBidRequestNotification)
      return this.equals((ThriftBidRequestNotification)that);
    return false;
  }

  public boolean equals(ThriftBidRequestNotification that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_user_id = true;
    boolean that_present_user_id = true;
    if (this_present_user_id || that_present_user_id) {
      if (!(this_present_user_id && that_present_user_id))
        return false;
      if (this.user_id != that.user_id)
        return false;
    }

    boolean this_present_host_hash = true;
    boolean that_present_host_hash = true;
    if (this_present_host_hash || that_present_host_hash) {
      if (!(this_present_host_hash && that_present_host_hash))
        return false;
      if (this.host_hash != that.host_hash)
        return false;
    }

    boolean this_present_user_agent = true;
    boolean that_present_user_agent = true;
    if (this_present_user_agent || that_present_user_agent) {
      if (!(this_present_user_agent && that_present_user_agent))
        return false;
      if (this.user_agent != that.user_agent)
        return false;
    }

    boolean this_present_ip_address = true;
    boolean that_present_ip_address = true;
    if (this_present_ip_address || that_present_ip_address) {
      if (!(this_present_ip_address && that_present_ip_address))
        return false;
      if (this.ip_address != that.ip_address)
        return false;
    }

    boolean this_present_timestamp = true;
    boolean that_present_timestamp = true;
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(user_id);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(host_hash);

    hashCode = hashCode * 8191 + user_agent;

    hashCode = hashCode * 8191 + ip_address;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(timestamp);

    return hashCode;
  }


  public int compareTo(ThriftBidRequestNotification other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetUser_id()).compareTo(other.isSetUser_id());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_id()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_id, other.user_id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetHost_hash()).compareTo(other.isSetHost_hash());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHost_hash()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.host_hash, other.host_hash);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetUser_agent()).compareTo(other.isSetUser_agent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUser_agent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.user_agent, other.user_agent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIp_address()).compareTo(other.isSetIp_address());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIp_address()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ip_address, other.ip_address);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTimestamp()).compareTo(other.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, other.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ThriftBidRequestNotification(");
    boolean first = true;

    sb.append("user_id:");
    sb.append(this.user_id);
    first = false;
    if (!first) sb.append(", ");
    sb.append("host_hash:");
    sb.append(this.host_hash);
    first = false;
    if (!first) sb.append(", ");
    sb.append("user_agent:");
    sb.append(this.user_agent);
    first = false;
    if (!first) sb.append(", ");
    sb.append("ip_address:");
    sb.append(this.ip_address);
    first = false;
    if (!first) sb.append(", ");
    sb.append("timestamp:");
    sb.append(this.timestamp);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ThriftBidRequestNotificationStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ThriftBidRequestNotificationStandardScheme getScheme() {
      return new ThriftBidRequestNotificationStandardScheme();
    }
  }

  private static class ThriftBidRequestNotificationStandardScheme extends org.apache.thrift.scheme.StandardScheme<ThriftBidRequestNotification> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ThriftBidRequestNotification struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.user_id = iprot.readI64();
              struct.setUser_idIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HOST_HASH
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.host_hash = iprot.readI64();
              struct.setHost_hashIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // USER_AGENT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.user_agent = iprot.readI32();
              struct.setUser_agentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IP_ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.ip_address = iprot.readI32();
              struct.setIp_addressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestamp = iprot.readI64();
              struct.setTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ThriftBidRequestNotification struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI64(struct.user_id);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(HOST_HASH_FIELD_DESC);
      oprot.writeI64(struct.host_hash);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(USER_AGENT_FIELD_DESC);
      oprot.writeI32(struct.user_agent);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(IP_ADDRESS_FIELD_DESC);
      oprot.writeI32(struct.ip_address);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
      oprot.writeI64(struct.timestamp);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ThriftBidRequestNotificationTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ThriftBidRequestNotificationTupleScheme getScheme() {
      return new ThriftBidRequestNotificationTupleScheme();
    }
  }

  private static class ThriftBidRequestNotificationTupleScheme extends org.apache.thrift.scheme.TupleScheme<ThriftBidRequestNotification> {


    public void write(org.apache.thrift.protocol.TProtocol prot, ThriftBidRequestNotification struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetUser_id()) {
        optionals.set(0);
      }
      if (struct.isSetHost_hash()) {
        optionals.set(1);
      }
      if (struct.isSetUser_agent()) {
        optionals.set(2);
      }
      if (struct.isSetIp_address()) {
        optionals.set(3);
      }
      if (struct.isSetTimestamp()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetUser_id()) {
        oprot.writeI64(struct.user_id);
      }
      if (struct.isSetHost_hash()) {
        oprot.writeI64(struct.host_hash);
      }
      if (struct.isSetUser_agent()) {
        oprot.writeI32(struct.user_agent);
      }
      if (struct.isSetIp_address()) {
        oprot.writeI32(struct.ip_address);
      }
      if (struct.isSetTimestamp()) {
        oprot.writeI64(struct.timestamp);
      }
    }


    public void read(org.apache.thrift.protocol.TProtocol prot, ThriftBidRequestNotification struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.user_id = iprot.readI64();
        struct.setUser_idIsSet(true);
      }
      if (incoming.get(1)) {
        struct.host_hash = iprot.readI64();
        struct.setHost_hashIsSet(true);
      }
      if (incoming.get(2)) {
        struct.user_agent = iprot.readI32();
        struct.setUser_agentIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ip_address = iprot.readI32();
        struct.setIp_addressIsSet(true);
      }
      if (incoming.get(4)) {
        struct.timestamp = iprot.readI64();
        struct.setTimestampIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

