package com.lifeclue.blog.famphlet

interface SiteItemStore {
    fun save(item: SiteItem)
    fun findById(id: Long): SiteItem?
    fun findAll(): List<SiteItem>
    fun deleteById(id: Long): SiteItem?
}