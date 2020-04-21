package com.zistus.core.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Update

/**
 * Parent of all of dao classes
 */
interface BaseDao<T> {
    @Insert(onConflict = IGNORE)
    suspend  fun insert(t: T): Long

    @Insert(onConflict = REPLACE)
    fun insert(ts: List<T>)

    @Update(onConflict = REPLACE)
    fun update(t: T)

    @Update(onConflict = REPLACE)
    fun update(ts: List<T>)

    @Delete
    fun delete(t: T): Int

    @Delete
    fun delete(ts: List<T>)

}