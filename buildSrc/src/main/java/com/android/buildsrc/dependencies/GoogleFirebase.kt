package com.android.buildsrc.dependencies

import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.googleFirebase(){
    implementation(platform("com.google.firebase:firebase-bom:30.3.2"))
    implementation ("com.google.firebase:firebase-analytics-ktx")
    implementation ("com.google.firebase:firebase-auth-ktx")
    implementation( "com.google.android.gms:play-services-auth:20.2.0")
}