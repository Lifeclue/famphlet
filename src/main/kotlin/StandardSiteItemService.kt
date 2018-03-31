package com.lifeclue.blog.famphlet

import org.springframework.stereotype.Service

@Service
class StandardSiteItemService(val itemStore: SiteItemStore) : SiteItemService {

    override fun createSiteItem(itemName: String, siteUri: String): SiteItem {
        val item = SiteItem(itemName, siteUri)
        itemStore.save(item)
        return item
    }

    override fun getSiteItem(id: Long): SiteItem {
        return itemStore.findById(id) ?: throw notFound(id)
    }

    override fun getSiteItems(): List<SiteItem> {
        return itemStore.findAll()
    }

    override fun modifySiteItem(id: Long, itemName: String, siteUri: String): SiteItem {
        val item: SiteItem = itemStore.findById(id) ?: throw notFound(id)
        item.itemName = itemName
        item.siteUri = siteUri
        itemStore.save(item)
        return item
    }

    override fun removeSiteItem(id: Long): SiteItem {
        return itemStore.deleteById(id) ?: throw notFound(id)
    }

    private fun notFound(id: Long) = IllegalArgumentException("${id}에 해당하는 즐겨찾기를 찾을 수 없습니다.")
}