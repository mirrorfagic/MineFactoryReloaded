package powercrystals.minefactoryreloaded.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

import javax.annotation.Nullable;
import java.util.Map;

@IFMLLoadingPlugin.TransformerExclusions({ "powercrystals.minefactoryreloaded.asm." })
@IFMLLoadingPlugin.SortingIndex(1001)
@IFMLLoadingPlugin.Name("MineFactoryReloadedCore")
public class LoadingPlugin implements IFMLLoadingPlugin {

	@Override
	public String[] getASMTransformerClass() {

		return new String[] { WorldTransformer.class.getName() };
	}

	@Override
	public String getModContainerClass() {

		return null;
	}

	@Nullable
	@Override
	public String getSetupClass() {

		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {

	}

	@Override
	public String getAccessTransformerClass() {

		return null;
	}

}
