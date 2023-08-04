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

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

/**
 * BukkitGUI; de.kuchengames.bukkit.gui:GUIInventory
 *
 * @author <a href="https://github.com/LuciferMorningstarDev">LuciferMorningstarDev</a>
 * @since 04.08.2023
 */
public class GUIInventory implements Inventory {
    private Inventory bukkitInventory;

    @Override
    public int getSize() {
        return this.bukkitInventory.getSize();
    }

    @Override
    public int getMaxStackSize() {
        return this.bukkitInventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int size) {
        this.bukkitInventory.setMaxStackSize(size);
    }

    @Override
    public @Nullable ItemStack getItem(int index) {
        return this.bukkitInventory.getItem(index);
    }

    @Override
    public void setItem(int index, @Nullable ItemStack item) {
        this.bukkitInventory.setItem(index, item);
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> addItem(@NotNull ItemStack... items) throws IllegalArgumentException {
        return this.bukkitInventory.addItem(items);
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> removeItem(@NotNull ItemStack... items) throws IllegalArgumentException {
        return this.bukkitInventory.removeItem(items);
    }

    @Override
    public @NotNull HashMap<Integer, ItemStack> removeItemAnySlot(@NotNull ItemStack... items) throws IllegalArgumentException {
        return this.bukkitInventory.removeItem(items);
    }

    @Override
    public @Nullable ItemStack @NotNull [] getContents() {
        return this.bukkitInventory.getContents();
    }

    @Override
    public void setContents(@Nullable ItemStack @NotNull [] items) throws IllegalArgumentException {
        this.bukkitInventory.setContents(items);
    }

    @Override
    public @Nullable ItemStack @NotNull [] getStorageContents() {
        return this.bukkitInventory.getStorageContents();
    }

    @Override
    public void setStorageContents(@Nullable ItemStack @NotNull [] items) throws IllegalArgumentException {
        this.bukkitInventory.setStorageContents(items);
    }

    @Override
    public boolean contains(@NotNull Material material) throws IllegalArgumentException {
        return this.bukkitInventory.contains(material);
    }

    @Override
    public boolean contains(@Nullable ItemStack item) {
        return this.bukkitInventory.contains(item);
    }

    @Override
    public boolean contains(@NotNull Material material, int amount) throws IllegalArgumentException {
        return this.bukkitInventory.contains(material, amount);
    }

    @Override
    public boolean contains(@Nullable ItemStack item, int amount) {
        return this.bukkitInventory.contains(item, amount);
    }

    @Override
    public boolean containsAtLeast(@Nullable ItemStack item, int amount) {
        return this.bukkitInventory.containsAtLeast(item, amount);
    }

    @Override
    public @NotNull HashMap<Integer, ? extends ItemStack> all(@NotNull Material material) throws IllegalArgumentException {
        return this.bukkitInventory.all(material);
    }

    @Override
    public @NotNull HashMap<Integer, ? extends ItemStack> all(@Nullable ItemStack item) {
        return this.bukkitInventory.all(item);
    }

    @Override
    public int first(@NotNull Material material) throws IllegalArgumentException {
        return this.bukkitInventory.first(material);
    }

    @Override
    public int first(@NotNull ItemStack item) {
        return this.bukkitInventory.first(item);
    }

    @Override
    public int firstEmpty() {
        return this.bukkitInventory.firstEmpty();
    }

    @Override
    public boolean isEmpty() {
        return this.bukkitInventory.isEmpty();
    }

    @Override
    public void remove(@NotNull Material material) throws IllegalArgumentException {
        this.bukkitInventory.remove(material);
    }

    @Override
    public void remove(@NotNull ItemStack item) {
        this.bukkitInventory.remove(item);
    }

    @Override
    public void clear(int index) {
        this.bukkitInventory.clear(index);
    }

    @Override
    public void clear() {
        this.bukkitInventory.clear();
    }

    @Override
    public int close() {
        return this.bukkitInventory.close();
    }

    @Override
    public @NotNull List<HumanEntity> getViewers() {
        return this.bukkitInventory.getViewers();
    }

    @Override
    public @NotNull InventoryType getType() {
        return this.bukkitInventory.getType();
    }

    @Override
    public @Nullable InventoryHolder getHolder() {
        return this.bukkitInventory.getHolder();
    }

    @Override
    public @Nullable InventoryHolder getHolder(boolean useSnapshot) {
        return this.bukkitInventory.getHolder(useSnapshot);
    }

    @Override
    public @NotNull ListIterator<ItemStack> iterator() {
        return this.bukkitInventory.iterator();
    }

    @Override
    public @NotNull ListIterator<ItemStack> iterator(int index) {
        return this.bukkitInventory.iterator(index);
    }

    @Override
    public @Nullable Location getLocation() {
        return this.bukkitInventory.getLocation();
    }

}
