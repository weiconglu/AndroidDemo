package com.example.mcprint2.printer.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.starmicronics.starioextension.ICommandBuilder;
import com.starmicronics.starioextension.StarIoExt;

public class PrintUtils {

    //     the method of source code
    public static byte[] createRasterData(StarIoExt.Emulation emulation, Bitmap bitmap, int width, boolean bothScale) {
        ICommandBuilder builder = StarIoExt.createCommandBuilder(emulation);
        builder.beginDocument();
        builder.appendBitmap(bitmap, true, width, bothScale);
        builder.appendCutPaper(ICommandBuilder.CutPaperAction.PartialCutWithFeed);
        builder.endDocument();
        return builder.getCommands();
    }

    // overload method used for creating data from resource id of a picture
    public static byte[] createRasterData(Context context, int rid) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), rid);
        ICommandBuilder builder = StarIoExt.createCommandBuilder(StarIoExt.Emulation.StarPRNT);
        builder.beginDocument();
        builder.appendBitmap(bitmap, true, 384, true);
        builder.appendCutPaper(ICommandBuilder.CutPaperAction.PartialCutWithFeed);
        builder.endDocument();
        return builder.getCommands();
    }

}
