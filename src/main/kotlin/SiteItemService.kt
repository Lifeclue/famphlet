package com.lifeclue.blog.famphlet

interface SiteItemService {
    fun createSiteItem(itemName: String, siteUri: String): SiteItem
    fun getSiteItem(id: Long): SiteItem
    fun getSiteItems(): List<SiteItem>
    fun modifySiteItem(id: Long, itemName: String, siteUri: String): SiteItem
    fun removeSiteItem(id: Long): SiteItem
}

