package com.makeevrserg.exposedgradlefail

import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("users", "user_id") {
    val minecraftUUID = varchar("minecraft_uuid", 64).uniqueIndex()
    val minecraftName = varchar("minecraft_name", 64).uniqueIndex()
    val lastUpdated = long("last_updated")
}