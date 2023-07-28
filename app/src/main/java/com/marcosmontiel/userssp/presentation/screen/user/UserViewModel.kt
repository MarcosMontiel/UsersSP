package com.marcosmontiel.userssp.presentation.screen.user

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor() : ViewModel() {

    fun assignPreference(preferences: SharedPreferences) {
        val pref = preferences.getBoolean("test", false)
        Log.i("UserViewModel", "$pref")
    }

}