@Override
public void process(String key, byte[] value) {
    OrderRequestProto.OrderRequest request;
    try {
        request = OrderRequest.parseFrom(value);
        RequestInfo requestInfo = request.getRequestInfo();
        
        // Add in exponential backoff + jitter here
        
        String storeKey = String.valueOf(ZonedDateTime.now().toInstant().toEpochMilli()) + "-" + UUID.randomUUID().toString();

        kvStore.put(storeKey, value);
    } catch (Exception e) {
        Log.error("Error", e);
    }
}
