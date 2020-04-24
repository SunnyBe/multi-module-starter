package com.zistus.core.util.misc

import android.content.Context
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.tasks.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class SplitInstallUtil(context: Context) {

    var splitInstallManager: SplitInstallManager =
        SplitInstallManagerFactory.create(context)
    lateinit var installListener: SplitInstallStateUpdatedListener

    fun isModuleInstalled(moduleName: String): Boolean =
        splitInstallManager.installedModules.contains(moduleName)

    fun installModule(moduleName: String, block: (Throwable?) -> Unit) {
        if (!splitInstallManager.installedModules.contains(moduleName)) {
            splitInstallManager
                .startInstall(
                    SplitInstallRequest.newBuilder()
                        .addModule(moduleName)
                        .build()
                ).addOnCompleteListener { block(it.exception) }
        } else block(null)
    }

    fun installDemandedModule(moduleName: String, block: (Task<Int>?)-> Unit) {
        // if module is not yet installed
        if (!splitInstallManager.installedModules.contains(moduleName)) {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleName)
                .build()
            val task = splitInstallManager.startInstall(request)
            block(task)
        } else {
            block(null)
        }
    }

    suspend fun includeModule(moduleName: String, splitInstallStateUpdatedListener: SplitInstallStateUpdatedListener): Task<Int> = withContext(Dispatchers.Main) {
        val request = buildRequest(moduleName)
        installListener = splitInstallStateUpdatedListener
        splitInstallManager.registerListener(splitInstallStateUpdatedListener)
        splitInstallManager.startInstall(request)
    }

    private fun buildRequest(moduleName: String): SplitInstallRequest {
        return SplitInstallRequest.newBuilder()
            .addModule(moduleName)
            .build()
    }

    fun unregisterSplitListener() {
        splitInstallManager.unregisterListener(installListener)
    }

    fun deferInstallModules(modules: List<String>) {
        splitInstallManager.deferredInstall(modules)
    }

    fun installMultiModule(vararg modules: String, block: (Throwable?) -> Unit) {
        modules.forEach { moduleName ->
            if (!splitInstallManager.installedModules.contains(moduleName)) {
                splitInstallManager
                    .startInstall(
                        SplitInstallRequest.newBuilder()
                            .addModule(moduleName)
                            .build()
                    ).addOnCompleteListener { block(it.exception) }
            } else block(null)
        }
    }

    fun installLanguage(languageCode: String, block: (Throwable?) -> Unit) {
        if (!splitInstallManager.installedLanguages.contains(languageCode)) {
            splitInstallManager
                .startInstall(
                    SplitInstallRequest.newBuilder()
                        .addLanguage(Locale(languageCode))
                        .build()
                ).addOnCompleteListener { block(it.exception) }
        } else block(null)
    }

    fun checkInstalledModules(): Set<String>{
        return splitInstallManager.installedModules
    }

    suspend fun checkForActiveDownloads(sessionId: Int) = withContext(Dispatchers.IO){
        splitInstallManager
            // Returns a SplitInstallSessionState object for each active session as a List.
            .sessionStates
    }

}