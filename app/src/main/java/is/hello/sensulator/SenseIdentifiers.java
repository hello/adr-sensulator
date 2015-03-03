package is.hello.sensulator;

import android.os.ParcelUuid;

public class SenseIdentifiers {
    public static final String ADVERTISEMENT_SERVICE_128_BIT = "23D1BCEA5F782315DEEF1212E1FE0000";
    public static final String ADVERTISEMENT_SERVICE_16_BIT = "E1FE";

    public static final ParcelUuid SERVICE = ParcelUuid.fromString("0000FEE1-1212-EFDE-1523-785FEABCD123");

    public static final ParcelUuid CHARACTERISTIC_PROTOBUF_COMMAND = ParcelUuid.fromString("0000BEEB-0000-1000-8000-00805F9B34FB");
    public static final ParcelUuid CHARACTERISTIC_PROTOBUF_COMMAND_RESPONSE = ParcelUuid.fromString("0000B00B-0000-1000-8000-00805F9B34FB");

    public static final ParcelUuid DESCRIPTOR_CHARACTERISTIC_COMMAND_RESPONSE_CONFIG = ParcelUuid.fromString("00002902-0000-1000-8000-00805F9B34FB");
}
