package com.dbasuporte.usuariosapi.converter;

import java.util.Base64;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DocumentoConverter implements AttributeConverter<byte[], String> {

	@Override
	public String convertToDatabaseColumn(byte[] attribute) {
		return Base64.getEncoder().encodeToString(attribute);
	}

	@Override
	public byte[] convertToEntityAttribute(String dbData) {
		return Base64.getDecoder().decode(dbData);
	}

}
