package com.github.rochedo098.fth.config

import com.google.gson.Gson
import net.fabricmc.loader.api.FabricLoader
import java.io.File
import java.io.FileReader

object FTHFileConfig {
    val config = Gson().fromJson(FileReader(File(FabricLoader.getInstance().configDir.toString() + "/fth.json")), FTHConfigFormat::class.java)


}