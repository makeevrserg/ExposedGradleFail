package com.makeevrserg.exposedgradlefail

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection

fun main() {
    val database = Database.connect("jdbc:h2:./build/h2file", driver = "org.h2.Driver")
    TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    transaction(database) {
        SchemaUtils.create(
            UserTable,
            UserRatingTable
        )
    }
    println("Done creating database")
}