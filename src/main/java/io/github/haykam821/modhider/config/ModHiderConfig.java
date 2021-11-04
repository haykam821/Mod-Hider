package io.github.haykam821.modhider.config;

import java.util.ArrayList;
import java.util.List;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "modhider")
@Config.Gui.Background("minecraft:textures/block/end_stone.png")
public class ModHiderConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip(count = 2)
	public List<String> hiddenMods = new ArrayList<>();
}