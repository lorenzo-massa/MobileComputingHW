package com.lorenzo.mobilecomputinghw.ui.home.categoryPayment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lorenzo.mobilecomputinghw.Graph
import com.lorenzo.mobilecomputinghw.data.repository.ReminderRepository
import com.lorenzo.mobilecomputinghw.data.room.PaymentToCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class CategoryPaymentViewModel(
    private val categoryId: Long,
    private val reminderRepository: ReminderRepository = Graph.reminderRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CategoryPaymentViewState())

    val state: StateFlow<CategoryPaymentViewState>
        get() = _state

    init {
        viewModelScope.launch {
            reminderRepository.remindersInCategory(categoryId).collect { list ->
                _state.value = CategoryPaymentViewState(
                    payments = list
                )
            }
        }
    }
}

data class CategoryPaymentViewState(
    val payments: List<PaymentToCategory> = emptyList()
)