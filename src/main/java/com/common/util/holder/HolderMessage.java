package com.common.util.holder;

import java.util.Locale;

import org.springframework.context.MessageSource;

/**
 * La clase que va a contener las propiedades que van a tener los mensajes propios de las excepciones que van a desplegarse dentro de la aplicaci�n.
 * 
 * @author Guillermo Mazzali
 * @version 1.0
 */
public class HolderMessage {

	/**
	 * El conjunto de los mensaje que va a tener los mensajes de los errores que surjan dentro del sistema.
	 */
	private static MessageSource resources;
	/**
	 * La localidad desde la que vamos a recuperar los mensajes.
	 */
	private static Locale locale;

	/**
	 * La func�on encargada de setear el recurso desde donde vamos a leer los mensajes.
	 * 
	 * @param resources
	 *            Los recursos desde donde vamos a tomar los mensajes del sistema.
	 */
	public void setResources(MessageSource resources) {
		HolderMessage.resources = resources;
	}

	/**
	 * La funci�n encargada de setear la localidad sobre la que vamos a leer los mensajes del sistema.
	 * 
	 * @param locale
	 *            La localidad sobre la que vamos a leer los mensajes.
	 */
	public static void setLocale(Locale locale) {
		HolderMessage.locale = locale;
	}

	/**
	 * La funci�n encargada de leer los recursos y retornar el mensaje dado solo su clave.
	 * 
	 * @param key
	 *            La clave para buscar el mensaje dentro de los recursos.
	 * @return El mensaje correspondiente a la clave recibida.
	 */
	public static String getMessage(String key) {
		return HolderMessage.getMessage(key, null);
	}

	/**
	 * La funci�n encargada de leer los recursos y retornar el mensaje dado su clave y su conjunto de par�metros.
	 * 
	 * @param key
	 *            La clave para buscar el mensaje dentro de los recursos.
	 * @param parameter
	 *            Los par�metros necesarios para completar el mensaje en caso de que se requiera.
	 * @return El mensaje correspondiente a la clave recibida.
	 */
	public static String getMessage(String key, Object[] parameter) {
		if (HolderMessage.resources != null) {
			return HolderMessage.resources.getMessage(key, parameter, key, HolderMessage.locale);
		} else {
			return "## KEY NOT FOUND: " + key + " ##";
		}
	}
}
