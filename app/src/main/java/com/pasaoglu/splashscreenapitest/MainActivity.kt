package com.pasaoglu.splashscreenapitest

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.pasaoglu.splashscreenapitest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
            it should be before setContentView otherwise app will be crashed.
            postSplashScreenTheme to set the theme that will be used once the Splash screen is no longer visible.
         */
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
       setContentView(R.layout.activity_main)
    }
}