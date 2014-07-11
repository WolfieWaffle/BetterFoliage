package mods.betterfoliage.client.gui;

import mods.betterfoliage.BetterFoliage;
import mods.betterfoliage.client.gui.widget.OptionDoubleWidget;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.client.FMLClientHandler;

public class ConfigGuiGrass extends ConfigGuiScreenBase {

	public ConfigGuiGrass(GuiScreen parent) {
		super(parent);
		int id = 10;
		widgets.add(new OptionDoubleWidget(BetterFoliage.config.grassSize, -100, -70, 200, 50, id++, id++, "message.betterfoliage.size", "%.2f"));
		widgets.add(new OptionDoubleWidget(BetterFoliage.config.grassHOffset, -100, -40, 200, 50, id++, id++, "message.betterfoliage.hOffset", "%.3f"));
		widgets.add(new OptionDoubleWidget(BetterFoliage.config.grassHeightMin, -100, -10, 200, 50, id++, id++, "message.betterfoliage.minHeight", "%.2f"));
		widgets.add(new OptionDoubleWidget(BetterFoliage.config.grassHeightMax, -100, 20, 200, 50, id++, id++, "message.betterfoliage.maxHeight", "%.2f"));
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addButtons(int x, int y) {
		buttonList.add(new GuiButton(0, x - 50, y + 50, 100, 20, "Close"));
	}

	@Override
	protected void onButtonPress(int id) {
		if (id == 0) FMLClientHandler.instance().showGuiScreen(parent);
		
		if (BetterFoliage.config.grassHeightMin.value > BetterFoliage.config.grassHeightMax.value) BetterFoliage.config.grassHeightMin.value = BetterFoliage.config.grassHeightMax.value;
	}
	
}