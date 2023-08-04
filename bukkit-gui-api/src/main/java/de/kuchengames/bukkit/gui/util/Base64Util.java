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

import java.io.IOException;
import java.util.Base64;

/**
 * BukkitGUI; de.kuchengames.bukkit.gui.util:Base64Util
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 04.08.2023
 */
public final class Base64Util {

    private Base64Util() {
        throw new IllegalStateException("Base64Util cannot been instantiated.");
    }

    /**
     * Helper method to convert a byte array to a Base64 string.
     *
     * @param data The byte array to be converted.
     * @return The Base64 string representation of the byte array.
     */
    public static String toBase64String(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    /**
     * Helper method to convert a Base64 string to a byte array.
     *
     * @param base64String The Base64 string to be converted.
     * @return The byte array representation of the Base64 string.
     * @throws IOException If an I/O error occurs while decoding the Base64 string.
     */
    public static byte[] base64StringToByteArray(String base64String) throws IOException {
        return Base64.getDecoder().decode(base64String);
    }

}
