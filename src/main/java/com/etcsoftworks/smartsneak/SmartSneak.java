/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.etcsoftworks.smartsneak;


import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.etcsoftworks.smartsneak.listeners.TestListener;
import com.etcsoftworks.smartsneak.listeners.client.ClientLoginListener;
import com.etcsoftworks.smartsneak.listeners.client.PlayerActionListener;
import com.etcsoftworks.smartsneak.listeners.server.EntityMetadataListener;
import com.etcsoftworks.smartsneak.listeners.server.PlayerLoginListener;


public class SmartSneak extends JavaPlugin {

	private ProtocolManager protocolManager;
	
	public void onEnable() {
		getLogger().info("Enabling SmartSneak");
		protocolManager = ProtocolLibrary.getProtocolManager();
		
		protocolManager.addPacketListener(new PlayerActionListener(this));
		protocolManager.addPacketListener(new ClientLoginListener(this));
		protocolManager.addPacketListener(new EntityMetadataListener(this));
		protocolManager.addPacketListener(new PlayerLoginListener(this));
		
		//protocolManager.addPacketListener(new TestListener(this));
	}
	
	public void onDisable() {
		getLogger().info("Disabling SmartSneak");
	}
}
