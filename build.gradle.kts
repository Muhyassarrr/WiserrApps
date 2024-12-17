buildscript {
    dependencies {
        classpath ("com.google.gms:google-services:4.3.13")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
//    alias(libs.plugins.google.gms.google.services) apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
//    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}