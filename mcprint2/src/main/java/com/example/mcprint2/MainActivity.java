package com.example.mcprint2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mcprint2.printer.PrinterStatus;
import com.example.mcprint2.printer.utils.PrintUtils;
import com.example.mylibrary.TipsUtils;
import com.starmicronics.stario.PortInfo;
import com.starmicronics.stario.StarIOPort;
import com.starmicronics.stario.StarIOPortException;
import com.starmicronics.stario.StarPrinterStatus;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // イントラネットのプリンタを探す
    public void searchPrinter(View view) {

        try {
            //Searches for an Ethernet / Wireless LAN interface Star printer on the same network.
        List<PortInfo> portList = StarIOPort.searchPrinter("TCP:");

        for (PortInfo port : portList) {
            Log.e("PRINTER_INFO", "プリンタ情報\n");
            Log.e("PRINTER_INFO", "Port Name: " + port.getPortName());
            Log.e("PRINTER_INFO", "MAC Address: " + port.getMacAddress());
            Log.e("PRINTER_INFO", "Model Name: " + port.getModelName());
        }

        TipsUtils.shortTips(this, "イントラネットのプリンタを探している");

    } catch (StarIOPortException e) {
        // An error occurred.
    }

    }

    // プリントテスト
    public void printTest(View view) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                StarIOPort port = null;

                try {
                    // Port open
                    String portName = "TCP:172.29.244.62";
                    String portSettings = "";
                    port = StarIOPort.getPort(portName, portSettings, 1000, MainActivity.this);

                    // Print end monitoring -Start
                    // もしプリンタに接続や状態が問題があったら、ここから例外を出します
                    StarPrinterStatus status = port.beginCheckedBlock();
                    Log.e("PrinterStatus", PrinterStatus.createFromStarPrinterStatus(status).toString());

//                    StarIoExt.Emulation emulation = StarIoExt.Emulation.StarPRNT;
//                    ILocalizeReceipts localizeReceipts = new Utf8MultiLanguageReceiptsImpl();
//                    byte[] command = PrinterFunctions.createTextReceiptData(emulation, localizeReceipts, true);
                    byte[] command = PrintUtils.createRasterData(MainActivity.this, R.drawable.printing);

                    // Send print data
                    port.writePort(command, 0, command.length);

                    // Print end monitoring -End
                    status = port.endCheckedBlock();
                    Log.e("PrinterStatus", PrinterStatus.createFromStarPrinterStatus(status).toString());

                    // Status judgment during printing completion monitoring
                    if (!status.offline) {
                        // Print successful end (Printer Online)
                    Log.e("PrinterStatus", "プリントテストは成功しました");
                    } else {
                        // Printing is abnormal termination (no paper, printer cover open etc)
                        // Notify user
                    Log.e("PrinterStatus", "プリンタはオフラインでした");

                    }
                } catch (StarIOPortException e) {
                    Log.e("PrinterStatus", "プリンタに例外が発生しました");
                    // Error
                } finally {
                    try {
                        // Port close
                        StarIOPort.releasePort(port);
                    } catch (StarIOPortException e) {
                    }
                }

            }
        }).start();

    }

}