package com.example.mcprint2.printer;

import com.starmicronics.stario.StarPrinterStatus;

import java.util.Arrays;

public class PrinterStatus {
    
    public boolean coverOpen;
    public boolean offline;
    public boolean compulsionSwitch;
    public boolean overTemp;
    public boolean unrecoverableError;
    public boolean cutterError;
    public boolean mechError;
    public boolean headThermistorError;
    public boolean receiveBufferOverflow;
    public boolean pageModeCmdError;
    public boolean paperDetectionError;
    public boolean blackMarkError;
    public boolean jamError;
    public boolean presenterPaperJamError;
    public boolean headUpError;
    public boolean voltageError;
    public boolean receiptBlackMarkDetection;
    public boolean receiptPaperEmpty;
    public boolean receiptPaperNearEmptyInner;
    public boolean receiptPaperNearEmptyOuter;
    public boolean paperPresent;
    public boolean presenterPaperPresent;
    public boolean peelerPaperPresent;
    public boolean stackerFull;
    public boolean slipTOF;
    public boolean slipCOF;
    public boolean slipBOF;
    public boolean validationPaperPresent;
    public boolean slipPaperPresent;
    public boolean etbAvailable;
    public int etbCounter;
    public int presenterState;
    public int connectedInterface;
    public int rawLength;
    public byte[] raw = new byte[64];

    public static PrinterStatus createFromStarPrinterStatus(StarPrinterStatus status) {
        PrinterStatus printerStatus = new PrinterStatus();

        printerStatus.coverOpen = status.coverOpen;
        printerStatus.offline = status.offline;
        printerStatus.compulsionSwitch = status.compulsionSwitch;
        printerStatus.overTemp = status.overTemp;
        printerStatus.unrecoverableError = status.unrecoverableError;
        printerStatus.cutterError = status.cutterError;
        printerStatus.mechError = status.mechError;
        printerStatus.headThermistorError = status.headThermistorError;
        printerStatus.receiveBufferOverflow = status.receiveBufferOverflow;
        printerStatus.pageModeCmdError = status.pageModeCmdError;
        printerStatus.paperDetectionError = status.paperDetectionError;
        printerStatus.blackMarkError = status.blackMarkError;
        printerStatus.jamError = status.jamError;
        printerStatus.presenterPaperJamError = status.presenterPaperJamError;
        printerStatus.headUpError = status.headUpError;
        printerStatus.voltageError = status.voltageError;
        printerStatus.receiptBlackMarkDetection = status.receiptBlackMarkDetection;
        printerStatus.receiptPaperEmpty = status.receiptPaperEmpty;
        printerStatus.receiptPaperNearEmptyInner = status.receiptPaperNearEmptyInner;
        printerStatus.receiptPaperNearEmptyOuter = status.receiptPaperNearEmptyOuter;
        printerStatus.paperPresent = status.paperPresent;
        printerStatus.presenterPaperPresent = status.presenterPaperPresent;
        printerStatus.peelerPaperPresent = status.peelerPaperPresent;
        printerStatus.stackerFull = status.stackerFull;
        printerStatus.slipTOF = status.slipTOF;
        printerStatus.slipCOF = status.slipCOF;
        printerStatus.slipBOF = status.slipBOF;
        printerStatus.validationPaperPresent = status.validationPaperPresent;
        printerStatus.slipPaperPresent = status.slipPaperPresent;
        printerStatus.etbAvailable = status.etbAvailable;
        printerStatus.etbCounter = status.etbCounter;
        printerStatus.presenterState = status.presenterState;
        printerStatus.connectedInterface = status.connectedInterface;
        printerStatus.rawLength = status.rawLength;
        printerStatus.raw = status.raw;
        
        return printerStatus;
    }

    @Override
    public String toString() {
        return "PrinterStatus{" +
                "coverOpen=" + coverOpen +
                ", offline=" + offline +
                ", compulsionSwitch=" + compulsionSwitch +
                ", overTemp=" + overTemp +
                ", unrecoverableError=" + unrecoverableError +
                ", cutterError=" + cutterError +
                ", mechError=" + mechError +
                ", headThermistorError=" + headThermistorError +
                ", receiveBufferOverflow=" + receiveBufferOverflow +
                ", pageModeCmdError=" + pageModeCmdError +
                ", paperDetectionError=" + paperDetectionError +
                ", blackMarkError=" + blackMarkError +
                ", jamError=" + jamError +
                ", presenterPaperJamError=" + presenterPaperJamError +
                ", headUpError=" + headUpError +
                ", voltageError=" + voltageError +
                ", receiptBlackMarkDetection=" + receiptBlackMarkDetection +
                ", receiptPaperEmpty=" + receiptPaperEmpty +
                ", receiptPaperNearEmptyInner=" + receiptPaperNearEmptyInner +
                ", receiptPaperNearEmptyOuter=" + receiptPaperNearEmptyOuter +
                ", paperPresent=" + paperPresent +
                ", presenterPaperPresent=" + presenterPaperPresent +
                ", peelerPaperPresent=" + peelerPaperPresent +
                ", stackerFull=" + stackerFull +
                ", slipTOF=" + slipTOF +
                ", slipCOF=" + slipCOF +
                ", slipBOF=" + slipBOF +
                ", validationPaperPresent=" + validationPaperPresent +
                ", slipPaperPresent=" + slipPaperPresent +
                ", etbAvailable=" + etbAvailable +
                ", etbCounter=" + etbCounter +
                ", presenterState=" + presenterState +
                ", connectedInterface=" + connectedInterface +
                ", rawLength=" + rawLength +
                ", raw=" + Arrays.toString(raw) +
                '}';
    }

}