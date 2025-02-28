
# Eagler Context Redacted Diff
# Copyright (c) 2025 lax1dude. All rights reserved.

# Version: 1.0
# Author: lax1dude

> DELETE  2  @  2 : 11

> DELETE  1  @  1 : 3

> DELETE  1  @  1 : 4

> CHANGE  2 : 13  @  2 : 4

~ import java.util.function.Consumer;
~ 
~ import com.google.common.collect.ImmutableList;
~ import com.google.common.collect.Lists;
~ 
~ import net.lax1dude.eaglercraft.v1_8.IOUtils;
~ import net.lax1dude.eaglercraft.v1_8.futures.ListenableFuture;
~ import net.lax1dude.eaglercraft.v1_8.log4j.LogManager;
~ import net.lax1dude.eaglercraft.v1_8.log4j.Logger;
~ import net.lax1dude.eaglercraft.v1_8.minecraft.EaglerFolderResourcePack;
~ import net.lax1dude.eaglercraft.v1_8.opengl.ImageData;

> DELETE  1  @  1 : 2

> DELETE  2  @  2 : 5

> DELETE  4  @  4 : 5

> DELETE  1  @  1 : 8

> DELETE  3  @  3 : 11

> DELETE  1  @  1 : 2

> DELETE  2  @  2 : 3

> CHANGE  4 : 5  @  4 : 6

~ 	public ResourcePackRepository(IResourcePack rprDefaultResourcePackIn, IMetadataSerializer rprMetadataSerializerIn,

> DELETE  1  @  1 : 3

> CHANGE  2 : 8  @  2 : 3

~ 		reconstruct(settings);
~ 	}
~ 
~ 	public void reconstruct(GameSettings settings) {
~ 		this.repositoryEntriesAll.clear();
~ 		this.repositoryEntries.clear();

> CHANGE  6 : 8  @  6 : 7

~ 			for (int i = 0, l = this.repositoryEntriesAll.size(); i < l; ++i) {
~ 				ResourcePackRepository.Entry resourcepackrepository$entry = this.repositoryEntriesAll.get(i);

> DELETE  16  @  16 : 34

> CHANGE  1 : 2  @  1 : 2

~ 		List<ResourcePackRepository.Entry> list = Lists.<ResourcePackRepository.Entry>newArrayList();

> CHANGE  1 : 6  @  1 : 3

~ 		List<EaglerFolderResourcePack> list2 = EaglerFolderResourcePack
~ 				.getFolderResourcePacks(EaglerFolderResourcePack.RESOURCE_PACKS);
~ 		for (int j = 0, l = list2.size(); j < l; ++j) {
~ 			ResourcePackRepository.Entry resourcepackrepository$entry = new ResourcePackRepository.Entry(list2.get(j));
~ 

> CHANGE  3 : 4  @  3 : 4

~ 					list.add(resourcepackrepository$entry);

> CHANGE  1 : 5  @  1 : 2

~ 					logger.error("Failed to call \"updateResourcePack\" for resource pack \"{}\"",
~ 							resourcepackrepository$entry.reResourcePack.resourcePackFile);
~ 					logger.error(var6);
~ 					list.remove(resourcepackrepository$entry);

> INSERT  3 : 4  @  3

+ 

> CHANGE  1 : 2  @  1 : 2

~ 					list.add(this.repositoryEntriesAll.get(i));

> CHANGE  4 : 5  @  4 : 5

~ 		this.repositoryEntriesAll.removeAll(list);

> CHANGE  1 : 3  @  1 : 3

~ 		for (int i = 0, l = this.repositoryEntriesAll.size(); i < l; ++i) {
~ 			this.repositoryEntriesAll.get(i).closeResourcePack();

> CHANGE  2 : 3  @  2 : 3

~ 		this.repositoryEntriesAll = list;

> CHANGE  15 : 22  @  15 : 47

~ 	public void downloadResourcePack(String s1, String s2, Consumer<Boolean> cb) {
~ 		EaglerFolderResourcePack.loadRemoteResourcePack(s1, s2, res -> {
~ 			if (res != null) {
~ 				ResourcePackRepository.this.resourcePackInstance = res;
~ 				Minecraft.getMinecraft().scheduleResourcesRefresh();
~ 				cb.accept(true);
~ 				return;

> CHANGE  1 : 8  @  1 : 29

~ 			cb.accept(false);
~ 		}, runnable -> {
~ 			Minecraft.getMinecraft().addScheduledTask(runnable);
~ 		}, () -> {
~ 			Minecraft.getMinecraft().loadingScreen.eaglerShow(I18n.format("resourcePack.load.loading"),
~ 					"Server resource pack");
~ 		});

> DELETE  2  @  2 : 22

> CHANGE  5 : 8  @  5 : 19

~ 		if (this.resourcePackInstance != null) {
~ 			this.resourcePackInstance = null;
~ 			Minecraft.getMinecraft().scheduleResourcesRefresh();

> DELETE  1  @  1 : 2

> CHANGE  3 : 4  @  3 : 5

~ 		private EaglerFolderResourcePack reResourcePack;

> CHANGE  1 : 2  @  1 : 2

~ 		private ImageData texturePackIcon;

> INSERT  1 : 2  @  1

+ 		private TextureManager iconTextureManager;

> CHANGE  1 : 3  @  1 : 3

~ 		private Entry(EaglerFolderResourcePack resourcePackFileIn) {
~ 			this.reResourcePack = resourcePackFileIn;

> DELETE  3  @  3 : 6

> CHANGE  5 : 8  @  5 : 7

~ 			} catch (Throwable var2) {
~ 				logger.error("Failed to load resource pack icon for \"{}\"!", reResourcePack.resourcePackFile);
~ 				logger.error(var2);

> INSERT  11 : 12  @  11

+ 				this.iconTextureManager = textureManagerIn;

> INSERT  8 : 12  @  8

+ 			if (this.locationTexturePackIcon != null) {
+ 				this.iconTextureManager.deleteTexture(this.locationTexturePackIcon);
+ 				this.locationTexturePackIcon = null;
+ 			}

> INSERT  14 : 18  @  14

+ 		public String getResourcePackEaglerDisplayName() {
+ 			return this.reResourcePack.getDisplayName();
+ 		}
+ 

> CHANGE  21 : 22  @  21 : 25

~ 			return this.reResourcePack.resourcePackFile;

> EOF
