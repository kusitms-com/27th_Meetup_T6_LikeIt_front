package com.kustims.a6six.app.Base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    open fun fetchData(): Job = viewModelScope.launch{ }
}