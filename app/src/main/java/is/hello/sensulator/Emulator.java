package is.hello.sensulator;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.AdvertiseCallback;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.util.Log;

public class Emulator {
    public static final String LOG_TAG = Emulator.class.getSimpleName();

    private final Context context;

    private final BluetoothManager manager;
    private final BluetoothLeAdvertiser advertiser;

    public Emulator(@NonNull Context context) {
        this.context = context;

        this.manager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);

        BluetoothAdapter adapter = manager.getAdapter();
        this.advertiser = adapter.getBluetoothLeAdvertiser();
    }


    //region Advertising

    public boolean isAdvertising() {
        return false;
    }

    public void startAdvertising() {
        AdvertiseSettings settings = new AdvertiseSettings.Builder()
                .setAdvertiseMode(AdvertiseSettings.ADVERTISE_MODE_LOW_LATENCY)
                .setConnectable(true)
                .build();
        AdvertiseData advertiseData = new AdvertiseData.Builder()
                .addManufacturerData(BluetoothUtils.TYPE_LIST_OF_16_BIT_SERVICE_CLASS_UUIDS, BluetoothUtils.stringToBytes(SenseIdentifiers.ADVERTISEMENT_SERVICE_16_BIT))
                .addManufacturerData(BluetoothUtils.TYPE_LIST_OF_128_BIT_SERVICE_CLASS_UUIDS, BluetoothUtils.stringToBytes(SenseIdentifiers.ADVERTISEMENT_SERVICE_128_BIT))
                .build();
        AdvertiseData scanResponse = new AdvertiseData.Builder()
                .addServiceUuid(SenseIdentifiers.SERVICE)
                .addManufacturerData(BluetoothUtils.TYPE_SERVICE_DATA, BluetoothUtils.stringToBytes("01020304"))
                .build();
        advertiser.startAdvertising(settings, advertiseData, scanResponse, new AdvertiseCallback() {
            @Override
            public void onStartSuccess(AdvertiseSettings settingsInEffect) {
                Log.i(LOG_TAG, "onStartSuccess(" + settingsInEffect + ")");
            }

            @Override
            public void onStartFailure(int errorCode) {
                Log.e(LOG_TAG, "onStartFailure(" + errorCode + ")");
            }
        });
    }

    public void stopAdvertising() {

    }

    //endregion


    public EmulatorServer openServer() {
        return new EmulatorServer(context, manager);
    }
}
