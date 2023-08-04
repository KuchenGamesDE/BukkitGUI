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

package de.kuchengames.bukkit.gui;

import org.bukkit.event.inventory.InventoryType;

/**
 * BukkitGUI; de.kuchengames.bukkit.gui:GUIInventoryType
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 04.08.2023
 */
public enum GUIInventoryType {

    /**
     * Use to create a default GUI using {@link InventoryType#CHEST}
     */
    GUI(InventoryType.CHEST);

    InventoryType bukkitInventoryType;

    /**
     * Constructor for GUIInventoryType
     *
     * @param bukkitInventoryType instance of {@link InventoryType}
     */
    GUIInventoryType(InventoryType bukkitInventoryType) {
        this.bukkitInventoryType = bukkitInventoryType;
    }

    /**
     * Returns the {@link GUIInventoryType}
     *
     * @return the {@link InventoryType}
     */
    public InventoryType getBukkitInventoryType() {
        return bukkitInventoryType;
    }

}