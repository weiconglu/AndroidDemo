package com.example.usbrelay;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import java.io.IOException;
import java.util.List;

import static com.hoho.android.usbserial.util.HexDump.hexStringToByteArray;

public class MainActivity extends AppCompatActivity {

    private static final String ACTION_USB_PERMISSION = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    // 最终要使用的通信端口
    private UsbSerialPort usbSerialPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsbManager usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);
        List<UsbSerialDriver> usbSerialDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(usbManager);

        if (!usbSerialDrivers.isEmpty()) {
            //------------------------------------------------------------------------------------------------------------------------------------------
            for (UsbSerialDriver usbSerialDriver : usbSerialDrivers) {

                UsbDevice usbDevice = usbSerialDriver.getDevice();
                boolean authorizedFlag = false;

                // 如果找到了这个设备
                if (usbDevice.getProductId() == 29987 && usbDevice.getVendorId() == 6790) {
                    authorizedFlag = usbManager.hasPermission(usbDevice);  // Returns true if the caller has permission to access the device

                    // 如果没权限，广播要权限
                    if (!authorizedFlag) {
                        Intent intent = new Intent(ACTION_USB_PERMISSION);//发送自定义广播
                        PendingIntent pendingIntent =
                                PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
                        usbManager.requestPermission(usbDevice, pendingIntent);//弹出权限框，进行权限申请
                    }

                    // 如果有权限，初始化通信端口
                    if (authorizedFlag) {
                        usbSerialPort = usbSerialDriver.getPorts().get(0);
                        UsbDeviceConnection usbDeviceConnection = usbManager.openDevice(usbSerialDriver.getDevice());
                        try {
                            usbSerialPort.open(usbDeviceConnection);
                            usbSerialPort.setParameters(9600, 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }

            }
            //------------------------------------------------------------------------------------------------------------------------------------------
        }

    }

    // 开
    public void relayOn(View view) {

        if (null != usbSerialPort) {
            try {
                usbSerialPort.write(hexStringToByteArray("A00101A2"), 5000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // 关
    public void relayOff(View view) {

        if (null != usbSerialPort) {
            try {
                usbSerialPort.write(hexStringToByteArray("A00100A1"), 5000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
