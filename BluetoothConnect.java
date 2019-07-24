
package com.example.parker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;
import android.os.Bundle;

public class BluetoothConnect extends AppCompatActivity {
    TextView text_v;
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 456;
    private mSensorState mState;
    private enum mSensorState {IDLE, ACC_ENABLE, ACC_READ};
    Button test;
    BleWrapper mBleWrapper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_connect);
        text_v = findViewById(R.id.text_view);
        Button scan = findViewById(R.id.action_scan);
        Button stop = findViewById(R.id.action_stop);
        test = findViewById(R.id.test);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_REQUEST_COARSE_LOCATION);
        }

        mBleWrapper=  new BleWrapper(this, new BleWrapperUiCallbacks.Null() {
            @Override
            public void uiDeviceFound(final BluetoothDevice device,
                                      final int rssi,
                                      final byte[] record
            ) {
                String msg = "uiDeviceFound: " + device.getName() + ", " + "rssi" + ": " + rssi;

                //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                Log.d("DEBUG", "uiDeviceFound: " + msg);
                if (device.getAddress().equals("C4:4F:33:08:3B:97"))//device.getName() != null && device.getName().equals("ESP32_fh"))
                {
                    boolean status;
                    action_stop();
                    status = mBleWrapper.connect(device.getAddress());
                    if (!status)
                    {
                        Log.d("DEBUG", "uiDeviceFound: Connection problem");
                    }
                    else{
                        text_v.setText("Connection successful");
                        //action_stop();
                    }
                }
            }
            @Override
            public void uiAvailableServices(BluetoothGatt gatt,
                                            BluetoothDevice device,
                                            List<BluetoothGattService> services
            )
            {
                for (BluetoothGattService service : services)
                {   Log.d("DEBUG", "service");
                    String serviceName = (String) BLENamesResolver.resolveUuid
                            (String.valueOf(service.getUuid()));
                    Log.d("DEBUG", serviceName);
                    text_v.setText(serviceName);
                }
            }
            @Override
            public void uiSuccessfulWrite( BluetoothGatt gatt,
                                              BluetoothDevice device,
                                              BluetoothGattService service,
                                              BluetoothGattCharacteristic ch,
                                              String description)
            {
                BluetoothGattCharacteristic c;

                super.uiSuccessfulWrite(gatt, device, service, ch, description);
                Log.d("BLE", "uiSuccessfulWrite");

                switch (mState)
                {
                    case ACC_ENABLE:
                        Log.d("BLE", "uiSuccessfulWrite: Reading acc");
                        c = gatt.getService( UUID.fromString("00001811-0000-1000-8000-00805f9b34fb")).getCharacteristic(UUID.fromString("00002a43-0000-1000-8000-00805f9b34fb"));
                        mBleWrapper.requestCharacteristicValue(c);
                        mState = mSensorState.ACC_READ;
                        break;

                    case ACC_READ:
                        Log.d("BLE", "uiSuccessfulWrite: state = ACC_READ");
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void uiFailedWrite( BluetoothGatt gatt,
                                          BluetoothDevice device,
                                          BluetoothGattService service,
                                          BluetoothGattCharacteristic ch,
                                          String description)
            {
                super.uiFailedWrite(gatt, device, service, ch, description);
                Log.d("BLE", "uiFailedWrite");
            }

            @Override
            public void uiNewValueForCharacteristic(BluetoothGatt gatt,
                                                    BluetoothDevice device,
                                                    BluetoothGattService service,
                                                    BluetoothGattCharacteristic ch,
                                                    String strValue,
                                                    int intValue,
                                                    byte[] rawValue,
                                                    String timestamp)
            {
                super.uiNewValueForCharacteristic( gatt, device, service,
                        ch, strValue, intValue,
                        rawValue, timestamp);
// decode current read operation
//                switch (mState)
//                {
//                    case ACC_READ:
//                        Log.d("DEBUG", "uiNewValueForCharacteristic: BLE data:");
//                        break;
//                }
// dump data byte array
                text_v.setText("");
                byte bl = rawValue[0];
                int il = bl;
                Log.d("DEBUG", "rawVal: " + il);
                text_v.append(String.valueOf(il));
//                for (byte b:rawValue)
//                {int i = b;
//                Log.d("DEBUG", "Val: " + i);
//                text_v.append(String.valueOf(i));
//                }
            }
            @Override
            public void uiGotNotification( BluetoothGatt gatt,
                                              BluetoothDevice device,
                                              BluetoothGattService service,
                                              BluetoothGattCharacteristic characteristic)
            {
                super.uiGotNotification(gatt, device, service, characteristic);
                String ch = BLENamesResolver.resolveCharacteristicName(characteristic.getUuid().toString());

                Log.d("ble",  "uiGotNotification: " + ch);
            }

        }
        );
        if (!mBleWrapper.checkBleHardwareAvailable())
        {
            Toast.makeText(this, "No BLE-compatible hardware detected",
                    Toast.LENGTH_SHORT).show();
            finish();
        }
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action_scan();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action_stop();
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test_button();
            }
        });
    }

    //    private void test_button() {
//        BluetoothGatt gatt;
//        BluetoothGattCharacteristic c;
//        if (!mBleWrapper.isConnected()) {
//            return;
//        }
//        Log.d("DEBUG", "testButton: Reading acc");
//        gatt = mBleWrapper.getGatt();
//        c = gatt.getService( UUID.fromString("00001811-0000-1000-8000-00805f9b34fb")).getCharacteristic(UUID.fromString("00002a43-0000-1000-8000-00805f9b34fb"));
//        mBleWrapper.requestCharacteristicValue(c);
//        mState = mSensorState.ACC_READ;
//    }
    private void test_button()
    {
        BluetoothGatt gatt;
        BluetoothGattCharacteristic c;
        if (!mBleWrapper.isConnected()) {
            return;
        }
// set notification on characteristic
        Log.d("BLE_notify", "Setting notification");
        gatt = mBleWrapper.getGatt();
        c = gatt.getService(UUID.fromString("00001811-0000-1000-8000-00805f9b34fb")).getCharacteristic(UUID.fromString("00002a43-0000-1000-8000-00805f9b34fb"));
        mBleWrapper.setNotificationForCharacteristic(c, true);
        //mState = mSensorState.ACC_NOTIFy_ENB;
    }

    private void action_stop() {
        mBleWrapper.stopScanning();
        text_v.setText("stop");
    }

    private void action_scan() {
        mBleWrapper.startScanning();
        text_v.setText("start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        // check for Bluetooth enabled on each resume
        if (!mBleWrapper.isBtEnabled())
        {
            // Bluetooth is not enabled. Request to user to turn it on
            Intent enableBtIntent = new Intent(BluetoothAdapter.
                    ACTION_REQUEST_ENABLE);
            startActivity(enableBtIntent);
            finish();
        }
        // init ble wrapper
        mBleWrapper.initialize();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mBleWrapper.diconnect();
        mBleWrapper.close();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_COARSE_LOCATION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, yay! Start the Bluetooth device scan.
                } else {
                    // Alert the user that this application requires the location permission to perform the scan.
                }
            }
        }
    }
    }

