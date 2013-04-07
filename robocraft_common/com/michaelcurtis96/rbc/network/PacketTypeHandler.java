package com.michaelcurtis96.rbc.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.michaelcurtis96.rbc.lib.Reference;
import com.michaelcurtis96.rbc.network.packet.PacketRBC;
import com.michaelcurtis96.rbc.network.packet.PacketTileUpdate;

public enum PacketTypeHandler {
    TILE(PacketTileUpdate.class);

    private Class<? extends PacketRBC> validClass;

    PacketTypeHandler(Class<? extends PacketRBC> validClass) {

        this.validClass = validClass;
    }

    public static PacketRBC buildPacket(byte[] data) {

        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        int selector = bis.read();
        DataInputStream dis = new DataInputStream(bis);

        PacketRBC packet = null;

        try {
            packet = values()[selector].validClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        packet.readPopulate(dis);

        return packet;
    }

    public static PacketRBC buildPacket(PacketTypeHandler type) {

        PacketRBC packet = null;

        try {
            packet = values()[type.ordinal()].validClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return packet;
    }

    public static Packet populatePacket(PacketRBC packetRBC) {

        byte[] data = packetRBC.populate();

        Packet250CustomPayload packet250 = new Packet250CustomPayload();
        packet250.channel = Reference.CHANNEL_NAME;
        packet250.data = data;
        packet250.length = data.length;
        packet250.isChunkDataPacket = packetRBC.isChunkDataPacket;

        return packet250;
    }

}
