package com.lorenzo.mobilecomputinghw.data.repository

import com.lorenzo.mobilecomputinghw.data.entity.User
import com.lorenzo.mobilecomputinghw.data.room.UserDao
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun getUsers(): Flow<List<User>> = userDao.getUsers()

    suspend fun addUser(user: User) = userDao.insert(user)

    suspend fun updateUser(user: User) = userDao.update(user)

    suspend fun getUser(id: Long): User = userDao.getUser(id)
}