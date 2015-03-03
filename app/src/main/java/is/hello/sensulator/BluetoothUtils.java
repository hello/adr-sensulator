package is.hello.sensulator;

import android.support.annotation.NonNull;

public final class BluetoothUtils {

    public static @NonNull String bytesToString(@NonNull byte[] bytes) {
        StringBuilder builder = new StringBuilder(bytes.length * 2);

        for (byte b : bytes)
            builder.append(String.format("%02X", b));

        return builder.toString();
    }

    public static @NonNull byte[] stringToBytes(@NonNull String string) {
        if (string.length() % 2 != 0)
            throw new IllegalArgumentException("string length is odd");

        byte[] bytes = new byte[string.length() / 2];
        for (int i = 0, length = string.length(); i < length; i += 2) {
            bytes[i / 2] = (byte) Integer.parseInt(string.substring(i, i + 2), 16);
        }
        return bytes;
    }

    public static boolean bytesStartsWith(@NonNull byte[] haystack, @NonNull byte[] needle) {
        if (haystack.length < needle.length) {
            return false;
        }

        for (int i = 0, length = needle.length; i < length; i++) {
            if (haystack[i] != needle[i]) {
                return false;
            }
        }

        return true;
    }

    // See https://www.bluetooth.org/en-us/specification/assigned-numbers/generic-access-profile
    public static final int TYPE_FLAGS = 0x01;
    public static final int TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS = 0x02;
    public static final int TYPE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS = 0x03;
    public static final int TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS = 0x04;
    public static final int TYPE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS = 0x05;
    public static final int TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS = 0x06;
    public static final int TYPE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS = 0x07;
    public static final int TYPE_SHORTENED_LOCAL_NAME = 0x08;
    public static final int TYPE_LOCAL_NAME = 0x09;
    public static final int TYPE_TX_POWER_LEVEL = 0x0A;
    public static final int TYPE_CLASS_OF_DEVICE = 0x0D;
    public static final int TYPE_SIMPLE_PAIRING_HASH_C = 0x0E;
    public static final int TYPE_SIMPLE_PAIRING_RANDOMIZER_R = 0x0F;
    public static final int TYPE_DEVICE_ID = 0x10;
    public static final int TYPE_SECURITY_MANAGER_OUT_OF_BAND_FLAGS = 0x11;
    public static final int TYPE_SLAVE_CONNECTION_INTERVAL_RANGE = 0x12;
    public static final int TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS = 0x14;
    public static final int TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS = 0x1F;
    public static final int TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS = 0x15;
    public static final int TYPE_SERVICE_DATA = 0x16;
    public static final int TYPE_SERVICE_DATA_32_BIT_UUID = 0x20;
    public static final int TYPE_SERVICE_DATA_128_BIT_UUID = 0x21;
    public static final int TYPE_PUBLIC_TARGET_ADDRESS = 0x17;
    public static final int TYPE_RANDOM_TARGET_ADDRESS = 0x18;
    public static final int TYPE_APPEARANCE = 0x19;
    public static final int TYPE_ADVERTISING_INTERVAL = 0x1A;
    public static final int TYPE_​LE_BLUETOOTH_DEVICE_ADDRESS = 0x1B;
    public static final int TYPE_​LE_ROLE = 0x1C;
    public static final int TYPE_​SIMPLE_PAIRING_HASH_C_256 = 0x1D;
    public static final int TYPE_​SIMPLE_PAIRING_RANDOMIZER_R_256 = 0x1E;
    public static final int TYPE_​3D_INFORMATION_DATA = 0x3D;
    public static final int TYPE_MANUFACTURER_SPECIFIC_DATA = 0xFF;

    public static @NonNull String typeToString(int type) {
        switch (type) {
            case TYPE_FLAGS:
                return "TYPE_FLAGS";

            case TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS:
                return "TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS";

            case TYPE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS:
                return "TYPE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS";

            case TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS:
                return "TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS";

            case TYPE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS:
                return "TYPE_LIST_OF_32_BIT_SERVICE_CLASS_UUIDS";

            case TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS:
                return "TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS";

            case TYPE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS:
                return "TYPE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS";

            case TYPE_SHORTENED_LOCAL_NAME:
                return "TYPE_SHORTENED_LOCAL_NAME";

            case TYPE_LOCAL_NAME:
                return "TYPE_LOCAL_NAME";

            case TYPE_TX_POWER_LEVEL:
                return "TYPE_TX_POWER_LEVEL";

            case TYPE_CLASS_OF_DEVICE:
                return "TYPE_CLASS_OF_DEVICE";

            case TYPE_SIMPLE_PAIRING_HASH_C:
                return "TYPE_SIMPLE_PAIRING_HASH_C";

            case TYPE_SIMPLE_PAIRING_RANDOMIZER_R:
                return "TYPE_SIMPLE_PAIRING_RANDOMIZER_R";

            case TYPE_DEVICE_ID:
                return "TYPE_DEVICE_ID";

            case TYPE_SECURITY_MANAGER_OUT_OF_BAND_FLAGS:
                return "TYPE_SECURITY_MANAGER_OUT_OF_BAND_FLAGS";

            case TYPE_SLAVE_CONNECTION_INTERVAL_RANGE:
                return "TYPE_SLAVE_CONNECTION_INTERVAL_RANGE";

            case TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS:
                return "TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS";

            case TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS:
                return "TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS";

            case TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS:
                return "TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS";

            case TYPE_SERVICE_DATA:
                return "TYPE_SERVICE_DATA";

            case TYPE_SERVICE_DATA_32_BIT_UUID:
                return "TYPE_SERVICE_DATA_32_BIT_UUID";

            case TYPE_SERVICE_DATA_128_BIT_UUID:
                return "TYPE_SERVICE_DATA_128_BIT_UUID";

            case TYPE_PUBLIC_TARGET_ADDRESS:
                return "TYPE_PUBLIC_TARGET_ADDRESS";

            case TYPE_RANDOM_TARGET_ADDRESS:
                return "TYPE_RANDOM_TARGET_ADDRESS";

            case TYPE_APPEARANCE:
                return "TYPE_APPEARANCE";

            case TYPE_ADVERTISING_INTERVAL:
                return "TYPE_ADVERTISING_INTERVAL";

            case TYPE_MANUFACTURER_SPECIFIC_DATA:
                return "TYPE_MANUFACTURER_SPECIFIC_DATA";

            case TYPE_​LE_BLUETOOTH_DEVICE_ADDRESS:
                return "TYPE_​LE_BLUETOOTH_DEVICE_ADDRESS";

            case TYPE_​LE_ROLE:
                return "TYPE_​LE_ROLE";

            case TYPE_​SIMPLE_PAIRING_HASH_C_256:
                return "TYPE_​SIMPLE_PAIRING_HASH_C_256";

            case TYPE_​SIMPLE_PAIRING_RANDOMIZER_R_256:
                return "TYPE_​SIMPLE_PAIRING_RANDOMIZER_R_256";

            case TYPE_​3D_INFORMATION_DATA:
                return "TYPE_​3D_INFORMATION_DATA";

            default:
                return "TYPE_UNKNOWN";
        }
    }

}
