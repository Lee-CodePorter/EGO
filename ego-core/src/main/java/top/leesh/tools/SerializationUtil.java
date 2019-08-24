package top.leesh.tools;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import net.bytebuddy.implementation.bytecode.Throw;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SerializationUtil {
	private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<>();

	private static Objenesis objenesis = new ObjenesisStd(true);

	private SerializationUtil() {
	}

	/**
	 * 序列化（对象 -> 字节数组）
	 */
	@SuppressWarnings("unchecked")
	public static <T> byte[] serialize(T obj) {
		Class<T> cls = (Class<T>) obj.getClass();
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		try {
			Schema<T> schema = getSchema(cls);
			return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		} finally {
			buffer.clear();
		}
	}

	/**
	 * 反序列化（字节数组 -> 对象）
	 */
	public static <T> T deserialize(byte[] data, Class<T> cls) {
		try {
			T message = objenesis.newInstance(cls);
			Schema<T> schema = getSchema(cls);
			ProtostuffIOUtil.mergeFrom(data, message, schema);
			return message;
		} catch (Exception e) {
			throw new IllegalStateException(e.getMessage(), e);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> Schema<T> getSchema(Class<T> cls) {
		Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
		if (schema == null) {
			schema = RuntimeSchema.createFrom(cls);
			cachedSchema.put(cls, schema);
		}
		return schema;
	}

	/**
	 *@Description //TODO 序列化集合
	 *@Param [obj]
	 *@Return byte[]
	 */
	public  static <T> byte[] serializeList(List<T> obj)
	{
		if(obj==null||obj.size()==0)
		{
			throw  new RuntimeException("序列化集合为空!");
		}
		Class<T> aClass = (Class<T>) obj.get(0).getClass();

		LinkedBuffer buffer = LinkedBuffer.allocate(1024 * 1024);

		Schema<T> schema = getSchema(aClass);


		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			ProtostuffIOUtil.writeListTo(outputStream,obj,schema,buffer);
			return  outputStream.toByteArray();
		} catch (IOException e) {
			throw  new IllegalStateException(e.getMessage(),e);
		}
		finally {
			buffer.clear();
		}

	}

	/**
	 *@Description //TODO      反序列化集合
	 *@Param [bytes, cls]
	 *@Return java.util.List<T>
	 */
	public  static <T> List<T> deserializeList(byte[] bytes,Class<T> cls)
	{
		try {
			Schema<T> schema = getSchema(cls);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
			return  ProtostuffIOUtil.parseListFrom(inputStream,schema);
		}
		catch (Exception  e)
		{
			throw  new IllegalStateException(e.getMessage(),e);
		}


	}

}
