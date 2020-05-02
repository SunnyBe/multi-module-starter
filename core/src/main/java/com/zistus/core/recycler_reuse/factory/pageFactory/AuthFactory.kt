package com.zistus.core.recycler_reuse.factory.pageFactory

import com.zistus.core.recycler_reuse.factory.models.UIField
import com.zistus.core.recycler_reuse.factory.models.uiFields.ButtonField
import com.zistus.core.recycler_reuse.factory.models.uiFields.NameField

object AuthFactory {
    object Keys {
        val F_NAME = "F_NAME"
        val L_NAME = "F_NAME"
        val Phone = "Phone"
        val Photo = "Photo"
        val Email = "Email"
        val Bvn = "Bvn"
        val Dob = "Dob"
        val Gender = "Gender"
        val Button = "Button"
    }

    fun signUpPage(): MutableList<UIField> {
        return mutableListOf<UIField>().apply {
            val fName = NameField("Test Name", required = true)
            fName.validation = {!it.isBlank()}
            fName.errorMessage("This field is needed")
            add(fName.withKey(Keys.F_NAME))
            add(NameField("Last Name").errorMessage("This field is needed").withKey(Keys.Phone))
            add(ButtonField("Submit").withKey(Keys.Button))
        }
    }
}