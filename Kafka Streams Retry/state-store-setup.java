StoreBuilder<KeyValueStore<String, byte[]>> retryBuilder =
    Stores.keyValueStoreBuilder(
        Stores.inMemoryKeyValueStore("inmemory-order-create-retry"),
        Serdes.String(),
        Serdes.ByteArray());

topology.addStateStore(
    retryOrderBuilder,
    processor("inmemory-order-create-retry")
);
