package com.aravind.lloyds.model

import com.aravind.lloyds.model.ApiResponseTest.Companion.AVATAR_URL
import com.aravind.lloyds.model.ApiResponseTest.Companion.DESCRIPTION
import com.aravind.lloyds.model.ApiResponseTest.Companion.NAME
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiResponseTest {

    companion object {
        val AVATAR_URL = "www.api.github.com"
        val NAME = "Aravind"
        val DESCRIPTION = "description"
    }

    @Test
    fun apiResponse() {
        val list = ArrayList<Item>()

        val ownerData = Owner(AVATAR_URL)
        list.add(Item(NAME, DESCRIPTION, ownerData))
        var apiResponse = ApiResponse(list)
        assertEquals("true", NAME, apiResponse.items.get(0).name)
        assertEquals("true", DESCRIPTION, apiResponse.items.get(0).description)
        assertEquals("true", AVATAR_URL, apiResponse.items.get(0).owner.avatar_url)
    }
}

@Test
fun Owner() {
    val ownerData = Owner(AVATAR_URL)
    Assert.assertEquals("true", AVATAR_URL, ownerData.avatar_url)
}

@Test
fun Item() {
    val ownerData = Owner(ApiResponseTest.AVATAR_URL)

    val item = Item(NAME, DESCRIPTION, ownerData)
    assertEquals("true", NAME, item.name)
    assertEquals("true", DESCRIPTION, item.description)
    assertEquals("true", AVATAR_URL, item.owner.avatar_url)

}