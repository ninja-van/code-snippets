@Override
@SuppressWarnings("unchecked")
public void init(ProcessorContext context) {
    super.init(context);

    kvStore = (KeyValueStore) context.getStateStore("inmemory-order-create-retry");

    context.schedule(100, PunctuationType.WALL_CLOCK_TIME, (timestamp) -> {
        // Processing code goes here
    });
}
