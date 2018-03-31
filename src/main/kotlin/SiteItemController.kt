package com.lifeclue.blog.famphlet

import org.springframework.web.bind.annotation.*
import java.util.stream.Collectors

@RestController
class SiteItemController(val siteItemService: SiteItemService) {

    @GetMapping("/sites")
    fun getSites() = responseOf(siteItemService.getSiteItems())

    @GetMapping("/sites/{id}")
    fun getSite(@PathVariable id:Long) = responseOf(siteItemService.getSiteItem(id))

    @PostMapping("/sites")
    fun createSite(@RequestBody payload: SiteRequest) = responseOf(siteItemService.createSiteItem(payload.name, payload.uri))

    @PatchMapping("/sites/{id}")
    fun modifySite(@PathVariable id:Long, @RequestBody payload: SiteRequest)
            = responseOf(siteItemService.modifySiteItem(id, payload.name, payload.uri))

    @DeleteMapping("/sites/{id}")
    fun removeSite(@PathVariable id:Long) = responseOf(siteItemService.removeSiteItem(id))

    private fun responseOf(newSite: SiteItem): SiteResponse {
        return SiteResponse(newSite.id, newSite.itemName, newSite.siteUri)
    }

    private fun responseOf(newSite: List<SiteItem>): SiteListResponse {
        return SiteListResponse(
                newSite.stream()
                .map(this::responseOf)
                .collect(Collectors.toList())
        )
    }
}