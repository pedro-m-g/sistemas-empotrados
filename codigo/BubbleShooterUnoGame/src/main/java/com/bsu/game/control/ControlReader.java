package com.bsu.game.control;

import com.fazecast.jSerialComm.*;

public class ControlReader implements SerialPortDataListener {

    private final SerialPort port;
    private final Controlled controlled;
    private StringBuffer buffer = new StringBuffer();

    public ControlReader(Controlled controlled) {
        SerialPort[] ports = SerialPort.getCommPorts();
        port = ports[0];
        this.controlled = controlled;
    }

    public void start() {
        port.openPort();
        port.addDataListener(this);
    }

    @Override
    public int getListeningEvents() {
        return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
    }

    @Override
    public void serialEvent(SerialPortEvent event)
    {
        if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE)
            return;
        byte[] newData = new byte[port.bytesAvailable()];
        port.readBytes(newData, newData.length);
        String data = new String(newData);
        buffer.append(data);
        if (data.endsWith("\n")) {
            String[] components = buffer.toString().trim().split(" ");
            String command = components[0];
            String[] args = parseArgs(components);
            controlled.command(command, args);
            buffer = new StringBuffer();
        }
    }

    private String[] parseArgs(String[] components) {
        int n = components.length - 1;
        String[] args = new String[n];
        for (int i = 1; i <= n; i++) {
            args[i - 1] = components[i];
        }
        return args;
    }

}