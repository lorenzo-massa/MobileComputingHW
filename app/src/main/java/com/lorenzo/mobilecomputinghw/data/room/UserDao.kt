package com.lorenzo.mobilecomputinghw.data.room

import androidx.room.*
import com.lorenzo.mobilecomputinghw.data.entity.Reminder
import com.lorenzo.mobilecomputinghw.data.entity.User
import kotlinx.coroutines.flow.Flow


@Dao
abstract class UserDao {

    @Query(value = "SELECT * FROM user_table")
    abstract fun getUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(entity: User): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun update(entity: User)

    @Update
    abstract fun updateU(vararg users: User)

    @Query(value = "SELECT * FROM user_table WHERE userName=:username")
    abstract fun getUser(username: String): User

}