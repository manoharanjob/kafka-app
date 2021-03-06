package app.kafka.constants;

public interface KafkaConfig {

	public static String KAFKA_BROKERS = "localhost:9092";

	public static Integer MESSAGE_COUNT = 1000;

	public static String CLIENT_ID = "client1";

	public static String TOPIC_NAME = "demo";

	public static String GROUP_ID_CONFIG = "consumerGroup10";

	public static Integer MAX_NUM_MESSAGE_FOUND_COUNT = 100;

	public static String OFFSET_RESET_LATEST = "latest";

	public static String OFFSET_RESET_EARLIER = "earliest";

	public static Integer MAX_POLL_RECORDS = 1000;
	
	public static Integer POLL_TIMEOUT = 3000;
	
	public static String CRON_EXPRESSION = "0 0/1 * 1/1 * ? *";
	
	public static String CRON_JOB_KEY_NAME = "KAFKA_JOB";
	
	public static String CRON_JOB_GROUP_NAME = "DATA_PUSH_TO_KAFKA_PRODUCER";
}
