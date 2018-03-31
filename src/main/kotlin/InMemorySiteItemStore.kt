package com.lifeclue.blog.famphlet

import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicLong

@Component
class InMemorySiteItemStore : SiteItemStore {
    val id: AtomicLong = AtomicLong(1)
    val storage: MutableMap<Long, SiteItem> = mutableMapOf()
    override fun save(item: SiteItem) {
        if (item.id < 1) {
            item.id = id.getAndIncrement()
        }
        storage[item.id] = item
    }

    override fun findById(id: Long): SiteItem? {
        return storage[id]
    }

    override fun findAll(): List<SiteItem> {
        return storage.values.toList()
    }

    override fun deleteById(id: Long): SiteItem? {
        return storage.remove(id)
    }
}