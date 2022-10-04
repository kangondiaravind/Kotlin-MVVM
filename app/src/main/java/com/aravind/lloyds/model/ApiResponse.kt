package com.aravind.lloyds.model

/**
 * Api response
 *
 * @property items
 * @constructor Create Api response
 */
data class ApiResponse(
    val items: ArrayList<Item>,
)

/**
 * Item
 *
 * @property name
 * @property description
 * @property owner
 * @constructor Create Item
 */
data class Item(
    var name: String,
    val description: String,
    val owner: Owner
)

/**
 * Owner
 *
 * @property avatar_url
 * @constructor Create Owner Avatar url
 */
data class Owner(
     val avatar_url: String,
)