package com.lorenzo.mobilecomputinghw.data.repository

import com.lorenzo.mobilecomputinghw.data.entity.Reminder
import com.lorenzo.mobilecomputinghw.data.room.ReminderDao
import kotlinx.coroutines.flow.Flow

/**
 * A data repository for [Reminder] instances
 */
class ReminderRepository(
    private val reminderDao: ReminderDao
) {
    /**
     * Returns a flow containing the list of payments associated with the category with the
     * given [categoryId]
     */
    /*fun remindersInCategory(categoryId: Long) : Flow<List<PaymentToCategory>> {
        return reminderDao.paymentsFromCategory(categoryId)
    }*/

    /**
     * Add a new [Reminder] to the payment store
     */
    suspend fun addReminder(reminder: Reminder): Long {
        return reminderDao.insert(reminder)
    }
    fun reminders(): Flow<List<Reminder>> = reminderDao.reminders()
    suspend fun removeReminderById(id: Long) = reminderDao.deleteById(id)
    suspend fun updateReminder(reminder: Reminder) = reminderDao.update(reminder)
    suspend fun getReminder(id: Long) = reminderDao.reminder(id)
    suspend fun updateSeen(id: Long) = reminderDao.updateSeen(id)


}