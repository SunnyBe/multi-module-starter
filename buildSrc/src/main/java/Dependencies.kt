import Versions.currencyEditTextVersion
import Versions.otpViewVersion
import Versions.prefix_version

object ApplicationId {
    const val application_id = "com.zistus.multimodule"
    const val core_id = "com.zistus.core"
}

object Releases {
    const val version_code = 7
    const val version_name = "0.0.7"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
}

object SDKVersions {
    const val min_sdk = 21
    const val target_sdk = 28
    var compile_sdk = 29
    const val build_tool_versioin = "29.0.2"
}

object Versions {
    const val kotlin = "1.3.71"
    const val gradle = "3.6.2"
    const val realm = "5.3.0"
    const val retrofit = "2.6.0"
    const val retrofit_logger = "3.10.0"
    const val android_arch = "1.1.1"
    const val lifecycle_version = "2.2.0"
    const val navigation_architecture = "2.0.0"
    const val room_version = "2.2.5"
    const val fragment_version = "1.2.0"

    const val databinding_version ="3.0.1"
    const val koin_version = "2.0.1"
    const val javaxInjectVersion = "1"
    const val daggerVersion = "2.25.2"
    const val nav_verison = "2.1.0"

    const val support = "1.1.0"
    const val lagacy = "1.0.0"
    const val core = "1.1.0"
    const val design = "1.1.0"
    const val constrainst_layout = "1.1.3"
    const val appcompat = "1.1.0"

    const val pagingVersion = "2.1.2"
    const val timber_version = "4.7.1"
    const val deeplink_version = "4.1.0"
    const val currencyEditTextVersion = "2.0.2"
    const val circleImageVersion = "3.0.0"
    const val otpViewVersion = "2.0.3"
    const val easy_pref_version = "1.9.0"
    const val cognitoVersion = "2.15.1"

    const val lottie = "2.5.1"
    const val glide = "4.6.1"
    const val rx_android = "2.1.1"
    const val rx_java = "2.2.15"
    const val rx_kotlin = "2.3.0"
    const val reactiveStreamsVersion = "1.1.0"

    const val prefix_version = "1.1"

    const val coroutine_version = "1.3.0"
    const val calligraphy = "2.3.0"
    const val pager_indicator = "1.0.3"
    const val biometric_version = "1.0.0"
    const val espresso = "3.2.0"
    const val espresso_contrib = "3.2.0"
    const val junit = "4.12"
    const val junit_x = "1.1.0"
    const val mockito = "2.13.0"
    const val mockito_core = "2.28.2"
    const val support_test = "1.0.2"
    const val core_test = "1.0.0"
    const val robo_electric = "1.0.0"
    const val fragment_testing = "1.1.0"

    const val crashlyticsVersion = "2.10.1"
    const val firebase_crashlytics_version = "17.0.0-beta04"
    const val firebase_auth_version = "19.2.0"
    const val firebase_db_version = "19.2.0"
    const val firebase_firestore_version = "21.3.1"
    const val firebase_location_version = "17.0.0"
    const val firebase_analytics_version = "17.2.1"
    const val gmsVersion = "16.0.0"
    const val play_core_version = "1.7.1"
    const val firebase_core_version = "16.0.4"
    const val anko_version = "0.10.8"
}

object ClassPaths {
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_ext = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"
    const val gradle_build = "com.android.tools.build:gradle:${Versions.gradle}"
    const val realm = "io.realm:realm-gradle-plugin:${Versions.realm}"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlin_jdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val bindingCompiler = "com.android.databinding:compiler:${Versions.databinding_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofix_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofit_http_logger = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofit_logger}"

