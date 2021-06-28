
context.schedule(100, PunctuationType.WALL_CLOCK_TIME, (timestamp) -> {
        try {
            KeyValueIterator<String, byte[]> iter = kvStore.all();
            while (iter.hasNext()) {
                KeyValue<String, byte[]> entry = iter.next();
                
                // Any checks on when to process the message (e.g. due to backoff + jitter) 
                // should be done here
                
                // You can do anything here, process the message directly etc
                // For us, we're forwarding the message to another topic for processing
                context.forward(null, entry.value, 0);
                kvStore.delete(entry.key);
            }
            iter.close();

            context.commit();
        } catch (Exception e) {
           Log.error("Error", e);
        }
    });
}
