package com.aravind.lloyds.model

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ApiResponseTest {


    @Test
    fun apiResponse() {
        val list = ArrayList<Item>()

        val ownerData = Owner("www.api.github.com")
        list.add(Item("Aravind", "description", ownerData))
        var apiResponse = ApiResponse(list)
        assertEquals("true", "Aravind", apiResponse.items.get(0).name)
        assertEquals("true", "description", apiResponse.items.get(0).description)
        assertEquals("true", "www.api.github.com", apiResponse.items.get(0).owner.avatar_url)
    }
}

@Test
fun Owner() {
    val ownerData = Owner("www.api.github.com")
    Assert.assertEquals("true", ownerData.avatar_url, "www.api.github.com")
}

@Test
fun Item() {
    /*val ownerData = Owner("www.api.github.com")

    Assert.assertEquals("true", ownerData.avatar_url, "www.api.github.com")
*/
    val ownerData = Owner("www.api.github.com")

    val item = Item("Aravind", "description", ownerData)
    assertEquals("true", "Aravind", item.name)
    assertEquals("true", "description", item.description)
    assertEquals("true", "www.api.github.com", item.owner.avatar_url)

}