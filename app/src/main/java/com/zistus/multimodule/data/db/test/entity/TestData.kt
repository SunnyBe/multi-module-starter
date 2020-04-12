package com.zistus.multimodule.data.db.test.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zistus.multimodule.domain.test.TestEntity

sealed class TestData {
    @Entity
    data class User(
        @PrimaryKey val name: String
    ): TestData(){
        fun toEntity() = TestEntity.User(this.name)
    }
    @Entity
    data class Post(
        @PrimaryKey val post: String
    ): TestData()
}