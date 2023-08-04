/*
 * Copyright (c) 2023 - present | LuciferMorningstarDev <contact@lucifer-morningstar.dev>
 * Copyright (c) 2023 - present | kuchengames.de <contact@kuchengames.de>
 * Copyright (c) 2023 - present | kuchengames.de team and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.kuchengames.bukkit.gui.util;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * BukkitGUI; de.kuchengames.bukkit.gui.util:InventorySerializer
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 04.08.2023
 */
public final class InventorySerializer {

    private InventorySerializer() {
        throw new IllegalStateException("InventorySerializer cannot been instantiated.");
    }

    /**
     * Serializes the given inventory into a Base64 string.
     *
     * @param inventory         The inventory to be serialized.
     * @param fallbackInventory The fallback inventory type to be used in case of serialization failure.
     * @return A Base64 string representing the serialized inventory.
     */
    public static String serialize(Inventory inventory, InventoryType fallbackInventory) {
        try {
            // Prepare serialization.
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try (BukkitObjectOutputStream objectStream = new BukkitObjectOutputStream(outputStream)) {
                // Write the size inventory type.
                objectStream.writeObject(inventory.getType());

                // Iterate over every item in the inventory and add it to the output stream.
                for (int i = 0; i < inventory.getSize(); i++) {
                    objectStream.writeObject(inventory.getItem(i));
                }
            }
            // Convert the output stream to a Base64 string and return it.
            return Base64Util.toBase64String(outputStream.toByteArray());
        } catch (IOException ex) {
            // If serialization fails, return fallback inventory serialized.
            return serialize(Bukkit.getServer().createInventory(null, fallbackInventory), fallbackInventory);
        }
    }

    /**
     * Deserializes an inventory from a Base64 string.
     *
     * @param base64SerializedInventory The Base64 string representing the serialized inventory.
     * @param fallbackInventory         The fallback inventory type to be used in case of deserialization failure.
     * @return The deserialized inventory.
     */
    public static Inventory deserialize(String base64SerializedInventory, InventoryType fallbackInventory) {
        try {
            // Convert the Base64 string to a byte array.
            byte[] data = Base64Util.base64StringToByteArray(base64SerializedInventory);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            try (BukkitObjectInputStream objectStream = new BukkitObjectInputStream(inputStream)) {
                // Read the inventory type from the stream.
                InventoryType type = (InventoryType) objectStream.readObject();

                // Create an empty inventory of the specified type to store the items.
                Inventory inventory = Bukkit.getServer().createInventory(null, type);

                // Iterate over every item in the stream and set it in the inventory.
                for (int i = 0; i < inventory.getSize(); i++) {
                    inventory.setItem(i, (ItemStack) objectStream.readObject());
                }

                // Close the stream and return the crafted inventory.
                return inventory;
            }
        } catch (IOException | ClassNotFoundException ex) {
            // If deserialization fails, return fallback inventory.
            return Bukkit.getServer().createInventory(null, fallbackInventory);
        }
    }

}
