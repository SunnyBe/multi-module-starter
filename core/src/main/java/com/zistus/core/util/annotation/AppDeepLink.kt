package com.zistus.core.util.annotation

import com.airbnb.deeplinkdispatch.DeepLinkSpec
import com.zistus.core.util.misc.Urls

@DeepLinkSpec(prefix = [Urls.AppScheme])
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.BINARY)
annotation class AppDeepLink(vararg val value: String)