package com.zistus.multimodule.domain.test

import com.zistus.multimodule.data.api.test.TestDto
import com.zistus.multimodule.data.db.test.entity.TestData

sealed class TestEntity {
    data class User(
        val name: String
    ): TestEntity() {
        fun toDto() = TestDto.UsersResponse(this.name)
        fun toData() = TestData.User(this.name)
    }
}