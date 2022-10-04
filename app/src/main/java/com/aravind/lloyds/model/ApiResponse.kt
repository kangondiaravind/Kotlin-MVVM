package com.aravind.lloyds.model

/**
 * Create Api response
 *
 * @property items
 */
data class ApiResponse(
    val items: ArrayList<Item>,
)

/**
 * create Item
 *
 * @property name
 * @property description
 * @property owner
 */
data class Item(
    var name: String,
    val description: String,
    val owner: Owner
)

/**
 * create Owner
 *
 * @property avatar_url
 */
data class Owner(
     val avatar_url: String,
)