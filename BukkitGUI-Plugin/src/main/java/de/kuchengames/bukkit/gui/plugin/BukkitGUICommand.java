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

package de.kuchengames.bukkit.gui.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * BukkitGUI; de.kuchengames.bukkit.gui.plugin:BukkitGUICommand
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 04.08.2023
 */
public class BukkitGUICommand extends Command {
    private BukkitGUIPlugin plugin;

    public BukkitGUICommand(BukkitGUIPlugin plugin) {
        super("bukkitgui");
        this.plugin = plugin;
        this.setAliases(List.of("bgui"));
        this.setDescription("BukkitGUI Main Command");
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage("&cnot implemented yet.");
        return false;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return Collections.emptyList();
    }

}
