
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
    const val compile_sdk = 29
    const val build_tool_versioin = "29.0.2"
}

object Versions {
    const val androidArch = "1.1.1"
    const val appcompat = "1.1.0"
    const val ankoVersion = "0.10.8"

    const val biometricVersion = "1.0.0"

    const val core = "1.1.0"
    const val constrainstLayoutVersion = "1.1.3"
    const val currencyEditTextVersion = "2.0.2"
    const val circleImageVersion = "3.0.0"
    const val cognitoVersion = "2.15.1"
    const val coroutineVersion = "1.3.0"
    const val crashlyticsVersion = "2.10.1"
    const val coreTest = "1.0.0"
    const val calligraphy = "2.3.0"

    const val design = "1.1.0"
    const val daggerVersion = "2.25.2"
    const val databindingVersion ="3.0.1"
    const val deeplinkVersion = "4.1.0"

    const val easyPrefVersion = "1.9.0"
    const val espresso = "3.2.0"
    const val espressoContrib = "3.2.0"

    const val fragmentVersion = "1.2.0"
    const val firebaseCrashlyticsVersion = "17.0.0-beta04"
    const val firebaseAuthVersion = "19.2.0"
    const val firebaseDbVersion = "19.2.0"
    const val firebaseFirestoreVersion = "21.3.1"
    const val firebaseLocationVersion = "17.0.0"
    const val firebaseAnalyticsVersion = "17.2.1"
    const val firebaseCoreVersion = "16.0.4"
    const val fragmentTesting = "1.1.0"
    const val firebaseCrashlyticsGradle = "2.0.0-beta04"

    const val gmsVersion = "16.0.0"
    const val gradle = "3.6.2"
    const val glide = "4.6.1"
    const val gms = "4.2.0"

    const val javaxInjectVersion = "1"
    const val junit = "4.12"
    const val junit_x = "1.1.0"

    const val kotlin = "1.3.71"
    const val koinVersion = "2.0.1"

    const val lifecycleVersion = "2.2.0"
    const val lagacy = "1.0.0"
    const val lottie = "2.5.1"

    const val mockito = "2.13.0"
    const val mockito_core = "2.28.2"
    const val navigationArchitecture = "2.0.0"
    const val navVersion = "2.1.0"

    const val otpViewVersion = "2.0.3"

    const val playCoreVersion = "1.7.1"
    const val prefixVersion = "1.1"
    const val pagerIndicator = "1.0.3"
    const val pagingVersion = "2.1.2"
    const val roomVersion = "2.2.5"
    const val realm = "5.3.0"
    const val retrofit = "2.6.0"
    const val retrofitLogger = "3.10.0"
    const val rxAndroid = "2.1.1"
    const val rxJava = "2.2.15"
    const val rxKotlin = "2.3.0"
    const val reactiveStreamsVersion = "1.1.0"
    const val roboElectric = "1.0.0"
    const val support = "1.1.0"
    const val supportTest = "1.0.2"
    const val timberVersion = "4.7.1"
}

object ClassPaths {
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlin_ext = "org.jetbrains.kotlin:kotlin-android-extensions:${Versions.kotlin}"
    const val gradle_build = "com.android.tools.build:gradle:${Versions.gradle}"
    const val realm = "io.realm:realm-gradle-plugin:${Versions.realm}"
    const val gms = "com.google.gms:google-services:${Versions.gms}"
    const val firebase_crashlytics_gradle = "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradle}"
}

object Deps {
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val bindingCompiler = "com.android.databinding:compiler:${Versions.databindingVersion}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitRxJava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitHttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.retrofitLogger}"

    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomRxJava = "androidx.room:room-rxjava2:${Versions.roomVersion}"

    const val lifecycleRuntime = "android.arch.lifecycle:runtime:${Versions.lifecycleVersion}"
    const val lifecycleExt = "android.arch.lifecycle:extensions:${Versions.lifecycleVersion}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleCompiler = "android.arch.lifecycle:compiler:${Versions.lifecycleVersion}"
    const val reactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.reactiveStreamsVersion}"

    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    var glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxBind = "com.jakewharton.rxbinding:rxbinding:0.4.0"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    const val rxCompiler = "android.arch.persistence.room:compiler:${Versions.rxJava}"

    var coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}"
    var coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    const val calligraphy = "uk.co.chrisjenx:calligraphy:${Versions.calligraphy}"
    const val pagerIndicator = "com.romandanylyk:pageindicatorview:${Versions.pagerIndicator}"
    const val biometric = "androidx.biometric:biometric:${Versions.biometricVersion}"

    const val koin = "org.koin:koin-android:${Versions.koinVersion}"
    const val koinScope = "org.koin:koin-android-scope:${Versions.koinVersion}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koinVersion}"
    const val javaxInject = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.pagingVersion}"
    const val pagingRxJava = "androidx.paging:paging-rxjava2:${Versions.pagingVersion}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    const val ankoCommons = "org.jetbrains.anko:anko-commons:${Versions.ankoVersion}"
    const val ankoDesigns = "org.jetbrains.anko:anko-design:${Versions.ankoVersion}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val deepLinkDispatch = "com.airbnb:deeplinkdispatch:${Versions.deeplinkVersion}"
    const val deepLinkDispatchProcessor = "com.airbnb:deeplinkdispatch-processor:${Versions.deeplinkVersion}"

    const val currencyEditText = "com.github.BlacKCaT27:CurrencyEditText:${Versions.currencyEditTextVersion}"
    const val circleImage = "de.hdodenhof:circleimageview:${Versions.circleImageVersion}"
    const val otpView = "com.github.mukeshsolanki:android-otpview-pinview:${Versions.otpViewVersion}"
    const val easyPref = "com.pixplicity.easyprefs:library:${Versions.easyPrefVersion}"
    const val prefix = "com.github.bachors:Android-Prefix-Input:${Versions.prefixVersion}"

    const val cognito = "com.amazonaws:aws-android-sdk-cognitoidentityprovider:${Versions.cognitoVersion}"
    const val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlyticsVersion}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlyticsVersion}"
    const val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebaseAuthVersion}"
    const val googleLocation = "com.google.android.gms:play-services-location:${Versions.firebaseLocationVersion}"
    const val playCore = "com.google.android.play:core:${Versions.playCoreVersion}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCoreVersion}"
    const val firebaseDb = "com.google.firebase:firebase-database:${Versions.firebaseDbVersion}"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseAnalyticsVersion}"
    const val googlePlayLocation = "com.google.android.gms:play-services-location:${Versions.gmsVersion}"
}


object SupportLibraries {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val annotation = "androidx.annotation:annotation:${Versions.appcompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    const val supportLagacy = "androidx.legacy:legacy-support-v4:${Versions.lagacy}"
    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val materialDesign = "com.google.android.material:material:${Versions.design}"
    const val cardview = "androidx.cardview:cardview:${Versions.support}"
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.support}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constrainstLayoutVersion}"
}

object TestDeps {
    const val junit = "junit:junit:${Versions.junit}"
    const val junitX = "androidx.test.ext:junit:${Versions.junit_x}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoContrib}"
    const val espressoIdling = "androidx.test.espresso.idling:idling-concurrent:${Versions.espresso}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito_core}"
    const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
    const val archtesting = "android.arch.core:core-testing:${Versions.androidArch}"
    const val supportTestRunner = "androidx.test:runner:${Versions.supportTest}"
    const val coreTest = "androidx.test:core:${Versions.coreTest}"
    const val fragmentTest = "androidx.fragment:fragment-testing:${Versions.fragmentTesting}"
    const val testRule = "androidx.test:rules:1.1.0"
}