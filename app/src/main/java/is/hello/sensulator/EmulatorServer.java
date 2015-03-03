package is.hello.sensulator;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

public class EmulatorServer extends BluetoothGattServerCallback {
    public static final String LOG_TAG = EmulatorServer.class.getSimpleName();

    private final BluetoothManager bluetoothManager;
    private final BluetoothGattServer gattServer;

    public EmulatorServer(@NonNull Context context, @NonNull BluetoothManager bluetoothManager) {
        this.bluetoothManager = bluetoothManager;
        this.gattServer = bluetoothManager.openGattServer(context, this);
        BluetoothGattService service = new BluetoothGattService(SenseIdentifiers.SERVICE.getUuid(), BluetoothGattService.SERVICE_TYPE_PRIMARY);

        BluetoothGattCharacteristic incoming = new BluetoothGattCharacteristic(SenseIdentifiers.CHARACTERISTIC_PROTOBUF_COMMAND.getUuid(),
                BluetoothGattCharacteristic.PROPERTY_WRITE,
                BluetoothGattCharacteristic.PERMISSION_WRITE);
        incoming.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT);
        service.addCharacteristic(incoming);

        BluetoothGattCharacteristic outgoing = new BluetoothGattCharacteristic(SenseIdentifiers.CHARACTERISTIC_PROTOBUF_COMMAND_RESPONSE.getUuid(),
                BluetoothGattCharacteristic.PROPERTY_NOTIFY,
                BluetoothGattCharacteristic.PERMISSION_READ);
        service.addCharacteristic(outgoing);

        gattServer.addService(service);
    }


    @Override
    public void onConnectionStateChange(BluetoothDevice device, int status, int newState) {
        Log.i(LOG_TAG, "onConnectionStateChange(" + status + ", " + newState + ")");
    }

    @Override
    public void onServiceAdded(int status, BluetoothGattService service) {
        Log.i(LOG_TAG, "onServiceAdded(" + status + ", " + service + ")");
    }

    @Override
    public void onCharacteristicReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattCharacteristic characteristic) {
        Log.i(LOG_TAG, "onCharacteristicReadRequest()");
    }

    @Override
    public void onCharacteristicWriteRequest(BluetoothDevice device, int requestId, BluetoothGattCharacteristic characteristic, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        Log.i(LOG_TAG, "onCharacteristicWriteRequest()");
    }

    @Override
    public void onDescriptorReadRequest(BluetoothDevice device, int requestId, int offset, BluetoothGattDescriptor descriptor) {
        Log.i(LOG_TAG, "onDescriptorReadRequest()");
    }

    @Override
    public void onDescriptorWriteRequest(BluetoothDevice device, int requestId, BluetoothGattDescriptor descriptor, boolean preparedWrite, boolean responseNeeded, int offset, byte[] value) {
        Log.i(LOG_TAG, "onDescriptorWriteRequest()");
    }

    @Override
    public void onExecuteWrite(BluetoothDevice device, int requestId, boolean execute) {
        Log.i(LOG_TAG, "onExecuteWrite()");
    }
}
