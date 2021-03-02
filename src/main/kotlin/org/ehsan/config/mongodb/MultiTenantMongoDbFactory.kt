package org.ehsan.config.mongodb

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoDatabase
import org.ehsan.config.TenantContext
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory

class MultiTenantMongoDbFactory(
    mongoClient: MongoClient,
    dbName: String
) : SimpleMongoClientDbFactory(mongoClient, dbName) {
    override fun getMongoDatabase(): MongoDatabase {
        val tenant = TenantContext.getCurrentTenant()
        return getMongoDatabase(tenant)
    }
}
