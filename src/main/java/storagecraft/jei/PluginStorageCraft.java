package storagecraft.jei;

import mezz.jei.api.IItemRegistry;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.IRecipeRegistry;
import mezz.jei.api.JEIPlugin;
import storagecraft.StorageCraftItems;
import storagecraft.storage.CellStorage;

@JEIPlugin
public class PluginStorageCraft implements IModPlugin
{
	private IItemRegistry itemRegistry;
	private IJeiHelpers jeiHelpers;

	@Override
	public void onJeiHelpersAvailable(IJeiHelpers jeiHelpers)
	{
		this.jeiHelpers = jeiHelpers;
	}

	@Override
	public void onItemRegistryAvailable(IItemRegistry itemRegistry)
	{
		this.itemRegistry = itemRegistry;
	}

	@Override
	public void register(IModRegistry registry)
	{
		registry.addRecipeCategories(new SoldererRecipeCategory(jeiHelpers.getGuiHelper()));

		registry.addRecipeHandlers(new SoldererRecipeHandler());

		registry.addRecipes(SoldererRecipeMaker.getRecipes());

		jeiHelpers.getNbtIgnoreList().ignoreNbtTagNames(StorageCraftItems.STORAGE_CELL, CellStorage.NBT_ITEMS, CellStorage.NBT_STORED);
	}

	@Override
	public void onRecipeRegistryAvailable(IRecipeRegistry recipeRegistry)
	{
	}
}