    const val room = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room_version}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val room_rxjava = "androidx.room:room-rxjava2:${Versions.room_version}"

    const val lifecycle_runtime = "android.arch.lifecycle:runtime:${Versions.lifecycle_version}"
    const val lifecycle_ext = "android.arch.lifecycle:extensions:${Versions.lifecycle_version}"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycle_view_model = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycle_compiler = "android.arch.lifecycle:compiler:${Versions.lifecycle_version}"
    const val reactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.reactiveStreamsVersion}"

    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    var glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"
    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx_java}"
    const val rx_bind = "com.jakewharton.rxbinding:rxbinding:0.4.0"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rx_kotlin}"
    const val rx_compiler = "android.arch.persistence.room:compiler:${Versions.rx_java}"

    var coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine_version}"
    var coroutine_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine_version}"

    const val calligraphy = "uk.co.chrisjenx:calligraphy:${Versions.calligraphy}"
    const val pager_indicator = "com.romandanylyk:pageindicatorview:${Versions.pager_indicator}"
    const val biometric = "androidx.biometric:biometric:${Versions.biometric_version}"

    const val koin = "org.koin:koin-android:${Versions.koin_version}"
    const val koin_scope = "org.koin:koin-android-scope:${Versions.koin_version}"
    const val koin_view_model = "org.koin:koin-android-viewmodel:${Versions.koin_version}"
    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.pagingVersion}"
    const val pagingRxJava = "androidx.paging:paging-rxjava2:${Versions.pagingVersion}"
    const val nav_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_verison}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav_verison}"

    const val anko_commons = "org.jetbrains.anko:anko-commons:${Versions.anko_version}"
    const val anko_designs = "org.jetbrains.anko:anko-design:${Versions.anko_version}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber_version}"
    const val deepLinkDispatch = "com.airbnb:deeplinkdispatch:${Versions.deeplink_version}"
    const val deepLinkDispatchProcessor = "com.airbnb:deeplinkdispatch-processor:${Versions.deeplink_version}"

    const val currencyEditText = "com.github.BlacKCaT27:CurrencyEditText:$currencyEditTextVersion"
    const val circleImage = "de.hdodenhof:circleimageview:${Versions.circleImageVersion}"
    const val otpView = "com.github.mukeshsolanki:android-otpview-pinview:$otpViewVersion"
    const val easyPref = "com.pixplicity.easyprefs:library:${Versions.easy_pref_version}"
    const val prefix = "com.github.bachors:Android-Prefix-Input:$prefix_version"

    const val cognito = "com.amazonaws:aws-android-sdk-cognitoidentityprovider:${Versions.cognitoVersion}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlyticsVersion}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebase_crashlytics_version}"
    const val firebase_auth = "com.google.firebase:firebase-auth:${Versions.firebase_auth_version}"
    const val google_location = "com.google.android.gms:play-services-location:${Versions.firebase_location_version}"
    const val playCore = "com.google.android.play:core:${Versions.play_core_version}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebase_core_version}"
    const val firebase_db = "com.google.firebase:firebase-database:${Versions.firebase_db_version}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebase_analytics_version}"
    const val googlePlayLocation = "com.google.android.gms:play-services-location:${Versions.gmsVersion}"
}


object SupportLibraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val annotation = "androidx.annotation:annotation:${Versions.appcompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"
    const val supportLagacy = "androidx.legacy:legacy-support-v4:${Versions.lagacy}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val materialDesign = "com.google.android.material:material:${Versions.design}"
    const val cardview = "androidx.cardview:cardview:${Versions.support}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.support}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constrainst_layout}"
}

object TestDeps {
    const val junit = "junit:junit:${Versions.junit}"
    const val junit_x = "androidx.test.ext:junit:${Versions.junit_x}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espresso_intents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso_contrib}"
    const val espresso_idling = "androidx.test.espresso.idling:idling-concurrent:${Versions.espresso}"
    const val mocito_core = "org.mockito:mockito-core:${Versions.mockito_core}"
    const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
    const val arch_testing = "android.arch.core:core-testing:${Versions.android_arch}"
    const val support_test_runner = "androidx.test:runner:${Versions.support_test}"
    const val core_test = "androidx.test:core:${Versions.core_test}"
    const val fragment_test = "androidx.fragment:fragment-testing:${Versions.fragment_testing}"
    const val test_rule = "androidx.test:rules:1.1.0"
}