package io.github.haykam821.modhider.mixin;

import java.util.Collection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.modhider.ClientMain;
import io.github.prospector.modmenu.gui.ModListWidget;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

@Mixin(value = ModListWidget.class, remap = false)
public class ModListWidgetMixin {
	@Redirect(method = "filter(Ljava/lang/String;ZZ)V", at = @At(value = "INVOKE", target = "Lnet/fabricmc/loader/api/FabricLoader;getAllMods()Ljava/util/Collection;"))
	private Collection<ModContainer> hideFilterMods(FabricLoader loader) {
		return ClientMain.hideMods(loader.getAllMods());
	}
}