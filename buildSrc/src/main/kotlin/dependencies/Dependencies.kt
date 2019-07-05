package dependencies


object config {

    val applicationId = "com.example.factorynewsreader"
    val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    val versionCode = 1
    val versionName = "1"

}


object versions {
    val buildTools = "29.0.0"

    val compileSdk = 29
    val minSdk = 19
    val targetSdk = 29


    val kotlin = "1.3.31"
    val gradle = "3.4.1"
    val androidX = "1.0.2"
    val ktx = "1.1.0-alpha05"
    val koin = "2.0.1"
    val retrofit = "2.6.0"
    val loggingInterceptor = "3.10.0"
    val nav_version_ktx = "2.1.0-alpha05"
    val arch = "2.1.0-alpha03"
    val epoxy = "3.7.0"
    val butterknife = "10.1.0"
    val rxJava = "2.1.6"
    val rxAndroid = "2.1.0"
    val rxBinding = "2.2.0"
    val rx_kotlin_2 = "2.2.0"
    val constraint = "1.1.3"
    val lifecycle = "2.0.0"
    val support = "27.1.1"
    val glide = "4.9.0"
}


object plugin {
    object android {
        val gradle = "com.android.tools.build:gradle:${versions.gradle}"
    }

    object kotlin {
        val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
        val runtime = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${versions.kotlin}"
    }

    object knife {
        val butter = "com.jakewharton:butterknife-gradle-plugin:${versions.butterknife}"
    }

}


object deps {

    val ktx = "androidx.core:core-ktx:${versions.ktx}"
    val viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${versions.arch}"
    val glide = "com.github.bumptech.glide:glide:${versions.glide}"


    object support{
        val appCompact = "androidx.appcompat:appcompat:${versions.androidX}"
        val constraintLayout = "androidx.constraintlayout:constraintlayout:${versions.constraint}"
        val livedata = "androidx.lifecycle:lifecycle-livedata:${versions.lifecycle}"
        val design =  "com.android.support:design:${versions.support}"

    }

    object retrofit {
        val retrofit = "com.squareup.retrofit2:retrofit:${versions.retrofit}"
        val rxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${versions.retrofit}"
        val converterGson = "com.squareup.retrofit2:converter-gson:${versions.retrofit}"
        val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${versions.loggingInterceptor}"
    }

    object koin {
        val android = "org.koin:koin-android:${versions.koin}"
        val viewModel = "org.koin:koin-androidx-viewmodel:${versions.koin}"
    }

    object navigation{
        val fragment = "androidx.navigation:navigation-fragment-ktx:${versions.nav_version_ktx}"
        val ui = "androidx.navigation:navigation-ui-ktx:${versions.nav_version_ktx}"
    }


    object epoxy {
        val dep = "com.airbnb.android:epoxy:${versions.epoxy}"
        val annotation = "com.airbnb.android:epoxy-processor:${versions.epoxy}"
    }

    object rx {
        val java = "io.reactivex.rxjava2:rxjava:${versions.rxJava}"
        val kotlin = "io.reactivex.rxjava2:rxkotlin:${versions.rx_kotlin_2}"
        val android = "io.reactivex.rxjava2:rxandroid:${versions.rxAndroid}"
        val binding = "com.jakewharton.rxbinding2:rxbinding-kotlin:${versions.rxBinding}"
    }


}