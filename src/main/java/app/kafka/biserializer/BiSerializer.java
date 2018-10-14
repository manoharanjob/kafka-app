package app.kafka.biserializer;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class BiSerializer {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> String serialize(T data) {
		try {
			return objectMapper.writeValueAsString(data);
		} catch (Exception exception) {
			System.out.println("Exception in serializing " + data);
		}
		return null;
	}

	public static <T> T deserialize(String data, Class<T> claz) {
		try {
			return (T) objectMapper.readValue(data, claz);
		} catch (Exception exception) {
			System.out.println("Exception in deserializing " + exception);
		}
		return null;
	}

}