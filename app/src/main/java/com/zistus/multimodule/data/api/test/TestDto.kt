package com.zistus.multimodule.data.api.test

import com.zistus.multimodule.data.db.test.entity.TestData
import com.zistus.multimodule.domain.test.TestEntity

sealed class TestDto {
    data class UsersResponse(val name: String): TestDto() {
        fun toData() = TestData.User(this.name)
        fun toEntity() = TestEntity.User(this.name)
    }
}