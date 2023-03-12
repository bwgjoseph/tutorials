package com.bwgjoseph.springbootdebeziummongodbes.config;

import java.io.File;
import java.io.IOException;

import org.springframework.context.annotation.Bean;

import io.debezium.config.Configuration;

@org.springframework.context.annotation.Configuration
public class DebeziumConnectorConfig {
    // based off https://debezium.io/documentation/reference/2.1/connectors/mongodb.html#mongodb-connector-properties
    @Bean
    public Configuration mongodbConnector() throws IOException {
        File offsetStorageTempFile = File.createTempFile("offsets_", ".dat");

        return Configuration.create()
                // engine properties
                .with("name", "sbd-mongodb")
                .with("connector.class", "io.debezium.connector.mongodb.MongoDbConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", offsetStorageTempFile.getAbsolutePath())
                .with("offset.flush.interval.ms", "60000")
                // connector specific properties
                .with("mongodb.connection.string", "mongodb+srv://sb-debezium.1ewsyzd.mongodb.net")
                .with("topic.prefix", "sbd-mongodb-connector")
                .with("mongodb.user", "bwgjoseph")
                .with("mongodb.password", "<redacted>")
                .with("mongodb.ssl.enabled", "true") // default false
                .with("database.include.list", "source") // default empty
                .with("snapshot.delay.ms", "100")
                .with("errors.log.include.messages", "true")
                .build();
    }
}
